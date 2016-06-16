<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<h1>Résutats pour '${search}'</h1>
	<c:if test="${empty result}">
		Pas de résultats
	</c:if>
	
	<div class="card-group" data-type="">
		<c:forEach items="${result}" var="item">
			<a class="card card-primary text-xs-center z-depth-2 list-item" href="${item[0]}">
				<span class="card-block main-panel-content">
					<p class="white-text">${item[1]}</p>
				</span>
			</a>
		</c:forEach>
	</div>
	
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>