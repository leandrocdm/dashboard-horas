<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Editacao de Funcionario">

	<h1>Editar Funcionario</h1>

	<c:url var="link" value="/funcionario/editar" />
	<form:form action="${link}" method="post" commandName="funcionario">
	
		<form:hidden path="id" />
		
		<div class="form-group">
			<form:label path="matricula">Matricula</form:label>
			<form:input path="matricula" cssClass="form-control" />
		</div>
		
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control" />
		</div>
		
		<div class="form-group">
			<form:label path="area">Area</form:label>
			<form:select path="area.id" cssClass="form-control">
			<form:options items="${areas }" itemLabel="nome" itemValue="id" />
			</form:select>
		</div>
		
		<input type="submit" value="Editar" class="btn btn-primary bt-lg">
		
		<a class="btn btn-secondary" href="/dashboard-horas/funcionario/listar" role="button">Cancelar</a>
		
	</form:form>
</tags:template>