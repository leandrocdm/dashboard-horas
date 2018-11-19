<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="titulo" required="true"%>
<%@ attribute name="scripts" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard Horas | ${titulo }</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="<c:url value="/"/>">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Funcionario </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							href="<c:url value="/funcionario/cadastrar"/>">Cadastrar</a> <a
							class="dropdown-item" href="<c:url value="/funcionario/listar"/>">Listar</a>
					</div>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Area </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<c:url value="/area/cadastrar"/>">Cadastrar</a>
						<a class="dropdown-item" href="<c:url value="/area/listar"/>">Listar</a>
					</div>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Mes/Competencia </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							href="<c:url value="/competencia/cadastrar"/>">Cadastrar</a> <a
							class="dropdown-item" href="<c:url value="/competencia/listar"/>">Listar</a>
					</div>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/bancodehoras/listagem"/>">Banco de Horas</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<br>
		<jsp:doBody />
		<br>
		<p>Todos os direitos reservados &copy; - 2018</p>
	</div>
	<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

	<jsp:invoke fragment="scripts"></jsp:invoke>

</body>
</html>