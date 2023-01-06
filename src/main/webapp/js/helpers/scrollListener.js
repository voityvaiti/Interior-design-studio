import { aboutStudioReveal } from "../animations/about-studio/aboutStudio.js";

export function addScrollListener(breakpoint) {
  window.addEventListener("scroll", () => {
    let scrollYPosition = scrollY;
    console.log(scrollYPosition);
    switch (breakpoint) {
      case "xs":
        if (scrollYPosition >= 500 && scrollYPosition <= 600) {
          aboutStudioReveal("xs");
        }
        break;
      case "lg":
        if (scrollYPosition >= 100 && scrollYPosition <= 200) {
          aboutStudioReveal("lg");
        }
        break;
    }
  });
}
