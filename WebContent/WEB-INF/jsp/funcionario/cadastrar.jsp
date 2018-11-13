<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Cadastro de Funcionarios">

	<h1>Cadastro de Funcionario</h1>

	<c:if test="${not empty msgSucesso }">
		<div class="alert alert-success">${msgSucesso }</div>
	</c:if>

	<c:if test="${not empty msgErro }">
		<div class="alert alert-danger">${msgErro }</div>
	</c:if>

	<c:url value="/funcionario/cadastrar" var="acao" />
	<form:form action="${acao}" method="post" commandName="funcionario">
	
		<div class="form-group">
			<form:label path="matricula">Matricula</form:label>
			<form:input path="matricula" cssClass="form-control" />
			<form:errors path="matricula" />
		</div>
		
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control" />
			<form:errors path="nome" />
		</div>
		
		<div class="form-group">
			<form:label path="qtdHorasAtual">Quantidade Hora Atual</form:label>
			<form:input path="qtdHorasAtual" cssClass="form-control" />
			<form:errors path="qtdHorasAtual" />
		</div>
		
		<div class="form-group">
			<form:label path="area">Area</form:label>
			<form:select path="area.id" cssClass="form-control">
			<form:options items="${areas }" itemLabel="nome" itemValue="id" />
			</form:select>
		</div>
		
		<input type="submit" value="Cadastrar" class="btn btn-primary">
		
		<a class="btn btn-secondary" href="/dashboard-horas/" role="button">Voltar</a>
		
	</form:form>
</tags:template>