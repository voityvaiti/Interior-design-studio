<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="styles/main-page/main.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<title>id Studio</title>
</head>

<body>
<nav class="navbar">
    <div class="inner-navbar px-0">
        <a class="navbar-brand py-0 me-0" href="#">
            <img class="logo" id="header-logo" src="images/navbar/logo.svg" alt="">
        </a>
        <p class="header-link navigation-link mb-0" id="services" href="#">Services</p>
        <p class="header-link navigation-link mb-0" id="portfolio" href="#">Portfolio</p>
        <p class="header-link navigation-link mb-0" id="pricing" href="#">Pricing</p>
    </div>
    <div class="header-right-section">
        <a href="#" class="contact-phone">(303) 555-0105</a>
        <div class="dropdown">
            <div class="en-language" id="en-language">
                <p>EN</p>
                <img id="dropdown-arrow" src="images/navbar/dropdown-arrow.svg" alt="">
            </div>
            <div class="ua-language" id="ua-language">
                <p>UA</p>
            </div>
        </div>
    </div>
    <div class="hamburger-container menu-off" id="hamburger-container">
        <span></span>
        <span></span>
        <span></span>
    </div>
</nav>

<section class="sidenav-container">
    <div class="sidenav">
        <div class="navigation">
            <div class="navigation-dropdown">
                <div class="en-language" id="sidenav-en-language">
                    <p class="mb-0">EN</p>
                </div>
                <div class="ua-language ms-5" id="sidenav-ua-language">
                    <p class="mb-0">UA</p>
                </div>
            </div>
            <p class="navigation-link sidenav-navigation-link" id="about">About</p>
            <p class="navigation-link sidenav-navigation-link" id="services">Services</p>
            <p class="navigation-link sidenav-navigation-link" id="portfolio">Portfolio</p>
            <p class="navigation-link sidenav-navigation-link" id="pricing">Pricing</p>
            <p class="navigation-link sidenav-navigation-link" id="testimonials">Testimonials</p>
        </div>
    </div>
    <div class="sidenav-back-panel"></div>
</section>

<main class="hero row d-flex justify-content-between mx-0 px-0">
    <div class="hero-header col-12 col-sm-6 d-flex flex-column">
        <h1 class="mb-0" id="hero-header-h1">We create your space better</h1>
        <p class="mb-0" id="hero-header-p">Our team creates comfortable spaces for our clients. We've been designing your
            everyday life and
            work through great ideas since 1999.</p>
        <a href="<%=request.getContextPath()%>/subscribing" style="text-decoration: none">
            <button class="get-started-button main-btn" id="hero-header-button">GET STARTED</button>
        </a>
    </div>
    <div class="col-12 col-sm-6 px-0">
        <img class="hero-img" src="images/main.svg" alt="" draggable="false">
    </div>
</main>

<section class="about-studio-section d-flex">
    <div class="row about-studio-row">
        <div class="about-studio-header col-12 col-lg-5 d-flex align-items-center px-0">
            <h2 class="section-header" id="about-studio-section-header">About <span>Studio</span></h2>
        </div>
        <div class="about-studio-col col px-0">
            <p class="about-studio-main-text" id="about-studio-main-text">Interiart is an award-winning architecture and
                interior design practice based in NYC. We work
                internationally
                on projects of residential & commercial interior design that require a creative approach. Our talented and
                experienced designers leverage their knowledge and expertise to create unique and comfortable interiors for
                you.
            </p>
            <p class="about-studio-more-text-lg" id="about-studio-more-text-lg">
                <br>
                Our team knows that interior design can be stressful for the client and we do our best to make it as easy as
                possible. We listen to your needs, ideas, and inputs. And most importantly, we make it exciting and
                enjoyable
                for our clients.
            </p>
            <div class=" about-studio-more-container">
                <p class="about-studio-more-text-xs" id="about-studio-more-text-xs">
                    Our team knows that interior design can be stressful for the client and we do our best to make it as easy as
                    possible. We listen to your needs, ideas, and inputs. And most importantly, we make it exciting and
                    enjoyable
                    for our clients.
                </p>
            </div>
            <p class="more about-studio-more" id="about-studio-more">READ MORE</p>
        </div>
    </div>
</section>

