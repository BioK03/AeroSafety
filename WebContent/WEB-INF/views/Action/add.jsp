<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<c:set var="isEdit" value="${MyAction != null}" />
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">
				<c:choose>
					<c:when test="${isEdit }">Editer</c:when>
					<c:otherwise>Créer</c:otherwise>
				</c:choose>
				une action
			</div>
		</div>
		<div class="main-panel-content">
			<div class="form">
				<form action="addValidateAction.htm" method="POST">
					<c:if test="${isEdit }">
						<input type="hidden" name="id" value="${MyAction.id }">
					</c:if>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Libellé :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="wording" value="${MyAction.wording }" />
								</c:if>
								<input type="text" name="wording" value="${wording }" />
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Score minimum :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="scoreminimum" value="${MyAction.scoreMinimum }" />
								</c:if>
								<input type="number" name="scoreminimum" min="0"
									value="${scoreminimum }" />
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Action suivante :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="fk_action" value="${MyAction.action.id }" />
								</c:if>
								<SELECT name="fk_action">
									<option value="-1">Aucune</option>
									<c:forEach items="${actions}" var="action">
										<option value="${action.id }"
											<c:if test="${fk_action == action.id}"> selected</c:if>>${action.wording}</option>
									</c:forEach>
								</SELECT>
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Objectifs comprenant l'action :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="objectifs" value="${MyAction.goals }" />
								</c:if>
								<select multiple class="chosen-select" name="goals">
									<c:forEach items="${goals}" var="goal">
										<option value="${goal.id }"
											<c:if test="${isEdit and fn:contains(objectifs, goal) }"> selected</c:if>>${goal.wording}</option>
									</c:forEach>
								</SELECT>
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Indicateurs appliqués à  l'action :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="indic" value="${MyAction.indicators }" />
								</c:if>
								<select multiple class="chosen-select" name="indicators">
									<c:forEach items="${indicators}" var="indicator">
										<option value="${indicator.id }"
											<c:if test="${isEdit and fn:contains(indic, indicator)}"> selected</c:if>>${indicator.id}</option>
									</c:forEach>
								</SELECT>
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Apprenants ayant obtenu l'action :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="learnerActions" value="${MyAction.learnerActions }" />
								</c:if>
								<select multiple class="chosen-select" name="learners">
									<c:forEach items="${learners}" var="learner">
										<option value="${learner.id }"
											<c:if 
										test="${isEdit and fn:contains(learnerActions, learner.learnerActions)}"> selected</c:if>>
											${learner.surname} ${learner.forname}</option>
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