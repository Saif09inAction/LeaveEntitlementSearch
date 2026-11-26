package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public void loginAsAdmin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("Admin");
        driver.findElement(password).sendKeys("admin123");
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']")),
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'oxd-userdropdown-name')]"))
        ));
    }
}
