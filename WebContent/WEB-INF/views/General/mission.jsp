<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>

<div class="modal fade" id="modalMenu" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content BGFFFFFF">
            <div class="modal-header BGFFFFFF">
                <button type="button" class="close" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"></span>
                </button>
                <h4 class="modal-title" id="modalMenuTitle">Modal title</h4>
            </div>
            <div id="modalMenuContent" class="modal-body BGFFFFFF">
                ...
            </div>
        </div>
    </div>
</div>

<div class="container">
	<div class="row">
		<h1 class="col-xs-5">${mission.wording}</h1>
		<div class="col-xs-7 PaddingTop2em">
			<a class="btn btn-primary showPopup col-xs-offset-1 col-xs-5" data-title="Aide" data-content="
					<div class='Dblock Padding00'>
						<p class='colx-100'>Vous devez trier les actions en cliquant sur leur nom :</p>
						<img class='colx-60' src='resources/img/help/1.png'/>
						<p class='colx-100'>puis vous devez cocher les indicateurs vous semblant corrects :</p>
						<img class='colx-60' src='resources/img/help/2.png'/>
						<p class='colx-100'>A la fin, validez votre réponse</p>
					</div>
				">
				<span class="glyphicon glyphicon-question-sign"></span> Aide
			</a>
			<form method="GET" action="missionValidate.htm" class="col-xs-offset-1 col-xs-5 Padding00">
				<input id="globalAnswer" type="hidden" name="globalAnswer" value=""/>
				<input type="hidden" name="missionId" value="${mission.id}"/>
				<input type="submit" class="btn btn-primary col-xs-12 MarginLeft0 MarginRight0 CursorPointer"/>
			</form>
		</div>
		
		<div class="clearfix"></div>
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
											<input id="indicator${indicator.id}" type="checkbox" class="indicator" data-id="${indicator.id}">
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