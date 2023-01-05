export function animateHeroImg() {
  const heroImg = document.querySelector(".hero-img");

  heroImg.style.animation = "reveal-to-left 1.5s ease-in-out";
  
  setTimeout(() => {
    heroImg.style.opacity = "1";
  }, 900);
}
