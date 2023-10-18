package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/home");
        wait
                .withMessage("URL does not contain /login")
                .until(ExpectedConditions.urlContains("/login"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/profile");
        wait
                .withMessage("URL does not contain /login")
                .until(ExpectedConditions.urlContains("/login"));
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/admin/cities/");
        wait
                .withMessage("URL does not contain /login")
                .until(ExpectedConditions.urlContains("/login"));
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/admin/users");
        wait
                .withMessage("URL does not contain /login")
                .until(ExpectedConditions.urlContains("/login"));
    }
}
