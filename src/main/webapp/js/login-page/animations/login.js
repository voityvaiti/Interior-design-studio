const loginInputs = document.querySelectorAll(".login-input");
const loginLabels = document.querySelectorAll(".login-label");

const loginInputContainers = [
  document.querySelector(".username-input-container"),
  document.querySelector(".password-input-container"),
];

document.addEventListener("DOMContentLoaded", () => {
  for (let i = 0; i < loginInputs.length; i++) {
    loginInputs[i].addEventListener("focus", (event) => {
      if (event.currentTarget === loginInputs[i]) {
        loginLabels[i].style.transform = "translateY(-20px)";
        loginLabels[i].style.fontSize = "14px";
      }
    });
    loginInputs[i].addEventListener("blur", () => {
      if (loginInputs[i].value === "") {
        loginLabels[i].style.transform = "translateY(0px)";
        loginLabels[i].style.fontSize = "16px";
      }
    });
    loginInputs[i].addEventListener("keydown", (event) => {
      if (event.key === "ArrowDown") {
        try {
          loginInputs[i + 1].focus();
        } catch (error) {
          return;
        }
      } else if (event.key === "ArrowUp") {
        try {
          loginInputs[i - 1].focus();
        } catch (error) {
          return;
        }
      }
    });
  }
});
