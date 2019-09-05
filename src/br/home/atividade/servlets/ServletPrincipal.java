package br.home.atividade.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.home.atividade.conexao.Conexao;
import br.home.atividade.controler.Controller;
import br.home.atividade.model.DadoInvalidoException;
import br.home.atividade.model.Funcionario;
import br.home.atividade.view.FuncionarioVisao;

@WebServlet(name="ServletPrincipal", urlPatterns = {"/adicionar", "/listar", "/cadastrar"})
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletPrincipal() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String url = String.valueOf(request.getRequestURL());
			String[] vetor = url.split("/");
			String path = vetor[ vetor.length -1 ];
			
			RequestDispatcher r = null;
			if( path.equals("listar") ) {
				r = request.getRequestDispatcher( "index.jsp" ); 
			}else if( path.equals("cadastrar")) {
				r = request.getRequestDispatcher( "cadastro.html" );
			}
			r.forward( request, response );
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome;
		String cpf;
		String cargo;
		Double salario;
		String matricula;
		
		nome = request.getParameter("nome");
		cpf = request.getParameter("cpf");
		cargo = request.getParameter("cargo");
		matricula = request.getParameter("matr");
		String s = request.getParameter("sal");
		salario = Double.valueOf(s);
		
		try {
			Funcionario f = new Funcionario(nome, cpf, matricula, salario, cargo);
			Controller ctrl = new Controller();
			ctrl.inserirFuncionario(f);
			
		} catch (DadoInvalidoException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
