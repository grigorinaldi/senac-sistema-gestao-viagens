package br.senac.agencia.dao;

import br.senac.agencia.db.ConexaoMySQL;
import br.senac.agencia.model.Pacote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacoteDAO {

    public void inserir(Pacote p) throws SQLException {
        String sql = "INSERT INTO pacotes (destino, data_inicio, data_fim, preco) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoMySQL.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getDestino());
            ps.setString(2, p.getDataInicio());
            ps.setString(3, p.getDataFim());
            ps.setBigDecimal(4, new java.math.BigDecimal(p.getPreco()));
            ps.executeUpdate();
        }
    }

    public void atualizar(Pacote p) throws SQLException {
        String sql = "UPDATE pacotes SET destino=?, data_inicio=?, data_fim=?, preco=? WHERE id=?";
        try (Connection conn = ConexaoMySQL.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getDestino());
            ps.setString(2, p.getDataInicio());
            ps.setString(3, p.getDataFim());
            ps.setBigDecimal(4, new java.math.BigDecimal(p.getPreco()));
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM pacotes WHERE id=?";
        try (Connection conn = ConexaoMySQL.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Pacote> listar() throws SQLException {
        List<Pacote> lista = new ArrayList<>();
        String sql = "SELECT id, destino, data_inicio, data_fim, preco FROM pacotes ORDER BY id";
        try (Connection conn = ConexaoMySQL.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pacote p = new Pacote();
                p.setId(rs.getInt("id"));
                p.setDestino(rs.getString("destino"));
                p.setDataInicio(rs.getString("data_inicio"));
                p.setDataFim(rs.getString("data_fim"));
                p.setPreco(rs.getBigDecimal("preco").doubleValue());
                lista.add(p);
            }
        }
        return lista;
    }
}