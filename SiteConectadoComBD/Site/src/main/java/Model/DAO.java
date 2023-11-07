package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/rjtrip2?useUnicode=true&character_set_server=utf8mb4?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "senhadificil123";

	private Connection conectar() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}
	
	public ArrayList<User> listarClientes() {
		ArrayList<User> lista = new ArrayList<>();
		String sql = "SELECT * FROM cliente";
		try {
			Connection conn = conectar();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rset = pstm.executeQuery();
			while (rset.next()) {
				int cliente_id = rset.getInt(1);
				String nomeCliente = rset.getString(2);
				String cpf = rset.getString(3);
				String dataNascimento = rset.getString(4);
				String email = rset.getString(5);
				String senha = rset.getString(6);
				String endereco = rset.getString(7);
				lista.add(new User(cliente_id, cpf, email, nomeCliente, senha, endereco, dataNascimento));
				//public User(int clienteId, String cpf, String email, String nome, String senha, String endereco,
				//String dataNascimento) {
			}
			conn.close();
			return lista;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public ArrayList<JavaBeans> listarMsg() {
		ArrayList<JavaBeans> listmsg = new ArrayList<>();
		String sql = "SELECT * FROM contatosmsg";
		try {
			Connection conn = conectar();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rset = pstm.executeQuery();
			while (rset.next()) {
				int contato_id = rset.getInt(1);
				String nomeContato = rset.getNString(2);
				String telefoneContato = rset.getNString(3);
				String emailContato = rset.getNString(4);
				String contatoMSG = rset.getNString(5);
				listmsg.add(new JavaBeans(contato_id, nomeContato, telefoneContato, emailContato, contatoMSG));
			}
			conn.close();
			return listmsg;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void contatosMSG(JavaBeans contato) {
		String sql = "INSERT INTO contatosmsg (nomeContato,emailContato,telefoneContato,mensagemContato) VALUES(?,?,?,?)";
		try {
			Connection conn = conectar();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setNString(1, contato.getNome());
			pstm.setNString(2, contato.getEmail());
			pstm.setNString(3, contato.getTelefone());
			pstm.setNString(4, contato.getContatoMSG());
			pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void cadastrarUsuario(User usuario) {
		String sql = "INSERT INTO cliente (email,senha,nomeCliente,cpf,dataNascimento,endereco) VALUES(?,?,?,?,?,?)";
		try {
			Connection conn = conectar();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setNString(1, usuario.getEmail());
			pstm.setNString(2, usuario.getSenha());
			pstm.setNString(3, usuario.getNome());
			pstm.setNString(4, usuario.getCpf());
			pstm.setNString(5, usuario.getDataNascimento());
			pstm.setNString(6, usuario.getEndereco());
			pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void selecionarContato(JavaBeans contato) {
		String sql = "SELECT * FROM contatosmsg WHERE contato_id = ?";
		try {
			Connection conn = conectar();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, contato.getContato_id());
			ResultSet rset = pstm.executeQuery();
			while (rset.next()) {
				contato.setContato_id(rset.getInt(1));
				contato.setNome(rset.getNString(2));
				contato.setTelefone(rset.getNString(3));
				contato.setEmail(rset.getNString(4));
				contato.setContatoMSG(rset.getNString(5));
			}
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
