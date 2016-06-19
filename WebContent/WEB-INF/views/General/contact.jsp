<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<h1>Contact</h1>
	<form name='contact' method="post" action="contactValidate.htm">
		<span class="col-xs-6 col-xs-offset-3 noPadding"> <input
			class="col-xs-12 noOutline" type="text" name="name" value=""
			placeholder="Votre nom (facultatif)" id="name" autocomplete="off">
		</span> <span class="col-xs-6 col-xs-offset-3 noPadding"> <input
			class="col-xs-12 noOutline" type="email" name="mail"
			placeholder="Votre e-mail" id="mail" autocomplete="on" required>
		</span> <span class="col-xs-6 col-xs-offset-3 noPadding"> <textarea
				line="5" class="col-xs-12 noOutline" type="text" name="content"
				placeholder="Votre message" id="content" autocomplete="off" required></textarea>
		</span> <span class="col-xs-6 col-xs-offset-3 noPadding"> <input
			type="submit" name="bt" value="Envoyer"
			class="btn btn-primary noPadding MarginLeft0 col-xs-12">
		</span>
	</form>

</div>
<jsp:include page="../layout/afterContent.jsp"></jsp:include>