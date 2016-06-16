<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">Détails de la mission</div>
		</div>
		<div class="main-panel-content">
			<table class="table table-responsive table-hover">
				<tr>
					<td class="table-field">ID :</td>
					<td>${myMission.id }</td>
				</tr>
				<tr>
					<td class="table-field">Libellé :</td>
					<td>${myMission.wording }</td>
				</tr>
				<tr>
					<td class="table-field">Jeu incorporant la mission :</td>
					<td><a href="detailsGame.htm?id=${myMission.game.id}">${myMission.game.wording }</a></td>
				</tr>
				<tr>
					<td class="table-field">Objectifs :</td>

					<td><ul>
							<c:forEach items="${myMission.goals }" var="goal">
								<li><a href="detailsGoal.htm?id=${goal.id }">${goal.wording }</a></li>
							</c:forEach>
						</ul></td>
				</tr>

			</table>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>