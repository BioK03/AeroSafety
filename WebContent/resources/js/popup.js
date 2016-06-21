$(".showPopup").click(function(){
    $('#modalMenu').modal('hide');
    $("#modalMenuTitle").html($(this).data("title"));
    $("#modalMenuContent").html($(this).data("content"));
    $('#modalMenu').modal('show');;
});