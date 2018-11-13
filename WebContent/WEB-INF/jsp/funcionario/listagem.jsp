<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:template titulo="Listagem Funcionarios">
	<h1>Lista de Funcionarios</h1>
	
	<table class="table">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Matricula</th>
		</tr>
		<c:forEach items="${funcionarios }" var="f">
			<tr>
				<td>${f.id }</td>
				<td>${f.nome }</td>
				<td>${f.matricula }</td>
			</tr>
		</c:forEach>
	</table>
</tags:template>