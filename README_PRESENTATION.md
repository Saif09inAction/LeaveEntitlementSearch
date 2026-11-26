# Problem Statement 14: Leave Entitlement Search

## Project overview
This project automates the Employee Entitlements search screen in the OrangeHRM demo application using Java, Selenium WebDriver, TestNG, Maven and the Page Object Model (POM).

## Screen under test
URL after login: `/web/index.php/leave/viewLeaveEntitlements`

The supplied application screenshot shows:
- Employee Name (mandatory autocomplete field)
- Leave Type (dropdown)
- Leave Period (dropdown)
- Search button

## Framework structure
- `base/BaseTest.java`: starts the browser, signs in, and closes the browser after each test.
- `utils/DriverFactory.java`: creates and quits ChromeDriver.
- `pages/LoginPage.java`: handles the OrangeHRM login form.
- `pages/LeaveEntitlementPage.java`: locators and actions for the Employee Entitlements screen.
- `pages/NavigationBar.java`: reusable Leave navigation method.
- `pages/EntitlementFilterPage.java` and `EntitlementResultPage.java`: page-object placeholders retained for the assignment structure.
- `tests/LeaveEntitlementTest.java`: TestNG test cases.
- `testng.xml`: TestNG suite configuration.

## Test cases
1. TC01: Verify the Employee Entitlements page opens.
2. TC02: Verify Employee Name, Leave Type and Leave Period filters are visible.
3. TC03: Verify Employee Name is mandatory.
4. TC04: Verify employee autocomplete suggestions appear after entering a prefix.
5. TC05: Verify Leave Type dropdown options are displayed.

## Execution
Open the folder as a Maven project in IntelliJ IDEA, allow Maven to download dependencies, then run `testng.xml`.

Chrome must be installed. Selenium Manager attempts to manage the matching ChromeDriver automatically.

## Honest execution note
The source has been updated to wait for the actual search form instead of relying on a heading tag that was not found in the supplied run log. Employee Name matching also tolerates the mandatory asterisk shown in the screenshot. The public demo is dynamic, so execute the suite once in the presentation environment and report only the pass count shown by TestNG.

## Short presentation script
“Good morning. My problem statement is Leave Entitlement Search. The objective is to automate the Employee Entitlements screen in OrangeHRM and verify that its search controls behave correctly. I used Java, Selenium WebDriver, TestNG and Maven. The framework follows Page Object Model: page locators and actions are separated from test cases. The BaseTest class handles browser setup and login, while DriverFactory manages ChromeDriver. I designed five tests: opening the page, checking the filters, checking mandatory Employee Name validation, checking employee autocomplete, and checking Leave Type dropdown options. TestNG executes the tests and reports pass or fail. This reduces repetitive manual checking and makes the search screen easier to regression-test. Thank you.”
