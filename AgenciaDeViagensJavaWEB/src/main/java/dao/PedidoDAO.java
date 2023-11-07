package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Pedido;



public class PedidoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ClienteDAO clienteDAO = new ClienteDAO();
	DestinoDAO destinoDAO = new DestinoDAO();
	Pedido pedido = new Pedido();
	
	public void cadastrar(Pedido pedido) {
		String sql = "INSERT INTO pedidos (cli_id, dest_id, dataViagem) VALUE (?,?,?)";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pedido.getCliente().getClienteId());
			pstm.setInt(2, pedido.getDestino().getDestino_id());
			pstm.setString(3, pedido.getDataViagem());;
			pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
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
	
	public ArrayList<Pedido> listarPedidos() {
		ArrayList<Pedido> pedidos = new ArrayList<>();
		String sql = "SELECT * from pedidos";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			ResultSet rset = pstm.executeQuery();
			while(rset.next()) {
				Pedido pedido = new Pedido();
				pedido.setPedido_id(rset.getInt("pedido_id"));
				pedido.setCliente(clienteDAO.buscarCliente(rset.getInt("cli_id")));
				pedido.setDestino(destinoDAO.buscarDestino(rset.getInt("dest_id")));
				pedido.setDataViagem(rset.getNString("dataViagem"));
				pedidos.add(pedido);
			}
			conn.close();
			return pedidos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public void DeletarPedido(Pedido pedido) {
		String sql = "DELETE FROM pedidos where pedido_id = ?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pedido.getPedido_id());
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void SelecionarPedido (Pedido pedido) {
		String sql = "select * from pedidos where pedido_id = ?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pedido.getPedido_id());
			ResultSet rset = pstm.executeQuery();
			while(rset.next()) {
				pedido.setPedido_id(1);
				pedido.setCliente(clienteDAO.buscarCliente(rset.getInt(2)));
				pedido.setDestino(destinoDAO.buscarDestino(rset.getInt(3)));
				pedido.setDataViagem(rset.getString(4));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void AtualizarPedido(Pedido pedido) {
		String sql = "UPDATE pedidos SET cli_id=?,dest_id=?,dataViagem=? WHERE pedido_id=?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pedido.getCliente().getClienteId());
			pstm.setInt(2, pedido.getDestino().getDestino_id());
			pstm.setString(3, pedido.getDataViagem());
			pstm.setInt(4, pedido.getPedido_id());
			pstm.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	 
	
}
