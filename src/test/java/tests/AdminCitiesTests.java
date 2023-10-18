package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities() {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.loginLink().click();
        loginPage.emailInput().sendKeys(email);
        loginPage.passwordInput().sendKeys(password);
        loginPage.loginButton().click();
        wait
                .withMessage("URL does not contain /home")
                .until(ExpectedConditions.urlContains("/home"));
        navPage.adminLink().click();
        navPage.adminCitiesLink().click();
        wait
                .withMessage("URL does not contain /admin/cities")
                .until(ExpectedConditions.urlContains("/admin/cities"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreateOrEditNewCity() {
        navPage.adminLink().click();
        navPage.adminCitiesLink().click();
        citiesPage.newItemButton().click();
        citiesPage.visibilityOfNewItemDialog();
        Assert.assertEquals(citiesPage.newItemNameInput().getAttribute("type"), "text");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createNewCity() {
        String city = "Novi Sad";
        navPage.adminLink().click();
        navPage.adminCitiesLink().click();
        citiesPage.newItemButton().click();
        citiesPage.visibilityOfNewItemDialog();
        citiesPage.newItemNameInput().sendKeys(city);
        citiesPage.saveNewItemButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertTrue(
                messagePopUpPage.popUpMessageCitiesPage().getText().contains("Saved successfully"),
                "The message does not contain saved successfully"
        );
    }
}
