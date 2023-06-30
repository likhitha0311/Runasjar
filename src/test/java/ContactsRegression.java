import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PageFactory;
import util.ListenerClass;
import util.RetryAnalyser;
import util.SetUpTestDriver;

public class ContactsRegression {
    private WebDriver driver;
    private PageFactory factory;
    private LoginPage loginPage;


    @BeforeTest
    @Parameters({"os", "browser", "url"})
    public void setUp(String os, String browser, String url) {
        SetUpTestDriver setUpTestDriver = new SetUpTestDriver(driver, url, browser, os);

        driver = setUpTestDriver.getDriver();

        factory = new PageFactory(driver);
        this.loginPage = factory.getLoginPage();
        ListenerClass.driver = driver;

    }

    @Test(retryAnalyzer = RetryAnalyser.class)
    @Parameters({"username", "password", "loginurl"})
    public void testLogin(String username, String password, String loginurl) {
        loginPage.loginToApplication(username, password, loginurl);
    }

}
