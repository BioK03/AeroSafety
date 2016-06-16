<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<h1 class="page-title">Apprenants 		<a href="addLearner.htm">
			<p class="btn btn-success btn-success-custom">
				<span class="glyphicon glyphicon-plus"></span>
			</p>
		</a></h1>
	<div class="card-group" data-type="Learner">
	<c:forEach items="${learners}" var="learner">
		<div class="card card-primary text-xs-center z-depth-2 list-item">
			<div class="card-block main-panel-content">
				<a class="fullSizeBlock" href="detailsLearner.htm?id=${learner.id }">
					<p class="white-text">${learner.forname } ${learner.surname }</p>
				</a>
				<span class="buttons-group">
					<a class="btn btn-default" href="addLearner.htm?id=${learner.id }">
						<span class="glyphicon glyphicon-edit"></span>
					</a>
					<a class="btn btn-warning" href="deleteLearner.htm?id=${learner.id }">
						<span class="glyphicon glyphicon-remove"></span>
					</a>
				</span>
			</div>
		</div>
		</c:forEach>
		<div class="card btn-success BG4285F4 card-create-item text-xs-center z-depth-2 list-item">
			<div class="">
				<span class="glyphicon glyphicon-plus"></span>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>