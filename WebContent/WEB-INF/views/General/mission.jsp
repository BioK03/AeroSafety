<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>

<div class="container">
	<div class="row">
		<h1>Trier les actions 
			<span class="glyphicon glyphicon-question-sign" data-toggle="tooltip" data-placement="bottom" title="
				Cliquez sur les actions non tri�es pour qu'elles apparaissent dans le bon ordre dans la partie droite
			"></span>
		</h1>
		<div id="nosort" class="col-xs-6">
			<p>Actions � trier :</p>
			<c:forEach items="${mission.actions}" var="action" varStatus="status">
				<div id="action${action.id}" class="card cardSelAction Tleft col-xs-12 Padding00 BGCustom white-text" data-id="${action.id}">
					<div class="card-content">${action.wording}<span class="glyphicon glyphicon-chevron-right"></span></div>
				</div>
			</c:forEach>
		</div>
		<div id="sort" class="col-xs-6">
			<p>Action tri�es :</p>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>