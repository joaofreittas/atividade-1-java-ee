package br.home.atividade.conexao;

import java.sql.DriverManager;

import java.sql.Connection;

public class Conexao {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String URL = "jdbc:mysql://localhost:3306/crudFuncionario?serverTimezone=UTC";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	
    public static Connection abrir() throws Exception {
    	Connection conn = null;
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conn;
    }
}
