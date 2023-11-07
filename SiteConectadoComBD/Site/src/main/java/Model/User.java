package Model;

public class User {
	private int clienteId;
	private String cpf, email, nome, senha, endereco;
	private String dataNascimento;
	
	public User(int clienteId, String cpf, String email, String nome, String senha, String endereco,
			String dataNascimento) {
		super();
		this.clienteId = clienteId;
		this.cpf = cpf;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}
	
	public User() {
		
	}
	
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
