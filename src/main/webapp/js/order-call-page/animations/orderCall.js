import {
  orderCallNameLabel,
  orderCallNumberLabel,
  inputFields,
} from "../helpers/variables.js";

document.addEventListener("DOMContentLoaded", () => {
  const flagContainer = document.querySelector(".flag-container");
  for (let i = 0; i < inputFields.length; i++) {
    inputFields[i].addEventListener("focus", (event) => {
      if (event.currentTarget === inputFields[0]) {
        orderCallNameLabel.style.transform = "translateY(-20px)";
        orderCallNameLabel.style.fontSize = "14px";
      } else {
        orderCallNumberLabel.style.transform = "translateY(-20px)";
        orderCallNumberLabel.style.fontSize = "14px";
        setTimeout(() => {
          flagContainer.style.opacity = "1";
          inputFields[1].classList.add("reveal-placeholder");
        }, 100);
      }
    });
    inputFields[0].addEventListener("blur", () => {
      if (inputFields[0].value === "") {
        orderCallNameLabel.style.transform = "translateY(0px)";
        orderCallNameLabel.style.fontSize = "16px";
      }
    });
  }
});

let inputNumber = $("#number");
let errorMessage = $("#error-msg");
let validMessage = $("#valid-msg");

// initialize plugin
inputNumber.intlTelInput({
  utilsScript:
    "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/11.0.4/js/utils.js",
});

let reset = function () {
  inputNumber.removeClass("error");
  errorMessage.addClass("hide");
  validMessage.addClass("hide");
};

// on blur: validate
inputNumber.blur(function () {
  reset();
  if ($.trim(inputNumber.val())) {
    if (inputNumber.intlTelInput("isValidNumber")) {
      validMessage.removeClass("hide");
    } else {
      inputNumber.addClass("error");
      errorMessage.removeClass("hide");
    }
  }
});

// on keyup / change flag: reset
inputNumber.on("keyup change", reset);
