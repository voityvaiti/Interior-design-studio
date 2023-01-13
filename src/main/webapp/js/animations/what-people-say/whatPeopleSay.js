let wasInvoked = false;
export function testimonialsSectionHeaderReveal() {
  if (!wasInvoked) {
    const testimonialsSectionHeader = document.getElementById(
      "testimonials-section-header"
    );
    testimonialsSectionHeader.style.animation = "reveal-to-top 1s ease-in-out";
    testimonialsSectionHeader.style.opacity = "1";
  }
}
