package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    public void enterName(String name) {
        new Actions(driver)
                .click(nameField())
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(name)
                .perform();
    }

    public WebElement cityField() {
        return driver.findElement(By.id("city"));
    }

    public void enterCity(String city) {
        new Actions(driver)
                .click(cityField())
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(city)
                .perform();
    }

    public WebElement countryField() {
        return driver.findElement(By.id("country"));
    }

    public void enterCounty(String country) {
        new Actions(driver)
                .click(countryField())
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(country)
                .perform();
    }

    public WebElement urlTwitterField() {
        return driver.findElement(By.id("urlTwitter"));
    }

    public void enterTwitter(String twitter) {
        new Actions(driver)
                .click(urlTwitterField())
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(twitter)
                .perform();
    }

    public WebElement urlGitHubField() {
        return driver.findElement(By.id("urlGitHub"));
    }

    public void enterGit(String git) {
        new Actions(driver)
                .click(urlGitHubField())
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(git)
                .perform();
    }

    public WebElement phoneField() {
        return driver.findElement(By.id("phone"));
    }

    public void enterPhone(String phone) {
        new Actions(driver)
                .click(phoneField())
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(phone)
                .perform();
    }

    public WebElement saveButton() {
        return driver.findElement(By.className("btnSave"));
    }
}
