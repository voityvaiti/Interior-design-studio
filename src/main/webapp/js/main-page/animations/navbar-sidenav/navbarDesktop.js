import { revealIntoDirection } from "../reveal-function/revealIntoDirection.js";
export function animateNavbarDesktop() {
  // Getting access to desktop navbar elements
  const logo = document.querySelector(".logo");
  const headerLink = document.querySelectorAll(".header-link");
  const headerRightSection = document.querySelector(".header-right-section");

  /* Separately for each navbar element applying 
  animation in certain intervals */
  revealIntoDirection(logo, "left");

  setTimeout(() => {
    revealIntoDirection(headerLink[0], "left");
  }, 200);
  setTimeout(() => {
    revealIntoDirection(headerLink[1], "left");
  }, 400);
  setTimeout(() => {
    revealIntoDirection(headerLink[2], "left");
  }, 600);
  setTimeout(() => {
    revealIntoDirection(headerRightSection.children[0], "left");
  }, 800);
  setTimeout(() => {
    revealIntoDirection(headerRightSection.children[1], "left");
  }, 1000);
}
