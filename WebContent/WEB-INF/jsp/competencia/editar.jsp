<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Editar Competencia">

	<h1>Editar Competencia</h1>

	<c:url var="link" value="/competencia/editar" />
	<form:form action="${link}" method="post" commandName="competencia">
	
		<form:hidden path="id" />
		
		<div class="form-group">
			<form:label path="mes">Mes</form:label>
			<form:input path="mes" cssClass="form-control" readonly="true"/>
		</div>
		
		<div class="form-group">
			<form:label path="ano">Ano</form:label>
			<form:input path="ano" cssClass="form-control" readonly="true"/>
		</div>
		
		<div class="form-group">
			<form:label path="horasUteis">Horas Uteis</form:label>
			<form:input path="horasUteis" cssClass="form-control"/>
		</div>
		
		<input type="submit" value="Alterar" class="btn btn-primary bt-lg">
		
		<a class="btn btn-secondary" href="/dashboard-horas/competencia/listar" role="button">Cancelar</a>
		
	</form:form>
</tags:template>