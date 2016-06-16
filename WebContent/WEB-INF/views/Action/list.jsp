<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<h1 class="page-title">
		Actions 
		<a href="addAction.htm">
			<p class="btn btn-success btn-success-custom">
				<span class="glyphicon glyphicon-plus"></span>
			</p>
		</a>
	</h1>
	<div class="card-group" data-type="Action">
		<c:forEach items="${actions}" var="action">
			<div class="card card-primary text-xs-center z-depth-2 list-item">
				<div class="card-block main-panel-content">
					<a class="fullSizeBlock" href="detailsAction.htm?id=${action.id}">
						<p class="white-text">${action.wording}</p>
					</a> <span class="buttons-group"> <a class="btn btn-default"
						href="addAction.htm?id=${action.id}"> <span
							class="glyphicon glyphicon-edit"></span>
					</a> <a class="btn btn-warning" href="deleteAction.htm?id=${action.id}">
							<span class="glyphicon glyphicon-remove"></span>
					</a>
					</span>
				</div>
			</div>
		</c:forEach>

		<!-- 
	
		<div class="card card-primary text-xs-center z-depth-2 list-item">
			<div class="card-block main-panel-content">
				<p class="white-text">Action 1</p>
				<p class="white-text"></p>
				<span class="buttons-group"> <span class="btn btn-default"
					data-toggle="tooltip" data-placement="bottom" title="Modifier"><a
						class="glyphicon glyphicon-edit"></a></span> <span
					class="btn btn-warning" data-toggle="tooltip"
					data-placement="bottom" title="Supprimer"><a
						class="glyphicon glyphicon-remove"></a></span>
				</span>
			</div>
		</div>
		<div class="card card-primary text-xs-center z-depth-2 list-item">
			<div class="card-block main-panel-content">
				<p class="white-text">Action 1</p>
				<span class="buttons-group"> <span class="btn btn-default"><a
						class="glyphicon glyphicon-edit"></a></span> <span
					class="btn btn-warning"><a
						class="glyphicon glyphicon-remove"></a></span>
				</span>
			</div>
		</div>
		<div class="card card-primary text-xs-center z-depth-2 list-item">
			<div class="card-block main-panel-content">
				<p class="white-text">Action 1</p>
				<span class="buttons-group"> <span class="btn btn-default"><a
						class="glyphicon glyphicon-edit"></a></span> <span
					class="btn btn-warning"><a
						class="glyphicon glyphicon-remove"></a></span>
				</span>
			</div>
		</div>
		<div class="card card-primary text-xs-center z-depth-2 list-item">
			<div class="card-block main-panel-content">
				<p class="white-text">Action 1</p>
				<span class="buttons-group"> <span class="btn btn-default"><a
						class="glyphicon glyphicon-edit"></a></span> <span
					class="btn btn-warning"><a
						class="glyphicon glyphicon-remove"></a></span>
				</span>
			</div>
		</div>
		<div class="card card-primary text-xs-center z-depth-2 list-item">
			<div class="card-block main-panel-content">
				<p class="white-text">Action 1</p>
				<span class="buttons-group"> <span class="btn btn-default"><a
						class="glyphicon glyphicon-edit"></a></span> <span
					class="btn btn-warning"><a
						class="glyphicon glyphicon-remove"></a></span>
				</span>
			</div>
		</div>
		<div class="card card-primary text-xs-center z-depth-2 list-item">
			<div class="card-block main-panel-content">
				<p class="white-text">Action 1</p>
				<span class="buttons-group"> <span class="btn btn-default"><a
						class="glyphicon glyphicon-edit"></a></span> <span
					class="btn btn-warning"><a
						class="glyphicon glyphicon-remove"></a></span>
				</span>
			</div>
		</div>
		<div class="card card-primary text-xs-center z-depth-2 list-item">
			<div class="card-block main-panel-content">
				<p class="white-text">Action 1</p>
				<span class="buttons-group"> <span class="btn btn-default"><a
						class="glyphicon glyphicon-edit"></a></span> <span
					class="btn btn-warning"><a
						class="glyphicon glyphicon-remove"></a></span>
				</span>
			</div>
		</div>
		<div class="card card-primary text-xs-center z-depth-2 list-item">
			<div class="card-block main-panel-content">
				<p class="white-text">Action 1</p>
				<span class="buttons-group"> <span class="btn btn-default"><a
						class="glyphicon glyphicon-edit"></a></span> <span
					class="btn btn-warning"><a
						class="glyphicon glyphicon-remove"></a></span>
				</span>
			</div>
		</div>
		<div class="card card-primary text-xs-center z-depth-2 list-item">
			<div class="card-block main-panel-content">
				<p class="white-text">Action 1</p>
				<span class="buttons-group"> <span class="btn btn-default"><a
						class="glyphicon glyphicon-edit"></a></span> <span
					class="btn btn-warning"><a
						class="glyphicon glyphicon-remove"></a></span>
				</span>
			</div>
		</div> -->
		<div
			class="card btn-success BG4285F4 card-create-item text-xs-center z-depth-2 list-item">
			<div class="">
				<span class="glyphicon glyphicon-plus"></span>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>