package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement loginLink() {
        return driver.findElement(By.cssSelector("div.v-toolbar__items a[href='/login']"));
    }

    public WebElement logoutLink() {
        return driver.findElement(By.className("btnLogout"));
    }

    public WebElement signupButton() {
        return driver.findElement(By.cssSelector("div.v-toolbar__items a[href='/signup']"));
    }

    public WebElement adminLink() {
        return driver.findElement(By.className("btnAdmin"));
    }

    public WebElement adminCitiesLink() {
        return driver.findElement(By.className("btnAdminCities"));
    }

    public WebElement languageSwitcherLink() {
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement englishLanguageLink() {
        return driver.findElement(By.className("btnEN"));
    }

    public WebElement spanishLanguageLink() {
        return driver.findElement(By.className("btnES"));
    }

    public WebElement chineseLanguageLink() {
        return driver.findElement(By.className("btnCN"));
    }

    public WebElement frenchLanguageLink() {
        return driver.findElement(By.className("btnFR"));
    }

    public WebElement ukrainianLanguageLink() {
        return driver.findElement(By.className("btnUA"));
    }
}
