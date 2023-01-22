import { changeLanguage } from "../../helpers/changeLanguage.js";

const hamburgerContainer = document.querySelector(".hamburger-container");
const sideNavBackPanel = document.querySelector(".sidenav-back-panel");
const sideNav = document.querySelector(".sidenav");
const navigationLinks = document.querySelectorAll('.navigation-link')
const selectENLanguage = document.getElementById("sidenav-en-language");
const selectUALanguage = document.getElementById("sidenav-ua-language");

export function toggleSideNav() {
  hamburgerContainer.addEventListener("click", () => {
    hamburgerContainer.classList.remove("menu-off");
    hamburgerContainer.classList.add("menu-on");

    sideNav.style.width = "60%";
    sideNavBackPanel.style.display = "block";
    sideNavBackPanel.style.backgroundColor = "rgba(0, 0, 0, 0.3)";
  });
  sideNavBackPanel.addEventListener("click", closeSideNav);
  for (let i = 0; i < navigationLinks.length; i++) {
    navigationLinks[i].addEventListener('click', closeSideNav)
  }
  selectENLanguage.addEventListener('click', function () {
    changeLanguage('en')
  })
  selectUALanguage.addEventListener('click', function () {
    changeLanguage('ua')
  })
}

function closeSideNav() {
  hamburgerContainer.classList.remove("menu-on");
  hamburgerContainer.classList.add("menu-off");

  sideNav.style.width = "0";
  sideNavBackPanel.style.display = "none";
}
