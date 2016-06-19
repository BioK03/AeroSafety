<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../layout/beforeContent.jsp"></jsp:include>
<div class="container">
	<h1>Dashboard</h1>
	
	 <div class="row">
        <div class="col-md-3 col-xs-6">
            <div class="card BGCustom">
                <div class="card-content white-text">
                    <span class="card-title">Mission 1</span>
                    <p id="gauge" class="createGauge" data-max="100" data-value="50" data-title=""></p>
                </div>
                <div class="card-action">
                    <a href="#">Détails du résultat</a>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-xs-6">
            <div class="card BGCustom">
                <div class="card-content white-text">
                    <span class="card-title">Mission 3</span>
                    <p id="gauge2" class="createGauge" data-max="75" data-value="51" data-title=""></p>
                </div>
                <div class="card-action">
                    <a href="#">Détails du résultat</a>
                </div>
            </div>
        </div>
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