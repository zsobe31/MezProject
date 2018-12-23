// műveletek az elemekkel

// módosítás
$(document).ready(function(){
    $("#modositas-mentes").on("click", function(){
        var id = $("#modositas-id").val();
        var nev = $("#modositas-nev").val();
        var kor = $("#modositas-kor").val();
        var kepesseg =  $("#modositas-kepesseg").val();
        $.ajax({
            url:"ControllerThree",
            type: "post",
            data:{"task" : "updateBemutat", "id" : id, "kep" : kep , "leiras" : leiras},      
            success:function(valasz){
                alert(valasz);
                
                
                         
            },
            error:function(){
                //alert("hiba: módosít");
            }
        }); // end of ajax
        setTimeout(function()
        { location.reload(true); }, 1000);
    });//end of event
}); // end of fucntion