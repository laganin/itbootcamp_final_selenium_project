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

    public WebElement languageSwitcherLink() {
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement englishLanguageLink() {
        return driver.findElement(By.className("btnEN"));
    }
}
