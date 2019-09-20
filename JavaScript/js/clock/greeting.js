const form = document.querySelector(".js-form");
const input = form.querySelector("input");
const greeting = document.querySelector(".js-greetings");
const rename = document.querySelector(".js-rename");

const USER_LS = "currentUser";
const SHOWING_CN = "showing";

function replaceName(){
  console.log("replace");
  localStorage.removeItem(USER_LS);
  location.reload();
}

function saveName(text){
  localStorage.setItem(USER_LS, text);
}

function handleSubmit(event){
  event.preventDefault(); 
  const currentValue = input.value;
  console.log(currentValue);
  saveName(currentValue);
  paintGreeting(currentValue);
}

function askForName(){
  form.classList.add(SHOWING_CN);
  form.addEventListener("submit", handleSubmit);
}

function paintGreeting(text) {
  form.classList.remove(SHOWING_CN);
  greeting.classList.add(SHOWING_CN);
  greeting.innerText = `Hello ${text}`;
  console.log("paintGreetings");    
}

function loadName() {
  const currentUser = localStorage.getItem(USER_LS);
  if (currentUser === null) {
    console.log("loadName false");
    askForName();
  } else {
    console.log("loadName true");
    paintGreeting(currentUser);
  }
}

function init() {
  loadName();
}

init();