<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="main-panel card">
		<div class="main-panel-header">
			<a href="deleteLearner.htm?id=${learner.id}">
				<p class="btn btn-danger FloatRight">
					<span class="glyphicon glyphicon-trash"></span>
				</p>
			</a> <a href="addLearner.htm?id=${learner.id}">
				<p class="btn btn-warning FloatRight">
					<span class="glyphicon glyphicon-pencil"></span>
				</p>
			</a> 
			<a href="associate.htm?learner_id=${learner.id}">
				<p class="btn btn-info FloatRight">
					<span class="fa fa-gears"></span>
				</p>
			</a>
			<div class="main-panel-title">Détails de l'apprenant</div>
		</div>
		<div class="main-panel-content">
			<table class="table table-responsive table-hover">
				<tr>
					<td class="table-field">ID :</td>
					<td>${learner.id}</td>
				</tr>
				<tr>
					<td class="table-field">Prénom :</td>
					<td>${learner.forname}</td>
				</tr>
				<tr>
					<td class="table-field">Nom :</td>
					<td>${learner.surname}</td>
				</tr>
				<tr>
					<td class="table-field">Adresse email :</td>
					<td>${learner.email}</td>
				</tr>
				<tr>
					<td class="table-field">Missions auxquelles participe
						l'apprenant :</td>
					<td>
						<ul>
							<c:forEach items="${learner.inscriptions}" var="inscription">
								<li><a
									href="detailsMission.htm?id=${inscription.mission.id}">${inscription.mission.wording}</a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="table-field">Actions obtenues :</td>
					<td>
						<ul>
							<c:forEach items="${learner.inscriptions}" var="inscription">
								<c:forEach items="${inscription.inscriptionActions}"	var="inscriptionAction">
									<li><a href="detailsAction.htm?id=${inscriptionAction.action.id}">${inscriptionAction.action.wording}</a></li>
								</c:forEach>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>