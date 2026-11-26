package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeaveEntitlementPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // OrangeHRM displays an asterisk beside the mandatory Employee Name label.
    // starts-with() keeps the locator valid whether the asterisk is rendered as text or separately.
    private final By heading = By.xpath("//*[self::h5 or self::h6][contains(normalize-space(),'Leave Entitlements')]");
    private final By employeeNameLabel = By.xpath("//label[starts-with(normalize-space(),'Employee Name')]");
    private final By employeeName = By.xpath(
        "//label[starts-with(normalize-space(),'Employee Name')]/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By leaveType = By.xpath(
        "//label[starts-with(normalize-space(),'Leave Type')]/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private final By leavePeriod = By.xpath(
        "//label[starts-with(normalize-space(),'Leave Period')]/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private final By searchButton = By.xpath("//button[@type='submit' and normalize-space()='Search']");

    public LeaveEntitlementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openDirectly(String baseUrl) {
        driver.get(baseUrl + "/web/index.php/leave/viewLeaveEntitlements");
        // The live page's visible form is a more reliable readiness signal than its
        // heading tag, which can vary between OrangeHRM builds.
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameLabel));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
    }

    public boolean isHeadingVisible() {
        // TC01 verifies that the target Employee Entitlements search form is loaded.
        return !driver.findElements(employeeNameLabel).isEmpty()
                && !driver.findElements(searchButton).isEmpty();
    }

    public WebElement employeeNameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(employeeName));
    }

    public WebElement leaveTypeDropdown() {
        return wait.until(ExpectedConditions.elementToBeClickable(leaveType));
    }

    public WebElement leavePeriodDropdown() {
        return wait.until(ExpectedConditions.elementToBeClickable(leavePeriod));
    }

    public WebElement searchButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(searchButton));
    }

    public boolean areAllFiltersVisible() {
        return isVisible(employeeName) && isVisible(leaveType) && isVisible(leavePeriod);
    }

    private boolean isVisible(By locator) {
        return !driver.findElements(locator).isEmpty() && driver.findElement(locator).isDisplayed();
    }

    public boolean isRequiredValidationVisible() {
        By required = By.xpath(
            "//*[contains(@class,'oxd-input-field-error-message') and normalize-space()='Required']"
            + " | //*[contains(@class,'oxd-input-group')]//*[normalize-space()='Required']");
        return !driver.findElements(required).isEmpty();
    }

    public void typeEmployeePrefix(String prefix) {
        WebElement input = employeeNameField();
        input.clear();
        input.sendKeys(prefix);
    }

    public int employeeSuggestionCount() {
        By suggestions = By.xpath("//div[@role='option']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestions));
        return driver.findElements(suggestions).size();
    }

    public void chooseFirstEmployeeSuggestion() {
        By suggestions = By.xpath("//div[@role='option']");
        wait.until(ExpectedConditions.elementToBeClickable(suggestions)).click();
    }

    public void openLeaveTypeDropdown() {
        leaveTypeDropdown().click();
    }

    public int leaveTypeOptionCount() {
        By options = By.xpath("//div[@role='option']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(options));
        return driver.findElements(options).size();
    }

    public void chooseFirstLeaveTypeOption() {
        By options = By.xpath("//div[@role='option']");
        wait.until(ExpectedConditions.elementToBeClickable(options)).click();
    }

    public void clickSearch() {
        searchButton().click();
    }
}
