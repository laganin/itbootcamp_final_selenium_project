package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage() {
        navPage.signupButton().click();
        wait
                .withMessage("URL does not contain /signup")
                .until(ExpectedConditions.urlContains("/signup"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        navPage.signupButton().click();
        Assert.assertEquals(signupPage.nameInput().getAttribute("type"), "text");
        Assert.assertEquals(signupPage.emailInput().getAttribute("type"), "email");
        Assert.assertEquals(signupPage.passwordInput().getAttribute("type"), "password");
        Assert.assertEquals(signupPage.confirmPasswordInput().getAttribute("type"), "password");
    }
}
