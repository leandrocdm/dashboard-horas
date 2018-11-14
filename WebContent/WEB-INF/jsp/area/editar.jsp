<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Editar Area">
	<h1>Editar Area</h1>

	<c:url var="link" value="/area/editar" />
	<form:form action="${link}" method="post" commandName="area">
	
		<form:hidden path="id" />
		
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control" />
		</div>
		
		<div class="form-group">
			<form:label path="gestor">Gestor</form:label>
			<form:input path="gestor" cssClass="form-control" />
		</div>
		
		<input type="submit" value="Editar" class="btn btn-primary bt-lg">
		<a class="btn btn-secondary" href="/dashboard-horas/area/listar" role="button">Cancelar</a>
	</form:form>
</tags:template>