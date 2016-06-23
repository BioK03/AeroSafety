function declareEvents()
{
	$(".cardDeselAction").unbind('click').click(function(){
		$("#nosort").append($(this).parent());
		$(this).removeClass("cardDeselAction Tright").addClass("cardSelAction Tleft");
		$(this).find(".glyphicon").removeClass("glyphicon-chevron-left").addClass("glyphicon-chevron-right");
		
		declareEvents();
	});
	$(".cardSelAction").unbind('click').click(function(){
		$("#sort").append($(this).parent());
		$(this).removeClass("cardSelAction Tleft").addClass("cardDeselAction Tright");
		$(this).find(".glyphicon").removeClass("glyphicon-chevron-right").addClass("glyphicon-chevron-left");
		
		declareEvents();
	});
	
	updateGlobalAnswer();
}

declareEvents();

$(".indicator").change(function(){
	updateGlobalAnswer();
});


function updateGlobalAnswer()
{
	$result = "";
	$(".cardDeselAction").each(function(){
		$result += $(this).parent().data("id");
		$(this).parent().find(".indicator").each(function(){
			if($(this).is(":checked"))
			{
				$result += "|"+$(this).data("id");
			}
		});
		$result += "$";
	});
	$("#globalAnswer").attr("value", $result);
}

updateGlobalAnswer();

