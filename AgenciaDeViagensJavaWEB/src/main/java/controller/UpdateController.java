package controller;

import java.io.IOException;

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

@WebServlet(urlPatterns = { "/UpdateController", "/SelecionarCliente", "/EditarCliente", "/SelecionarDestino", "/EditarDestino", "/SelecionarPedido", "/EditarPedido" })
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cliente cliente = new Cliente();
	Destinos destino = new Destinos();
	Pedido pedido = new Pedido();
	ClienteDAO cliDAO = new ClienteDAO();
	DestinoDAO desDAO = new DestinoDAO();
	PedidoDAO pedDAO = new PedidoDAO();

	public UpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/SelecionarCliente")) {
			SelecionarCliente(request, response);
		} else if(action.equals("/EditarCliente")) {
			EditarCliente(request,response);
		} else if(action.equals("/SelecionarDestino")) {
			SelecionarDestino(request,response);
		} else if(action.equals("/EditarDestino")) {
			EditarDestino(request,response);
		} else if(action.equals("/SelecionarPedido")) {
			SelecionarPedido(request,response);
		} else if(action.equals("/EditarPedido")) {
			EditarPedido(request,response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void SelecionarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcli = request.getParameter("idcli");
		int number = Integer.parseInt(idcli);
		cliente.setClienteId(number);
		cliDAO.SelecionarCliente(cliente);
		request.setAttribute("idcli", cliente.getClienteId());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("cpf", cliente.getCpf());
		RequestDispatcher rd = request.getRequestDispatcher("/AtualizarCliente.jsp");
		rd.forward(request, response);

	}
	
	protected void SelecionarDestino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idDest = request.getParameter("idDest");
		int number = Integer.parseInt(idDest);
		destino.setDestino_id(number);
		desDAO.SelecionarDestino(destino);
		request.setAttribute("idDest", destino.getDestino_id());
		request.setAttribute("pais", destino.getPais());
		request.setAttribute("cidade", destino.getCidade());
		RequestDispatcher rd = request.getRequestDispatcher("/AtualizarDestino.jsp");
		rd.forward(request, response);
	}
	
	protected void SelecionarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPed = request.getParameter("idPed");
		int number = Integer.parseInt(idPed);
		pedido.setPedido_id(number);
		pedDAO.SelecionarPedido(pedido);
		request.setAttribute("idPed", pedido.getPedido_id());
		request.setAttribute("idCli", pedido.getCliente().getClienteId());
		request.setAttribute("idDest", pedido.getDestino().getDestino_id());
		request.setAttribute("dataViagem", pedido.getDataViagem());
		RequestDispatcher rd = request.getRequestDispatcher("/AtualizarPedido.jsp");
		rd.forward(request, response);
	}

	protected void EditarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcli = request.getParameter("idcli");
		int number = Integer.parseUnsignedInt(idcli);
		cliente.setClienteId(number);
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliDAO.EditarCliente(cliente);
		response.sendRedirect("/AgenciaDeViagensJavaWEB/ListarCliente");
	}
	
	protected void EditarDestino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idDest = request.getParameter("idDest");
		int number = Integer.parseInt(idDest);
		destino.setDestino_id(number);
		destino.setPais(request.getParameter("pais"));
		destino.setCidade(request.getParameter("cidade"));
		desDAO.EditarDestino(destino);
		response.sendRedirect("/AgenciaDeViagensJavaWEB/ListarDestinos");
		
	}
	protected void EditarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idPed = request.getParameter("idPed");
		int idCli = Integer.parseInt(request.getParameter("idCli"));
		int idDest = Integer.parseInt(request.getParameter("idDest"));
		int number = Integer.parseInt(idPed);
		pedido.setPedido_id(number);
		pedido.getCliente().setClienteId(idCli);
		pedido.getDestino().setDestino_id(idDest);
		pedido.setDataViagem(request.getParameter("dataViagem"));
		pedDAO.AtualizarPedido(pedido);
		response.sendRedirect("/AgenciaDeViagensJavaWEB/ListarPedidos");
	}
}
