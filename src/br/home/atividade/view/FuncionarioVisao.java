package br.home.atividade.view;

import java.io.PrintWriter;
import java.util.List;

import br.home.atividade.model.Funcionario;

public class FuncionarioVisao {

	public FuncionarioVisao() {
		
	}
	
	public String desenhaFuncionarios(List<Funcionario> f) {
		
		String resposta = 
				"<html><body>"
				+ "<table border=1><thead>"
				+ "<tr><th>Nome</th><th>Cargo</th><th>Matricula</th><th>CPF</th><th>Salario</th></tr></thead>"
				+ "<tbody>";
		for(Funcionario func: f){ 
			resposta += "<tr><td>"+func.getNome()+"</td>"
					+ "<td>"+func.getCargo()+"</td>"
					+ "<td>"+func.getMatricula()+"</td>"
					+ "<td>"+func.getCpf()+"</td>"
					+ "<td>"+func.getSalario()+"</td></tr>";
		}
		
		resposta += "</tbody></table></body></html>";
		return resposta;
	}

}
