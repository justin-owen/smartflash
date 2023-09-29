const containerCard = document.querySelector('.containerCard')
const cardList = document.querySelectorAll('.card')
const flashCardContainer = document.getElementById("containerFlashCards")
const updatedQuestion = document.getElementById("newQuestion")
const updatedAnswer = document.getElementById("newAnswer")
const updateCardBtn = document.getElementById("submitFlashCardEdit")

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const setId = urlParams.get('id');

var modal = document.getElementById("myModal");
var editModal = document.getElementById("edit-modal")
var btn = document.getElementById("myBtn");

var span = document.getElementsByClassName("close")[0];

var flashCardSubmit = document.getElementById("flashCardForm")

const baseUrl = 'http://localhost:8080/api/v1/questions/'

const headers = {
    'Content-Type': 'application/json'
}

window.onload = function(){
    getQuestions();
    console.log(setId)
}

btn.onclick = function() {
  modal.style.display = "block";
}

span.onclick = function() {
  modal.style.display = "none";
}


const submitFlashCard = async (e) => {
    e.preventDefault()
    let bodyObj = {
        question_string: document.getElementById("question").value,
        answer_string: document.getElementById("answer").value
    }
    await addFlashCard(bodyObj);
    document.getElementById("question").value = ''
    document.getElementById("answer").value = ''
}
async function addFlashCard(obj) {
    const response = await fetch(`${baseUrl}set/${setId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200){
        location.href=`http://localhost:8080/set?id=${setId}`
    }
}
async function getQuestions() {
    await fetch(`${baseUrl}set/${setId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createFlashCards(data))
        .catch(err => console.error(err))
}
const createFlashCards = (array) => {
    flashCardContainer.innerHTML = '';
    array.forEach(obj => {
        let flashCard = document.createElement("div")
        flashCard.classList.add("containerCard")
        flashCard.innerHTML = `
        <div class="card card${obj.id}" onclick="flip(${obj.id})" style="margin-bottom: 100px;">
            <div class="cardFront">
                <div class="dropdown options" style="color: black;">
                    <div class="cardOptions">
                        <span class="material-symbols-outlined dropbtn">more_horiz</span>
                        <div class="dropdown-content">
                            <a href="#" style="color: black;" onclick="getCardById(${obj.id})">Edit Card</a>
                            <a href="#" style="color: red;" onclick="handleCardDelete(${obj.id})">Delete Card</a>
                        </div>
                    </div>
                </div>
                <h3>${obj.question_string}</h3>
            </div>
            <div class="cardBack">
                <div class="dropdown options" style="color: black;">
                    <div class="cardOptions">
                        <span class="material-symbols-outlined dropbtn">more_horiz</span>
                        <div class="dropdown-content">
                            <a href="#" style="color: black;" onclick="getCardById(${obj.id})">Edit Card</a>
                            <a href="#" style="color: red;" onclick="handleCardDelete(${obj.id})">Delete Card</a>
                        </div>
                    </div>
                </div>
                <h3>${obj.answer_string}</h3>
            </div>
        </div>
        `
        flashCardContainer.append(flashCard);
    })
}
flashCardSubmit.addEventListener("submit", submitFlashCard)

function flip(id){
    let card = document.querySelector(`.card${id}`)
    card.classList.toggle('animate')
}
async function handleCardEdit(cardId){
    let bodyObj = {
        id: cardId,
        question_string: updatedQuestion.value,
        answer_string: updatedAnswer.value
    }

    await fetch(baseUrl, {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err))
    return getQuestions();
}

async function handleCardDelete(cardId){
    await fetch(baseUrl + cardId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))
    return getQuestions();
}
async function getCardById(cardId){
    editModal.style.display = "block";
    await fetch(baseUrl + cardId, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => populateModal(data))
        .catch(err => console.error(err.message))
}
const populateModal = (obj) => {
    updatedQuestion.innerText = ''
    updatedAnswer.innerText = ''
    updatedQuestion.innerText = obj.question_string
    updatedAnswer.innerText = obj.answer_string
    updateCardBtn.setAttribute('card-id', obj.id)
}
updateCardBtn.addEventListener("click", (e)=>{
    let cardId = e.target.getAttribute('card-id')
    handleCardEdit(cardId);
    editModal.style.display = "none";
})

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}