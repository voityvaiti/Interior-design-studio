const nameInput = document.getElementById("name");
const numberInput = document.getElementById("number");
const nameLabel1 = document.querySelector(".name-label");
const numberLabel1 = document.querySelector(".number-label");
const submitButton = document.querySelector(".submit-button");

submitButton.addEventListener("click", setUserInfo);

function setUserInfo() {
  localStorage.setItem("name", nameInput.value);
  localStorage.setItem("number", numberInput.value);
}

document.addEventListener("DOMContentLoaded", () => {
  function getUserInfo() {
    const savedName = localStorage.getItem("name");
    const savedNumber = localStorage.getItem("number");
    const flagContainer = document.querySelector(".flag-container");
    nameInput.value = savedName;
    numberInput.value = savedNumber;
    if (nameInput.value != "") {
      nameLabel1.style.transform = "translateY(-20px)";
      nameLabel1.style.fontSize = "14px";
    }
    if (numberInput.value != "") {
      numberLabel1.style.transform = "translateY(-20px)";
      numberLabel1.style.fontSize = "14px";
      flagContainer.style.opacity = "1";
      inputFields[1].classList.add("reveal-placeholder");
    }
  }
  console.log(localStorage);
  getUserInfo();
});
