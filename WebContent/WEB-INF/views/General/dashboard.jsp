<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<h1>Dashboard [Bonjour, ${learner.forname}]</h1>
	
	 <div class="row">
	 	<c:forEach items="${learner.missions}" var="game" varStatus="status">
	 		<c:if test="${status.index < 2}">
	 			<div class="col-md-3 col-xs-6">
		            <div class="card BGCustom">
		                <div class="card-content white-text">
		                    <span class="card-title">${mission.wording}</span>
		                    <p id="gauge${status.index}" class="createGauge" data-max="100" data-value="50" data-title=""></p>
		                </div>
		                <div class="card-action">
		                    <a href="#">Détails du résultat</a>
		                </div>
		            </div>
		        </div>
	 		</c:if>
	 	</c:forEach>
        <div class="col-md-6 col-xs-12">
            <div class="card BGCustom">
                <div class="card-content white-text">
                    <span class="card-title">Commencer une mission</span>
                    <p></p>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>