export function animateNavbarDesktop() {
  // Getting access to desktop navbar elements
  const logo = document.querySelector(".logo");
  const headerLink = document.querySelectorAll(".header-link");
  const headerRightSection = document.querySelector(".header-right-section");

  /* Separately for each navbar element applying 
  animation in certain intervals */
  logo.style.animation = "reveal-to-left 1s ease-in-out";
  logo.style.opacity = 1;

  setTimeout(() => {
    headerLink[0].style.animation = "reveal-to-left 1s ease-in-out";
    headerLink[0].style.opacity = 1;
  }, 200);
  setTimeout(() => {
    headerLink[1].style.animation = "reveal-to-left 1s ease-in-out";
    headerLink[1].style.opacity = 1;
  }, 400);
  setTimeout(() => {
    headerLink[2].style.animation = "reveal-to-left 1s ease-in-out";
    headerLink[2].style.opacity = 1;
  }, 600);
  setTimeout(() => {
    headerRightSection.children[0].style.animation =
      "reveal-to-left 1s ease-in-out";
    headerRightSection.children[0].style.opacity = 1;
  }, 800);
  setTimeout(() => {
    headerRightSection.children[1].style.animation =
      "reveal-to-left 1s ease-in-out";
    headerRightSection.children[1].style.opacity = 1;
  }, 1000);
}
