<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Cadastro de Competencia">

	<h1>Cadastro de Competencia</h1>

	<c:if test="${not empty msgSucesso }">
		<div class="alert alert-success">${msgSucesso }</div>
	</c:if>

	<c:if test="${not empty msgErro }">
		<div class="alert alert-danger">${msgErro }</div>
	</c:if>

	<c:url value="/competencia/cadastrar" var="acao" />
	<form:form action="${acao}" method="post" commandName="competencia">
	
    <div class="form-group">
	  <form:label path="mes">Mes</form:label>
      <form:select path="mes" class="form-control" id="mes">
        <option>Janeiro</option>
        <option>Fevereiro</option>
        <option>Marco</option>
        <option>Abril</option>
        <option>Maio</option>
        <option>Junho</option>
        <option>Julho</option>
        <option>Agosto</option>
        <option>Setembro</option>
        <option>Outrubro</option>
        <option>Novembro</option>
        <option>Dezembro</option>
      </form:select>
      </div>
		
	
    <div class="form-group">
	  <form:label path="ano">Ano</form:label>
      <form:select path="ano" class="form-control" id="ano">
        <option>2018</option>
        <option>2019</option>
        <option>2020</option>
        <option>2021</option>
        <option>2022</option>
        <option>2023</option>
        <option>2024</option>
        <option>2025</option>
      </form:select>
      </div>
		
		<div class="form-group">
			<form:label path="horasUteis">Quantidade de Horas Uteis</form:label>
			<form:input path="horasUteis" cssClass="form-control" />
			<form:errors path="horasUteis" />
		</div>
				
		<input type="submit" value="Cadastrar" class="btn btn-primary">
		
		<a class="btn btn-secondary" href="/dashboard-horas/" role="button">Voltar</a>
		
	</form:form>
</tags:template>