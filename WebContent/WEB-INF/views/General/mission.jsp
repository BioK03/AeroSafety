<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>

<div class="container">
	<div class="row">
		<h1>${mission.wording}
			<span class="glyphicon glyphicon-question-sign" data-toggle="tooltip" data-placement="bottom" title="
				Cliquez sur les actions non triées pour qu'elles apparaissent dans le bon ordre dans la partie droite
			"></span>
		</h1>
		<div id="nosort" class="col-xs-6">
			<p>Actions à trier :</p>
			<c:forEach items="${mission.actions}" var="action" varStatus="status">
				<div id="action${action.id}" class="card Tleft col-xs-12 Padding00 white-text" data-id="${action.id}">
					<div class="cardSelAction card-title CursorPointer BGCustom PaddingLeft0-5em PaddingRight0-5em">
						${action.wording}<span class="glyphicon glyphicon-chevron-right"></span>
					</div>
					<div class="card-content">
						<c:choose>
							<c:when test="${fn:length(action.indicators)>0}">
								<ul>
									<c:forEach items="${action.indicators}" var="indicator">
										<li>
											<input type="checkbox" id="indicator${indicator.id}">
											<label class="TCustom" for="indicator${indicator.id}">${indicator.wording}</label>
										</li>
									</c:forEach>
								</ul>
							</c:when>
							<c:otherwise>
								<p class="TCustom">Pas d'indicateurs pour cette action</p>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:forEach>
		</div>
		<div id="sort" class="col-xs-6">
			<p>Action triées :</p>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>