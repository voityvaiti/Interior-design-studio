import { revealIntoDirection } from "../reveal-function/revealIntoDirection.js";

let wasInvoked = false;

export function ourServicesReveal(breakpoint) {
  if (!wasInvoked) {
    if (breakpoint === "xs") {
      interiorDesignReveal(breakpoint);
      setTimeout(() => {
        decorativeServicesReveal(breakpoint);
      }, 500);
      setTimeout(() => {
        spacePlanningReveal(breakpoint);
      }, 1000);
      setTimeout(() => {
        projectManagementReveal(breakpoint);
      }, 1500);
    } else {
      interiorDesignReveal(breakpoint);
      decorativeServicesReveal(breakpoint);
      spacePlanningReveal(breakpoint);
      projectManagementReveal(breakpoint);
    }
    wasInvoked = true;
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
    revealIntoDirection(ourServicesSectionHeader, "right");

    setTimeout(() => {
      revealIntoDirection(interiorDesignCardIcon, "right");
    }, 200);

    setTimeout(() => {
      revealIntoDirection(interiorDesignCardHeader, "right");
    }, 400);

    setTimeout(() => {
      revealIntoDirection(interiorDesignCardDescription, "right");
    }, 600);
  } else if (
    breakpoint === "sm" ||
    breakpoint === "md" ||
    breakpoint === "lg"
  ) {
    revealIntoDirection(ourServicesSectionHeader, "top");
    
    setTimeout(() => {
      revealIntoDirection(interiorDesignCardIcon, "top");
    }, 200);

    setTimeout(() => {
      revealIntoDirection(interiorDesignCardHeader, "top");
    }, 400);

    setTimeout(() => {
      revealIntoDirection(interiorDesignCardDescription, "top");
    }, 600);
  } else {
    revealIntoDirection(ourServicesSectionHeader, "top");

    setTimeout(() => {
      revealIntoDirection(interiorDesignCardIcon, "bottom");
    }, 300);

    setTimeout(() => {
      revealIntoDirection(interiorDesignCardHeader, "bottom");
    }, 200);

    setTimeout(() => {
      revealIntoDirection(interiorDesignCardDescription, "bottom");
    }, 100);
  }
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
    revealIntoDirection(servicesSplittingLine, "right");

    setTimeout(() => {
      revealIntoDirection(decorativeServicesCardIcon, "right");
    }, 200);

    setTimeout(() => {
      revealIntoDirection(decorativeServicesCardHeader, "right");
    }, 400);

    setTimeout(() => {
      revealIntoDirection(decorativeServicesCardDescription, "right");
    }, 600);
  } else if (
    breakpoint === "sm" ||
    breakpoint === "md" ||
    breakpoint === "lg"
  ) {
    setTimeout(() => {
      revealIntoDirection(decorativeServicesCardIcon, "top");
    }, 200);

    setTimeout(() => {
      revealIntoDirection(decorativeServicesCardHeader, "top");
    }, 400);

    setTimeout(() => {
      revealIntoDirection(decorativeServicesCardDescription, "top");
    }, 600);
  } else {
    setTimeout(() => {
      revealIntoDirection(decorativeServicesCardIcon, "top");
    }, 400);

    setTimeout(() => {
      revealIntoDirection(decorativeServicesCardHeader, "top");
    }, 500);

    setTimeout(() => {
      revealIntoDirection(decorativeServicesCardDescription, "top");
    }, 600);
  }
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
    revealIntoDirection(planningSplittingLine, "right");

    setTimeout(() => {
      revealIntoDirection(spacePlanningCardIcon, "right");
    }, 200);

    setTimeout(() => {
      revealIntoDirection(spacePlanningCardHeader, "right");
    }, 400);

    setTimeout(() => {
      revealIntoDirection(spacePlanningCardDescription, "right");
    }, 600);
  } else if (
    breakpoint === "sm" ||
    breakpoint === "md" ||
    breakpoint === "lg"
  ) {
    setTimeout(() => {
      revealIntoDirection(spacePlanningCardIcon, "top");
    }, 800);

    setTimeout(() => {
      revealIntoDirection(spacePlanningCardHeader, "top");
    }, 1000);

    setTimeout(() => {
      revealIntoDirection(spacePlanningCardDescription, "top");
    }, 1200);
  } else {
    setTimeout(() => {
      revealIntoDirection(spacePlanningCardIcon, "bottom");
    }, 900);

    setTimeout(() => {
      revealIntoDirection(spacePlanningCardHeader, "bottom");
    }, 800);

    setTimeout(() => {
      revealIntoDirection(spacePlanningCardDescription, "bottom");
    }, 700);
  }
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
  const consultationButton = document.getElementById("consultation-button");
  if (breakpoint === "xs") {
    revealIntoDirection(managementSplittingLine, "right");

    setTimeout(() => {
      revealIntoDirection(projectManagementCardIcon, "right");
    }, 200);

    setTimeout(() => {
      revealIntoDirection(projectManagementCardHeader, "right");
    }, 400);

    setTimeout(() => {
      revealIntoDirection(projectManagementCardDescription, "right");
    }, 600);
  } else if (
    breakpoint === "sm" ||
    breakpoint === "md" ||
    breakpoint === "lg"
  ) {
    setTimeout(() => {
      revealIntoDirection(projectManagementCardIcon, "top");
    }, 800);

    setTimeout(() => {
      revealIntoDirection(projectManagementCardHeader, "top");
    }, 1000);

    setTimeout(() => {
      revealIntoDirection(projectManagementCardDescription, "top");
    }, 1200);
  } else {
    setTimeout(() => {
      revealIntoDirection(projectManagementCardIcon, "top");
    }, 1000);

    setTimeout(() => {
      revealIntoDirection(projectManagementCardHeader, "top");
    }, 1100);

    setTimeout(() => {
      revealIntoDirection(projectManagementCardDescription, "top");
    }, 1200);
    setTimeout(() => {
      revealIntoDirection(consultationButton, "top");
    }, 1300);
  }
}
