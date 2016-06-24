<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="card main-panel-danger">
		<div class="card-header BGDanger">
			<div class="card-title">Attention</div>
		</div>
		<div class="main-panel-content card-block">
			<h5 class="card-text">Voulez vous vraiment supprimer l'action
				${action.wording} ?</h5>
			Les éléments suivants seront également supprimés
			<div class="card-footer">
				<c:if test="${hasIndicators==true}">
					<ul class="cascade-ul">
						<li class="cascade-title">Indicators</li>
						<c:forEach items="${action.indicators}" var="indic">
							<li class="cascade-item"><a
								href="detailsIndicator.htm?id=${indic.id}">${indic.wording}</a></li>
						</c:forEach>
					</ul>
				</c:if>
				<c:if test="${hasInscriptionActions==true}">
					<ul class="cascade-ul">
						<li class="cascade-title">Validations</li>
						<c:forEach items="${action.inscriptionActions}" var="ia">
							<li class="cascade-item">${ia.inscription.learner.forname}
								${ia.inscription.learner.surname} |
								${ia.inscription.mission.wording}</li>
							<li>
								<ul>
									<li>${ia.score}</li>
								</ul>
							</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="buttons-group">
				<a href="detailsAction.htm?id=${mission.id}"
					class="btn btn-primary disabled">Annuler</a> <a
					href="deleteValidateAction.htm?id=${action.id}"
					class="btn btn-danger disabled">Supprimer</a>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>