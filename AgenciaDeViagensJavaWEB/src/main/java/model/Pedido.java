package model;

public class Pedido {
	private int Pedido_id;
	private Cliente cliente;
	private Destinos destino;
	private String DataViagem;
	
	public String getDataViagem() {
		return DataViagem;
	}
	public void setDataViagem(String dataViagem) {
		DataViagem = dataViagem;
	}
	public int getPedido_id() {
		return Pedido_id;
	}
	public void setPedido_id(int pedido_id) {
		Pedido_id = pedido_id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Destinos getDestino() {
		return destino;
	}
	public void setDestino(Destinos destino) {
		this.destino = destino;
	}
		
}
