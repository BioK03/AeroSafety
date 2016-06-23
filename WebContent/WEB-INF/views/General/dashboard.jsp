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
		<h1>Dashboard [Bonjour, ${learner.forname}]</h1><br/>
		<h4 class="col-xs-12 Padding00">Commencer une mission</h4>
		
		<div class="col-xs-12 Padding00">
			
			<c:forEach items="${missions}" var="mission">
				<a href="mission.htm?id=${mission.id}">
		            <div class="card BGCustom col-xs-5 cardMission Padding00">
		                <div class="card-content white-text">
		                    ${mission.wording}
		                </div>
		            </div>
		        </a>
			</c:forEach>
		</div>
		
		<h4 class="col-xs-12 Padding00">Résultats</h4>
	
	 
	 	<c:forEach items="${learner.inscriptions}" var="inscription" varStatus="status">
	 		<c:if test="${status.index < 2}">
	 			<c:set var="score" scope="page" value="0"/>
		 		<c:set var="scoreMax" scope="page" value="0"/>
	 			<c:forEach items="${inscription.inscriptionActions}" var="inscriptionAction">
	 				<c:set var="score" scope="page" value="${score+inscriptionAction.score}"/>
		 		</c:forEach>
		 		<c:forEach items="${inscription.mission.actions}" var="action">
					<c:forEach items="${action.indicators}" var="indicateur">
						<c:choose>
		 					<c:when test="${indicateur.valueIfCheck > indicateur.valueIfUnCheck}">
		 						<c:set var="scoreMax" scope="page" value="${scoreMax+indicateur.valueIfCheck}"/>
		 					</c:when>
		 					<c:otherwise>
		 						<c:set var="scoreMax" scope="page" value="${scoreMax+indicateur.valueIfUnCheck}"/>
		  					</c:otherwise>
	  					</c:choose>
		 			</c:forEach>
		 		</c:forEach>
	 		
	 		
	 		
	 			<div class="col-md-3 col-md-offset-1 col-xs-5 col-xs-offset-1 Padding00">
		            <div class="card BGCustom">
		                <div class="card-content white-text">
		                    <span class="card-title">${inscription.mission.wording}</span>
		                    <h6 class="card-text">${inscription.date}</h6>
		                    <p id="gauge${status.index}" class="createGauge" data-max="${scoreMax}" data-value="${score}" data-title=""></p>
		                </div>
		                <div class="card-action">
		                    <a href="#" class="showPopup" data-title="${inscription.mission.wording}" data-content="
		                    	<p>Mission réalisée le ${inscription.date}</p><br/>
		                    	<c:choose>
			                    	<c:when test="${empty inscription.inscriptionActions}">
			                    		<p>Aucun résultat disponible</p>
			                    	</c:when>
			                    	<c:otherwise>
					                    <table class='table col-xs-12 Padding00 Dblock'>
					                    	<tbody class='col-xs-12 Padding00 Dblock'>
						                    	<tr class='col-xs-12 Padding00'>
						                    		<th class='col-xs-6 DiBlock Padding00'>Action</th><!--
						                    		--><th class='col-xs-6 DiBlock Padding00'>Points</th>
						                    	</tr>
						                    	<c:forEach items="${inscription.inscriptionActions}" var="inscriptionAction">
						                    		<tr class='col-xs-12 Padding00'>
						                    			<td class='col-xs-6 DiBlock Padding00'>${inscriptionAction.action.wording}</td><!--
						                    			--><td class='col-xs-6 DiBlock Padding00'>${inscriptionAction.score}</td>
						                    		</tr>
						                    	</c:forEach>
					                    	</tbody>
					                    </table>
					                    <br/>
					                    <p>Points obtenus : ${score}/${scoreMax}</p>
					            	</c:otherwise>
				            	</c:choose>
		                    ">Détails du résultat</a>
		                </div>
		            </div>
		        </div>
	 		</c:if>
	 	</c:forEach>
        
    </div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>