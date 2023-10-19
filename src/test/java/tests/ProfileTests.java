package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheProfilePage() {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.loginLink().click();
        loginPage.emailInput().sendKeys(email);
        loginPage.passwordInput().sendKeys(password);
        loginPage.loginButton().click();
        wait
                .withMessage("URL does not contain /home")
                .until(ExpectedConditions.urlContains("/home"));
        navPage.myProfileLink().click();
        wait
                .withMessage("URL does not contain /profile")
                .until(ExpectedConditions.urlContains("/profile"));
        profilePage.waitUntilLoadDialogIsInvisible();
        Assert.assertEquals(
                profilePage.emailField().getAttribute("value"), email, "Email field attribute value is not " + email
        );
        navPage.logoutLink().click();
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.loginLink().click();
        loginPage.emailInput().sendKeys(email);
        loginPage.passwordInput().sendKeys(password);
        loginPage.loginButton().click();
        wait
                .withMessage("URL does not contain /home")
                .until(ExpectedConditions.urlContains("/home"));
        navPage.myProfileLink().click();
        wait
                .withMessage("URL does not contain /profile")
                .until(ExpectedConditions.urlContains("/profile"));
        profilePage.waitUntilLoadDialogIsInvisible();
        Assert.assertEquals(
                profilePage.emailField().getAttribute("type"), "email",
                "Email field attribute type is not email");
        Assert.assertTrue(
                Boolean.parseBoolean(profilePage.emailField().getAttribute("disabled")),
                "Email field attribute disabled is not disabled");
        Assert.assertEquals(
                profilePage.nameField().getAttribute("type"), "text",
                "Name field attribute type is not text");
        Assert.assertEquals(
                profilePage.cityField().getAttribute("type"), "text",
                "City field attribute type is not text");
        Assert.assertEquals(
                profilePage.countryField().getAttribute("type"), "text",
                "Country field attribute type is not text");
        Assert.assertEquals(
                profilePage.urlTwitterField().getAttribute("type"), "url",
                "Twitter URL field attribute type is not URL");
        Assert.assertEquals(
                profilePage.urlGitHubField().getAttribute("type"), "url",
                "GitHub URL field attribute type is not URL");
        Assert.assertEquals(
                profilePage.phoneField().getAttribute("type"), "tel",
                "Phone field attribute type is not URL");
        navPage.logoutLink().click();
    }
}
