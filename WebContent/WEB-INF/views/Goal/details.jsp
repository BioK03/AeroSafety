<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">Détails de l'objectif</div>
		</div>
		<div class="main-panel-content">
			<table class="table table-responsive table-hover">
				<tr>
					<td class="table-field">ID de l'objectif</td>
					<td>${goal.id}</td>
				</tr>
				<tr>
					<td class="table-field">Libellé de l'objectif</td>
					<td>${goal.wording}</td>	
				</tr>
			</table>
			<div class="col-xs-12 Tcenter">
				<c:forEach items="${goal.actions}" var="action" varStatus="status">
					<a href="detailsAction.htm?id=${action.id}">${action.wording}</a> ${status.last? "" : "<span class='glyphicon glyphicon-arrow-right'></span>"}
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>