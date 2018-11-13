<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tags:template titulo="Listagem Áreas">
	<h1>Lista de Áreas</h1>

	<c:if test="${not empty msgSucesso }">
		<div class="alert alert-success">${msgSucesso }</div>
	</c:if>

	<c:if test="${not empty msgErro }">
		<div class="alert alert-danger">${msgErro }</div>
	</c:if>

	<table class="table">

		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Gestor</th>
		</tr>

		<c:forEach items="${areas }" var="a">
			<tr>
				<td>${a.id }</td>
				<td>${a.nome }</td>
				<td>${a.gestor }</td>
				<td>
				<a class="btn btn-primary" href="<c:url value="/area/editar/${a.id}"/>">Editar</a>
					<button onclick="idExcluir.value = ${a.id }" data-toggle="modal" data-target="#modalExcluir" class="btn btn-danger">Excluir</button>
				</td>
			</tr>
		</c:forEach>
	</table>

	<!-- Modal exclusao -->
	<div class="modal fade" id="modalExcluir" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Exclusão de Área</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Deseja realmente excluir essa Área?</div>
				<div class="modal-footer">
					<c:url value="/area/excluir" var="action" />
					<form action="${action}" method="post">
						<input type="hidden" name="id" id="idExcluir" />
						<button type="submit" class="btn btn-danger bt-lg">Sim,
							Excluir!</button>
					</form>
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				</div>
			</div>
		</div>
	</div>

</tags:template>