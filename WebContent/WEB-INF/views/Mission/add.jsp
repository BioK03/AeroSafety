<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<c:set var="isEdit" value="${MyMission != null}" />
	<div class="main-panel card">
		<div class="main-panel-header">
			<div class="main-panel-title">Ajouter une mission</div>
		</div>
		<div class="main-panel-content">
			<div class="form">
				<form action="" method="POST">
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Libellé de la mission :</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="wording" value="${MyMission.wording }" />
								</c:if>
								<input type="text" name="wording" value="${wording }" />
							</div>
						</div>
						<div class="form-field form-field-right">
							<div class="form-label">Jeux comprenant la mission:</div>
							<div class="form-input">
								<c:if test="${isEdit}">
									<c:set var="fk_game" value="${MyMission.game.id }" />
								</c:if>
								<select multiple class="chosen-select" class="form-input" name="fk_game">
									<c:forEach items="${games}" var="game">
										<option value="${game.id }"
											<c:if test="${fk_game == game.id}"> selected</c:if>>${game.wording}</option>
									</c:forEach>
								</SELECT>
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-field form-field-left">
							<div class="form-label">Objectifs de la mission:</div>
							<div class="form-input">
<%-- 								<c:if test="${isEdit}"> --%>
<%-- 									<c:set var="fk_goal" value="${MyMission.goal.id }" /> --%>
<%-- 								</c:if> --%>
								<select multiple class="chosen-select" class="form-input" name="fk_goal">
									<c:forEach items="${goals}" var="goal">
										<option value="${goal.id }"
											<c:if test="${fk_goal == goal.id}"> selected</c:if>>${goal.wording}</option>
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