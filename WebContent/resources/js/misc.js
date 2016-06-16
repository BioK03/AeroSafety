$(document).ready(function() {
	listenToClick();
	HighLightMenuItem();
	activateChosen();
});

$(function() {
	$('[data-toggle="tooltip"]').tooltip({
		'container' : 'body'
	});
});

function activateChosen() {
	$(".chosen-select").chosen({
		width: "100%"
	});
}

function HighLightMenuItem() {
	$("ul.nav.navbar-nav li").mouseenter(function() {
		$(this).addClass("active");
	})
	$("ul.nav.navbar-nav li").mouseleave(function() {
		$(this).removeClass("active");
	})
}

$(function() {
	$('[data-toggle="tooltip"]').tooltip();
})

function listenToClick() {
	$(".card-create-item").click(getForm);
}

function getForm() {
	var type = $(".card-group").attr("data-type");
	$.ajax({
		url : 'add' + type + '.htm',
		type : 'GET',
		success : function(content, status) {
			var res = $(content).find(".main-panel");
			displayContent(res);
		},
		error : function(res, status, error) {
			alert(res + "\n" + status + "\n" + error)
		}
	});
}

function displayContent(HTMLcontent) {
	$(HTMLcontent)
			.find(".main-panel-title")
			.append(
					$("<span style=\"float:right\"><a class=\"delete glyphicon glyphicon-remove btn btn-danger\"></a></span>"));

	var button = $(".card-create-item");
	$(".card-create-item").remove();
	$(".card-group").append($(HTMLcontent).fadeIn());
	$(".card-group").append(button);
	activateChosen();
	listenToClick();
	$(".delete").click(function() {
		$(HTMLcontent).fadeOut("slow");
	});
}

$(".container").click(
		function() {
			if ($("#searchIcon").find("i").hasClass("fa-times")) {
				$("#searchInput").removeClass("inputWidth5em").addClass(
						"inputWidth0");
				$("#searchIcon").find("i").removeClass("fa-times").addClass(
						"fa-search");
			}
		});

$("#searchIcon")
		.click(
				function() {
					if ($(this).find("i").hasClass("fa-search")) {
						$("#searchInput").removeClass("inputWidth0").addClass(
								"inputWidth5em").focus();
						$(this).find("i").removeClass("fa-search").addClass(
								"fa-times");
					} else {
						$("#searchInput").removeClass("inputWidth5em")
								.addClass("inputWidth0");
						$(this).find("i").removeClass("fa-times").addClass(
								"fa-search");
					}
				});