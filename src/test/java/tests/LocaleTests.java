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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEn() {
        navPage.languageSwitcherLink().click();
        navPage.englishLanguageLink().click();
        Assert.assertEquals(
                landingPage.header().getText(),
                "Landing",
                "Text Landing not present in header."
        );
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToCn() {
        navPage.languageSwitcherLink().click();
        navPage.chineseLanguageLink().click();
        Assert.assertEquals(
                landingPage.header().getText(),
                "首页",
                "Text 首页 not present in header."
        );
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToFr() {
        navPage.languageSwitcherLink().click();
        navPage.frenchLanguageLink().click();
        Assert.assertEquals(
                landingPage.header().getText(),
                "Page d'atterrissage",
                "Text Page d'atterrissage not present in header."
        );
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToUa() {
        navPage.languageSwitcherLink().click();
        navPage.ukrainianLanguageLink().click();
        Assert.assertEquals(
                landingPage.header().getText(),
                "Лендінг",
                "Text Лендінг not present in header."
        );
    }
}
