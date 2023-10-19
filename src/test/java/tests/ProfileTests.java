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
                profilePage.emailField().getAttribute("value"), email,
                "Email field attribute value is not " + email
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

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void editsProfile() {
        String email = "admin@admin.com";
        String password = "12345";
        String name = "Milan Jovanovic";
        String phone = "+38161283223";
        String city = "Bucaramanga";
        String country = "Spain";
        String twitter = "https://twitter.com/profile/milan1232";
        String github = "https://github.com/";
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
        profilePage.enterName(name);
        profilePage.enterPhone(phone);
        profilePage.enterCity(city);
        profilePage.enterCounty(country);
        profilePage.enterTwitter(twitter);
        profilePage.enterGit(github);
        profilePage.saveButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        System.out.println(messagePopUpPage.popUpMessageCitiesAndProfilePage().getText());
        Assert.assertTrue(
                messagePopUpPage.popUpMessageCitiesAndProfilePage().getText().contains("Profile saved successfuly"),
                "The message does not contain profile saved successfuly "
        );
        Assert.assertEquals(
                profilePage.emailField().getAttribute("value"), email,
                "Email field attribute value is not " + email
        );
        Assert.assertEquals(
                profilePage.nameField().getAttribute("value"), name,
                "Name field attribute value is not " + name
        );
        Assert.assertEquals(
                profilePage.phoneField().getAttribute("value"), phone,
                "Phone field attribute value is not " + phone
        );
        Assert.assertEquals(
                profilePage.cityField().getAttribute("value"), city,
                "City field attribute value is not " + city
        );
        Assert.assertEquals(
                profilePage.countryField().getAttribute("value"), country,
                "County field attribute value is not " + country
        );
        Assert.assertEquals(
                profilePage.urlTwitterField().getAttribute("value"), twitter,
                "Twitter URL field attribute value is not " + twitter
        );
        Assert.assertEquals(
                profilePage.urlGitHubField().getAttribute("value"), github,
                "GitHub URL field attribute value is not " + github
        );
        navPage.logoutLink().click();
    }
}
