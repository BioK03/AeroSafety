<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="main-panel card">
		<div class="main-panel-header">
			<a href="deleteLearner.htm?id=${learner.id }">
				<p class="btn btn-danger FloatRight">
					<span class="glyphicon glyphicon-trash"></span>
				</p>
			</a>
			<div class="main-panel-title">Détails de l'apprenant</div>
		</div>
		<div class="main-panel-content">
			<table class="table table-responsive table-hover">
				<tr>
					<td class="table-field">ID</td>
					<td>${learner.id}</td>
				</tr>
				<tr>
					<td class="table-field">Prénom</td>
					<td>${learner.forname}</td>
				</tr>
				<tr>
					<td class="table-field">Nom</td>
					<td>${learner.surname}</td>
				</tr>
				<tr>
					<td class="table-field">Adresse email</td>
					<td>${learner.email}</td>
				</tr>
				<tr>
					<td class="table-field">Jeux auxquels est inscrit l'apprenant</td>
					<td>
						<ul>
							<c:forEach items="${learner.games}" var="game">
								<li><a href="detailsGame.htm?id=${game.id }">${game.wording }</a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="table-field">Actions obtenues</td>
					<td>
						<ul>
							<c:forEach items="${learner.learnerActions }" var="learnerAction">
								<li><a href="detailsAction.htm?id=${learnerAction.action.id }">${learnerAction.action.wording }</a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>