<section class="our-services-section d-flex flex-column align-items-center">
    <h2 class="section-header text-center" id="our-services-section-header">Our <span>Services</span></h2>
    <div class="row container-fluid px-0">

        <div class="services-card-container col-12 col-sm-6 col-xl-3 d-flex justify-content-center px-0">
            <div class="card text-center">
                <div class="card-img-container d-flex align-items-center mx-auto">
                    <img class="card-img-top" id="interior-design-card-icon"
                         src="./images/our-services/interior-design-icon.svg" alt="" draggable="false">
                </div>
                <div class="card-body d-flex flex-column px-0 py-0 mt-5 ">
                    <h5 class="fw-semibold mb-3" id="interior-design-card-header">INTERIOR DESIGN</h5>
                    <p class="service-description fw-normal" id="interior-design-card-description">
                        Interior design services offer a vast variety of solutions for our clients' homes and offices.</p>
                </div>
            </div>
            <span id="services-splitting-line"></span>
        </div>

        <div class="services-card-container col-12 col-sm-6 col-xl-3 d-flex justify-content-center px-0">
            <div class="card text-center">
                <div class="card-img-container d-flex align-items-center mx-auto">
                    <img class="card-img-top" id="decorative-services-card-icon"
                         src="./images/our-services/decorative-services-icon.svg" alt="" draggable="false">
                </div>
                <div class="card-body d-flex flex-column px-0 py-0 mt-5 ">
                    <h5 class="fw-semibold mb-3" id="decorative-services-card-header">DECORATIVE SERVICES</h5>
                    <p class="service-description fw-normal" id="decorative-services-card-description">
                        Our professional decorators will be happy to help you change your house's inner look.
                    </p>
                </div>
            </div>
            <span id="planning-splitting-line"></span>
        </div>

        <div class="services-card-container col-12 col-sm-6 col-xl-3 d-flex justify-content-center px-0">
            <div class="card text-center">
                <div class="card-img-container d-flex align-items-center mx-auto">
                    <img class="card-img-top" id="space-planning-card-icon" src="./images/our-services/space-planning-icon.svg"
                         alt="" draggable="false">
                </div>
                <div class="card-body d-flex flex-column px-0 py-0 mt-5">
                    <h5 class="fw-semibold mb-3" id="space-planning-card-header">SPACE PLANNING</h5>
                    <p class="service-description fw-normal" id="space-planning-card-description">
                        We create better interior experiences through our space planning services.
                    </p>
                </div>
            </div>
            <span id="management-splitting-line"></span>
        </div>

        <div class="services-card-container col-12 col-sm-6 col-xl-3 d-flex justify-content-center px-0">
            <div class="card text-center">
                <div class="card-img-container d-flex align-items-center mx-auto">
                    <img class="card-img-top" id="project-management-card-icon"
                         src="./images/our-services/project-management-icon.svg" alt="" draggable="false">
                </div>
                <div class="card-body container-fluid d-flex flex-column px-0 py-0 mt-5">
                    <h5 class="fw-semibold mb-3" id="project-management-card-header">PROJECT MANAGEMENT</h5>
                    <p class="service-description fw-normal" id="project-management-card-description">
                        We provide proper project management as it's one of the main success factors in interior design.
                    </p>
                </div>
            </div>
        </div>
    </div>
    <a href="<%=request.getContextPath()%>/order-call" style="text-decoration: none">
        <button type="button" class="free-consultation-button main-btn fw-bold rounded-3" id="consultation-button">FREE
            CONSULTATION</button>
    </a>
</section>

