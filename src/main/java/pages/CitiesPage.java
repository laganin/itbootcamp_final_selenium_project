package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CitiesPage extends BasicPage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement newItemButton() {
        return driver.findElement(By.className("btnNewItem"));
    }

    public void visibilityOfNewItemDialog() {
        wait
                .withMessage("New item dialog not visible")
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dlgNewEditItem"))));
    }

    public WebElement newItemNameInput() {
        return driver.findElement(By.id("name"));
    }

    public WebElement saveNewItemButton() {
        return driver.findElement(By.className("btnSave"));
    }
}
