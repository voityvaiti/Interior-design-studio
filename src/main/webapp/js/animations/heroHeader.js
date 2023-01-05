export function heroHeaderReveal() {
  // Getting access to hero-header
  const heroHeader = document.querySelector(".hero-header");

  /* heroHeader.children[0, 1, 2 ... n] returns HTMLCollection 
  of child elements. Separately for each child element applying 
  animation in certain intervals */

  heroHeader.children[0].style.animation = "reveal-to-right 1s ease-in-out";
  setTimeout(() => {
    heroHeader.children[0].style.opacity = "1";
  }, 900);
  setTimeout(() => {
    heroHeader.children[1].style.animation = "reveal-to-right 1s ease-in-out";
    heroHeader.children[1].style.opacity = "1";
  }, 250);
  setTimeout(() => {
    heroHeader.children[2].style.animation = "reveal-to-right 1s ease-in-out";
    heroHeader.children[2].style.opacity = "1";
  }, 500);
}
