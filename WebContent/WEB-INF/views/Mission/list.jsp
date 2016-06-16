<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<h1 class="page-title">
		Missions <a href="addMission.htm">
			<p class="btn btn-success btn-success-custom">
				<span class="glyphicon glyphicon-plus"></span>
			</p>
		</a>
	</h1>
	<div class="card-group" data-type="Mission">
		<c:forEach items="${missions }" var="mission">
			<div class="card card-primary text-xs-center z-depth-2 list-item">
				<div class="card-block main-panel-content">
					<a class="fullSizeBlock"
						href="detailsMission.htm?id=${mission.id }">
						<p class="white-text">${mission.wording }</p>
					</a>
					<p class="white-text"></p>
					<span class="buttons-group"> <a class="btn btn-default"
						href="addMission.htm?id=${mission.id }"> <span
							class="glyphicon glyphicon-edit"></span>
					</a> <a class="btn btn-warning"
						href="deleteMission.htm?id=${mission.id }"> <span
							class="glyphicon glyphicon-remove"></span>
					</a>
					</span>
				</div>
			</div>
		</c:forEach>
		<div
			class="card btn-success BG4285F4 card-create-item text-xs-center z-depth-2 list-item">
			<div class="">
				<span class="glyphicon glyphicon-plus"></span>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>