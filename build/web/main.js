
//  bemutatkozás betöltése
function betoltBemutat(){
    $.ajax({
        url:"Controller",
        type:"post",
        data:{"task":"bemutatB"},
        success:function(valasz){
                    document.getElementById("kep1").src = valasz[0].kep;
                    document.getElementById("bemutat").innerHTML = valasz[0].leiras;
        },
        error:function(){
            alert("bemutatkozás hiba");
        }
    });
}

// ismertető betöltése
function betoltI(){
    $.ajax({
        url:"Controller",
        type:"post",
        data:{"task":"ismertetok"},
        success:function(valasz){
            
                    document.getElementById("logo0").src = valasz[0].logo;
                    document.getElementById("leirt0").innerHTML = valasz[0].leirt;
                    document.getElementById("leiras0").innerHTML = valasz[0].leiras;
                    
                    document.getElementById("logo1").src = valasz[1].logo;
                    document.getElementById("leirt1").innerHTML = valasz[1].leirt;
                    document.getElementById("leiras1").innerHTML = valasz[1].leiras;
                    
                    document.getElementById("logo2").src = valasz[2].logo;
                    document.getElementById("leirt2").innerHTML = valasz[2].leirt;
                    document.getElementById("leiras2").innerHTML = valasz[2].leiras;
                    
        },
        error:function(){
            alert("ismertető hiba");
        }
    });
}

// méztermékek betöltése
function betoltT(){
    var termek = document.getElementById("termekek");
    $.ajax({
        url:"Controller",
        type:"post",
        data:{"task":"termekekT"},
        success:function(valasz){
            for (var i = 0; i < valasz.length; i++) {
                termek.innerHTML += "<div>";
//                    termek.innerHTML += "<span>" + valasz[i].id + "</span>";
                    termek.innerHTML += "<span>" + valasz[i].nev + "</span>";
                    termek.innerHTML += "<span>" + valasz[i].mennyiseg + "</span>";
                    termek.innerHTML += "<span>" + valasz[i].ar + "</span>";
                termek.innerHTML += "</div>";
            }
        },
        error:function(){
            alert("méztermék hiba");
        }
    });
}

// diszcsomagolt termékek betöltése
function betoltD(){
    var termek = document.getElementById("disz");
    $.ajax({
        url:"Controller",
        type:"post",
        data:{"task":"termekekD"},
        success:function(valasz){
            for (var i = 0; i < valasz.length; i++) {
                termek.innerHTML += "<div>";
//                    termek.innerHTML += "<span>" + valasz[i].id + "</span>";
                    termek.innerHTML += "<span>" + valasz[i].nev + "</span>";
                    termek.innerHTML += "<span>" + valasz[i].mennyiseg + "</span>";
                    termek.innerHTML += "<span>" + valasz[i].ar + "</span>";
                termek.innerHTML += "</div>";
            }
        },
        error:function(){
            alert("diszcsomag hiba");
        }
    });
}

// vélemények betöltése
function betoltV(){
    $.ajax({
        url:"Controller",
        type:"post",
        data:{"task":"velemenyekV"},
        success:function(valasz){
            
                    document.getElementById("velemeny1").innerHTML = valasz[0].leiras;
                    document.getElementById("szerzo1").innerHTML = valasz[0].szerzo;
                    
                    document.getElementById("velemeny2").innerHTML = valasz[1].leiras;
                    document.getElementById("szerzo2").innerHTML = valasz[1].szerzo;
                    
                    document.getElementById("velemeny3").innerHTML = valasz[2].leiras;
                    document.getElementById("szerzo3").innerHTML = valasz[2].szerzo;
                    
                    document.getElementById("velemeny4").innerHTML = valasz[3].leiras;
                    document.getElementById("szerzo4").innerHTML = valasz[3].szerzo;
                    
                    document.getElementById("velemeny5").innerHTML = valasz[4].leiras;
                    document.getElementById("szerzo5").innerHTML = valasz[4].szerzo;
                    
        },
        error:function(){
            alert("vélemények hiba");
        }
    });
}

// partnerek betöltése
function betoltP(){
    $.ajax({
        url:"Controller",
        type:"post",
        data:{"task":"partnerekP"},
        success:function(valasz){
            
                    document.getElementById("url01").href = valasz[0].url;
                    document.getElementById("icon01").src = valasz[0].icon;
                    document.getElementById("partner01").innerHTML = valasz[0].nev;
                    
                    document.getElementById("url02").href = valasz[1].url;
                    document.getElementById("icon02").src = valasz[1].icon;
                    document.getElementById("partner02").innerHTML = valasz[1].nev;
                    
                    document.getElementById("url03").href = valasz[2].url;
                    document.getElementById("icon03").src = valasz[2].icon;
                    document.getElementById("partner03").innerHTML = valasz[2].nev;
                    
        },
        error:function(){
            alert("partnerek hiba");
        }
    });
}

// elérhetőségek betöltése
function betoltE(){
    $.ajax({
        url:"Controller",
        type:"post",
        data:{"task":"taskEler"},
        success:function(valasz){
            
                    document.getElementById("url10").href = valasz[0].url;
                    document.getElementById("icon10").src = valasz[0].icon;
                    document.getElementById("nev10").innerHTML = valasz[0].nev;
                    
                    document.getElementById("url11").href = valasz[1].url;
                    document.getElementById("icon11").src = valasz[1].icon;
                    document.getElementById("nev11").innerHTML = valasz[1].nev;
                    
                    document.getElementById("url12").href = valasz[2].url;
                    document.getElementById("icon12").src = valasz[2].icon;
                    document.getElementById("nev12").innerHTML = valasz[2].nev;
                    
                    document.getElementById("url13").href = valasz[3].url;
                    document.getElementById("icon13").src = valasz[3].icon;
                    document.getElementById("nev13").innerHTML = valasz[3].nev;
                    
        },
        error:function(){
            alert("elérhetőségek hiba");
        }
    });
}

function betoltTermek(){
    $.ajax({
        url:"Controller",
        type:"post",
        data:{"task":"taskTermek"},
        success:function(valasz){
            
                    document.getElementById("kepmeztermek").src = valasz[0].kep;
                    document.getElementById("akac").innerHTML = valasz[0].nev;
                    document.getElementById("leirasmez").innerHTML = valasz[0].leiras;
                    
                    document.getElementById("kepdisz").src = valasz[1].kep;
                    document.getElementById("diszcsomag").innerHTML = valasz[1].nev;
                    document.getElementById("leirasdisz").innerHTML = valasz[1].leiras;
                    
        },
        error:function(){
            alert("elérhetőségek hiba");
        }
    });
}
