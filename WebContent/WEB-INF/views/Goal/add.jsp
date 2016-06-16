<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<c:set var="isEdit" value="${MyGoal != null}" />
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">
				<c:choose>
					<c:when test="${isEdit }">Editer</c:when>
					<c:otherwise>Créer</c:otherwise>
				</c:choose>
				un Objectif ${missions} ${actions }
			</div>
		</div>
		<div class="main-panel-content">
			<div class="form">
				<form action="addValidateGoal.htm" method="POST">
					<c:if test="${isEdit }">
						<input type="hidden" name="id" value="${MyGoal.id }">
					</c:if>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Libellé de l'objectif :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="wording" value="${MyGoal.wording }" />
								</c:if>
								<input type="text" name="wording" value="${wording}" />
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Missions où apparait l'objectif :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									TODO : pré-remplissage
									<c:set var="wording" value="${MyGoal.wording }" />
								</c:if>
								<select multiple class="chosen-select" name="missions">
									<c:forEach items="${missions }" var="mission">
										<option value="${mission.id }">${mission.wording }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Actions comprises dans l'objectif :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="wording" value="${MyGoal.wording }" />
								</c:if>
								<select multiple class="chosen-select" name="actions">
									<c:forEach items="${actions }" var="action">
										<option value="${action.id }">${action.wording }</option>
									</c:forEach>
								</select>
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