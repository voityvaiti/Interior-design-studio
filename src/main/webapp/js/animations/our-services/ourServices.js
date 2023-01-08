const ourServicesCardsInvoking = {
  design: false,
  services: false,
  planning: false,
  management: false,
};

export function ourServicesReveal(breakpoint, card) {
  if (!ourServicesCardsInvoking.design && card === "design") {
    interiorDesignReveal(breakpoint);
  } else if (!ourServicesCardsInvoking.services && card === "services") {
    decorativeServicesReveal(breakpoint);
  } else if (!ourServicesCardsInvoking.planning && card === "planning") {
    spacePlanningReveal(breakpoint);
  } else if (!ourServicesCardsInvoking.management && card === "management") {
    projectManagementReveal(breakpoint);
  }
  if (
    breakpoint === "sm" ||
    breakpoint === "md" ||
    breakpoint === "lg" ||
    breakpoint === "xl"
  ) {
    interiorDesignReveal(breakpoint);
    decorativeServicesReveal(breakpoint);
    spacePlanningReveal(breakpoint);
    projectManagementReveal(breakpoint);
  }
}

function interiorDesignReveal(breakpoint) {
  const ourServicesSectionHeader = document.getElementById(
    "our-services-section-header"
  );
  const interiorDesignCardIcon = document.getElementById(
    "interior-design-card-icon"
  );
  const interiorDesignCardHeader = document.getElementById(
    "interior-design-card-header"
  );
  const interiorDesignCardDescription = document.getElementById(
    "interior-design-card-description"
  );
  if (breakpoint === "xs") {
    ourServicesSectionHeader.style.animation = "reveal-to-right 1s ease-in-out";
    ourServicesSectionHeader.style.opacity = "1";

    setTimeout(() => {
      interiorDesignCardIcon.style.animation = "reveal-to-right 1s ease-in-out";
      interiorDesignCardIcon.style.opacity = "1";
    }, 200);

    setTimeout(() => {
      interiorDesignCardHeader.style.animation =
        "reveal-to-right 1s ease-in-out";
      interiorDesignCardHeader.style.opacity = "1";
    }, 400);

    setTimeout(() => {
      interiorDesignCardDescription.style.animation =
        "reveal-to-right 1s ease-in-out";
      interiorDesignCardDescription.style.opacity = "1";
    }, 600);
  } else if (
    breakpoint === "sm" ||
    breakpoint === "md" ||
    breakpoint === "lg"
  ) {
    ourServicesSectionHeader.style.animation = "reveal-to-top 1s ease-in-out";
    ourServicesSectionHeader.style.opacity = "1";

    setTimeout(() => {
      interiorDesignCardIcon.style.animation = "reveal-to-top 1s ease-in-out";
      interiorDesignCardIcon.style.opacity = "1";
    }, 200);

    setTimeout(() => {
      interiorDesignCardHeader.style.animation = "reveal-to-top 1s ease-in-out";
      interiorDesignCardHeader.style.opacity = "1";
    }, 400);

    setTimeout(() => {
      interiorDesignCardDescription.style.animation =
        "reveal-to-top 1s ease-in-out";
      interiorDesignCardDescription.style.opacity = "1";
    }, 600);
  } else {
    ourServicesSectionHeader.style.animation = "reveal-to-top 1s ease-in-out";
    ourServicesSectionHeader.style.opacity = "1";

    setTimeout(() => {
      interiorDesignCardIcon.style.animation = "reveal-to-bottom 1s ease-in-out";
      interiorDesignCardIcon.style.opacity = "1";
    }, 300);

    setTimeout(() => {
      interiorDesignCardHeader.style.animation = "reveal-to-bottom 1s ease-in-out";
      interiorDesignCardHeader.style.opacity = "1";
    }, 200);

    setTimeout(() => {
      interiorDesignCardDescription.style.animation =
        "reveal-to-bottom 1s ease-in-out";
      interiorDesignCardDescription.style.opacity = "1";
    }, 100);
  }
  ourServicesCardsInvoking.design = true;
}

