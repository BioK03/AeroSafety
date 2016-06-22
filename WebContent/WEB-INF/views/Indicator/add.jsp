<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<c:set var="isEdit" value="${indicator != null}" />
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">Créer un indicateur</div>
		</div>
		<div class="main-panel-content">
			<div class="form">
				<form action="addValidateIndicator.htm" method="POST">
					<c:if test="${isEdit}">
						<input type="hidden" name="id" value="${indicator.id}">
					</c:if>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Libellé de l'indicateur :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="wording" value="${indicator.wording}" />
								</c:if>
								<input type="text" name="wording" value="${wording}" />
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Action valorisée par l'indicateur :</div>
							<div class="form-input">
								<select class="chosen-select" name="fk_action"
									data-placeholder="Choisissez une action">
									<option value="-1">Aucune</option>
									<c:forEach items="${actions}" var="action">
										<option value="${action.id }">${action.wording}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Valeur ajoutée :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="valueIfCheck" value="${indicator.valueIfCheck}" />
								</c:if>
								<input type="number" name="valueIfCheck" min="0" value="${valueIfCheck}" />
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Valeur si absent :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="ValueIfUnCheck" value="${indicator.valueIfUnCheck}" />
								</c:if>
								<input type="number" name="valueIfUnCheck" min="" value="${ValueIfUnCheck}" />
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