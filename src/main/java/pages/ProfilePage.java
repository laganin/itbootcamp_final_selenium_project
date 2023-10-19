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
}
