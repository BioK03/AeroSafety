<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<c:set var="isEdit" value="${MyGame != null}" />
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title"><c:choose><c:when test="${isEdit }">Editer</c:when><c:otherwise>Créer</c:otherwise></c:choose> un jeu</div>
		</div>
		<div class="main-panel-content">
			<div class="form">
				<form action="addValidateGame.htm" method="POST">
					<c:if test="${isEdit }">
						<input type="hidden" name="id" value="${MyGame.id }">
					</c:if>
					<div class="form-row">
						<div class="form-field">
							<div class="form-label">Libellé du jeu :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="wording" value="${MyGame.wording }" />
								</c:if>
								<input type="text" name="wording" value="${wording }" />
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