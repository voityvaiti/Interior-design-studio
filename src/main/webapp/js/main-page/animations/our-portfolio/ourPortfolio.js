import { revealIntoDirection } from "../reveal-function/revealIntoDirection.js";

let wasInvoked = false;
export function ourPortfolioReveal(breakpoint) {
  if (!wasInvoked) {
    const ourPortfolioSectionHeader = document.getElementById(
      "our-portfolio-section-header"
    );
    const tabsContainerMore = document.getElementById("tabs-container-more");
    const filters = document.querySelectorAll("#filter");
    const galleryImages = document.querySelectorAll("#gallery-img");
    let filterTimeReveal = 0;
    let galleryImagesTimeReveal = 400;
    if (breakpoint === "xs") {
      revealIntoDirection(ourPortfolioSectionHeader, "right");
      for (let i = 0; i < filters.length; i++) {
        setTimeout(() => {
          revealIntoDirection(filters[i], "top");
        }, filterTimeReveal);
        filterTimeReveal += 100;
      }
      for (let i = 0; i < galleryImages.length; i++) {
        if (galleryImages[i].id === "gallery-img-4") {
          break;
        }
        setTimeout(() => {
          revealIntoDirection(galleryImages[i], "right");
        }, galleryImagesTimeReveal);
        galleryImagesTimeReveal += 100;
      }
    } else if (
      breakpoint === "sm" ||
      breakpoint === "md" ||
      breakpoint === "lg" ||
      breakpoint === "xl"
    ) {
      revealIntoDirection(ourPortfolioSectionHeader, "top");
      for (let i = 0; i < filters.length; i++) {
        setTimeout(() => {
          revealIntoDirection(filters[i], "top");
        }, filterTimeReveal);
        filterTimeReveal += 100;
      }
      setTimeout(() => {
        revealIntoDirection(tabsContainerMore, "top");
      }, 600);
      for (let i = 0; i < galleryImages.length; i++) {
        setTimeout(() => {
          revealIntoDirection(galleryImages[i], "top");
        }, galleryImagesTimeReveal);
        galleryImagesTimeReveal += 100;
      }
    }
    wasInvoked = true;
  }
}
