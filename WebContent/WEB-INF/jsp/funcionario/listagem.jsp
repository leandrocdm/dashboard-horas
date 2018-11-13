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
			<th></th>
		</tr>
		
		<c:forEach items="${funcionarios }" var="f">
			<tr>
				<td>${f.id }</td>
				<td>${f.nome }</td>
				<td>${f.matricula }</td>
				<td><button onclick="idExcluir.value = ${f.id }" data-toggle="modal" data-target="#modalExcluir" class="btn btn-outline-danger">Excluir</button>
			</tr>
		</c:forEach>
	</table>
	
	<!-- Modal exclusao -->
	<div class="modal fade" id="modalExcluir" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Excluir Convidado</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Deseja realmente excluir o funcionario?
	      </div>
	      <div class="modal-footer">
	      	<c:url value="/funcionario/excluir" var="action"/>
	      	<form action="${action}" method="post">
	      		<input type="hidden" name="id" id="idExcluir"/>
		        <button type="submit" class="btn btn-danger">Sim</button>
	        </form>
		    <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
	      </div>
	    </div>
	  </div>
	</div>
	
</tags:template>