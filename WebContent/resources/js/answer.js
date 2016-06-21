$(".cardSelAction").click(function(){
	
	
	selAction();
});

$(".cardDeselAction").click(function(){
	$("#nosort").append($(this));
	$(this).removeClass("cardDeselAction Tright").addClass("cardSelAction Tleft");
	$(this).find(".glyphicon").removeClass("glyphicon-chevron-left").addClass("glyphicon-chevron-right");
	
	deselAction();
});

function declareEvents()
{
	$(".cardDeselAction").unbind('click').click(function(){
		$("#nosort").append($(this));
		$(this).removeClass("cardDeselAction Tright").addClass("cardSelAction Tleft");
		$(this).find(".glyphicon").removeClass("glyphicon-chevron-left").addClass("glyphicon-chevron-right");
		
		declareEvents();
	});
	$(".cardSelAction").unbind('click').click(function(){
		$("#sort").append($(this));
		$(this).removeClass("cardSelAction Tleft").addClass("cardDeselAction Tright");
		$(this).find(".glyphicon").removeClass("glyphicon-chevron-right").addClass("glyphicon-chevron-left");
		
		declareEvents();
	});
}