<section class="our-portfolio-section container-fluid text-center px-0">
    <div class="section-header-container d-flex justify-content-center">
        <h2 class="section-header" id="our-portfolio-section-header">Our <span>Portfolio</span></h2>
    </div>
    <div class="tabs-container container-fluid">
        <div class="tabs d-flex justify-content-between">
            <p class="mb-0" id="filter">ALL</p>
            <p class="mb-0 mx-1" id="filter">COMMERCIAL</p>
            <p class="mb-0" id="filter">RESIDENTIAL</p>
            <p class="mb-0 mx-1" id="filter">OFFICE</p>
            <p class="mb-0" id="filter">OTHER</p>
        </div>
        <a class="more px-0" id="tabs-container-more" href="#">VIEW MORE</a>
    </div>
    </div>
    <div class="gallery row mx-0">
        <div class="col-12 col-sm-6 col-lg-4 col-xl-3 px-0">
            <div class="card h-100">
                <img class="card-img-top h-100 w-100" id="gallery-img" src="images/gallery/img (1).svg" alt=""
                     draggable="false">
            </div>
        </div>
        <div class="col-12 col-sm-6 col-lg-4 col-xl-3 px-0">
            <div class="card h-100">
                <img class="card-img-top h-100 w-100" id="gallery-img" src="images/gallery/img (2).svg" alt=""
                     draggable="false">
            </div>
        </div>
        <div class="col-12 col-sm-6 col-lg-4 col-xl-3 px-0">
            <div class="card h-100">
                <img class="card-img-top h-100 w-100" id="gallery-img" src="images/gallery/img (3).svg" alt=""
                     draggable="false">
            </div>
        </div>
        <div class="col-12 col-sm-6 col-lg-4 col-xl-3 px-0">
            <div class="card h-100">
                <img class="card-img-top h-100 w-100" id="gallery-img" src="images/gallery/img (4).svg" alt=""
                     draggable="false">
            </div>
        </div>
        <div class="col-12 col-sm-6 col-lg-4 col-xl-3 px-0">
            <div class="card h-100">
                <img class="card-img-top h-100 w-100" id="gallery-img" src="images/gallery/img (5).svg" alt=""
                     draggable="false">
            </div>
        </div>
        <div class="col-12 col-sm-6 col-lg-4 col-xl-3 px-0">
            <div class="card h-100">
                <img class="card-img-top h-100 w-100" id="gallery-img" src="images/gallery/img (6).svg" alt=""
                     draggable="false">
            </div>
        </div>
        <div class="col-12 col-sm-6 col-lg-4 col-xl-3 px-0">
            <div class="card h-100">
                <img class="card-img-top h-100 w-100" id="gallery-img" src="images/gallery/img (7).svg" alt=""
                     draggable="false">
            </div>
        </div>
        <div class="col-12 col-sm-6 col-lg-4 col-xl-3 px-0">
            <div class="card h-100">
                <img class="card-img-top h-100 w-100" id="gallery-img" src="images/gallery/img (8).svg" alt=""
                     draggable="false">
            </div>
        </div>
        <a class="more px-0" href="#">VIEW MORE</a>
    </div>
