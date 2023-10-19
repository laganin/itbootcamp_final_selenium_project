# Selenium Test Automation Project - My Awesome App

This repository contains a Java project for automating tests using Selenium WebDriver,
Maven, and TestNG to test the web application [My Awesome App](https://vue-demo.daniel-avellaneda.com/).<br />
Project follows the Page Object Model (POM) design pattern, providing a structured and maintainable
framework for automating UI tests.<br /> The tests are categorized into the following sections:

- [**Login Tests:**](test_cases/TS_LOGIN_PAGE.md) Verify user login functionality
- [**Signup Tests:**](test_cases/TS_SIGN_UP_PAGE.md) Verify signup functionality
- [**Admin Cities Tests:**](test_cases/TS_ADMIN_CITIES_PAGE.md) Test edit and delete functionality for table with cities
- [**Auth Routes Tests:**](test_cases/TS_AUTH_ROUTES.md) Test route protection for unauthenticated user 
- [**Locale Tests:**](test_cases/TS_LOCALE.md) Test page content in different languages
- [**Profile Tests:**](test_cases/TS_PROFILE_PAGE.md) Test profile page form and functionality for editing a profile

## Prerequisites

Before running the tests, ensure you have the following dependencies installed:

- Java Development Kit (JDK)
- Maven
- TestNG
- Chrome WebDriver


## Page Objects

Page objects are located in the `src/main/java/pages` directory. You can extend or modify them to accommodate changes in the application.