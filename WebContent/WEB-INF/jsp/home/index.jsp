<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template titulo="Pagina Inicial">

	<jsp:attribute name="scripts"></jsp:attribute>

	<jsp:body>
	<div class="jumbotron">
  <h1 class="display-3">Dashboard de Horas</h1>
  <p class="lead">Painel desenvolvido para fazer o controle de horas dos funcionarios PJ da Centauro!</p>
  <hr class="my-4">
  <p class="lead">
  <p> Voce pode listar todos os funcionarios ja cadastrados:</p>
    <a class="btn btn-primary btn-lg" href="/dashboard-horas/funcionario/listar" role="button">Clique aqui</a>
</div>
	</jsp:body>

</tags:template>