<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="card main-panel-danger">
		<div class="card-header BGDanger">
			<div class="card-title ">Attention</div>
		</div>
		<div class="main-panel-content card-block">
			<p class="card-text">Voulez vous vraiment supprimer le jeu
				${game.wording } ?</p>
			<div class="card-footer">
				<h6>Supprimer un jeu supprimera également les éléments suivants :</h6>
				<h6>NOTE: NE MARCHE PAS A CAUSE DES INSCRIPTIONS</h6>
				<div class="list-group">
					<span class="list-group-item active"> Inscriptions </span>
					<c:forEach var="mission" items="${game.inscriptions}">
						<a class="list-group-item"
							href="detailsMission.htm?id=${mission.id}">${mission.wording }</a>
					</c:forEach>
				</div>				
				<div class="list-group">
					<span class="list-group-item active"> Missions </span>
					<c:forEach var="mission" items="${game.missions}">
						<a class="list-group-item"
							href="detailsMission.htm?id=${mission.id}">${mission.wording }</a>
					</c:forEach>
				</div>


			</div>
			<div class="buttons-group">
				<a href="detailsGame.htm?id=${game.id }"
					class="btn btn-primary">Annuler</a> <a
					href="deleteValidateGame.htm?id=${game.id }"
					class="btn btn-danger">Supprimer</a>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>