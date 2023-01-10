export function glowOfMainButtons() {
  // Getting access to main buttons
  const mainButtons = document.querySelectorAll(".main-btn");
  // Adding event listeners for each main button
  mainButtons.forEach((button) => {
    button.addEventListener("mouseover", (event) => {
      /* Adding class that on hover causes animation and removing class
      that causes inverted animation if it was previously assigned */
      event.target.classList.remove("pulsating-effect-off");
      event.target.classList.add("pulsating-effect-on");
      event.target.style.animation =
        "pulsating-effect-on .5s ease-in-out forwards";
    });
    //  Manipulating classes in reverse order
    button.addEventListener("mouseout", (event) => {
      event.target.classList.remove("pulsating-effect-on");
      event.target.classList.add("pulsating-effect-off");
      event.target.style.animation =
        "pulsating-effect-off .5s ease-in-out forwards";
    });
  });
}
