<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="main-panel card">
		<div class="main-panel-header">
			<a href="deleteMission.htm?id=${mission.id}">
				<p class="btn btn-danger FloatRight">
					<span class="glyphicon glyphicon-trash"></span>
				</p>
			</a>
			<a href="addMission.htm?id=${mission.id}">
				<p class="btn btn-warning FloatRight">
					<span class="glyphicon glyphicon-pencil"></span>
				</p>
			</a>
			<a href="associate.htm?mission_id=${mission.id}">
				<p class="btn btn-info FloatRight">
					<span class="fa fa-gears"></span>
				</p>
			</a>
			<div class="main-panel-title">Détails de la mission</div>
		</div>
		<div class="main-panel-content">
			<table class="table table-responsive table-hover">
				<tr>
					<td class="table-field">ID :</td>
					<td>${mission.id}</td>
				</tr>
				<tr>
					<td class="table-field">Libellé :</td>
					<td>${mission.wording}</td>
				</tr>
				<tr>
					<td class="table-field">Apprenants inscrits :</td>
					<td>
						<ul>
							<c:forEach items="${mission.inscriptions}" var="inscription">
								<li>
									<a href="detailsLearner.htm?id=${inscription.learner.id}">
											${inscription.learner.forname} ${inscription.learner.surname} 
									</a>
								</li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="table-field">Actions :</td>
					<td>
						<ul>
							<c:forEach items="${mission.actions}" var="action">
								<li><a href="detailsAction.htm?id=${action.id}">
										${action.wording} </a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>