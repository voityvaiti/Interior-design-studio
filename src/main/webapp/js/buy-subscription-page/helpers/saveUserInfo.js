import { inputFields, labels, submitButton, inputNames } from "./variables.js";

submitButton.addEventListener("click", setUserInfo);

function setUserInfo() {
  for (let i = 0; i < inputFields.length; i++) {
    localStorage.setItem(inputNames[i], inputFields[i].value);
  }
}

document.addEventListener("DOMContentLoaded", () => {
  function getUserInfo() {
    const localStorageElements = [
      localStorage.getItem("First name"),
      localStorage.getItem("Last name"),
      localStorage.getItem("Phone number"),
      localStorage.getItem("Email"),
    ];
    for (let i = 0; i < inputFields.length; i++) {
      inputFields[i].value = localStorageElements[i];
      if (inputFields[i].value !== "") {
        labels[i].style.transform = "translateY(-20px)";
        labels[i].style.fontSize = "12px";
      }
    }
  }
  console.log(localStorage);
  getUserInfo();
});
