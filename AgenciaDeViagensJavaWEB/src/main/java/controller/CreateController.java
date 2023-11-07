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


@WebServlet(urlPatterns = { "/CreateController", "/CadastrarCliente", "/CadastrarDestino", "/CadastrarPedido"})
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cliente cliente = new Cliente();
	Destinos destino = new Destinos();
	Pedido pedido = new Pedido();
	ClienteDAO cliDAO = new ClienteDAO();
	DestinoDAO desDAO = new DestinoDAO();
	PedidoDAO pedDAO = new PedidoDAO();
	
	
    public CreateController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/CadastrarCliente")) {
			newClient(request, response);
		} else if (action.equals("/CadastrarDestino")) {
			newDestino(request, response);
		} else if (action.equals("/CadastrarPedido")) {
			newPedido(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void newClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliDAO.cadastrar(cliente);
		response.sendRedirect("CadastroCliente.jsp");
		
	}
	
	protected void newDestino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		destino.setPais(request.getParameter("pais"));
		destino.setCidade(request.getParameter("cidade"));
		desDAO.cadastrar(destino);
		response.sendRedirect("CadastrarDestino.jsp");
	}
	
	protected void newPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCli = Integer.parseInt(request.getParameter("idCli"));
		int idDest = Integer.parseInt(request.getParameter("idDest"));
		Cliente clienteSelecionar = cliDAO.buscarCliente(idCli);
		Destinos destinoSelecionar = desDAO.buscarDestino(idDest);
		pedido.setCliente(clienteSelecionar);
		pedido.setDestino(destinoSelecionar);
		pedido.setDataViagem(request.getParameter("dataViagem"));
		pedDAO.cadastrar(pedido);
		response.sendRedirect("CadastroPedido.jsp");
	}
}
