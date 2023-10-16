package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
}
