<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<h1>Connexion au service</h1>
	<form action="" method="get" class="col-xs-6 col-xs-offset-3">
		<input name="email" class="col-xs-12" placeholder="Adresse e-mail"
			type="email" required /> <input name="password" class="col-xs-12"
			placeholder="Mot de passe" type="password" autocomplete="off"
			required /> <input type="submit"
			class="btn btn-primary col-xs-12 MarginLeft0 MarginRight0" />
	</form>
	<a href="register.htm" class="col-xs-12 Tcenter">Pas de compte ?</a>
</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>