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

public class ContactsRegression {
    private WebDriver driver;
    private PageFactory factory;
    private LoginPage loginPage;

    private ContactsPage contactsPage;

    private CompanyPage companyPage;

    private ContactsData contactsData;

    private CompanyData companyData;
    private ExistingData existingData;

    private CompanyDetailsPage companyDetailsPage;

    private ContactDetailsPage contactDetailsPage;

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
        this.contactsPage=factory.getContactsPage();
        this.companyPage=factory.getCompanyPage();
        contactsData=new ContactsData();
        companyData=new CompanyData();
        existingData=new ExistingData();
        companyDetailsPage= new CompanyDetailsPage(driver);
        contactDetailsPage=new ContactDetailsPage(driver);
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
    @Test(groups="Test Add Contact",dependsOnMethods = {"testAddExistingCompany"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testAddContact()
    {
        Assert.assertTrue(contactsPage.addContact(contactsData,contactsData.createContactData));

    }

    @Test(groups = {"Test Contact Details"},dependsOnMethods = {"testAddContact"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDetailsOfContactCreated()
    {
        Assert.assertTrue(contactDetailsPage.validateContactDetails(contactsData.createContactData));

    }

    @Test(groups="Test Edit Contact",dependsOnMethods = {"testDetailsOfContactCreated"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testEditContact()
    {
        Assert.assertTrue(contactDetailsPage.editContact(contactsData,contactsData.editContactData,contactsData.createContactData));


    }

    @Test(groups = {"Test Contact Details"},dependsOnMethods = {"testEditContact"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDetailsOfEditedContact()
    {
        Assert.assertTrue( contactDetailsPage.validateContactDetails(contactsData.editContactData));

    }

    @Test(groups="Test Add Notes",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testAddNotes()
    {
        Assert.assertTrue(contactDetailsPage.addContactNotes(notesData,notesData.generateDataForCreateNotes()));
    }

    @Test(groups="Test Edit Notes",dependsOnMethods = {"testAddNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testEditNotes()
    {
        Assert.assertTrue(contactDetailsPage.editContactNotes(notesData,notesData.generateDataForUpdateNotes()));
    }
    @Test(groups="Test Add Notes Negative",dependsOnMethods = {"testAddNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testAddNotesNegative()
    {
        Assert.assertTrue(contactDetailsPage.addContactNotesNegative(notesData,notesData.generateDataForCreateNotesNegativeTesting(),notesData.generateAddNotesValidationMessages()));
    }



    @Test(groups="Test Edit Notes Negative",dependsOnMethods = {"testEditNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testEditNotesNegative()
    {
        Assert.assertTrue(contactDetailsPage.editContactNotesNegative(notesData,notesData.generateDataForEditNotesNegativeTesting(),notesData.generateEditNotesValidationMessages()));
    }

    @Test(groups = {"Test Delete Notes"},dependsOnMethods = {"testAddNotes"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDeleteNotes()
    {
        Assert.assertTrue(contactDetailsPage.validateDeleteContactNotes());

    }

    @Test(groups="Test Add Documents",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testAddDocuments()
    {
        Assert.assertTrue(contactDetailsPage.addContactDocuments(documentsData,documentsData.generateDataForAddDocuments()));
    }

    @Test(groups="Test Edit Documents",dependsOnMethods = {"testAddDocuments"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testEditDocuments()
    {
        Assert.assertTrue(contactDetailsPage.editContactDocuments(documentsData,documentsData.generateDataForEditDocuments()));
    }

    @Test(groups="Test Delete Documents",dependsOnMethods = {"testAddDocuments"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testDeleteDocuments()
    {
        Assert.assertTrue(contactDetailsPage.deleteContactDocuments());
    }

    @Test(groups="Test Add Documents Negative",dependsOnMethods = {"testAddDocuments"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    public void testAddDocumentsNegative()
    {
        Assert.assertTrue(contactDetailsPage.addContactDocumentsNegative(documentsData,documentsData.generateDataForAddDocumentsNegativeTesting(),documentsData.generateAddDocumentsValidationMessages()));
    }
    @Test(groups="Test Add Contact Negative",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=true)
    @Parameters
    public void testAddContactNegative()
    {
        Assert.assertTrue(contactsPage.addContactNegative(contactsData,contactsData.addContactNegativeTestData,contactsData.addContactValidationMessages));

    }


    @Test(groups="Test Edit Contact Negative",dependsOnMethods = {"testLogin"},retryAnalyzer = RetryAnalyser.class,enabled=true)
    @Parameters
    public void testEditContactNegative()
    {
        Assert.assertTrue(contactDetailsPage.editContactNegative(contactsData,contactsData.editContactNegativeTestData,contactsData.editContactValidationMessages));

    }


    @Test(groups = {"Test Delete Contact"},dependsOnMethods = {"testDetailsOfEditedContact"},retryAnalyzer = RetryAnalyser.class,enabled=enabled)
    @Parameters
    public void testDeleteContact()
    {
        Assert.assertTrue(contactsPage.validateDeleteContact(contactsData.editContactData));

    }


}