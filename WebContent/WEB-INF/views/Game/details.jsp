<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">Détails du Jeu</div>
		</div>
		<div class="main-panel-content">
			<table class="table table-responsive table-hover">
				<tr>
					<td class="table-field">ID :</td>
					<td>${game.id }</td>
				</tr>
				<tr>
					<td class="table-field">Libellé :</td>
					<td>${game.wording }</td>
				</tr>
				<tr>
					<td class="table-field">Actions du jeu :</td>
					<td>
						<ul>
							<c:forEach items="${game.actions}" var="action">
								<li><a href="detailsAction.htm?id=${action.id}">
										${action.wording }</a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="table-field">Apprenants inscrits :</td>
					<td>
						<ul>
							<c:forEach items="${game.learners}" var="learner">
								<li><a href="detailsLearner.htm?id=${learner.id}">
										${learner.forname} ${learner.surname }</a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="table-field">Missions :</td>
					<td>
						<ul>
							<c:forEach items="${game.missions}" var="mission">
								<li><a href="detailsMission.htm?id=${mission.id}">
										${mission.wording }</a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>