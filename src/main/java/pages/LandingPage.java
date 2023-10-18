package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasicPage {
    public LandingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement header() {
        return driver.findElement(By.tagName("h1"));
    }
}
