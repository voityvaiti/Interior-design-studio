import { heroHeaderReveal } from "./animations/heroHeader.js";
import { glowOfMainButtons } from "./animations/mainButtons.js";

const links = document.querySelectorAll(".navigation-link");

heroHeaderReveal()
glowOfMainButtons()

// Adding event listeners for each link
links.forEach((link) => {
  link.addEventListener("click", (event) => {
    // Declaring a variable that will contain selected section
    let selectedSection;
    // Assigning selected section depending on id of clicked link
    switch (event.target.id) {
      case "about":
        selectedSection = document.querySelector(".about-studio-section");
        break;
      case "services":
        selectedSection = document.querySelector(".our-services-section");
        break;
      case "portfolio":
        selectedSection = document.querySelector(".our-portfolio-section");
        break;
      case "pricing":
        selectedSection = document.querySelector(".our-pricing-section");
        break;
      case "testimonials":
        selectedSection = document.querySelector(".testimonials-section");
        break;
    }
    // Scrolling into selected section
    selectedSection.scrollIntoView({ block: "center", behavior: "smooth" });
  });
});
