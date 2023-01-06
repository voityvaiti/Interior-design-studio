export function animateNavbarMobile() {
  // Getting access to mobile navbar elements
  const logo = document.querySelector(".logo");
  const hamburgerContainer = document.querySelector(".hamburger-container");
  logo.style.animation = "reveal-to-right 1.5s ease-in-out";
  hamburgerContainer.style.animation = "reveal-to-left 1.5s ease-in-out";
  setTimeout(() => {

    logo.style.opacity = "1";
    hamburgerContainer.style.opacity = "1";
  }, 1400);
}
