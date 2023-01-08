let wasInvoked = false;

export function aboutStudioReveal(breakpoint) {
  if (!wasInvoked) {
    const aboutStudioSectionHeader = document.getElementById(
      "about-studio-section-header"
    );
    const aboutStudioMainText = document.getElementById(
      "about-studio-main-text"
    );
    const aboutStudioMore = document.getElementById("about-studio-more");
    const aboutStudioMoreContainer = document.querySelector(
      ".about-studio-more-container"
    );
    const aboutStudioMoreTextLg = document.getElementById(
      "about-studio-more-text-lg"
    );

    aboutStudioMore.addEventListener("click", () => {
      aboutStudioMoreContainer.classList.toggle(`reveal-text-${breakpoint}`);
    });

    aboutStudioSectionHeader.style.animation = "reveal-to-left 1s ease-in-out";
    aboutStudioSectionHeader.style.opacity = "1";

    if (
      breakpoint === "xs-1" ||
      breakpoint === "xs-2" ||
      breakpoint === "xs-3" ||
      breakpoint === "sm" ||
      breakpoint === "md"
    ) {
      setTimeout(() => {
        aboutStudioMainText.style.animation = "reveal-to-right 1s ease-in-out";
        aboutStudioMainText.style.opacity = "1";
      }, 200);
    } else {
      setTimeout(() => {
        aboutStudioMainText.style.animation = "reveal-to-bottom 1s ease-in-out";
        aboutStudioMainText.style.opacity = "1";

        aboutStudioMoreTextLg.style.animation = "reveal-to-top 1s ease-in-out";
        aboutStudioMoreTextLg.style.opacity = "1";
      }, 200);
    }

    setTimeout(() => {
      aboutStudioMore.style.animation = "reveal-to-left 1s ease-in-out";
      aboutStudioMore.style.opacity = "1";
    }, 400);

    wasInvoked = true;
  }
}
