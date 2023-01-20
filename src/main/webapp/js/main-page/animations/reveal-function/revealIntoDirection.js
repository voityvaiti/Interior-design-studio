export function revealIntoDirection(element, direction) {
  switch (direction) {
    case "top":
      element.style.animation = "reveal-to-top 1s ease-in-out";
      element.style.opacity = "1";
      break;

    case "right":
      element.style.animation = "reveal-to-right 1s ease-in-out";
      element.style.opacity = "1";
      break;
      
    case "bottom":
      element.style.animation = "reveal-to-bottom 1s ease-in-out";
      element.style.opacity = "1";
      break;

    case "left":
      element.style.animation = "reveal-to-left 1s ease-in-out";
      element.style.opacity = "1";
      break;
  }
}
