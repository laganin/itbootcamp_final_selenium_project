package tests;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected NavPage navPage;
    protected LoginPage loginPage;
    protected MessagePopUpPage messagePopUpPage;
    protected SignupPage signupPage;
    protected CitiesPage citiesPage;
    protected LandingPage landingPage;
    protected ProfilePage profilePage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navPage = new NavPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        messagePopUpPage = new MessagePopUpPage(driver, wait);
        signupPage = new SignupPage(driver, wait);
        citiesPage = new CitiesPage(driver, wait);
        landingPage = new LandingPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(baseUrl);
    }


    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
            String strDate = dateFormat.format(date);

            File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(f1, new File("screenshots/screenshot_" + result.getName() + strDate + ".jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
