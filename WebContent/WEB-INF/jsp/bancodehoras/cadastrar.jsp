<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Cadastro de Banco de Horas">

	<h1>Cadastro de Banco de Horas</h1>

	<c:if test="${not empty msgSucesso }">
		<div class="alert alert-success">${msgSucesso }</div>
	</c:if>

	<c:if test="${not empty msgErro }">
		<div class="alert alert-danger">${msgErro }</div>
	</c:if>

	<c:url value="/bancodehoras/cadastrar" var="acao" />
	<form:form action="${acao}" method="post" commandName="banco">
	
	<!-- 
		<div class="form-group">
			<form:label path="bancodehoras.funcionario">Funcionario</form:label>
			<form:select path="bancodehoras.funcionario.id" cssClass="form-control">
			<form:options items="${funcionarios }" itemLabel="nome" itemValue="id" />
			</form:select>
		</div>
		
		
		<div class="form-group">
			<form:label path="competencia">Competencia</form:label>
			<form:select path="competencia.id" cssClass="form-control">
			<form:options items="${competencias }" itemLabel="ano" itemValue="id" />
			</form:select>
		</div>
		 -->
		
		
		<input type="submit" value="Cadastrar" class="btn btn-primary">
		
		<a class="btn btn-secondary" href="/dashboard-horas/" role="button">Voltar</a>
		
	</form:form>
</tags:template>