<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="card main-panel-danger">
		<div class="card-header BGDanger">
			<div class="card-title">Attention</div>
		</div>
		<div class="main-panel-content card-block">
			<p class="card-text">
				Voulez vous vraiment supprimer l'action : ${action.wording} ?<br/>
			</p>
			<p class="card-text">
				<h5>Attention, les éléments suivants seront également supprimés :</h5>
				<ul>
				<c:forEach items="cascade" var="obj">
					<li></li>
				</c:forEach>
				</ul>
			</p>
			<div class="card-footer">
			</div>
			<div class="buttons-group">
				<a href="detailsAction.htm?id=${mission.id}" class="btn btn-primary disabled">Annuler</a>
				<a href="deleteValidateAction.htm?id=${action.id}" class="btn btn-danger disabled">Supprimer</a>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>