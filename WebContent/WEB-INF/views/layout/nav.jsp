<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand waves-effect waves-light" href="index.htm">
				<img class="h1em Dblock" src="resources/img/logo.png" />
			</a>
		</div>

		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<c:if test="${(!empty user) && (user.role == 'admin')}">
 					<li class="dropdown hoverable">
 						<a href="#" class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" role="button" aria-expanded="false">
 							<i class="fa fa-bars" aria-hidden="true"></i> Entités
 						</a>
 						<ul class="dropdown-menu" role="menu">
 							<li class="hoverable">
 								<a href="listAction.htm" class="waves-effect waves-light">
 									<i class="icon ion-android-locate"></i> Actions
 								</a>
 							</li>
 							<li class="hoverable">
 								<a href="listLearner.htm" class="waves-effect waves-light">
 									<i class="icon ion-ios-person-outline"></i> Apprenants
 								</a>
 							</li>
 							<li class="hoverable">
 								<a href="listIndicator.htm" class="waves-effect waves-light">
 									<i class="icon ion-android-checkbox-outline"></i> Indicateurs
 								</a>
 							</li>
 							<li class="hoverable">
 								<a href="listMission.htm" class="waves-effect waves-light">
 									<i class="icon ion-ios-briefcase-outline"></i> Missions
 								</a>
 							</li>
 						</ul>
 					</li>
 				</c:if>
 				<c:if test="${(!empty user)}">
 					<li class="hoverable">
 					<a href="dashboard.htm" class="waves-effect waves-light">
 							<i class="fa fa-tachometer"></i> Dashboard
 					</a>
 					</li>
 				</c:if>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown hoverable">
					<a href="#" class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" role="button" aria-expanded="false">
						<i class="fa fa-user"></i> Bienvenue ${user.forname}<span class="caret"></span>
					</a>
					<c:if test="${empty user}">
						<ul class="dropdown-menu" role="menu">
							<li class="hoverable">
								<a href="login.htm" class="waves-effect waves-light">
									<i class="fa fa-key"></i> Connexion
								</a>
							</li>
							<li class="hoverable">
								<a href="register.htm" class="waves-effect waves-light"> 
									<i class="fa fa-user-plus"></i> Inscription
								</a>
							</li>
						</ul>
					</c:if>
					<c:if test="${!empty user}">
						<ul class="dropdown-menu" role="menu">
							<li class="hoverable">
								<a href="logout.htm" class="waves-effect waves-light">
									<i class="fa fa-key"></i> Déconnexion
								</a>
							</li>
							<li class="hoverable">
								<a href="detailsLearner.htm?id=${user.id }" class="waves-effect waves-light"> 
									<i class="fa fa-user-plus"></i> Mes détails
								</a>
							</li>
						</ul>
					</c:if>
				</li>
				<li class="dropdown hoverable">
					<a href="#" class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" role="button" aria-expanded="false">
						<i class="fa fa-info" aria-hidden="true"></i>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li class="hoverable">
							<a href="infos.htm"	class="waves-effect waves-light">
								<i class="fa fa-info"></i> Informations
							</a>
						</li>
						<li class="hoverable">
							<a href="contact.htm" class="waves-effect waves-light">
								<i class="fa fa-envelope"></i> Contact
							</a>
						</li>
					</ul>
				</li>
				<c:if test="${(!empty user) && (user.role == 'admin')}">
 					<li class="hoverable">
 						<form class="navbar-form" role="search" method="GET" action="search.htm">
 							<div class="form-group white-text">
 								<input id="searchInput" type="text" name="search" class="form-control inputWidth0 customTransition"	placeholder="Search"/>
 								<a id="searchIcon" class="DiBlock WhiteLink"> 
 									<i class="fa fa-search CursorPointer" aria-hidden="true"></i>
 								</a>
 							</div>
 						</form>
 					</li>
 				</c:if>
			</ul>
		</div>
	</div>
</nav>