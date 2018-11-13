<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Cadastro de Área">
	<h1>Cadastro de Área</h1>

	<c:if test="${not empty msgSucesso }">
		<div class="alert alert-success">${msgSucesso }</div>
	</c:if>

	<c:if test="${not empty msgErro }">
		<div class="alert alert-danger">${msgErro }</div>
	</c:if>

	<c:url value="/area/cadastrar" var="acao" />
	<form:form action="${acao}" method="post" commandName="area">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control" />
			<form:errors path="nome" />
		</div>
		<div class="form-group">
			<form:label path="gestor">Gestor</form:label>
			<form:input path="gestor" cssClass="form-control" />
			<form:errors path="gestor" />
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">
		<input type="submit" value="Cancelar" class="btn btn-secondary"
			value="/">
	</form:form>

</tags:template>