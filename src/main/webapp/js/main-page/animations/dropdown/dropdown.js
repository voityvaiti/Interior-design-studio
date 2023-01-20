import { changeLanguage } from "../../helpers/changeLanguage.js"
export function dropdownToggle() {
  const selectUALanguage = document.getElementById("ua-language");
  const selectENLanguage = document.getElementById("en-language");
  const dropdownArrow = document.getElementById("dropdown-arrow");
  selectENLanguage.addEventListener("click", () => {
    if (selectUALanguage.classList.contains("language-reveal")) {
      dropdownArrow.style.transform = "rotate(0deg)";
      selectUALanguage.style.animation = "hide .3s ease-in-out forwards";
      setTimeout(() => {
        selectUALanguage.style.visibility = "hidden";
      }, 300);
    } else {
      dropdownArrow.style.transform = "rotate(-180deg)";
      selectUALanguage.style.animation = "reveal .3s ease-in-out forwards";
      selectUALanguage.style.visibility = "visible";
    }
    selectUALanguage.classList.toggle("language-reveal");
  });
  selectUALanguage.addEventListener("click", function () {
    if (location.hash === "#ua") {
      changeLanguage("en");
    } else {
      changeLanguage("ua");
    }
  });
}