function decorativeServicesReveal(breakpoint) {
  const servicesSplittingLine = document.getElementById(
    "services-splitting-line"
  );
  const decorativeServicesCardIcon = document.getElementById(
    "decorative-services-card-icon"
  );
  const decorativeServicesCardHeader = document.getElementById(
    "decorative-services-card-header"
  );
  const decorativeServicesCardDescription = document.getElementById(
    "decorative-services-card-description"
  );
  if (breakpoint === "xs") {
    servicesSplittingLine.style.animation = "reveal-to-right 1s ease-in-out";
    servicesSplittingLine.style.opacity = "1";

    setTimeout(() => {
      decorativeServicesCardIcon.style.animation =
        "reveal-to-right 1s ease-in-out";
      decorativeServicesCardIcon.style.opacity = "1";
    }, 200);

    setTimeout(() => {
      decorativeServicesCardHeader.style.animation =
        "reveal-to-right 1s ease-in-out";
      decorativeServicesCardHeader.style.opacity = "1";
    }, 400);

    setTimeout(() => {
      decorativeServicesCardDescription.style.animation =
        "reveal-to-right 1s ease-in-out";
      decorativeServicesCardDescription.style.opacity = "1";
    }, 600);
  } else if (
    breakpoint === "sm" ||
    breakpoint === "md" ||
    breakpoint === "lg"
  ) {
    setTimeout(() => {
      decorativeServicesCardIcon.style.animation =
        "reveal-to-top 1s ease-in-out";
      decorativeServicesCardIcon.style.opacity = "1";
    }, 200);

    setTimeout(() => {
      decorativeServicesCardHeader.style.animation =
        "reveal-to-top 1s ease-in-out";
      decorativeServicesCardHeader.style.opacity = "1";
    }, 400);

    setTimeout(() => {
      decorativeServicesCardDescription.style.animation =
        "reveal-to-top 1s ease-in-out";
      decorativeServicesCardDescription.style.opacity = "1";
    }, 600);
  } else {
    setTimeout(() => {
      decorativeServicesCardIcon.style.animation =
        "reveal-to-top 1s ease-in-out";
      decorativeServicesCardIcon.style.opacity = "1";
    }, 400);

    setTimeout(() => {
      decorativeServicesCardHeader.style.animation =
        "reveal-to-top 1s ease-in-out";
      decorativeServicesCardHeader.style.opacity = "1";
    }, 500);

    setTimeout(() => {
      decorativeServicesCardDescription.style.animation =
        "reveal-to-top 1s ease-in-out";
      decorativeServicesCardDescription.style.opacity = "1";
    }, 600);
  }
  ourServicesCardsInvoking.services = true;
}

