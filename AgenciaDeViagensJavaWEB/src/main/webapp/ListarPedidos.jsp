<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Pedido"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Pedido> lista = (ArrayList<Pedido>) request.getAttribute("pedidos");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Lista de Pedidos</title>
</head>
<body>
	<header>

		<nav class="navbar navbar-expand-lg bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand text-light" href="Index.html">Navbar</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active text-light"
							aria-current="page" href="Index.html">Home</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-light" href="#"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Clientes </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="ListarCliente">Listar</a></li>
								<li><a class="dropdown-item" href="CadastroCliente.jsp">Cadastrar</a></li>
							</ul></li>
							<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Destinos
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="ListarDestinos">Listar</a></li>
            <li><a class="dropdown-item" href="CadastrarDestino.jsp">Cadastrar</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-light" href="#"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Pedidos </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="ListarPedidos">Listar</a></li>
								<li><a class="dropdown-item" href="CadastroPedido.jsp">Novo</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>

	</header>
	
	<main class="container" style="margin-top: 8%;">

		<div class="container">
			<div class="row">
				<div class="col-md">
					<div class="card bg-transparent shadow">

						<div class="card-body">
							<h1 class="title text-dark">PEDIDOS</h1>
							<div class="tableContainer">
								<table style="margin-top: 20px;" class="table">
								<thead class="text-dark">
									<tr>
										<th>ID</th>
										<th>Nome</th>
										<th>Pais</th>
										<th>Cidade</th>
										<th>Data da Viagem</th>
									</tr>
								</thead>
								<tbody class="text-dark">
									<%
									for (Pedido p : lista) {
									%>
									<tr>
										<td><%=p.getPedido_id()%></td>
										<td><%=p.getCliente().getNome()%></td>
										<td><%=p.getDestino().getPais()%></td>
										<td><%=p.getDestino().getCidade()%></td>
										<td><%=p.getDataViagem()%></td>
										<td> 
											 <a href='SelecionarPedido?idPed=<%=p.getPedido_id()%>' class='btn btn-outline-primary'><i class="bi bi-pencil-square"></i></a>
										     <a href='DeletarPedido?idPed=<%= p.getPedido_id()%>' class='btn btn-outline-danger'><i class="bi bi-trash-fill"></i></a> 
										</td>
										
									</tr>
									<%
									}
									%>

								</tbody>
							</table>
							</div>
						</div>
					</div>
				</div>
	<script src="script.js"></script>
	<footer class="bg-dark text-light text-center py-3 fixed-bottom">
		&copy; 2023 Sua Empresa. Todos os direitos reservados. </footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>