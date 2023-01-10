let wasInvoked = false;
export function ourPortfolioReveal(breakpoint) {
  if (!wasInvoked) {
    const ourPortfolioSectionHeader = document.getElementById(
      "our-portfolio-section-header"
    );
    const tabsContainerMore = document.getElementById("tabs-container-more");
    const filters = [
      document.getElementById("our-portfolio-all"),
      document.getElementById("our-portfolio-commercial"),
      document.getElementById("our-portfolio-residental"),
      document.getElementById("our-portfolio-office"),
      document.getElementById("our-portfolio-other"),
    ];
    const galleryImages = [
      document.getElementById("gallery-img-1"),
      document.getElementById("gallery-img-2"),
      document.getElementById("gallery-img-3"),
      document.getElementById("gallery-img-4"),
      document.getElementById("gallery-img-5"),
      document.getElementById("gallery-img-6"),
      document.getElementById("gallery-img-7"),
      document.getElementById("gallery-img-8"),
    ];
    if (breakpoint === "xs") {
      ourPortfolioSectionHeader.style.animation =
        "reveal-to-right 1s ease-in-out";
      ourPortfolioSectionHeader.style.opacity = "1";
      let filterTime = 0;
      let galleryImagesTime = 800;
      for (let filter of filters) {
        setTimeout(() => {
          filter.style.animation = "reveal-to-top 1s ease-in-out";
          filter.style.opacity = "1";
        }, filterTime);
        filterTime += 200;
      }
      for (let image of galleryImages) {
        if (image.id === "gallery-img-4") {
          break;
        }
        setTimeout(() => {
          image.style.animation = "reveal-to-right 1s ease-in-out";
          image.style.opacity = "1";
        }, galleryImagesTime);
        galleryImagesTime += 200;
      }
    } else if (
      breakpoint === "sm" ||
      breakpoint === "md" ||
      breakpoint === "lg" ||
      breakpoint === "xl"
    ) {
      ourPortfolioSectionHeader.style.animation =
        "reveal-to-top 1s ease-in-out";
      ourPortfolioSectionHeader.style.opacity = "1";
      let filterTime = 0;
      let galleryImagesTime = 400;
      for (let filter of filters) {
        setTimeout(() => {
          filter.style.animation = "reveal-to-top 1s ease-in-out";
          filter.style.opacity = "1";
        }, filterTime);
        filterTime += 100;
      }
      setTimeout(() => {
        tabsContainerMore.style.animation = "reveal-to-top 1s ease-in-out";
        tabsContainerMore.style.opacity = "1";
      }, 1000);
      for (let image of galleryImages) {
        setTimeout(() => {
          image.style.animation = "reveal-to-top 1s ease-in-out";
          image.style.opacity = "1";
        }, galleryImagesTime);
        galleryImagesTime += 100;
      }
    }
    wasInvoked = true;
  }
}
