var modal = document.getElementById("myModal");

var btn = document.getElementById("myBtn");

var span = document.getElementsByClassName("close")[0];

var setSubmit = document.getElementById("setForm")

const setContainer = document.getElementById("sets")

const cookieArr = document.cookie.split("=");
const userId = cookieArr[1];
const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/sets/"


window.onload = function(){
    getAllSets();
}


btn.onclick = function() {
  modal.style.display = "block";
}

span.onclick = function() {
  modal.style.display = "none";
}

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

const submitSet = async (e) => {
    e.preventDefault()
    let bodyObj = {
        name: document.getElementById("setName").value,
        subject: document.getElementById("setSubject").value
    }
    await addSet(bodyObj);
    document.getElementById("setName").value = ''
    document.getElementById("setSubject").value = ''
}

async function addSet(obj) {
    const response = await fetch(`${baseUrl}user/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200){
        location.href='http://localhost:8080/home'
    }
}

async function getAllSets() {
    await fetch(baseUrl, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createSetCards(data))
        .catch(err => console.error(err))
}

const createSetCards = (array) => {
    setContainer.innerHTML = '';
    array.forEach(obj => {
        let setCard = document.createElement("div")
        console.log(obj);
        setCard.classList.add("setCard")
        setCard.innerHTML = `
        <div class="header" onclick='location.href="http://localhost:8080/set?id=${obj.id}"' style='cursor:pointer;'>
           <h4>Set Name: ${obj.name}</h4>
           <h4>Username: ${obj.userName}</h4>
           <h4>Subject: ${obj.subject}</h4>
        </div>
        `
        setContainer.append(setCard);
    })
}

setSubmit.addEventListener("submit", submitSet)