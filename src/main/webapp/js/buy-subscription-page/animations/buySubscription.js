import { inputFields, labels } from "../helpers/variables.js"

document.addEventListener("DOMContentLoaded", () => {
  for (let i = 0; i < inputFields.length; i++) {
    inputFields[i].addEventListener("focus", (event) => {
      if (event.currentTarget === inputFields[i]) {
        labels[i].style.transform = "translateY(-20px)";
        labels[i].style.fontSize = "14px";
      }
    });
    inputFields[i].addEventListener("blur", () => {
      if (inputFields[i].value === "") {
        labels[i].style.transform = "translateY(0px)";
        labels[i].style.fontSize = "16px";
      }
    });
    inputFields[i].addEventListener('keydown', (event) => {
      if(event.key === 'ArrowDown') {
        inputFields[i+1].focus()
      } else if(event.key === 'ArrowUp') {
        inputFields[i-1].focus()
      }
    })
  }
});
