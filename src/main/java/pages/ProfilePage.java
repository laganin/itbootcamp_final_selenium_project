package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage extends BasicPage {
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement emailField() {
        return driver.findElement(By.id("email"));
    }

    public void waitUntilLoadDialogIsInvisible() {
        wait
                .withMessage("Please wait dialog is still on the page")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("v-dialog v-dialog--persistent")));
    }

    public WebElement nameField() {
        return driver.findElement(By.id("name"));
    }

    public WebElement cityField() {
        return driver.findElement(By.id("city"));
    }

    public WebElement countryField() {
        return driver.findElement(By.id("country"));
    }

    public WebElement urlTwitterField() {
        return driver.findElement(By.id("urlTwitter"));
    }

    public WebElement urlGitHubField() {
        return driver.findElement(By.id("urlGitHub"));
    }

    public WebElement phoneField() {
        return driver.findElement(By.id("phone"));
    }
}
