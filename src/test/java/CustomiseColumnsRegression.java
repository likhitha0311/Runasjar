import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import testData.CompanyData;
import testData.DocumentsData;
import testData.NotesData;
import util.ListenerClass;
import util.RetryAnalyser;
import util.SetUpTestDriver;

public class CustomiseColumnsRegression
{

    private WebDriver driver;
    private PageFactory factory;
    private LoginPage loginPage;

    private ContactsPage contactsPage;

    private OpportunityListPage opportunityListPage;

    private CustomiseColumnsPage customiseColumnsPage;

    private static final boolean enabled=true;


    @BeforeTest
    @Parameters({"os", "browser", "url"})
    public void setUp(String os, String browser, String url) {
        SetUpTestDriver setUpTestDriver = new SetUpTestDriver(driver, url, browser, os);
        driver = setUpTestDriver.getDriver();
        factory = new PageFactory(driver);
        this.loginPage = factory.getLoginPage();
        this.contactsPage=factory.getContactsPage();
        this.customiseColumnsPage =factory.getCustomiseColumnsPage();
        this.opportunityListPage=factory.getOpportunityListPage();
        ListenerClass.driver = driver;

    }

    @Test(groups="Login",retryAnalyzer = RetryAnalyser.class, enabled=true)
    @Parameters({"username", "password", "loginUrl"})
    public void testLogin(String username, String password, String loginurl) {
        loginPage.loginToApplication(username, password, loginurl);
        Assert.assertTrue(loginPage.isLoggedIn());
    }
    @Test(groups="Contact Customise Columns", dependsOnGroups = {"Login"},retryAnalyzer = RetryAnalyser.class, enabled=false)
    public void testContactCustomiseColumns()
    {
        Assert.assertTrue(customiseColumnsPage.verifyContactCustomiseColumns());
    }

    @Test(groups="Company Customise Columns", dependsOnGroups = {"Login"},retryAnalyzer = RetryAnalyser.class, enabled=false)
    public void testCompanyCustomiseColumns()
    {
        Assert.assertTrue(customiseColumnsPage.verifyCompanyCustomiseColumns());
    }

    @Test(groups="Company Customise Columns", dependsOnGroups = {"Login"},retryAnalyzer = RetryAnalyser.class, enabled=true)
    public void testOpportunityCustomiseColumns()
    {
        Assert.assertTrue(customiseColumnsPage.verifyOpportunityCustomiseColumns());
    }


}