package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationBar {
    private final WebDriverWait wait;

    public NavigationBar(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openLeave() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[normalize-space()='Leave']"))).click();
    }
}
