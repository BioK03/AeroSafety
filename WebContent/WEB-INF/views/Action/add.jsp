<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<c:set var="isEdit" value="${action != null}" />
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">
				<c:choose>
					<c:when test="${isEdit}">Editer</c:when>
					<c:otherwise>Créer</c:otherwise>
				</c:choose>
				une action
			</div>
		</div>
		<div class="main-panel-content">
			<div class="form">
				<form action="addValidateAction.htm" method="POST">
					<c:if test="${isEdit}">
						<input type="hidden" name="id" value="${action.id}">
					</c:if>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Libellé :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="wording" value="${action.wording}" />
								</c:if>
								<input type="text" name="wording" value="${wording}" />
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Score minimum :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="scoreminimum" value="${action.scoreMinimum}" />
								</c:if>
								<input type="number" name="scoreminimum" min="0"
									value="${scoreminimum}" />
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Action suivante :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="fk_action" value="${action.action.id}" />
								</c:if>
								<select name="fk_action">
									<option value="-1">Aucune</option>
									<c:forEach items="${actions}" var="action">
										<option value="${action.id}"
											<c:if test="${fk_action == action.id}"> selected</c:if>>
											${action.wording}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Mission comprenant l'action :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="mis" value="${action.missions}" />
								</c:if>
								<select multiple class="chosen-select" name="missions"
									data-placeholder="Choisissez des missions">
									<c:forEach items="${missions}" var="mission">
										<c:set var="contains" value="false" />
										<c:forEach items="${mis}" var="miss">
											<c:if test="${miss.id == mission.id}">
												<c:set var="contains" value="true" />
											</c:if>
										</c:forEach>
										<option value="${mission.id}"
											<c:if test="${contains==true}">selected</c:if>>${mission.wording}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Indicateurs appliqués à  l'action :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="indic" value="${action.indicators}" />
								</c:if>
								<select multiple class="chosen-select" name="indicators"
									data-placeholder="Choisissez des indicateurs">
									<c:forEach items="${indicators}" var="indicator">
										<c:set var="contains" value="false" />
										<c:forEach var="indi" items="${indic}">
											<c:if test="${indi.id == indicator.id}">
												<c:set var="contains" value="true" />
											</c:if>
										</c:forEach>
										<option value="${indicator.id}"
											<c:if test="${contains==true}">selected</c:if>>${indicator.wording}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div id="learners-field"
							class="form-field form-field-disabled form-field-right">
							<div class="form-label">Apprenants ayant obtenu l'action :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="inscription" value="${learner.inscriptions}" />
								</c:if>
								<select multiple class="chosen-select" name="learners"
									disabled="disabled"
									data-placeholder="Choisissez des apprenants">
									<c:forEach items="${learners}" var="learner">
										<c:set var="contains" value="false" />
										<c:forEach items="${inscriptions}" var="inscription">
											<c:if test="${learner.id == inscription.learner.id}">
												<c:set var="contains" value="true" />
											</c:if>
										</c:forEach>
										<option value="${learner.id}"
											<c:if test="${contains==true}">selected</c:if>>${learner.surname}
											${learner.forname}</option>
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
<script>
	linkSelects('missions', 'learners', 'Learner', 'Mission');
	$('select[name="missions"]').trigger('change');
</script>