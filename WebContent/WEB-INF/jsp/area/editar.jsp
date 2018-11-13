<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Editar Área">
	<h1>Edição de Área</h1>

	<c:if test="${not empty msgSucesso }">
		<div class="alert alert-success">${msgSucesso }</div>
	</c:if>

	<c:if test="${not empty msgErro }">
		<div class="alert alert-danger">${msgErro }</div>
	</c:if>

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
		<input type="submit" value="Cancelar" class="btn btn-secondary bt-lg"
			value="/area/lsitagem">
	</form:form>

</tags:template>