const inputFields = document.querySelectorAll(".input-field");
const labels = [
  document.querySelector('.first-name-label'),
  document.querySelector('.last-name-label'),
  document.querySelector('.phone-number-label'),
  document.querySelector('.email-label'),
]

document.addEventListener("DOMContentLoaded", () => {
  for (let i = 0; i < inputFields.length; i++) {
    inputFields[i].addEventListener("focus", (event) => {
      if (event.currentTarget === inputFields[i]) {
        labels[i].style.transform = "translateY(-20px)";
        labels[i].style.fontSize = "12px";
      }
    });
    inputFields[i].addEventListener("blur", () => {
      if (inputFields[i].value === "") {
        labels[i].style.transform = "translateY(0px)";
        labels[i].style.fontSize = "14px";
      }
    });
  }
});