</section>
<section class="our-pricing-section d-flex align-items-center">
    <h2 class="section-header" id="our-pricing-section-header">Our <span>Pricing</span></h2>

    <div class="row container-fluid justify-content-center px-0">
        <div class="col-8 col-sm-5 col-lg-3 d-flex justify-content-center px-0">
            <div class="card" id="pricing-card-basic">
                <div class="card-body d-flex text-center justify-content-between align-items-center">
                    <p class="pricing-type">Basic</p>
                    <div class="price-container px-0 py-0">
                        <p class="price">$25</p>
                        <p class="per-month">per month</p>
                    </div>
                    <span></span>
                    <ul>
                        <li id="pricing-service">Interior Design</li>
                        <li id="pricing-service">Project Discussion</li>
                        <li id="pricing-service">Space Planning</li>
                        <li id="pricing-service">Online Consultation</li>
                    </ul>
                    <a href="<%=request.getContextPath()%>/subscribing?subscription-preset=basic" style="text-decoration: none">
                        <button type="button" class="buy-now-button main-btn" id="pricing-card-basic-btn">BUY NOW</button>
                    </a>
                </div>
            </div>
        </div>

        <div class="col-8 col-sm-5 col-lg-3 d-flex justify-content-center px-0">
            <div class="card active" id="pricing-card-standart">
                <div class="card-body d-flex text-center justify-content-between align-items-center">
                    <p class="pricing-type">Standard</p>
                    <div class="price-container px-0 py-0">
                        <p class="price">$50</p>
                        <p class="per-month">per month</p>
                    </div>
                    <span></span>
                    <ul>
                        <li id="pricing-service">Color Analysis</li>
                        <li id="pricing-service">Space Planning</li>
                        <li id="pricing-service">Home Remodeling</li>
                        <li id="pricing-service">3D Interior Model</li>
                    </ul>
                    <a href="<%=request.getContextPath()%>/subscribing?subscription-preset=standard" style="text-decoration: none">
                        <button type="button" class="buy-now-button main-btn" id="pricing-card-standart-btn">BUY NOW</button>
                    </a>
                </div>
            </div>
        </div>

        <div class="col-8 col-sm-5 col-lg-3 d-flex justify-content-center px-0">
            <div class="card" id="pricing-card-premium">
                <div class="card-body d-flex text-center justify-content-between align-items-center">
                    <p class="pricing-type">Premium</p>
                    <div class="price-container px-0 py-0">
                        <p class="price">$80</p>
                        <p class="per-month">per month</p>
                    </div>
                    <span></span>
                    <ul>
                        <li id="pricing-service">Concept Development</li>
                        <li id="pricing-service">Decoration Services</li>
                        <li id="pricing-service">Interior Architecture</li>
                        <li id="pricing-service">Flooring Installation</li>
                    </ul>
                    <a href="<%=request.getContextPath()%>/subscribing?subscription-preset=premium" style="text-decoration: none">
                        <button type="button" class="buy-now-button main-btn" id="pricing-card-premium-btn">BUY NOW</button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="testimonials-section d-flex align-items-center">
    <h2 class="section-header text-center" id="testimonials-section-header">What <span>People Say</span></h2>
    <div id="carousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="10000">
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <div class="testimonials-owner d-flex">
                            <img src="images/what-people-say/annette-black.png" alt="" draggable="false">
                            <div class="owner-info d-flex">
                                <p class="name">Annette Black</p>
                                <p class="position">Merchandising Associate</p>
                                <span></span>
                                <div class="social d-flex">
                                    <a href="#">
                                        <img src="images/social-media/twitter.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/linkedin.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/facebook.svg" alt="" draggable="false">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <p>Convallis non proin ac bibendum. At pharetra sed ultrices semper. Lectus et ornare ultrices urna in. Id
                            non fringilla dignissim ac risus amet eget egestas vestibulum. Aliquet etiam eget nulla nulla odio vel.
                        </p>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <div class="testimonials-owner d-flex">
                            <img src="images/what-people-say/marvin-mckinney.jpg" alt="" draggable="false">
                            <div class="owner-info d-flex">
                                <p class="name">Marvin McKinney</p>
                                <p class="position">Administrator</p>
                                <span></span>
                                <div class="social d-flex">
                                    <a href="#">
                                        <img src="images/social-media/twitter.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/linkedin.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/facebook.svg" alt="" draggable="false">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <p>Leo viverra vestibulum amet, scelerisque. Vitae, ultrices mi rhoncus porttitor nulla sed sodales.
                            Curabitur tellus massa, lacinia non at. Lacus, hac fermentum, viverra tortor, eget. Eget egestas eget
                            ultrices vitae.
                        </p>
                    </div>
                </div>
            </div>
            <div class="carousel-item" data-bs-interval="10000">
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <div class="testimonials-owner d-flex">
                            <img src="images/what-people-say/joanna-gaines.jpg" alt="" draggable="false">
                            <div class="owner-info d-flex">
                                <p class="name">Joanna Gaines</p>
                                <p class="position">Interior Designer</p>
                                <span></span>
                                <div class="social d-flex">
                                    <a href="#">
                                        <img src="images/social-media/twitter.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/linkedin.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/facebook.svg" alt="" draggable="false">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <p>
                            Est eius tenetur neque, impedit modi veniam. Quibusdam animi tenetur deserunt adipisci praesentium ex
                            obcaecati error sequi earum unde non nulla cumque quia, expedita repellendus sapiente eaque.
                        </p>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <div class="testimonials-owner d-flex">
                            <img src="images/what-people-say/marvin-mckinney.jpg" alt="" draggable="false">
                            <div class="owner-info d-flex">
                                <p class="name">Marvin McKinney</p>
                                <p class="position">Administrator</p>
                                <span></span>
                                <div class="social d-flex">
                                    <a href="#">
                                        <img src="images/social-media/twitter.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/linkedin.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/facebook.svg" alt="" draggable="false">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <p>Leo viverra vestibulum amet, scelerisque. Vitae, ultrices mi rhoncus porttitor nulla sed sodales.
                            Curabitur tellus massa, lacinia non at. Lacus, hac fermentum, viverra tortor, eget. Eget egestas eget
                            ultrices vitae.
                        </p>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <div class="testimonials-owner d-flex">
                            <img src="images/what-people-say/nate-berkus.jpg" alt="" draggable="false">
                            <div class="owner-info d-flex">
                                <p class="name">Nate Berkus</p>
                                <p class="position">Interior Designer</p>
                                <span></span>
                                <div class="social d-flex">
                                    <a href="#">
                                        <img src="images/social-media/twitter.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/linkedin.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/facebook.svg" alt="" draggable="false">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <p>Saepe facilis et, id amet necessitatibus quis cum suscipit nobis alias corrupti veniam velit at soluta
                            sapiente quod adipisci, maxime quae. Maxime, veniam aperiam impedit incidunt nemo aspernatur molestias.
                            Magnam!
                        </p>
                    </div>
                </div>
            </div>
            <div class="carousel-item" data-bs-interval="10000">
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <div class="testimonials-owner d-flex">
                            <img src="images/what-people-say/kelly-wearstler.jpg" alt="" draggable="false">
                            <div class="owner-info d-flex">
                                <p class="name">Kelly Wearstler</p>
                                <p class="position">Interior Designer</p>
                                <span></span>
                                <div class="social d-flex">
                                    <a href="#">
                                        <img src="images/social-media/twitter.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/linkedin.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/facebook.svg" alt="" draggable="false">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <p>
                            Et rerum a eos distinctio temporibus. Quod sed neque quibusdam facilis eveniet. Ipsum mollitia expedita,
                            illum officiis deleniti incidunt perspiciatis praesentium. Aperiam et ea molestias fugit dignissimos
                            ullam illo consectetur!
                        </p>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <div class="testimonials-owner d-flex">
                            <img src="images/what-people-say/pavlo-rymarovych.jpg" alt="" draggable="false">
                            <div class="owner-info d-flex">
                                <p class="name">Pavlo Rymarovych</p>
                                <p class="position">Backend Developer</p>
                                <span></span>
                                <div class="social d-flex">
                                    <a href="#">
                                        <img src="images/social-media/twitter.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/linkedin.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/facebook.svg" alt="" draggable="false">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <p>Quas beatae atque reprehenderit velit enim ratione nesciunt, aliquid ipsa, explicabo esse facere et!
                            Iusto labore vitae voluptatum maxime modi ab eveniet aperiam laboriosam accusamus, excepturi laborum.
                        </p>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <div class="testimonials-owner d-flex">
                            <img src="images/what-people-say/jonathan-adler.jpg" alt="" draggable="false">
                            <div class="owner-info d-flex">
                                <p class="name">Jonathan Adler</p>
                                <p class="position">Interior Designer</p>
                                <span></span>
                                <div class="social d-flex">
                                    <a href="#">
                                        <img src="images/social-media/twitter.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/linkedin.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/facebook.svg" alt="" draggable="false">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <p>
                            Est consequatur possimus suscipit. Alias aperiam maiores doloremque, possimus accusantium inventore ad
                            rerum, quibusdam molestias assumenda aut velit. Laudantium asperiores iusto quisquam quam deserunt
                            harum.
                        </p>
                    </div>
                </div>
            </div>
            <div class="carousel-item" data-bs-interval="10000">
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <div class="testimonials-owner d-flex">
                            <img src="images/what-people-say/pavlo-rymarovych.jpg" alt="" draggable="false">
                            <div class="owner-info d-flex">
                                <p class="name">Pavlo Rymarovych</p>
                                <p class="position">Backend Developer</p>
                                <span></span>
                                <div class="social d-flex">
                                    <a href="#">
                                        <img src="images/social-media/twitter.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/linkedin.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/facebook.svg" alt="" draggable="false">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <p>Quas beatae atque reprehenderit velit enim ratione nesciunt, aliquid ipsa, explicabo esse facere et!
                            Iusto labore vitae voluptatum maxime modi ab eveniet aperiam laboriosam accusamus, excepturi laborum.
                        </p>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <div class="testimonials-owner d-flex">
                            <img src="images/what-people-say/me.jpg" alt="">
                            <div class="owner-info d-flex">
                                <p class="name">Dmytro Truten</p>
                                <p class="position">Frontend Developer</p>
                                <span></span>
                                <div class="social d-flex">
                                    <a href="#">
                                        <img src="images/social-media/twitter.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/linkedin.svg" alt="" draggable="false">
                                    </a>
                                    <a href="#">
                                        <img src="images/social-media/facebook.svg" alt="" draggable="false">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae veniam, eum illo, tempora ipsa corporis
                            quis explicabo autem inventore quaerat nemo perferendis iste consequatur! Iure saepe cupiditate fugit
                            ipsum eligendi.
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="carousel-indicators justify-content-between">
            <button type="button" data-bs-target="#carousel" data-bs-slide-to="0" class="active"
                    aria-current="true"></button>
            <button type="button" data-bs-target="#carousel" data-bs-slide-to="1"></button>
            <button type="button" data-bs-target="#carousel" data-bs-slide-to="2"></button>
            <button type="button" data-bs-target="#carousel" data-bs-slide-to="3"></button>
        </div>
    </div>
