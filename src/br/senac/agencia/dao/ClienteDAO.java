package br.senac.agencia.dao;

import br.senac.agencia.db.ConexaoMySQL;
import br.senac.agencia.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void inserir(Cliente c) throws SQLException {
        String sql = "INSERT INTO clientes (nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoMySQL.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getEmail());
            ps.executeUpdate();
        }
    }

    public void atualizar(Cliente c) throws SQLException {
        String sql = "UPDATE clientes SET nome=?, cpf=?, telefone=?, email=? WHERE id=?";
        try (Connection conn = ConexaoMySQL.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getEmail());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id=?";
        try (Connection conn = ConexaoMySQL.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Cliente> listar() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT id, nome, cpf, telefone, email FROM clientes ORDER BY id";
        try (Connection conn = ConexaoMySQL.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                lista.add(c);
            }
        }
        return lista;
    }
}