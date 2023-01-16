import { revealIntoDirection } from "../reveal-function/revealIntoDirection.js";
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

    revealIntoDirection(aboutStudioSectionHeader, "left");

    if (
      breakpoint === "xs-1" ||
      breakpoint === "xs-2" ||
      breakpoint === "xs-3" ||
      breakpoint === "sm" ||
      breakpoint === "md"
    ) {
      setTimeout(() => {
        revealIntoDirection(aboutStudioMainText, "right");
      }, 200);
    } else {
      setTimeout(() => {
        revealIntoDirection(aboutStudioMainText, "bottom");

        revealIntoDirection(aboutStudioMoreTextLg, "top");
      }, 200);
    }

    setTimeout(() => {
      revealIntoDirection(aboutStudioMore, "left");
    }, 400);

    wasInvoked = true;
  }
}
