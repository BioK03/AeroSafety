function topPlane()
{
    $("#plane").animate({bottom: "100%"}, 2000);
    setTimeout(function(){
        $("#plane").css("bottom","0%");
        setTimeout(function(){
            topPlane();
        }, 5000);
    }, 2100);
    
}

topPlane();

var mouseHoverFooter = false;

$("footer").hover(function(){
    mouseHoverFooter = true;
}, function(){
    mouseHoverFooter = false;
});
/*
$("body").mousemove(function( event ) {
    if(mouseHoverFooter){ return; }
    console.log(event.clientX / $(document).width());
    if(event.clientX / $(document).width() < 0.9)
    {
        if(event.clientX / $(document).width() < 0.1)
        {
            $(".divFooter").css("left", "0%");
        }
        else
        {
            $(".divFooter").css("left", event.clientX / $(document).width() * 100 - 10 + "%");
        }
        
    }
    else
    {
        
        $(".divFooter").css("left", "80%");
    }
});*/