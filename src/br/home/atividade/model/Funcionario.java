package br.home.atividade.model;

public class Funcionario {

	private int id;
	private String nome;
	private String cpf;
	private String matricula;
	private double salario;
	private String cargo;
	
	public Funcionario(){
		
	}
	public Funcionario(String nome, String cpf, String matricula, double salario, String cargo) throws DadoInvalidoException {
		this.id = id;
		this.setNome(nome);
		this.setCpf(cpf);
		this.setMatricula(matricula);
		this.setSalario(salario);
		this.setCargo(cargo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws DadoInvalidoException {
		if(cpf.length() > 10 || cpf.length() < 0) {
			throw new DadoInvalidoException("O CPF deve ter entre 10 e 1 caracteres.");
		}
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) throws DadoInvalidoException {
		if(matricula.length() > 5 || matricula.length() < 0) {
			throw new DadoInvalidoException("A matrícula deve ter entre 5 e 1 caracteres.");
		}
		this.matricula = matricula;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	

}
