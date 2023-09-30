
const setContainer = document.getElementById("sets")
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const subject = urlParams.get('subject');

const baseUrl = "http://localhost:8080/api/v1/sets/"
const header = document.getElementById("headerSubject")

window.onload = function(){
    getSetsBySubject();
    createHeader()
}
const createHeader = () => {
    header.innerHTML = `<h2>${subject} Sets</h2>`;
}
const headers = {
    'Content-Type': 'application/json'
}

async function getSetsBySubject() {
    await fetch(`${baseUrl}subject/${subject}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createSetCards(data))
        .catch(err => console.error(err))
}

const createSetCards = (array) => {
    console.log(array)
    setContainer.innerHTML = '';
    array.forEach(obj => {
        let setCard = document.createElement("div")
        console.log(obj);
        setCard.classList.add("setCard")
        setCard.innerHTML = `
        <div class="header" onclick='http://localhost:8080/set?id=${obj.id}&name=${obj.name}&subject=${obj.subject}"' style='cursor:pointer;'>
           <h4>Set Name: ${obj.name}</h4>
           <h4>Username: ${obj.userName}</h4>
           <h4>Subject: ${obj.subject}</h4>
        </div>
        `
        setContainer.append(setCard);
    })
}
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}