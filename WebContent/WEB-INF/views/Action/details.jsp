<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">Détails de l'action</div>
		</div>
		<div class="main-panel-content">
			<table class="table table-responsive table-hover">
				<tr>
					<td class="table-field">ID :</td>
					<td>${action.id }</td>
				</tr>
				<tr>
					<td class="table-field">Libellé :</td>
					<td>${action.wording }</td>
				</tr>
				<tr>
					<td class="table-field">Score minimum :</td>

					<td>${action.scoreMinimum }</td>
				</tr>
				<tr>
					<td class="table-field">Action suivante :</td>
					<td><a href="detailsAction.htm?id=${nextAction.id}">${nextAction.wording}</a></td>
				</tr>
				<tr>
					<td class="table-field">Jeux où apparait l'action :</td>
					<td>
						<ul>
							<c:forEach items="${action.games}" var="game">
								<li><a href="detailsGame.htm?id=${game.id }">${game.wording }</a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="table-field">Indicateurs valorisant l'action :</td>
					<td>
						<ul>
							<c:forEach items="${action.indicators }" var="indicator">
								<li><a href="detailsIndicator.htm?id=${indicator.id }">TODO
										: Insert wording here</a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="table-field">Objectifs comprenant l'action :</td>
					<td>
						<ul>
							<c:forEach items="${action.goals }" var="goal">
								<li><a href="detailsGoal.htm?id=${goal.id }">${goal.wording }</a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="table-field">Apprenants ayant obtenu l'action :</td>
					<td>
						<ul>
							<c:forEach items="${action.learnerActions}" var="learnerAction">
								<li><a
									href="detailsLearner.htm?id=${learnerAction.learner.id }">${learnerAction.learner.forname }
										${learnerAction.learner.surname }</a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>