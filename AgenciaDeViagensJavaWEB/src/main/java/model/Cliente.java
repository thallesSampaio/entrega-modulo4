package model;

public class Cliente {
	private int clienteId;
	private String nome, cpf;
	
	public Cliente(int clienteId, String nome, String cpf) {
		super();
		this.clienteId = clienteId;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Cliente() {
		
	}
	
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
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
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
