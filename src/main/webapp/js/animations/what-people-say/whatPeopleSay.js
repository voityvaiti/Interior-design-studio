import { revealIntoDirection } from "../reveal-function/revealIntoDirection.js";

let wasInvoked = false;
export function testimonialsSectionHeaderReveal() {
  if (!wasInvoked) {
    const testimonialsSectionHeader = document.getElementById(
      "testimonials-section-header"
    );
    revealIntoDirection(testimonialsSectionHeader, 'top')
  }
}
