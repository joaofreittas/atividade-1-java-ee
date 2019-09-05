<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="br.home.atividade.model.Funcionario" %>
<%@ page import="br.home.atividade.controler.Controller, javax.servlet.RequestDispatcher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
		Controller ctrl = new Controller();
		List<Funcionario> lista = ctrl.listarFuncionarios();
	%>
	<table>
		<thead>
			<tr>
				<td>Nome</td>
				<td>CPF</td>
				<td>CARGO</td>
				<td>MATRICULA</td>
				<td>SALARIO</td>
				<td colspan>Opções</td>
			</tr>
		</thead>
		<tbody>
			<% for(Funcionario f: lista){ %>
				<tr>
					<td><% out.println( f.getNome() ); %></td>
					<td><% out.println( f.getCpf() ); %></td>
					<td><% out.println( f.getCargo() ); %></td>
					<td><% out.println( f.getMatricula() ); %></td>
					<td><% out.println( f.getSalario() ); %></td>
					<td><button onclick="editar()">Editar</button></td>
					<td><button onclick="excluir()">Excluir</button></td>
				</tr>
			<% } %>
		</tbody>
	</table>
	
	<a href="cadastro.html"><button>Adicionar Funcionario</button></a>
	
</body>
<script src="jquery.js"></script>
<script src="main.js"></script>
</html>