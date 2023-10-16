package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForPopUpToBeVisible() {
        wait
                .withMessage("Pop up not visible")
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("v-snack--active"))));
    }

    public void waitForVerifyYourAccountDialogToBeVisible() {
        wait
                .withMessage("Verify your account dialog not visible")
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("v-dialog__content--active"))));
    }

    public WebElement verifyYourAccountDialogHeadline() {
        return driver.findElement(By.className("dlgVerifyAccount"));
    }

    public WebElement closeVerifyAccountDialogButton() {
        return driver.findElement(By.className("btnClose"));
    }

    public WebElement popUpMessage() {
        return driver.findElement(By.cssSelector("div.v-snack__content li"));
    }

    public WebElement closeButton() {
        return driver.findElement(By.cssSelector("div.v-snack__content button"));
    }
}
