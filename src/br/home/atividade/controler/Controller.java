package br.home.atividade.controler;

import java.sql.SQLException;
import java.util.List;

import br.home.atividade.dao.FuncionarioDAO;
import br.home.atividade.model.Funcionario;

public class Controller {

	private FuncionarioDAO dao;
	public Controller() throws Exception {
		
		this.dao = new FuncionarioDAO();			
		
	}
	
	public void inserirFuncionario(Funcionario f) throws Exception {
		this.dao.inserir(f);
	}
	public List<Funcionario> listarFuncionarios()throws Exception{
		return this.dao.listar();
	}

}
