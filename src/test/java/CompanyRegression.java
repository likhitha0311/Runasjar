import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import testData.CompanyData;
import testData.ContactsData;
import testData.DocumentsData;
import testData.NotesData;
import util.ListenerClass;
import util.RetryAnalyser;
import util.SetUpTestDriver;

public class CompanyRegression

{

    private WebDriver driver;
    private PageFactory factory;
    private LoginPage loginPage;

    private ContactsPage contactsPage;

    private CompanyPage companyPage;

    private CompanyData companyData;
    
    private NotesData notesData;
    private DocumentsData documentsData;

    private CompanyDetailsPage companyDetailsPage;

    private static final boolean enabled=false;


    @BeforeTest
    @Parameters({"os", "browser", "url"})
    public void setUp(String os, String browser, String url) {
        SetUpTestDriver setUpTestDriver = new SetUpTestDriver(driver, url, browser, os);
        driver = setUpTestDriver.getDriver();
        factory = new PageFactory(driver);
        this.loginPage = factory.getLoginPage();
        this.companyPage=factory.getCompanyPage();
        companyData=new CompanyData();
        notesData=new NotesData();
        documentsData=new DocumentsData();
        companyDetailsPage= new CompanyDetailsPage(driver);
        ListenerClass.driver = driver;

    }

    @Test(groups="Login",retryAnalyzer = RetryAnalyser.class, enabled=true)
    @Parameters({"username", "password", "loginUrl"})
    public void testLogin(String username, String password, String loginurl) {
        loginPage.loginToApplication(username, password, loginurl);
        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @Test(groups="Test Add Company",dependsOnGroups = {"Login"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testAddCompany()
    {
        Assert.assertTrue(companyPage.addCompany(companyData,companyData.createCompanyData));

    }

    @Test(groups = {"Test Company Details"},dependsOnMethods = {"testAddCompany"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDetailsOfCompanyCreated()
    {
        Assert.assertTrue(companyDetailsPage.validateCompanyDetails(companyData.createCompanyData));

    }

    @Test(groups="Test Add Contact Inside Company",dependsOnMethods ={"testDetailsOfCompanyCreated"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testAddContactInsideCompany()
    {
        Assert.assertTrue(companyDetailsPage.addContactInsideCompany(companyData,companyData.createContactInsideCompanyData));

    }

    @Test(groups="Test Edit Contact Inside Company",dependsOnMethods ={"testAddContactInsideCompany"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testEditContactInsideCompany()
    {
        Assert.assertTrue(companyDetailsPage.editContactInsideCompany(companyData,companyData.editContactInsideCompanyData));

    }

    @Test(groups="Test Delete Contact Inside Company",dependsOnMethods ={"testEditContactInsideCompany"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDeleteContactInsideCompany()
    {
        Assert.assertTrue(companyDetailsPage.validateDeleteContact(companyData.editContactInsideCompanyData));

    }

    @Test(groups="Test Edit Company",dependsOnMethods = {"testDeleteContactInsideCompany"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testEditCompany()
    {

        Assert.assertTrue(companyDetailsPage.editCompany(companyData,companyData.editCompanyData,companyData.createCompanyData));


    }

    @Test(groups = {"Test Company Details"},dependsOnMethods = {"testEditCompany"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDetailsOfEditedCompany()
    {
        Assert.assertTrue(companyDetailsPage.validateCompanyDetails(companyData.editCompanyData));

    }

    @Test(groups = {"Test Delete Company"},dependsOnMethods = {"testDeleteContactInsideCompany","testDetailsOfEditedCompany"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDeleteCompany()
    {
        Assert.assertTrue(companyPage.validateDeleteCompany(companyData.editCompanyData));

    }

    @Test(groups="Test Add Company Negative",dependsOnMethods ={"testLogin"},retryAnalyzer = RetryAnalyser.class, enabled=enabled)
    @Parameters
    public void testAddCompanyNegative()
    {
        Assert.assertTrue(companyPage.addCompanyNegative(companyData,companyData.addCompanyNegativeTestData,companyData.addCompanyValidationMessages));

    }

    @Test(groups="Test Edit Company Negative",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testEditCompanyNegative()
    {
        Assert.assertTrue(companyDetailsPage.editCompanyNegative(companyData,companyData.editCompanyNegativeTestData,companyData.editCompanyValidationMessages));

    }

    @Test(groups="Test Add Notes",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testAddNotes()
    {
        Assert.assertTrue(companyDetailsPage.addCompanyNotes(notesData,notesData.generateDataForCreateNotes()));
    }

    @Test(groups="Test Edit Notes",dependsOnMethods = {"testAddNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testEditNotes()
    {
        Assert.assertTrue(companyDetailsPage.editCompanyNotes(notesData,notesData.generateDataForUpdateNotes()));
    }
    @Test(groups="Test Add Notes Negative",dependsOnMethods = {"testAddNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testAddNotesNegative()
    {
        Assert.assertTrue(companyDetailsPage.addCompanyNotesNegative(notesData,notesData.generateDataForCreateNotesNegativeTesting(),notesData.generateAddNotesValidationMessages()));
    }



    @Test(groups="Test Edit Notes Negative",dependsOnMethods = {"testEditNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testEditNotesNegative()
    {
        Assert.assertTrue(companyDetailsPage.editCompanyNotesNegative(notesData,notesData.generateDataForEditNotesNegativeTesting(),notesData.generateEditNotesValidationMessages()));
    }

    @Test(groups = {"Test Delete Notes"},dependsOnMethods = {"testAddNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDeleteNotes()
    {
        Assert.assertTrue(companyDetailsPage.validateDeleteCompanyNotes());

    }

    @Test(groups="Test Add Documents",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=true)
    public void testAddDocuments()
    {
        Assert.assertTrue(companyDetailsPage.addCompanyDocuments(documentsData,documentsData.generateDataForAddDocuments()));
    }

    @Test(groups="Test Edit Documents",dependsOnMethods = {"testAddDocuments"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testEditDocuments()
    {
        Assert.assertTrue(companyDetailsPage.editCompanyDocuments(documentsData,documentsData.generateDataForEditDocuments()));
    }

    @Test(groups="Test Delete Documents",dependsOnMethods = {"testEditDocuments"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testDeleteDocuments()
    {
        Assert.assertTrue(companyDetailsPage.deleteCompanyDocuments());
    }

    @Test(groups="Test Add Documents Negative",dependsOnMethods = {"testAddDocuments"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testAddDocumentsNegative()
    {
        Assert.assertTrue(companyDetailsPage.addCompanyDocumentsNegative(documentsData,documentsData.generateDataForAddDocumentsNegativeTesting(),documentsData.generateAddDocumentsValidationMessages()));
    }



}