</section>
<section class="question-section row container-fluid mx-0">
    <div class="col-8 col-md-4 col-lg-3 px-0">
        <h2 class="section-header" id="question-section-header">Do you have <br><span>any question?</span></h2>
    </div>
    <div class="col-sm-6 col-md-2 px-0">
        <a class="redirect-to-order-page" href="<%=request.getContextPath()%>/order-call" style="text-decoration: none">
            <button type="button" class="get-started-button main-btn" id="order-a-call-button">ORDER A CALL</button>
        </a>
    </div>
</section>
<footer class="row mx-0">
    <div class="footer-header col-12 col-lg-3 d-flex px-0">
        <img class="logo" src="images/navbar/logo.svg" alt="" draggable="false">
        <p id="footer-description">We are one of the leading interior design and remodeling studios available for all of
            your residential and
            commercial interior design needs.</p>
        <div class="social d-flex">
            <a href="#">
                <img src="images/social-media/twitter.svg" alt="" draggable="false">
            </a>
            <a href="#">
                <img src="images/social-media/linkedin.svg" alt="" draggable="false">
            </a>
            <a href="#">
                <img src="images/social-media/facebook.svg" alt="" draggable="false">
            </a>
        </div>
        <p class="license px-0 mb-0" id="license">© 2023 id Studio. All Rights Reserved.</p>
    </div>
    <div class="navigation-container col-sm-6 col-lg-2 px-0">
        <div class="navigation">
            <p id="navigation">NAVIGATION</p>
            <p class="navigation-link footer-navigation-link" id="about">About</p>
            <p class="navigation-link footer-navigation-link" id="services">Services</p>
            <p class="navigation-link footer-navigation-link" id="portfolio">Portfolio</p>
            <p class="navigation-link footer-navigation-link" id="pricing">Pricing</p>
            <p class="navigation-link footer-navigation-link" id="testimonials">Testimonials</p>
        </div>
        <div class="social d-flex">
            <a href="#">
                <img src="images/social-media/twitter.svg" alt="" draggable="false">
            </a>
            <a href="#">
                <img src="images/social-media/linkedin.svg" alt="" draggable="false">
            </a>
            <a href="#">
                <img src="images/social-media/facebook.svg" alt="" draggable="false">
            </a>
        </div>
    </div>
    <div class="contacts col-10 col-sm-6 col-lg-3">
        <p id="contacts">CONTACTS</p>
        <div class="address">
            <p id="address">ADDRESS</p>
            <p>3517 W. Gray St. Utica, Pensylvania 57867</p>
        </div>
        <div class="email">
            <p id="email">EMAIL</p>
            <p>michelle.rivera@idstudio.com</p>
        </div>
        <div class="phones">
            <p id="phones">PHONES</p>
            <p>(808) 555-0111 or (303) 555-0105</p>
        </div>
    </div>
    <p class="license px-0 mb-0" id="license">© 2023 id Studio. All Rights Reserved.</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
<script type="module" src="js/main-page/index.js"></script>
</body>

</html>