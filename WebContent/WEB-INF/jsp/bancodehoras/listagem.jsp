<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tags:template titulo="Banco de Horas">
	<h1>Banco de Horas</h1>

	<c:if test="${not empty msgSucesso }">
		<div class="alert alert-success">${msgSucesso }</div>
	</c:if>

	<c:if test="${not empty msgErro }">
		<div class="alert alert-danger">${msgErro }</div>
	</c:if>

	<table class="table">

		<tr>
			<th>Matricula</th>
			<th>Nome</th>
			<th>Area</th>
			<th>Quantidade de Horas</th>
		</tr>

		<c:forEach items="${bancodehoras }" var="b">
			<tr>
				<td>${b.funcionario.matricula}</td>
				<td>${b.funcionario.nome }</td>
				<td>${b.area.nome }</td>
				<td>${b.funcionario.qtdHorasAtual }</td>
			</tr>
		</c:forEach>
	</table>

</tags:template>