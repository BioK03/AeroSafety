<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="main-panel card">
		<div class="main-panel-header">
			<a href="deleteIndicator.htm?id=${myIndicator.id }">
				<p class="btn btn-danger FloatRight">
					<span class="glyphicon glyphicon-trash"></span>
				</p>
			</a>
			<div class="main-panel-title">Détails de l'indicateur</div>
		</div>
		<div class="main-panel-content">
			<table class="table table-responsive table-hover">
				<tr>
					<td class="table-field">ID :</td>
					<td>${myIndicator.id }</td>
				</tr>
				<tr>
					<td class="table-field">Action valorisée :</td>
					<td><a href="detailsAction.htm?id=${myIndicator.action.id }">${myIndicator.action.wording }</a></td>
				</tr>
				<tr>
					<td class="table-field">Poids :</td>
					<td>${myIndicator.weight }</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>