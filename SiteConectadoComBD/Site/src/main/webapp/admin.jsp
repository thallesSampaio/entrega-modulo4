<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.JavaBeans"%>
<%@ page import="Model.User"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> list = (ArrayList<JavaBeans>) request.getAttribute("contatos");
ArrayList<User> lista = (ArrayList<User>) request.getAttribute("clientes");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="node_modules/bootstrap/dist/css/bootstrap.css">
<link rel="stylesheet" href="style/admin.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="shortcut icon" href="imgs/favIcon96px.ico.png"
	type="image/x-icon">
<script src="https://cdn.tailwindcss.com"></script>

<title>RJTRIP - ADMNISTRADOR</title>
</head>
<body
	style="
	background-color: #e79087;
background-image: linear-gradient(315deg, #e79087 0%, #fcd181 74%);
">
	<!-- header -->
	<header class="p-3 text-bg-transparent">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

				<a href="Index.html"><img src="imgs/logo100px.png" alt=""
					srcset=""></a>
				<nav style="margin-left: 2%;"
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<ul class="nav justify-content-center">
						<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Destinos</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Promoções</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Contatos</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Pacotes</a>
						</li>
					</ul>
				</nav>
	</header>

	<!-- MAIN -->
	<main class="container" style="margin-top: 8%;">

		<div class="container">
			<div class="row">
				<div class="col-md">
					<div class="card bg-transparent shadow">

						<div class="card-body">
							<h1 class="title text-dark">MENSAGENS</h1>
							<div class="tableContainer">
								<table style="margin-top: 20px;" class="tabelaBonita">
								<thead class="text-dark">
									<tr>
										<th>ID</th>
										<th>Nome</th>
										<th>Telefone</th>
										<th>Email</th>
										<th>Mensagem</th>
									</tr>
								</thead>
								<tbody class="text-dark">
									<%
									for (JavaBeans jb : list) {
									%>
									<tr class="border-bottom border-dark">
										<td><%=jb.getContato_id()%></td>
										<td><%=jb.getNome()%></td>
										<td><%=jb.getTelefone()%></td>
										<td><%=jb.getEmail()%></td>
										<td><%=jb.getContatoMSG()%></td>
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
				
				<div class="col-md">
				<div class="card bg-transparent shadow"">

					<div class="card-body">
						<h1 class="title text-dark">CLIENTES</h1>
						<div class="tableContainer">
							<table style="margin-top: 20px;" class="tabelaBonita">
								<thead class="text-dark">
									<tr>
										<th>ID</th>
										<th>Nome</th>
										<th>Cpf</th>
										<th>Data Nascimento</th>
										<th>Email</th>
										<th>Endereco</th>
									</tr>
								</thead>
								<tbody class="text-dark">
									<%
									for (User jbc : lista) {
									%>
									<tr class="border-bottom border-dark">
										<td><%=jbc.getClienteId()%></td>
										<td><%=jbc.getNome()%></td>
										<td><%=jbc.getCpf()%></td>
										<td><%=jbc.getDataNascimento()%></td>
										<td><%=jbc.getEmail()%></td>
										<td><%=jbc.getEndereco()%></td>
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
			</div>
			
		</div>
		

	</main>

	<!--footer do site-->
	<footer id="footer" class="bg-transparent text-dark text-center py-3"
		style="margin-top: 8%;">
		<p>
			Todos os direitos reservados &copy; 2023 <span class="spanTxt">RJTRIP</span>
		</p>
		<p>Developed by:
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
				fill="currentColor" class="bi bi-github" viewBox="0 0 16 16">
                <path
					d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z" />
            </svg>
			<a style="color: #fdba00; text-decoration: none;" class="github"
				href="https://github.com/ThallesSampaio" target="_blank">ThallesSampaio</a>
		</p>
	</footer>

	<!--JAVASCRIPT-->
	<script src="scripts/script.js"></script>
	<script src="../assets/javascript/script.js"></script>
	<script src="../../node_modules/bootstrap/dist/js/bootstrap.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>