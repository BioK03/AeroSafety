<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<c:set var="isEdit" value="${mission != null}" />
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">
				<c:choose>
					<c:when test="${isEdit}">Editer</c:when>
					<c:otherwise>Créer</c:otherwise>
				</c:choose>
				une mission
			</div>
		</div>
		<div class="main-panel-content">
			<div class="form">
				<form action="addValidateMission.htm" method="POST">
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Libellé de la mission :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="wording" value="${mission.wording}" />
								</c:if>
								<input type="text" name="wording" value="${wording}" />
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Apprenants inscrits :</div>
							<div class="form-input">
								<select multiple class="chosen-select" class="form-input"
									name="learners" data-placeholder="Choisissez des apprenants">
									<c:forEach items="${learners}" var="learner">
										<c:set var="contains" value="false" />
										<c:forEach items="${mission.inscriptions }" var="inscription">
											<c:if test="${inscription.learner.id == learner.id }">
												<c:set var="contains" value="true" />
											</c:if>
										</c:forEach>
										<option value="${learner.id}"
											<c:if test="${contains==true}">selected</c:if>>${learner.forname}
											${learner.surname}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Actions de la mission:</div>
							<div class="form-input">
								<select multiple class="chosen-select" class="form-input"
									name="actions" data-placeholder="Choisissez des actions">
									<c:forEach items="${actions}" var="action">
										<c:set var="contains" value="false" />
										<c:forEach items="${mission.actions}" var="ac">
											<c:if test="${ac.id == action.id}">
												<c:set var="contains" value="true" />
											</c:if>
										</c:forEach>
										<option value="${action.id}" <c:if test="${contains==true}">selected</c:if>>${action.wording}</option>
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