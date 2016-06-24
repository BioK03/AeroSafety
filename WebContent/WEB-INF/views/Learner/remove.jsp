<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="card main-panel-danger">
		<div class="card-header BGDanger">
			<div class="card-title ">Attention</div>
		</div>
		<div class="main-panel-content card-block">
			<p class="card-text">Voulez vous vraiment supprimer l'apprenant ${learner.forname} ${learner.surname} ?</p>
				<div class="card-footer">
					Supprimer un apprenant annulera également les éléments suivants:
				</div>
			<div class="buttons-group">
				<a href="detailsLearner.htm?id=${learner.id}" class="btn btn-primary">
					Annuler
				</a>
				<a href="deleteValidateLearner.htm?id=${learner.id}" class="btn btn-danger">
					Supprimer
				</a>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>