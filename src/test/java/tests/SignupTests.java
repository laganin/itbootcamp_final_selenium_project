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

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserAlreadyExists() {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";
        navPage.signupButton().click();
        wait
                .withMessage("URL does not contain /signup")
                .until(ExpectedConditions.urlContains("/signup"));
        signupPage.populateNameInput(name);
        signupPage.populateEmailInput(email);
        signupPage.populatePasswordInput(password);
        signupPage.populateConfirmPasswordInput(confirmPassword);
        signupPage.signupButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(
                messagePopUpPage.popUpMessage().getText(),
                "E-mail already exists",
                "The error message does not contain e-mail already exists"
        );
        wait
                .withMessage("URL does not contain /signup")
                .until(ExpectedConditions.urlContains("/signup"));
    }
}
