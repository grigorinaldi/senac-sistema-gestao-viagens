package br.senac.agencia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static final String URL =
            "jdbc:mysql://localhost:3306/agencia_viagens?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
