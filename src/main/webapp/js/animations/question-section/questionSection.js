import { revealIntoDirection } from "../reveal-function/revealIntoDirection.js";

let wasInvoked = false;
export function questionSectionReveal(breakpoint) {
  if (!wasInvoked) {
    const questionSectionHeader = document.getElementById(
      "question-section-header"
    );
    const orderCallButton = document.getElementById("order-a-call-button");
    if (breakpoint === "xs") {
      revealIntoDirection(questionSectionHeader, 'top')
      setTimeout(() => {
        revealIntoDirection(orderCallButton, 'top')
      }, 200);
    } else {
      revealIntoDirection(questionSectionHeader, 'right')
      revealIntoDirection(orderCallButton, 'left')
    }
  }
}
