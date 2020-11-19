function loadDigimon(digimon){
    document.getElementById("name").innerHTML="Here is your " + digimon[0].name + "!";
    document.getElementById("digiImage").src = digimon[0].img;
}

function getDigimon() {
    console.log("in get digimon");
    let digimonName=document.getElementById("dgName").value;
    // Step 1
    var xhr = new XMLHttpRequest();
    // Step 2
    xhr.onreadystatechange = function() {
        console.log("in ORSC");
        if (xhr.readyState==4&&xhr.status==200) {
            console.log(xhr.responseText);
            var digimon = JSON.parse(xhr.responseText);
            loadDigimon(digimon);
        }
    }
    // Step 3
    xhr.open("GET", "https://digimon-api.vercel.app/api/digimon/name/"+digimonName,true);
    // Step 4
    xhr.send();

}

window.onload=function(){
    console.log("in onload");
    document.getElementById("digisubmit").addEventListener("click",getDigimon, false);
}