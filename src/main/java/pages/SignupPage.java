package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage {
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement nameInput() {
        return driver.findElement(By.id("name"));
    }

    public WebElement emailInput() {
        return driver.findElement(By.id("email"));
    }

    public WebElement passwordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement confirmPasswordInput() {
        return driver.findElement(By.id("confirmPassword"));
    }
}