function spacePlanningReveal(breakpoint) {
  const planningSplittingLine = document.getElementById(
    "planning-splitting-line"
  );
  const spacePlanningCardIcon = document.getElementById(
    "space-planning-card-icon"
  );
  const spacePlanningCardHeader = document.getElementById(
    "space-planning-card-header"
  );
  const spacePlanningCardDescription = document.getElementById(
    "space-planning-card-description"
  );
  if (breakpoint === "xs") {
    planningSplittingLine.style.animation = "reveal-to-right 1s ease-in-out";
    planningSplittingLine.style.opacity = "1";

    setTimeout(() => {
      spacePlanningCardIcon.style.animation = "reveal-to-right 1s ease-in-out";
      spacePlanningCardIcon.style.opacity = "1";
    }, 200);

    setTimeout(() => {
      spacePlanningCardHeader.style.animation =
        "reveal-to-right 1s ease-in-out";
      spacePlanningCardHeader.style.opacity = "1";
    }, 400);

    setTimeout(() => {
      spacePlanningCardDescription.style.animation =
        "reveal-to-right 1s ease-in-out";
      spacePlanningCardDescription.style.opacity = "1";
    }, 600);
  } else if (
    breakpoint === "sm" ||
    breakpoint === "md" ||
    breakpoint === "lg"
  ) {
    setTimeout(() => {
      spacePlanningCardIcon.style.animation = "reveal-to-top 1s ease-in-out";
      spacePlanningCardIcon.style.opacity = "1";
    }, 800);

    setTimeout(() => {
      spacePlanningCardHeader.style.animation = "reveal-to-top 1s ease-in-out";
      spacePlanningCardHeader.style.opacity = "1";
    }, 1000);

    setTimeout(() => {
      spacePlanningCardDescription.style.animation =
        "reveal-to-top 1s ease-in-out";
      spacePlanningCardDescription.style.opacity = "1";
    }, 1200);
  } else {
    setTimeout(() => {
      spacePlanningCardIcon.style.animation = "reveal-to-bottom 1s ease-in-out";
      spacePlanningCardIcon.style.opacity = "1";
    }, 900);

    setTimeout(() => {
      spacePlanningCardHeader.style.animation = "reveal-to-bottom 1s ease-in-out";
      spacePlanningCardHeader.style.opacity = "1";
    }, 800);

    setTimeout(() => {
      spacePlanningCardDescription.style.animation =
        "reveal-to-bottom 1s ease-in-out";
      spacePlanningCardDescription.style.opacity = "1";
    }, 700);
  }
  ourServicesCardsInvoking.services = true;
}

function projectManagementReveal(breakpoint) {
  const managementSplittingLine = document.getElementById(
    "management-splitting-line"
  );
  const projectManagementCardIcon = document.getElementById(
    "project-management-card-icon"
  );
  const projectManagementCardHeader = document.getElementById(
    "project-management-card-header"
  );
  const projectManagementCardDescription = document.getElementById(
    "project-management-card-description"
  );
  if (breakpoint === "xs") {
    managementSplittingLine.style.animation = "reveal-to-right 1s ease-in-out";
    managementSplittingLine.style.opacity = "1";

    setTimeout(() => {
      projectManagementCardIcon.style.animation =
        "reveal-to-right 1s ease-in-out";
      projectManagementCardIcon.style.opacity = "1";
    }, 200);

    setTimeout(() => {
      projectManagementCardHeader.style.animation =
        "reveal-to-right 1s ease-in-out";
      projectManagementCardHeader.style.opacity = "1";
    }, 400);

    setTimeout(() => {
      projectManagementCardDescription.style.animation =
        "reveal-to-right 1s ease-in-out";
      projectManagementCardDescription.style.opacity = "1";
    }, 600);
  } else if (
    breakpoint === "sm" ||
    breakpoint === "md" ||
    breakpoint === "lg"
  ) {
    setTimeout(() => {
      projectManagementCardIcon.style.animation =
        "reveal-to-top 1s ease-in-out";
      projectManagementCardIcon.style.opacity = "1";
    }, 800);

    setTimeout(() => {
      projectManagementCardHeader.style.animation =
        "reveal-to-top 1s ease-in-out";
      projectManagementCardHeader.style.opacity = "1";
    }, 1000);

    setTimeout(() => {
      projectManagementCardDescription.style.animation =
        "reveal-to-top 1s ease-in-out";
      projectManagementCardDescription.style.opacity = "1";
    }, 1200);
  } else {
    setTimeout(() => {
      projectManagementCardIcon.style.animation =
        "reveal-to-top 1s ease-in-out";
      projectManagementCardIcon.style.opacity = "1";
    }, 1000);

    setTimeout(() => {
      projectManagementCardHeader.style.animation =
        "reveal-to-top 1s ease-in-out";
      projectManagementCardHeader.style.opacity = "1";
    }, 1100);

    setTimeout(() => {
      projectManagementCardDescription.style.animation =
        "reveal-to-top 1s ease-in-out";
      projectManagementCardDescription.style.opacity = "1";
    }, 1200);
  }
  ourServicesCardsInvoking.services = true;
}
