export function animateHeroImg(breakpoint) {
  const heroImg = document.querySelector(".hero-img");

  if (breakpoint === "xs") {
    heroImg.style.animation = "reveal-to-top 2s ease-in-out";
  } else {
    heroImg.style.animation = "reveal-to-top 1.5s ease-in-out";
  }
  setTimeout(() => {
    heroImg.style.opacity = "1";
  }, 900);
}
