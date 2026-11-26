package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    protected static final String BASE_URL = "https://opensource-demo.orangehrmlive.com";

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(BASE_URL + "/web/index.php/auth/login");
        new LoginPage(driver).loginAsAdmin();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
