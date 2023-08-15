import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import testData.*;
import util.ListenerClass;
import util.RetryAnalyser;
import util.SetUpTestDriver;

public class AssociateContactRegression
{

    private WebDriver driver;
    private PageFactory factory;
    private LoginPage loginPage;
    private AssociateContactPage associateContactPage;
    private AssociateContactData associateContactData;

    private ContactsPage contactsPage;

    private CompanyPage companyPage;

    private ExistingData existingData;

    private static final boolean enabled=true;


    @BeforeTest
    @Parameters({"os", "browser", "url"})
    public void setUp(String os, String browser, String url) {
        SetUpTestDriver setUpTestDriver = new SetUpTestDriver(driver, url, browser, os);
        driver = setUpTestDriver.getDriver();
        factory = new PageFactory(driver);
        this.loginPage = factory.getLoginPage();
        this.contactsPage=factory.getContactsPage();
        this.companyPage=factory.getCompanyPage();
        this.associateContactPage = factory.getAssociateContactPage();
        existingData=new ExistingData();
        associateContactData= new AssociateContactData();
        ListenerClass.driver = driver;

    }

    @Test(groups="Login",retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters({"username", "password", "loginUrl"})
    public void testLogin(String username, String password, String loginurl) {
        loginPage.loginToApplication(username, password, loginurl);
        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @Test(groups="Test Add Contact",dependsOnGroups = {"Login"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testAddExistingContact()
    {
        Assert.assertTrue(contactsPage.addContact(existingData,existingData.createExistingContactData));

    }

    @Test(groups="Test Add Company",dependsOnGroups = {"Login"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testAddExistingCompany()
    {
        Assert.assertTrue(companyPage.addCompany(existingData,existingData.createExistingCompanyData));

    }

    @Test(groups="Associate Existing Contact",dependsOnMethods = {"testAddExistingContact"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testAddExistingContactToOpportunity()
    {
        Assert.assertTrue(associateContactPage.addExistingContactToOpportunity());
    }

    @Test(groups="Associate New Contact",dependsOnMethods = {"testAddExistingCompany"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testAddNewContactToOpportunity()
    {
        Assert.assertTrue(associateContactPage.addNewContactToOpportunity(associateContactData, associateContactData.createNewContactData));
    }

    @Test(groups="Associate New Contact Negative",dependsOnMethods = {"testAddExistingCompany"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testAddNewContactToOpportunityNegative()
    {
        Assert.assertTrue(associateContactPage.addNewContactToOpportunityNegative(associateContactData, associateContactData.createNewContactNegativeTestData,associateContactData.createNewContactValidationMessages));
    }

    @Test(groups="Delete Contact",dependsOnMethods = {"testAddExistingCompany"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDeleteContactInOpportunity()
    {
        Assert.assertTrue(associateContactPage.validateDeleteContactOfOpportunity(associateContactData, associateContactData.createNewContactData));
    }
}