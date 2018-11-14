<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tags:template titulo="Lista de Competencias">
	<h1>Lista de Competencias</h1>

	<c:if test="${not empty msgSucesso }">
		<div class="alert alert-success">${msgSucesso }</div>
	</c:if>

	<c:if test="${not empty msgErro }">
		<div class="alert alert-danger">${msgErro }</div>
	</c:if>

	<table class="table">

		<tr>
			<th>ID</th>
			<th>Mes</th>
			<th>Ano</th>
			<th>Horas Uteis</th>
		</tr>

		<c:forEach items="${competencias }" var="c">
			<tr>
				<td>${c.id }</td>
				<td>${c.mes }</td>
				<td>${c.ano }</td>
				<td>${c.horasUteis }</td>
				<td>
				<a class="btn btn-primary" href="<c:url value="/competencia/editar/${c.id}"/>">Alterar Horas Uteis</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</tags:template>