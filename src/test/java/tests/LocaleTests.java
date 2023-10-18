package tests;

import helpers.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEs() {
        navPage.languageSwitcherLink().click();
        navPage.spanishLanguageLink().click();
        Assert.assertEquals(
                landingPage.header().getText(),
                "Página de aterrizaje",
                "Text Página de aterrizaje not present in header."
        );
    }
}
