package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.DestinoDAO;
import dao.PedidoDAO;
import model.Cliente;
import model.Destinos;
import model.Pedido;


@WebServlet(urlPatterns = { "/DeleteController", "/DeletarCliente", "/DeletarDestino", "/DeletarPedido"})
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cliente cliente = new Cliente();
	Destinos destino = new Destinos();
	Pedido pedido = new Pedido();
	ClienteDAO cliDAO = new ClienteDAO();
	DestinoDAO desDAO = new DestinoDAO();
	PedidoDAO pedDAO = new PedidoDAO();
   
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/DeletarCliente")) {
			DeletarCliente(request, response);
		} else if(action.equals("/DeletarDestino")) {
			DeletarDestino(request, response);
		} else if(action.equals("/DeletarPedido")) {
			DeletarPedido(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
    
    protected void DeletarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idcli = request.getParameter("idcli");
		int number = Integer.parseInt(idcli);
		cliente.setClienteId(number);
		cliDAO.DeletarCliente(cliente);
		response.sendRedirect("/AgenciaDeViagensJavaWEB/ListarCliente");
    }
    
    protected void DeletarDestino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idDest = request.getParameter("idDest");
    	int number = Integer.parseInt(idDest);
    	destino.setDestino_id(number);
    	desDAO.DeletarDestino(destino);
    	response.sendRedirect("/AgenciaDeViagensJavaWEB/ListarDestinos");
    }
    
    protected void DeletarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String idPed = request.getParameter("idPed");
    	int number = Integer.parseInt(idPed);
    	pedido.setPedido_id(number);
    	pedDAO.DeletarPedido(pedido);
    	response.sendRedirect("/AgenciaDeViagensJavaWEB/ListarPedidos");
    }

}
