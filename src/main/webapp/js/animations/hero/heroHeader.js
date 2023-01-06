export function heroHeaderReveal() {
  // Getting access to hero-header elements
  const heroHeaderH1 = document.getElementById('hero-header-h1')
  const heroHeaderP = document.getElementById('hero-header-p')
  const heroHeaderButton = document.getElementById('hero-header-button')

  /* Separately for each hero-header element applying 
  animation in certain intervals */

  heroHeaderH1.style.animation = "reveal-to-right 1s ease-in-out";
  setTimeout(() => {
    heroHeaderH1.style.opacity = "1";
  }, 900);
  setTimeout(() => {
    heroHeaderP.style.animation = "reveal-to-right 1s ease-in-out";
    heroHeaderP.style.opacity = "1";
  }, 250);
  setTimeout(() => {
    heroHeaderButton.style.animation = "reveal-to-right 1s ease-in-out";
    heroHeaderButton.style.opacity = "1";
  }, 500);
}
