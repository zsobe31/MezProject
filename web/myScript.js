// admin oldalra betöltések

//  bemutatkozás betöltése
function bemutatkozas(){
    $.ajax({
        url:"ControllerTwo",
        type:"post",
        data:{"task":"taskBemutat"},
        success:function(valasz){
                    document.getElementById("id01").innerHTML = valasz[0].id;
                    document.getElementById("kep1").innerHTML = valasz[0].kep;
                    document.getElementById("bemutat").innerHTML = valasz[0].leiras;
        },
        error:function(){
            alert("bemutatkozás hiba");
        }
    });
}

//  ismertetők betöltése
function ismertetok(){
    var ismer = document.getElementById("ismerteto");
    $.ajax({
        url:"ControllerTwo",
        type:"post",
        data:{"task":"taskIsmerteto"},
        success:function(valasz){
            for (var i = 0; i < valasz.length; i++) {
                ismer.innerHTML += "<div>";
                    ismer.innerHTML += "<span>" + valasz[i].id + "</span>";
                    ismer.innerHTML += "<span>" + valasz[i].logo + "</span>";
                    ismer.innerHTML += "<span>" + valasz[i].leirt + "</span>";
                    ismer.innerHTML += "<span>" + valasz[i].leiras + "</span>";
                ismer.innerHTML += "</div>";
            }
                    
        },
        error:function(){
            alert("ismertetők hiba");
        }
    });
}

//  méztermékek betöltése
function mezterm(){
    var mez = document.getElementById("meztermek");
    $.ajax({
        url:"ControllerTwo",
        type:"post",
        data:{"task":"taskMez"},
        success:function(valasz){
            for (var i = 0; i < valasz.length; i++) {
                mez.innerHTML += "<div>";
                    mez.innerHTML += "<span>" + valasz[i].id + "</span>";
                    mez.innerHTML += "<span>" + valasz[i].nev + "</span>";
                    mez.innerHTML += "<span>" + valasz[i].mennyiseg + "</span>";
                    mez.innerHTML += "<span>" + valasz[i].ar + "</span>";
                mez.innerHTML += "</div>";
            }
                    
        },
        error:function(){
            alert("ismertetők hiba");
        }
    });
}

//  diszcsomagolt betöltése
function diszterm(){
    var diszT = document.getElementById("diszTermek");
    $.ajax({
        url:"ControllerTwo",
        type:"post",
        data:{"task":"taskDisz"},
        success:function(valasz){
            for (var i = 0; i < valasz.length; i++) {
                diszT.innerHTML += "<div>";
                    diszT.innerHTML += "<span>" + valasz[i].id + "</span>";
                    diszT.innerHTML += "<span>" + valasz[i].nev + "</span>";
                    diszT.innerHTML += "<span>" + valasz[i].mennyiseg + "</span>";
                    diszT.innerHTML += "<span>" + valasz[i].ar + "</span>";
                diszT.innerHTML += "</div>";
            }
                    
        },
        error:function(){
            alert("diszcsomagolt hiba");
        }
    });
}

//  képleírás betöltése
function kepLeiras(){
    var kepI = document.getElementById("kepIras");
    $.ajax({
        url:"ControllerTwo",
        type:"post",
        data:{"task":"taskKepIras"},
        success:function(valasz){
            for (var i = 0; i < valasz.length; i++) {
                kepI.innerHTML += "<div>";
                    kepI.innerHTML += "<span>" + valasz[i].id + "</span>";
                    kepI.innerHTML += "<span>" + valasz[i].nev + "</span>";
                    kepI.innerHTML += "<span>" + valasz[i].leiras + "</span>";
                    kepI.innerHTML += "<span>" + valasz[i].kep + "</span>";
                kepI.innerHTML += "</div>";
            }
                    
        },
        error:function(){
            alert("képleírás hiba");
        }
    });
}

//  vélemények betöltése
function velemenyV(){
    var velem = document.getElementById("velemeny");
    $.ajax({
        url:"ControllerTwo",
        type:"post",
        data:{"task":"taskVelemeny"},
        success:function(valasz){
            for (var i = 0; i < valasz.length; i++) {
                velem.innerHTML += "<div>";
                    velem.innerHTML += "<span>" + valasz[i].id + "</span>";
                    velem.innerHTML += "<span>" + valasz[i].leiras + "</span>";
                    velem.innerHTML += "<span>" + valasz[i].szerzo + "</span>";
                velem.innerHTML += "</div>";
            }
                    
        },
        error:function(){
            alert("vélemények hiba");
        }
    });
}

//  partnerek betöltése
function partnerP(){
    var par = document.getElementById("partner");
    $.ajax({
        url:"ControllerTwo",
        type:"post",
        data:{"task":"taskPartner"},
        success:function(valasz){
            for (var i = 0; i < valasz.length; i++) {
                par.innerHTML += "<div>";
                    par.innerHTML += "<span>" + valasz[i].id + "</span>";
                    par.innerHTML += "<span>" + valasz[i].nev + "</span>";
                    par.innerHTML += "<span>" + valasz[i].icon + "</span>";
                    par.innerHTML += "<span>" + valasz[i].url + "</span>";
                par.innerHTML += "</div>";
            }
                    
        },
        error:function(){
            alert("partnerek hiba");
        }
    });
}

//  elérhetőségek betöltése
function elerE(){
    var a = document.getElementById("elerheto");
    $.ajax({
        url:"ControllerTwo",
        type:"post",
        data:{"task":"taskElerheto"},
        success:function(valasz){
            for (var i = 0; i < valasz.length; i++) {
                a.innerHTML += "<div>";
                    a.innerHTML += "<span>" + valasz[i].id + "</span>";
                    a.innerHTML += "<span>" + valasz[i].nev + "</span>";
                    a.innerHTML += "<span>" + valasz[i].icon + "</span>";
                    a.innerHTML += "<span>" + valasz[i].url + "</span>";
                a.innerHTML += "</div>";
            }
                    
        },
        error:function(){
            alert("elérhetőségek hiba");
        }
    });
}

