import { revealIntoDirection } from "../reveal-function/revealIntoDirection.js";
export function heroHeaderReveal() {
  // Getting access to hero-header elements
  const heroHeaderH1 = document.getElementById('hero-header-h1')
  const heroHeaderP = document.getElementById('hero-header-p')
  const heroHeaderButton = document.getElementById('hero-header-button')

  /* Separately for each hero-header element applying 
  animation in certain intervals */

  revealIntoDirection(heroHeaderH1, "right");
  setTimeout(() => {
    revealIntoDirection(heroHeaderP, "right");
  }, 250);
  setTimeout(() => {
    revealIntoDirection(heroHeaderButton, "right");
  }, 500);
}
