<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript" src="resources/lib/jquery/jquery.js"></script>
<script type="text/javascript" src="resources/lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/lib/mdb/js/mdb.min.js"></script>
<script type="text/javascript" src="resources/lib/parallax/jquery.parallax.js"></script>
<script type="text/javascript" src="resources/lib/wow/wow.min.js"></script>
<script type="text/javascript" src="resources/lib/gauge/raphael.min.js"></script>
<script type="text/javascript" src="resources/lib/gauge/justgage.js"></script>
<script type="text/javascript" src="resources/lib/chosen/chosen.jquery.min.js"></script>
<script type="text/javascript">
	new WOW().init();
	$('[data-toggle="popover"]').popover();
	$(".createGauge").each(function(){
		new JustGage({
			id: $(this).attr('id'),
			value: $(this).data('value'),
			min: 0,
			max: $(this).data('max'),
			title: $(this).data('title'),
			titleFontColor: "white",
			valueFontColor: "white",
			labelFontColor: "white",
			titlePosition: "below",
			symbol: ' pts',
			customSectors: [
				{
			        color : "#ff0000",
			        lo : 0,
			        hi : $(this).data('max')/3
		      	},
		      	{
			        color : "#EEC800",
			        lo : $(this).data('max')/3,
			        hi : $(this).data('max')*2/3
		      	},
		      	{
			        color : "#00ff00",
			        lo : $(this).data('max')*2/3,
			        hi : $(this).data('max')
		      	}
		     ],
		});
	});
	

</script>
<script type="text/javascript" src="resources/js/footer.js"></script>
<script type="text/javascript" src="resources/js/misc.js"></script>
<script type="text/javascript" src="resources/js/carouselAnimations.js"></script>