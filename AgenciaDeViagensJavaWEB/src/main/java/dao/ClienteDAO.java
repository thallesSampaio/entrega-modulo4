package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import model.Cliente;




public class ClienteDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	
	
	
	
	public void cadastrar (Cliente cliente) {
		String sql = "INSERT INTO cliente(nome,cpf)" + "VALUES(?,?)";
		
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM cliente";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			ResultSet rset = pstm.executeQuery();
			
			while(rset.next()) {
				int idcli = rset.getInt(1);
				String nomecli = rset.getNString(2);
				String cpfcli = rset.getNString(3);
				clientes.add(new Cliente(idcli, nomecli, cpfcli));
			}
			conn.close();
			return clientes;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public void SelecionarCliente(Cliente cliente) {
		String sql = "select * from cliente where cliente_id = ?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cliente.getClienteId());
			ResultSet rset = pstm.executeQuery();
			
			while(rset.next()) {
				cliente.setClienteId(rset.getInt(1));
				cliente.setNome(rset.getNString(2));
				cliente.setCpf(rset.getNString(3));
			}
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public Cliente buscarCliente(int idCli) {
		Cliente clientee = null;
		String sql = "SELECT * FROM cliente WHERE cliente_id =?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCli);
			ResultSet rset = pstm.executeQuery();
			if (rset.next()) {
				clientee = new Cliente();
				clientee.setClienteId(rset.getInt("cliente_id"));
				clientee.setNome(rset.getNString("nome"));
				clientee.setCpf(rset.getNString("cpf"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clientee;
	}
	
	public void EditarCliente(Cliente cliente) {
		String sql = "UPDATE cliente set nome=?, cpf=? where cliente_id=?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setInt(3, cliente.getClienteId());
			pstm.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void DeletarCliente(Cliente cliente) {
		String sql = "DELETE from cliente where cliente_id = ?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cliente.getClienteId());
			pstm.executeUpdate();
			pstm.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}
}
