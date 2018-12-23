// műveletek az elemekkel

// MÉZTERMÉKEK
// hozzáadása
function hozMezTer(){
    var hozNev = document.getElementById("felvitel-nev").value;
    var hozMenny = document.getElementById("felvitel-mennyiseg").value;
    var hozAr = document.getElementById("felvitel-ar").value;
    $.ajax({
        url:"ControllerThree",
        type:"post",
        data:{"task":"hozzaadMezTer", "nev":hozNev, "mennyiseg":hozMenny, "ar":hozAr},
        success:function(valasz){
            alert(valasz);
        },
        error:function(){
            //alert("hozzáad hiba");
        }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}

function torMezTer(){
    var torId = document.getElementById("torol-id").value;
    $.ajax({
       url:"ControllerThree",
       type:"post",
       data:{"task":"torolMezTer", "id":torId},
       success:function(valasz){
           alert(valasz);
       },
       error:function(){
           
       }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}

function modMezTer(){
    var modNev = document.getElementById("modosit-nev").value;
    var modMenny = document.getElementById("modosit-mennyiseg").value;
    var modAr = document.getElementById("modosit-ar").value;
    var modId = document.getElementById("modosit-id").value;
    $.ajax({
       url:"ControllerThree",
       type:"post",
       data:{"task":"modositMezTer", "nev":modNev, "mennyiseg":modMenny, "ar":modAr, "id":modId},
       success:function(valasz){
           alert(valasz);
       },
       error:function(){
           
       }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}

// DÍSZCSOMAGOLT TERMÉKEK
// hozzáadása
function hozDisz(){
    var hozNev = document.getElementById("felvitel-nev").value;
    var hozMenny = document.getElementById("felvitel-mennyiseg").value;
    var hozAr = document.getElementById("felvitel-ar").value;
    $.ajax({
        url:"ControllerThree",
        type:"post",
        data:{"task":"hozzaadDisz", "nev":hozNev, "mennyiseg":hozMenny, "ar":hozAr},
        success:function(valasz){
            alert(valasz);
        },
        error:function(){
            //alert("hozzáad hiba");
        }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}
// törlés
function torDisz(){
    var torId = document.getElementById("torol-id").value;
    $.ajax({
       url:"ControllerThree",
       type:"post",
       data:{"task":"torolDisz", "id":torId},
       success:function(valasz){
           alert(valasz);
       },
       error:function(){
           
       }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}
// módosítás
function modDisz(){
    var modNev = document.getElementById("modosit-nev").value;
    var modMenny = document.getElementById("modosit-mennyiseg").value;
    var modAr = document.getElementById("modosit-ar").value;
    var modId = document.getElementById("modosit-id").value;
    $.ajax({
       url:"ControllerThree",
       type:"post",
       data:{"task":"modositDisz", "nev":modNev, "mennyiseg":modMenny, "ar":modAr, "id":modId},
       success:function(valasz){
           alert(valasz);
       },
       error:function(){
           
       }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}

//VÉLEMÉNYEK
// módosítás
function modVelemeny(){
    var modLeiras = document.getElementById("modosit-leiras").value;
    var modSzerzo = document.getElementById("modosit-szerzo").value;
    var modId = document.getElementById("modosit-id").value;
    $.ajax({
       url:"ControllerThree",
       type:"post",
       data:{"task":"modositVelemeny", "leiras":modLeiras, "szerzo":modSzerzo, "id":modId},
       success:function(valasz){
           alert(valasz);
       },
       error:function(){
           
       }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}

//BEMUTATKOZÁS
// módosítás
function modBemutat(){
    var modLeiras = document.getElementById("modosit-leiras").value;
    var modKepUrl = document.getElementById("modosit-kepUrl").value;
    var modId = document.getElementById("modosit-id").value;
    $.ajax({
       url:"ControllerThree",
       type:"post",
       data:{"task":"modositBemutat", "leiras":modLeiras, "kep":modKepUrl, "id":modId},
       success:function(valasz){
           alert(valasz);
       },
       error:function(){
           
       }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}

//ISMERTETŐK
// módosítás
function modIsmer(){
    var modLogo = document.getElementById("modosit-logo").value;
    var modLeirt = document.getElementById("modosit-leirt").value;
    var modLeiras = document.getElementById("modosit-leiras").value;
    var modId = document.getElementById("modosit-id").value;
    $.ajax({
       url:"ControllerThree",
       type:"post",
       data:{"task":"modositIsmer", "logo":modLogo, "leirt":modLeirt,"leiras":modLeiras, "id":modId},
       success:function(valasz){
           alert(valasz);
       },
       error:function(){
           
       }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}

//TERMÉKEK
// módosítás
function modKepLeir(){
    var modNev = document.getElementById("modosit-nev").value;
    var modLeiras = document.getElementById("modosit-leiras").value;
    var modKep = document.getElementById("modosit-kep").value;
    var modId = document.getElementById("modosit-id").value;
    $.ajax({
       url:"ControllerThree",
       type:"post",
       data:{"task":"modositTermek", "nev":modNev, "leiras":modLeiras, "kep":modKep, "id":modId},
       success:function(valasz){
           alert(valasz);
       },
       error:function(){
           
       }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}

//PARTNEREK
// módosítás
function modPartner(){
    var modNev = document.getElementById("modosit-nev").value;
    var modIcon = document.getElementById("modosit-icon").value;
    var modUrl = document.getElementById("modosit-url").value;
    var modId = document.getElementById("modosit-id").value;
    $.ajax({
       url:"ControllerThree",
       type:"post",
       data:{"task":"modositPartnerek", "nev":modNev, "icon":modIcon, "url":modUrl, "id":modId},
       success:function(valasz){
           alert(valasz);
       },
       error:function(){
           
       }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}

//ELÉRHETŐSÉGEK
// módosítás
function modEler(){
    var modNev = document.getElementById("modosit-nev").value;
    var modIcon = document.getElementById("modosit-icon").value;
    var modUrl = document.getElementById("modosit-url").value;
    var modId = document.getElementById("modosit-id").value;
    $.ajax({
       url:"ControllerThree",
       type:"post",
       data:{"task":"modositElerhetoseg", "nev":modNev, "icon":modIcon, "url":modUrl, "id":modId},
       success:function(valasz){
           alert(valasz);
       },
       error:function(){
           
       }
    });
    setTimeout(function()
    { location.reload(true); }, 1000);
}
