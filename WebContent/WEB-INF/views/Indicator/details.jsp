<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="main-panel card">
		<div class="main-panel-header">
			<a href="deleteIndicator.htm?id=${indicator.id}">
				<p class="btn btn-danger FloatRight">
					<span class="glyphicon glyphicon-trash"></span>
				</p>
			</a>
			<div class="main-panel-title">D�tails de l'indicateur</div>
		</div>
		<div class="main-panel-content">
			<table class="table table-responsive table-hover">
				<tr>
					<td class="table-field">ID :</td>
					<td>${indicator.id}</td>
				</tr>
				<tr>
					<td class="table-field">Libell� :</td>
					<td>${indicator.wording}</td>
				</tr>
				<tr>
					<td class="table-field">Action valoris�e :</td>
					<td><a href="detailsAction.htm?id=${indicator.action.id}">
							${indicator.action.wording} </a></td>
				</tr>
				<tr>
					<td class="table-field">Valeur ajout�e :</td>
					<td>${indicator.valueIfCheck}</td>
				</tr>
				<tr>
					<td class="table-field">Valeur ajout�e :</td>
					<td>${indicator.valueIfCheck}</td>
				</tr>
				<tr>
					<td class="table-field">Valeur appliqu�e en cas d'absence :</td>
					<td>${indicator.valueIfUnCheck}</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>