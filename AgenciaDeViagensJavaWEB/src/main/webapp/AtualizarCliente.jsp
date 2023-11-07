<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Editar Cliente</title>
</head>
<body>
	<header>
		
		<nav class="navbar navbar-expand-lg bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand text-light" href="Index.html">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active text-light" aria-current="page" href="Index.html">Home</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Clientes
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="ListarCliente">Listar</a></li>
            <li><a class="dropdown-item" href="CadastroCliente.jsp">Cadastrar</a></li>
          </ul>
        </li>
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


	<main>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h1 class="mt-5" >Editar Cliente</h1>
				<form class="mt-5" action="EditarCliente">
				<div class="form-group">
						<label for="nome">ID Cliente:</label> <input type="text"
							class="form-control" id="idcli" name="idcli" readonly value="<%out.print(request.getAttribute("idcli"));%>">
					</div>
					<div class="form-group">
						<label for="nome">Nome:</label> <input type="text"
							class="form-control" id="nome" name="nome" required value="<%out.print(request.getAttribute("nome"));%>">
					</div>
					<div class="form-group">
						<label for="cpf">CPF:</label> <input type="text"
							class="form-control" id="cpf" name="cpf" required value="<%out.print(request.getAttribute("cpf"));%>">
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form>
			</div>
		</div>
	</div>
	</main>
	
	<footer class="bg-dark text-light text-center py-3 fixed-bottom">
        &copy; 2023 Sua Empresa. Todos os direitos reservados.
    </footer>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>