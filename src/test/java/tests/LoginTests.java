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

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist() {
        String email = "non-existing-user@gmal.com";
        String password = "password123";
        navPage.loginLink().click();
        loginPage.emailInput().sendKeys(email);
        loginPage.passwordInput().sendKeys(password);
        loginPage.loginButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(
                messagePopUpPage.popUpMessage().getText(),
                "User does not exists",
                "The error message does not contain user does not exists"
        );
        wait
                .withMessage("URL does not contain /login")
                .until(ExpectedConditions.urlContains("/login"));
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenPasswordIsWrong() {
        String email = "admin@admin.com";
        String password = "password123";
        navPage.loginLink().click();
        loginPage.emailInput().sendKeys(email);
        loginPage.passwordInput().sendKeys(password);
        loginPage.loginButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(
                messagePopUpPage.popUpMessage().getText(),
                "Wrong password",
                "The error message does not contain wrong password"
        );
        wait
                .withMessage("URL does not contain /login")
                .until(ExpectedConditions.urlContains("/login"));
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void login() {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.loginLink().click();
        loginPage.emailInput().sendKeys(email);
        loginPage.passwordInput().sendKeys(password);
        loginPage.loginButton().click();
        wait
                .withMessage("URL does not contain /home")
                .until(ExpectedConditions.urlContains("/home"));
    }

    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void logout() {
        Assert.assertTrue(navPage.logoutLink().isDisplayed(), "Logout button not visible");
        navPage.logoutLink().click();
    }
}