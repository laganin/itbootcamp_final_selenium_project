package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void enterCityName(String cityName) {
        new Actions(driver)
                .click(newItemNameInput())
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(cityName)
                .perform();
    }

    public WebElement saveNewItemButton() {
        return driver.findElement(By.className("btnSave"));
    }

    public WebElement searchInput() {
        return driver.findElement(By.cssSelector("input#search"));
    }

    public void visibilityOfTableRows(int expectedTableRows) {
        wait
                .withMessage(expectedTableRows + " rows are not visible.")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody tr"), expectedTableRows));
    }

    public WebElement editButtonFromRow(int row) {
        return driver.findElements(By.cssSelector("tbody tr #edit")).get(row - 1);
    }

    public WebElement tableCellFromRow(int row, int cell) {
        return driver.findElements(By.cssSelector("tbody td")).get(cell - 4 + row * 4 - 1);
    }
}
