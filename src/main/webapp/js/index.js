const mainButtons = document.querySelectorAll(".main-btn");
const links = document.querySelectorAll(".navigation-link");

mainButtons.forEach((button) => {
  button.addEventListener("mouseover", (event) => {
    event.target.classList.remove("pulsating-effect-off");
    event.target.classList.add("pulsating-effect-on");
    event.target.style.animation =
      "pulsating-effect-on .5s ease-in-out forwards";
  });
  button.addEventListener("mouseout", (event) => {
    event.target.classList.remove("pulsating-effect-on");
    event.target.classList.add("pulsating-effect-off");
    event.target.style.animation =
      "pulsating-effect-off .5s ease-in-out forwards";
  });
});

links.forEach((link) => {
  link.addEventListener("click", (event) => {
    let selectedSection;
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
    selectedSection.scrollIntoView({ block: "center", behavior: "smooth" });
  });
});
