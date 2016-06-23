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
		width : "100%"
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
function fetchObjects(targetClass, linkClass, linkObjectId, selector) {
	return $.ajax({
		url : 'fetchObject.htm',
		type : 'GET',
		data : 'targetClass=' + targetClass + '&linkClass=' + linkClass
				+ '&linkObjectId=' + linkObjectId,
		success : function(content, status) {
			if(targetClass == "Learner")
				addJSONUsersToSelect(content, selector);
			else
				addJSONObjectsToSelect(content, selector);
		},
		error : function(res, status, error) {
			alert('Une erreur est survenue');
		}
	})
}

function addJSONUsersToSelect(JSONString, selector) {
	var list = JSON.parse(JSONString);
	$(list).each(function() {
		addToSelect(selector, this.id, this.forname + ' ' + this.surname)
	})
}

function addJSONObjectsToSelect(JSONString, selector) {
	var list = JSON.parse(JSONString);
	$(list).each(function() {
		addToSelect(selector, this.id, this.wording)
	})
}

function addToSelect(selector, id, text) {
	var html = "<option value=\"" + id + "\">" + text + "</option>";
	if ($(selector).html().indexOf(html) == -1) {
		$(selector).append(html);
		$(selector).chosen().trigger('chosen:updated');
	}
}

function fillSelect(selector, targetClass, linkClass, linkObjectId) {
	fetchObjects(targetClass, linkClass, linkObjectId, selector);
}

function linkSelects(firstName, secondName, firstClass, secondClass) {
	var firstSelector = 'select[name="' + firstName + '"]';
	var secondSelector = 'select[name="' + secondName + '"]';
	$(firstSelector).chosen().change(function() {
		var firstOptions = firstSelector + ' option:selected';
		var secondField = "#" + secondName + "-field";
		if ($(firstOptions).size() >= 1) {
			$(secondField).removeClass('form-field-disabled');
			$(firstOptions).each(function() {
				fillSelect(secondSelector, firstClass, secondClass, 1);
			})
			$(secondSelector).attr('disabled', false);
			$(secondSelector).chosen().trigger('chosen:updated');
		} else {
			$(secondField).addClass('form-field-disabled');
			$(secondSelector).empty();
		}
	})
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
			alert("Une erreur s'est produite")
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