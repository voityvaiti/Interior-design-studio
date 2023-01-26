import {
  orderCallNameLabel,
  orderCallNumberLabel,
  nameInput,
  numberInput,
  submitButton,
} from "./variables.js";

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
      orderCallNameLabel.style.transform = "translateY(-20px)";
      orderCallNameLabel.style.fontSize = "14px";
    }
    if (numberInput.value != "") {
      orderCallNumberLabel.style.transform = "translateY(-20px)";
      orderCallNumberLabel.style.fontSize = "14px";
      flagContainer.style.opacity = "1";
    }
  }
  console.log(localStorage);
  getUserInfo();
});
