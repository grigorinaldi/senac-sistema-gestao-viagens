package br.senac.agencia.dao;

import br.senac.agencia.db.ConexaoMySQL;
import br.senac.agencia.model.ReservaView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public void inserir(int clienteId, int pacoteId, String dataReserva, String status) throws SQLException {
        String sql = "INSERT INTO reservas (cliente_id, pacote_id, data_reserva, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoMySQL.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, clienteId);
            ps.setInt(2, pacoteId);
            ps.setString(3, dataReserva);
            ps.setString(4, status);
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM reservas WHERE id=?";
        try (Connection conn = ConexaoMySQL.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<ReservaView> listar() throws SQLException {
        List<ReservaView> lista = new ArrayList<>();
        String sql = """
            SELECT r.id,
                   CONCAT(c.nome, ' - ', c.cpf) AS cliente,
                   p.destino AS pacote,
                   r.data_reserva AS data_reserva,
                   r.status
            FROM reservas r
            JOIN clientes c ON c.id = r.cliente_id
            JOIN pacotes p ON p.id = r.pacote_id
            ORDER BY r.id
        """;
        try (Connection conn = ConexaoMySQL.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ReservaView rv = new ReservaView();
                rv.setId(rs.getInt("id"));
                rv.setCliente(rs.getString("cliente"));
                rv.setPacote(rs.getString("pacote"));
                rv.setData(rs.getString("data_reserva"));
                rv.setStatus(rs.getString("status"));
                lista.add(rv);
            }
        }
        return lista;
    }
}
