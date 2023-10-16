package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage() {
        navPage.signupButton().click();
        wait
                .withMessage("URL does not contain /signup")
                .until(ExpectedConditions.urlContains("/signup"));
    }
}
