<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="card main-panel-danger">
		<div class="card-header BGDanger">
			<div class="card-title ">Attention</div>
		</div>
		<div class="main-panel-content card-block">
			<p class="card-text">Voulez vous vraiment supprimer l'indicateur : ${indicator.wording} ?</p>
			<div class="buttons-group">
				<a href="detailsIndicator.htm?id=${indicator.id}" class="btn btn-primary">
					Annuler
				</a>
				<a href="deleteValidateIndicator.htm?id=${indicator.id}" class="btn btn-danger">
					Supprimer
				</a>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>