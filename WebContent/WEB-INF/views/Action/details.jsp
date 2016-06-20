<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<div class="main-panel card">
		<div class="main-panel-header">
			<a href="deleteAction.htm?id=${action.id}">
				<p class="btn btn-danger FloatRight">
					<span class="glyphicon glyphicon-trash"></span>
				</p>
			</a>
			<div class="main-panel-title">Détails de l'action</div>
		</div>
		<div class="main-panel-content">
			<table class="table table-responsive table-hover">
				<tr>
					<td class="table-field">ID :</td>
					<td>${action.id}</td>
				</tr>
				<tr>
					<td class="table-field">Libellé :</td>
					<td>${action.wording}</td>
				</tr>
				<tr>
					<td class="table-field">Score minimum :</td>

					<td>${action.sc	oreMinimum}</td>
				</tr>
				<tr>
					<td class="table-field">Action suivante :</td>
					<td><a href="detailsAction.htm?id=${nextAction.id}">
							${nextAction.wording} </a></td>
				</tr>
				<tr>
					<td class="table-field">Prédécesseurs</td>
					<td>
						<ul>
							<c:forEach var="predecessor" items="${action.actions}">
								<li><a href="detailsAction.htm?id=${predecessor.id}">
										${predecessor.wording} </a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="table-field">Indicateurs valorisant l'action :</td>
					<td>
						<ul>
							<c:forEach items="${action.indicators}" var="indicator">
								<li><a href="detailsIndicator.htm?id=${indicator.id}">
										TODO : Insert wording here </a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="table-field">Missions intégrant l'action :</td>
					<td>
						<ul>
							<c:forEach items="${action.inscriptionActions}" var="inscriptionAction">
								<li><a
									href="detailsMission.htm?id=${inscriptionAction.inscription.id}">
										${inscriptionAction.inscription.forname}
										${inscriptionAction.inscription.surname} </a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>