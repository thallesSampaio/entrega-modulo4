package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Destinos;

public class DestinoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	
	public void cadastrar(Destinos destino) {
		String sql = "INSERT INTO destinos(pais,cidade)" + "VALUES(?,?)";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setNString(1, destino.getPais());
			pstm.setNString(2, destino.getCidade());
			pstm.execute();
			pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Destinos> listarDestinos() {
		ArrayList<Destinos> destinos = new ArrayList<>();
		String sql = "SELECT * FROM destinos";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			ResultSet rset = pstm.executeQuery();
			while(rset.next()) {
				int idDest = rset.getInt(1);
				String pais = rset.getNString(2);
				String cidade = rset.getNString(3);
				destinos.add(new Destinos(idDest, pais, cidade));
			}
			conn.close();
			return destinos;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public void SelecionarDestino(Destinos destino) {
		String sql = "select * from destinos where destino_id = ?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, destino.getDestino_id());
			ResultSet rset = pstm.executeQuery();
			while(rset.next()) {
				destino.setDestino_id(rset.getInt(1));
				destino.setPais(rset.getNString(2));
				destino.setCidade(rset.getNString(3));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Destinos buscarDestino(int idDest) {
		Destinos destino = null;
		String sql = "SELECT * FROM destinos WHERE destino_id = ?";
		
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idDest);
			ResultSet rset = pstm.executeQuery();
			if (rset.next()) {
				destino = new Destinos();
				destino.setDestino_id(rset.getInt("destino_id"));
				destino.setPais(rset.getNString("pais"));
				destino.setCidade(rset.getNString("cidade"));
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
		return destino;
	}
	
	
	public void EditarDestino(Destinos destino) {
		String sql = "UPDATE destinos set pais=?, cidade=? where destino_id=?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, destino.getPais());
			pstm.setString(2, destino.getCidade());
			pstm.setInt(3, destino.getDestino_id());
			pstm.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void DeletarDestino(Destinos destino) {
		String sql = "DELETE from destinos where destino_id = ?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, destino.getDestino_id());
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
