package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheLoginPage() {
        navPage.languageSwitcherLink().click();
        navPage.englishLanguageLink().click();
        navPage.loginLink().click();
        wait
                .withMessage("URL does not contain /login")
                .until(ExpectedConditions.urlContains("/login"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        navPage.loginLink().click();
        Assert.assertEquals(loginPage.emailInput().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.passwordInput().getAttribute("type"), "password");
    }
}
