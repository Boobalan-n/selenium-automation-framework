# Web Automation Framework — Selenium WebDriver | TestNG | Java | POM

A reusable Selenium test automation framework built with the **Page Object Model (POM)**
for maintainable, scalable UI test suites.

## ✨ Features
- **Page Object Model** — page classes (`LoginPage`, `RegistrationPage`, `DashboardPage`) separate
  locators/actions from test logic, so a UI change only touches one file.
- **10 automated functional test cases** covering login (valid/invalid credentials, empty fields,
  locked-out user) and registration form validation (success, password mismatch, invalid email,
  empty required fields).
- **TestNG** for suite management, prioritized execution, parameters, and HTML reporting.
- **WebDriverManager** auto-downloads the correct ChromeDriver version — no manual setup.
- **ThreadLocal WebDriver** in `DriverManager` — safe for parallel execution.
- Built for easy Jira-style defect tracking: each failing assertion maps cleanly to one reported bug.

## 🗂️ Project Structure
```
selenium-automation-framework/
├── pom.xml
├── testng.xml
└── src
    ├── main/java
    │   ├── pages/        # Page Object classes (BasePage, LoginPage, RegistrationPage, DashboardPage)
    │   └── utils/         # DriverManager (WebDriver lifecycle)
    └── test/java
        ├── base/          # BaseTest (setup/teardown hooks)
        └── tests/         # LoginTest, RegistrationTest
```

## ▶️ How to Run
1. Install **Java 11+** and **Maven**.
2. Clone the repo:
   ```
   git clone https://github.com/Boobalan-n/selenium-automation-framework.git
   cd selenium-automation-framework
   ```
3. Run the suite:
   ```
   mvn clean test
   ```
4. TestNG HTML report is generated at `test-output/index.html`.

> The `baseUrl` parameters in `testng.xml` point to demo/sample sites — swap them for your own
> application under test.

## 🧰 Tech Stack
Java · Selenium WebDriver · TestNG · Maven · WebDriverManager · Page Object Model

## 📌 Why POM?
Locators live in one place per page. When the UI changes, you update the Page Object once —
every test that uses that page keeps working without touching test logic.
