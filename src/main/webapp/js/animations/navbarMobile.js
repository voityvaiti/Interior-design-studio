// Getting access to mobile navbar elements
const logo = document.querySelector('.logo');
const hamburgerContainer = document.querySelector('.hamburger-container');

export function animateNavbarMobile() {

  if(window.screen.width < 992) {
    logo.style.animation = 'reveal-to-right 1.5s ease-in-out';
    hamburgerContainer.style.animation = 'reveal-to-left 1.5s ease-in-out';
    setTimeout(() => {
      logo.style.opacity = '1'
      hamburgerContainer.style.opacity = '1'
    }, 1400)
  }
}



