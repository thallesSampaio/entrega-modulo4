package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.JavaBeans;
import Model.User;


@WebServlet(urlPatterns = { "/Controller", "/mainAdm", "/newMsg", "/newUser", "/admin", "/listar" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
	User usuario = new User();

    
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/admin")) {
			contatos(request, response);
		} else if (action.equals("/newMsg")) {
			contatosMSG(request, response);
		} else if (action.equals("/newUser")) {
			criarUsuario(request, response);
		} else if (action.equals("/mainAdm")) {
			response.sendRedirect("admin.jsp");
		} else if(action.equals("/listar")) {
			listarMsg(request, response);
		} else if(action.equals("/listar")) {
			clientes(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		
	}

	protected void listarMsg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contato_id = request.getParameter("contato_id");
		int numberr = Integer.parseInt(contato_id);
		contato.setContato_id(numberr);
		dao.selecionarContato(contato);
		request.setAttribute("contato_id", contato.getContato_id());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("telefone", contato.getTelefone());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("contatosmsg", contato.getContatoMSG());
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}
	
	private void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<JavaBeans> list = dao.listarMsg();
		request.setAttribute("contatos", list);
		RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
		clientes(request, response);
		rd.forward(request, response);
	}
	
	private void clientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> lista = dao.listarClientes();
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
		rd.forward(request, response);
	}
	
	private void contatosMSG(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setNome(request.getParameter("nomeContato"));
		contato.setEmail(request.getParameter("emailContato"));
		contato.setTelefone(request.getParameter("telefoneContato"));
		contato.setContatoMSG(request.getParameter("mensagemContato"));
		dao.contatosMSG(contato);
		response.sendRedirect("contato.html");
	}

	private void criarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.setNome(request.getParameter("inputName"));
		usuario.setEmail(request.getParameter("inputEmail"));
		usuario.setSenha(request.getParameter("inputPassword"));
		usuario.setCpf(request.getParameter("inputCpf"));
		usuario.setEndereco(request.getParameter("Endereco"));
		usuario.setDataNascimento(request.getParameter("dataNascimento"));
		dao.cadastrarUsuario(usuario);
		response.sendRedirect("cadastro.html");
	}

}
