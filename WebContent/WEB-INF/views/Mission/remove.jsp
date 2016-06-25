<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="card main-panel-danger">
		<div class="card-header BGDanger">
			<div class="card-title ">Attention</div>
		</div>
		<div class="main-panel-content card-block">
			<h5 class="card-text">Voulez vous vraiment supprimer
				${mission.wording} ?</h5>
			Les éléments suivants seront également supprimés
			<div class="card-footer">
				<c:if test="${hasInscriptions==true}">
					<ul class="cascade-ul">
						<li class="cascade-title">Inscriptions</li>
						<c:forEach items="${mission.inscriptions}" var="inscription">
							<li class="cascade-item">Inscription de <a
								href="detailsLearner.htm?id=${inscription.learner.id}">
									${inscription.learner.forname} ${inscription.learner.surname}</a>
							</li>
							<c:if test="${fn:length(inscription.inscriptionActions)>0}">
								<li>
									<ul>
										<c:forEach items="${inscription.inscriptionActions}" var="ia">
											<li>Validation de l'action ${ia.action.wording} avec
												${ia.score} points</li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
						</c:forEach>
					</ul>
				</c:if>
			</div>


			<div class="buttons-group">
				<a href="detailsLearner.htm?id=${learner.id}"
					class="btn btn-primary"> Annuler </a> <a
					href="deleteValidateLearner.htm?id=${learner.id}"
					class="btn btn-danger"> Supprimer </a>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>