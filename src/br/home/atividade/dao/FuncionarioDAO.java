package br.home.atividade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.home.atividade.conexao.Conexao;
import br.home.atividade.model.DadoInvalidoException;
import br.home.atividade.model.Funcionario;

public class FuncionarioDAO {

	public List<Funcionario> listar() throws Exception{
		Connection db = Conexao.abrir();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM funcionario");
		
		PreparedStatement comando = db.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		while(resultado.next()) {
			String nome = resultado.getString("nome");
			String cpf = resultado.getString("cpf");
			Double salario = resultado.getDouble("salario");
			String matricula = resultado.getString("matricula");
			String cargo = resultado.getString("cargo");
			Funcionario f = new Funcionario(nome, cpf, matricula, salario, cargo);
			lista.add(f);
		}
		
		resultado.close();
		comando.close();
		
		return lista;
	}
	
	public void inserir(Funcionario f) throws Exception {
		
		Connection db = Conexao.abrir();
		
		String sql = "INSERT INTO funcionario(nome, matricula, cpf, salario, cargo) "
				+ "VALUES('"+f.getNome()+"','"+f.getMatricula()+"',"
						+ "'"+f.getCpf()+"',"+f.getSalario()+",'"+f.getCargo()+"')";
		
		try {
			PreparedStatement stmt = db.prepareStatement(sql); 
			stmt.execute();
			stmt.close();
			
		}catch(Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}
}
