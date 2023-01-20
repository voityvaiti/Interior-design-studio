let wasInvoked = false;
export function pricingCardsHover() {
  if (!wasInvoked) {
    const pricingCards = [
      document.getElementById("pricing-card-basic"),
      document.getElementById("pricing-card-standart"),
      document.getElementById("pricing-card-premium"),
    ];
    const pricingCardsButtons = [
      document.getElementById("pricing-card-basic-btn"),
      document.getElementById("pricing-card-standart-btn"),
      document.getElementById("pricing-card-premium-btn"),
    ];
    pricingCards.forEach((card) => {
      card.addEventListener("mousemove", (event) => {
        const cursorPositionX = event.pageX - event.currentTarget.offsetLeft;
        const cursorPositionY = event.pageY - event.currentTarget.offsetTop;
        if (
          cursorPositionX < card.offsetWidth / 3 &&
          cursorPositionY < card.offsetHeight / 3
        ) {
          card.style.transform =
            "perspective(1500px) rotateX(10deg) rotateY(-10deg)";
        } else if (
          cursorPositionX > card.offsetWidth / 3 &&
          cursorPositionX < (card.offsetWidth / 3) * 2 &&
          cursorPositionY < card.offsetHeight / 3
        ) {
          card.style.transform = "perspective(1500px) rotateX(10deg)";
        } else if (
          cursorPositionX > (card.offsetWidth / 3) * 2 &&
          cursorPositionY < card.offsetHeight / 3
        ) {
          card.style.transform =
            "perspective(1500px) rotateX(10deg) rotateY(10deg)";
        } else if (
          cursorPositionX < card.offsetWidth / 3 &&
          cursorPositionY > card.offsetHeight / 3 &&
          cursorPositionY < (card.offsetHeight / 3) * 2
        ) {
          card.style.transform = "perspective(1500px) rotateY(-10deg)";
        } else if (
          cursorPositionX > card.offsetWidth / 3 &&
          cursorPositionX < (card.offsetWidth / 3) * 2 &&
          cursorPositionY > card.offsetHeight / 3 &&
          cursorPositionY < (card.offsetHeight / 3) * 2
        ) {
          card.style.transform = "rotateX(0deg) rotateY(0deg)";
        } else if (
          cursorPositionX > (card.offsetWidth / 3) * 2 &&
          cursorPositionY > card.offsetHeight / 3 &&
          cursorPositionY < (card.offsetHeight / 3) * 2
        ) {
          card.style.transform = "perspective(1500px) rotateY(10deg)";
        } else if (
          cursorPositionX < card.offsetWidth / 3 &&
          cursorPositionY > (card.offsetHeight / 3) * 2
        ) {
          if (
            event.target === pricingCardsButtons[0] ||
            event.target === pricingCardsButtons[1] ||
            event.target === pricingCardsButtons[2]
          ) {
            card.style.transform = "rotateX(0deg) rotateY(0deg)";
          } else {
            card.style.transform =
              "perspective(1500px) rotateX(-10deg) rotateY(-10deg)";
          }
        } else if (
          cursorPositionX > card.offsetWidth / 3 &&
          cursorPositionX < (card.offsetWidth / 3) * 2 &&
          cursorPositionY > (card.offsetHeight / 3) * 2
        ) {
          if (
            event.target === pricingCardsButtons[0] ||
            event.target === pricingCardsButtons[1] ||
            event.target === pricingCardsButtons[2]
          ) {
            card.style.transform = "rotateX(0deg) rotateY(0deg)";
          } else {
            card.style.transform = "perspective(1500px) rotateX(-10deg)";
          }
        } else if (
          cursorPositionX > (card.offsetWidth / 3) * 2 &&
          cursorPositionY > (card.offsetHeight / 3) * 2
        ) {
          if (
            event.target === pricingCardsButtons[0] ||
            event.target === pricingCardsButtons[1] ||
            event.target === pricingCardsButtons[2]
          ) {
            card.style.transform = "rotateX(0deg) rotateY(0deg)";
          } else {
            card.style.transform =
              "perspective(1500px) rotateX(-10deg) rotateY(10deg)";
          }
        }
      });
      card.addEventListener("mouseleave", () => {
        card.style.transform = "rotateX(0deg) rotateY(0deg)";
      });
    });
    wasInvoked = true;
  }
}
