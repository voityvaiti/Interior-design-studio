const inputFields = document.querySelectorAll(".input-field");
const nameLabel = document.querySelector(".name-label");
const numberLabel = document.querySelector(".number-label");

document.addEventListener("DOMContentLoaded", () => {
  const flagContainer = document.querySelector(".flag-container");
  for (let i = 0; i < inputFields.length; i++) {
    inputFields[i].addEventListener("focus", (event) => {
      if (event.currentTarget === inputFields[0]) {
        nameLabel.style.transform = "translateY(-20px)";
        nameLabel.style.fontSize = "14px";
      } else {
        numberLabel.style.transform = "translateY(-20px)";
        numberLabel.style.fontSize = "14px";
        setTimeout(() => {
          flagContainer.style.opacity = "1";
          inputFields[1].classList.add("reveal-placeholder");
        }, 100);
      }
    });
    inputFields[0].addEventListener("blur", () => {
      if (inputFields[0].value === "") {
        nameLabel.style.transform = "translateY(0px)";
        nameLabel.style.fontSize = "16px";
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
