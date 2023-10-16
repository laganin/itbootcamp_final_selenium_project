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

    public void populateNameInput(String name) {
        nameInput().clear();
        nameInput().sendKeys(name);
    }

    public WebElement emailInput() {
        return driver.findElement(By.id("email"));
    }

    public void populateEmailInput(String email) {
        emailInput().clear();
        emailInput().sendKeys(email);
    }

    public WebElement passwordInput() {
        return driver.findElement(By.id("password"));
    }

    public void populatePasswordInput(String password) {
        passwordInput().clear();
        passwordInput().sendKeys(password);
    }

    public WebElement confirmPasswordInput() {
        return driver.findElement(By.id("confirmPassword"));
    }

    public void populateConfirmPasswordInput(String password) {
        confirmPasswordInput().clear();
        confirmPasswordInput().sendKeys(password);
    }

    public WebElement signupButton() {
        return driver.findElement(By.cssSelector("button.secondary"));
    }
}
