import { revealIntoDirection } from "../reveal-function/revealIntoDirection.js";

const ourPricingInvoking = {
  reveal: false,
  select: false,
};
export function ourPricingReveal(breakpoint) {
  if (!ourPricingInvoking.reveal) {
    const ourPricingSectionHeader = document.getElementById(
      "our-pricing-section-header"
    );
    const pricingCards = [
      document.getElementById("pricing-card-basic"),
      document.getElementById("pricing-card-standart"),
      document.getElementById("pricing-card-premium"),
    ];
    let cardTimeReveal = 200;
    if (breakpoint === "xs") {
      revealIntoDirection(ourPricingSectionHeader, "right");
      for (let card of pricingCards) {
        setTimeout(() => {
          revealIntoDirection(card, "right");
        }, cardTimeReveal);
        cardTimeReveal += 200;
      }
    } else {
      revealIntoDirection(ourPricingSectionHeader, "top");
      for (let card of pricingCards) {
        setTimeout(() => {
          revealIntoDirection(card, "top");
        }, cardTimeReveal);
        cardTimeReveal += 200;
      }
    }
    ourPricingInvoking.reveal = true;
  }
}

export function selectPricingCard() {
  if (!ourPricingInvoking.select) {
    const pricingCards = [
      document.getElementById("pricing-card-basic"),
      document.getElementById("pricing-card-standart"),
      document.getElementById("pricing-card-premium"),
    ];
    for (let i = 0; i < pricingCards.length; i++) {
      pricingCards[i].addEventListener("click", function () {
        let currentCard = document.getElementsByClassName("card active");
        currentCard[0].className = currentCard[0].className.replace(
          "card active",
          "card"
        );
        this.className += " active";
      });
    }
    ourPricingInvoking.select = true;
  }
}
