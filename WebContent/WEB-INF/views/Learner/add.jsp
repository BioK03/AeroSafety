<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<c:set var="isEdit" value="${MyLearner != null}" />
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">Ajouter un apprenant</div>
		</div>
		<div class="main-panel-content">
			<div class="form">
				<form action="" method="POST">
					<c:if test="${isEdit }">
						<input type="hidden" name="id" value="${MyLearner.id }">
					</c:if>
					<div class="form-row">
						<div class="form-field form-field-left">
							<c:if test="${isEdit}">
								<c:set var="surname" value="${MyLearner.surname}" />
							</c:if>
							<div class="form-label">Nom de l'apprenant :</div>
							<div class="form-input">
								<input type="text" name="surname" value="${surname }" />
							</div>
						</div>
						<div class="form-field form-field-right">
							<c:if test="${isEdit}">
								<c:set var="forname" value="${MyLearner.forname}" />
							</c:if>
							<div class="form-label">Prénom de l'apprenant:</div>
							<div class="form-input">
								<input type="text" name="forname" value="${forname }" />
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-field form-field-left">
							<c:if test="${isEdit}">
								<c:set var="email" value="${MyLearner.email}" />
							</c:if>
							<div class="form-label">Adresse mail de l'apprenant :</div>
							<div class="form-input">
								<input type="text" name="email" value="${email }" />
							</div>
						</div>
						<div class="form-field form-field-right">
							<c:if test="${isEdit}">
								<c:set var="mdp" value="${MyLearner.mdp}" />
							</c:if>
							<div class="form-label">Mot de passe de l'apprenant:</div>
							<div class="form-input">
								<input type="text" name="forname" value="${mdp }" />
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Actions obtenues par l'apprenant :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="learnerActions"
										value="${MyLearner.learnerActions }" />
								</c:if>
								<select multiple class="chosen-select" class="form-input"
									name="actions">
									<c:forEach items="${actions}" var="action">
										<option value="${action.id }"
											<c:if 
										test="${isEdit and fn:contains(learnerActions, action.learnerActions)}"> selected</c:if>>
											${action.wording}</option>
									</c:forEach>
								</SELECT>
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Jeux auxquels est inscrit
								l'apprenant :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="jeux" value="${MyLearner.games }" />
								</c:if>
								<select multiple class="chosen-select" class="form-input"
									name="goals">
									<c:forEach items="${games}" var="game">
										<option value="${game.id }"
											<c:if test="${isEdit and fn:contains(jeux, game) }"> selected</c:if>>${game.wording}</option>
									</c:forEach>
								</SELECT>
							</div>
						</div>
					</div>
					<div class="form-submit">
						<input class="btn btn-primary" type="submit" value="Valider" />
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>