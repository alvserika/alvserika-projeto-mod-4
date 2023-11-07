<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pacotes</title>
<link rel="stylesheet" href="../styles/style.css">
<link rel="stylesheet" href="../styles/home.css">
<link rel="stylesheet" href="../styles/medias.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/devicons/devicon@v2.15.1/devicon.min.css">
<link rel="shortcut icon" href="../assets/favicon.png" type="image/x-icon">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body class="min-vh-100 d-flex flex-column justify-content-between">

<header class="container-fluid bg-white">

    </header>
	<main class="container">
	<div id="select">
	
	</div>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#cadastroModal">Cadastrar pacotes</button>

		<!--incio Modal cadastro -->

		<div class="modal fade" id="cadastroModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Cadastro de pacotes</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>

					<!-- body modal -->
					<div class="modal-body">
						<form action="/tde/pacotes-save">
							<div class="form-group mb-2 ">
								<label for="name">Valor do pacote</label> <input type="text" id="valorPacote"
									name="valor" class="form-control">
							</div>
							<div class="form-group mb-2 ">
								<label for="desconto">Desconto</label> <input type="text" id="descPacote"
									name="desconto" class="form-control">
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Cancelar</button>
								<button type="submit" class="btn btn-primary">Save</button>
							</div>


						</form>

					</div>


				</div>
			</div>
		</div>
		<!--  !fim do modal -->



		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID do Pacote</th>
						<th scope="col">Valor</th>
						<th scope="col">Desconto</th>
						<th scope="col">Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pacotes}" var="p">
						<tr>
							<th scope="row">${p.idPacote}</th>
							<td>${p.valorPacote}</td>
							<td>${p.descPacote}</td>
							<td><a href="#" class="btn btn-warning"
								data-bs-toggle="modal"
								data-bs-target="#atualizarModal${p.idPacote}">Editar</a>

								<button class="btn btn-danger" data-bs-toggle="modal"
									data-bs-target="#excluirModal${p.idPacote}">Excluir</button></td>
						</tr>
						<div class="modal fade" id="excluirModal${p.idPacote}"
							tabindex="-1" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title">Deseja excluir?</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
										<a href="/tde/pacotes-delete?id=${p.idPacote}"
											class="btn btn-danger">Excluir</a>
									</div>
								</div>
							</div>
						</div>

						<!--incio Modal -->

						<div class="modal fade" id="atualizarModal${p.idPacote}"
							tabindex="-1" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h1 class="modal-title fs-5" id="exampleModalLabel">Cadastro de Pacote</h1>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>

									<!-- body modal -->
									<div class="modal-body">

										<form action="/tde/pacotes-save">
											<input type="text" id="idPacote" name="id"
												class="form-control" value="${p.idPacote}" hidden>
											<div class="form-group mb-2 ">
												<label for="name">Valor</label> <input type="text" id="valorPacote"
													name="valor" class="form-control" value="${p.valorPacote}">
											</div>
											<div class="form-group mb-2 ">
												<label for="name">Desconto</label> <input type="text"
													id="descPacote" name="desconto" class="form-control"
													value="${p.descPacote}">
											</div>

											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">Cancelar</button>
												<button type="submit" class="btn btn-primary">Save</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>

						<!--  fim modal -->


					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
	<footer class="ft-cntt">
  	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
		<script type="module" src="../js/listas.js"></script>
</body>
</html>