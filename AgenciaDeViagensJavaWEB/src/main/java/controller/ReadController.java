package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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

@WebServlet(urlPatterns = { "/ReadController", "/ListarCliente", "/ListarDestinos", "/ListarPedidos"})
public class ReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cliente cliente = new Cliente();
	Destinos destino = new Destinos();
	ClienteDAO cliDAO = new ClienteDAO();
	DestinoDAO desDAO = new DestinoDAO();
	PedidoDAO pedDAO = new PedidoDAO();
    public ReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/ListarCliente")) {
			ListarClientes(request, response);
		} else if(action.equals("/ListarDestinos")) {
			ListarDestinos(request, response);
		} else if(action.equals("/ListarPedidos")) {
			ListarPedidos(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void ListarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Cliente> lista = cliDAO.listarClientes();
		
		request.setAttribute("clientes", lista); 
		RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
		rd.forward(request, response);
		}
	
	protected void ListarDestinos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Destinos> lista = desDAO.listarDestinos();
		request.setAttribute("destinos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/ListarDestinos.jsp");
		rd.forward(request, response);
	}
	
	protected void ListarPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Pedido> lista = pedDAO.listarPedidos();
		request.setAttribute("pedidos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/ListarPedidos.jsp");
		rd.forward(request, response);
	}
}
