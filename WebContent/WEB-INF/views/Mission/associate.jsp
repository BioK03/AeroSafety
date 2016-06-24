<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<c:set var="isEdit" value="${mission != null}" />
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">Validation d'une action par un
				apprenant</div>
		</div>
		<div class="main-panel-content">
			<div class="form">
				<form action="addValidateAssociation.htm" method="POST">
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Mission:</div>
							<div class="form-input">
								<select class="chosen-select" class="form-input" name="mission"
									data-placeholder="Choisissez des actions">
									<c:if test="${mission != nul}">
										<option value="${mission.id}" selected>${mission.wording}</option>
									</c:if>
									<c:forEach items="${missions}" var="mission">
										<option value="${mission.id}">${mission.wording}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Apprenant :</div>
							<div class="form-input">
								<select class="chosen-select" class="form-input" name="learner"
									data-placeholder="Choisissez des apprenants">
									<c:if test="${learner!=null}">
										<option selected value="${learner.id}">${learner.forname}
											${learner.surname}</option>
									</c:if>
									<c:forEach items="${learners}" var="learner">
										<option value="${learner.id}">${learner.forname}
											${learner.surname}</option>
									</c:forEach>
									<c:forEach items="${missions}" var="mission">
										<c:forEach items="${mission.inscriptions}" var="inscription">
											<option value="${inscription.learner.id}">${inscription.learner.forname}
												${inscription.learner.surname}</option>
										</c:forEach>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Action:</div>
							<div class="form-input">
								<select class="chosen-select" class="form-input" name="action"
									data-placeholder="Choisissez des actions">
									<c:if test="${action != nul}">
										<option value="${action.id}" selected>${action.wording}</option>
									</c:if>
									<c:forEach items="${actions}" var="action">
										<option value="${action.id}"
											<c:if test="${contains==true}">selected</c:if>>${action.wording}</option>
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
<c:if test="${needJS == true}">
	<script>
		linkSelects('mission', 'learner', 'Learner', 'Mission');
	</script>
</c:if>