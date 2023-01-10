import { heroHeaderReveal } from "./animations/hero/heroHeader.js";
import { glowOfMainButtons } from "./animations/main-buttons/mainButtons.js"
import { animateNavbarMobile } from "./animations/navbar-sidenav/navbarMobile.js";
import { animateNavbarDesktop } from "./animations/navbar-sidenav/navbarDesktop.js";
import { toggleSideNav } from "./animations/navbar-sidenav/sideNav.js";
import { animateHeroImg } from "./animations/hero/heroImg.js";
import { aboutStudioReveal } from "./animations/about-studio/aboutStudio.js";

import { addScrollListener } from "./helpers/scrollListener.js";
import { addScrollIntoSection } from "./helpers/navigation.js";

if (window.screen.width <= 576) {
  if (window.screen.width >= 270 && window.screen.width <= 320) {
    addScrollListener("xs-1");
  } else if (window.screen.width > 320 && window.screen.width <= 400) {
    addScrollListener("xs-2");
  } else if (window.screen.width > 400) {
    addScrollListener("xs-3");
  }
  animateHeroImg("xs");
} else if (window.screen.width > 576 && window.screen.width <= 768) {
  animateHeroImg("sm");
  aboutStudioReveal("sm");
  addScrollListener("sm");
} else if (window.screen.width > 768 && window.screen.width <= 992) {
  animateHeroImg("md");
  aboutStudioReveal("md");
  addScrollListener("md");
} else if(window.screen.width > 992 && window.screen.width <= 1200) {
  animateHeroImg("lg");
  animateNavbarDesktop();
  addScrollListener("lg");
} else {
  animateHeroImg("xl");
  animateNavbarDesktop();
  addScrollListener("xl");
}

if (window.screen.width < 992) {
  animateNavbarMobile();
  toggleSideNav();
} 

heroHeaderReveal();
glowOfMainButtons();
addScrollIntoSection();
