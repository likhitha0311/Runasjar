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

public class OpportunityRegression
{

    private WebDriver driver;
    private PageFactory factory;
    private LoginPage loginPage;
    private OpportunityListPage opportunityListPage;
    private OpportunityData opportunityData;

    private OpportunityDetailsPage opportunityDetailsPage;

    private ExistingData existingData;

    private CompanyPage companyPage;

    private NotesData notesData;
    private DocumentsData documentsData;

    private static final boolean enabled=false;

    @BeforeTest
    @Parameters({"os", "browser", "url"})
    public void setUp(String os, String browser, String url) {
        SetUpTestDriver setUpTestDriver = new SetUpTestDriver(driver, url, browser, os);
        driver = setUpTestDriver.getDriver();
        factory = new PageFactory(driver);
        this.loginPage = factory.getLoginPage();
        this.companyPage=factory.getCompanyPage();
        this.opportunityListPage=factory.getOpportunityListPage();
        this.opportunityDetailsPage=factory.getOpportunityDetailsPage();
        opportunityData=new OpportunityData();
        existingData=new ExistingData();
        notesData=new NotesData();
        documentsData=new DocumentsData();
        ListenerClass.driver = driver;

    }

    @Test(groups="Login",retryAnalyzer = RetryAnalyser.class,enabled=true)
    @Parameters({"username", "password", "loginUrl"})
    public void testLogin(String username, String password, String loginurl) {
        loginPage.loginToApplication(username, password, loginurl);
        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @Test(groups="Test Add Company",dependsOnGroups = {"Login"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testAddExistingCompany()
    {
        Assert.assertTrue(companyPage.addCompany(existingData,existingData.createExistingCompanyData));

    }

    @Test(groups="Test Add Opportunity",dependsOnMethods = {"testAddExistingCompany"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testAddOpportunity()
    {
        Assert.assertTrue(opportunityListPage.addOpportunity(opportunityData,opportunityData.createOpportunityData));

    }

    @Test(groups = {"Test Opportunity Details"},dependsOnMethods = {"testAddOpportunity"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDetailsOfOpportunityCreated()
    {
        Assert.assertTrue( opportunityDetailsPage.validateOpportunityDetails(opportunityData.createOpportunityData));

    }

    @Test(groups="Test Add Opportunity Negative",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testAddOpportunityNegative()
    {
        Assert.assertTrue(opportunityListPage.addOpportunityNegative(opportunityData,opportunityData.addOpportunityNegativeTestData,opportunityData.addOpportunityValidationMessages));

    }

    @Test(groups="Test Edit Opportunity",dependsOnMethods = {"testAddOpportunity"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testEditOpportunity()
    {
        Assert.assertTrue(opportunityDetailsPage.editOpportunity(opportunityData,opportunityData.editOpportunityData, opportunityData.createOpportunityData));

    }

    @Test(groups="Test Edit Opportunity",dependsOnMethods = {"testAddOpportunity"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testEditOpportunityLocation()
    {
        Assert.assertTrue(opportunityDetailsPage.editOpportunityLocation(opportunityData,opportunityData.editOpportunityLocationData, opportunityData.createOpportunityData));

    }

    @Test(groups = {"Test Opportunity Details"},dependsOnMethods = {"testEditOpportunity"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDetailsOfEditedOpportunity()
    {
        Assert.assertTrue(opportunityDetailsPage.validateOpportunityDetails(opportunityData.editOpportunityData));

    }

    @Test(groups="Test Edit Opportunity Negative",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testEditOpportunityNegative()
    {
        Assert.assertTrue(opportunityDetailsPage.editOpportunityNegative(opportunityData,opportunityData.editOpportunityNegativeTestData,opportunityData.editOpportunityValidationMessages));

    }

    @Test(groups="Test Edit Opportunity Location Negative",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=true)
    @Parameters
    public void testEditOpportunityLocationNegative()
    {
        Assert.assertTrue(opportunityDetailsPage.editOpportunityLocationNegative(opportunityData,opportunityData.editOpportunityLocationNegativeTestData,opportunityData.editOpportunityLocationValidationMessages));

    }

    @Test(groups="Test Add Notes",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testAddNotes()
    {
        Assert.assertTrue(opportunityDetailsPage.addOpportunityNotes(notesData,notesData.generateDataForCreateNotes()));
    }

    @Test(groups="Test Edit Notes",dependsOnMethods = {"testAddNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testEditNotes()
    {
        Assert.assertTrue(opportunityDetailsPage.editOpportunityNotes(notesData,notesData.generateDataForUpdateNotes()));
    }
    @Test(groups="Test Add Notes Negative",dependsOnMethods = {"testAddNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testAddNotesNegative()
    {
        Assert.assertTrue(opportunityDetailsPage.addOpportunityNotesNegative(notesData,notesData.generateDataForCreateNotesNegativeTesting(),notesData.generateAddNotesValidationMessages()));
    }



    @Test(groups="Test Edit Notes Negative",dependsOnMethods = {"testEditNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testEditNotesNegative()
    {
        Assert.assertTrue(opportunityDetailsPage.editOpportunityNotesNegative(notesData,notesData.generateDataForEditNotesNegativeTesting(),notesData.generateEditNotesValidationMessages()));
    }

    @Test(groups = {"Test Delete Notes"},dependsOnMethods = {"testAddNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDeleteNotes()
    {
        Assert.assertTrue(opportunityDetailsPage.validateDeleteOpportunityNotes());

    }

    @Test(groups="Test Add Documents",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testAddDocuments()
    {
        Assert.assertTrue(opportunityDetailsPage.addOpportunityDocuments(documentsData,documentsData.generateDataForAddDocuments()));
    }

    @Test(groups="Test Edit Documents",dependsOnMethods = {"testAddDocuments"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testEditDocuments()
    {
        Assert.assertTrue(opportunityDetailsPage.editOpportunityDocuments(documentsData,documentsData.generateDataForEditDocuments()));
    }

    @Test(groups="Test Delete Documents",dependsOnMethods = {"testAddDocuments"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testDeleteDocuments()
    {
        Assert.assertTrue(opportunityDetailsPage.deleteOpportunityDocuments());
    }

    @Test(groups="Test Add Documents Negative",dependsOnMethods = {"testAddDocuments"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testAddDocumentsNegative()
    {
        Assert.assertTrue(opportunityDetailsPage.addOpportunityDocumentsNegative(documentsData,documentsData.generateDataForAddDocumentsNegativeTesting(),documentsData.generateAddDocumentsValidationMessages()));
    }
}