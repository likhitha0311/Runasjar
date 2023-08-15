package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testData.BaseData;
import util.PageHelper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyDetailsPage extends AbstractBasePage {

    private WebDriver driver;
    private AddressbookPage addressbookPage;

    private NotesPage notesPage;

    private DocumentsPage documentsPage;

    public CompanyDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.addressbookPage = new AddressbookPage(driver);
        PageFactory.initElements(driver, this);
        this.notesPage=new NotesPage(driver);
        this.documentsPage = new DocumentsPage(driver);
    }

    @FindBy(xpath = "//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;

    @FindBy(xpath = "//label[.='Company Name']/following-sibling::h5")
    private WebElement displayedCompanyName;
    @FindBy(xpath = "//label[.='Industry Type']/following-sibling::h5")
    private WebElement displayedIndustryType;
    @FindBy(xpath = "//label[.='Country']/following-sibling::h5")
    private WebElement displayedCompanyCountry;

    @FindBy(xpath = "//b[.='Company Details']/ancestor::mat-expansion-panel//mat-chip-list//mat-chip")
    private WebElement displayedCompanyTag;

    @FindBy(xpath = "//label[.='State']/following-sibling::h5")
    private WebElement displayedCompanyState;

    @FindBy(xpath = "//label[.='ZIP/Postal Code']/following-sibling::h5")
    private WebElement displayedCompanyZip;

    @FindBy(xpath = "//label[.='Address']/following-sibling::h5")
    private WebElement displayedCompanyAddress;

    @FindBy(xpath = "//label[.='City']/following-sibling::h5")
    private WebElement displayedCompanyCity;

    @FindBy(xpath = "//mat-expansion-panel//button[contains(.,'Edit')]")
    private WebElement editCompanyButton;

    @FindBy(xpath = "//app-company-details//input[@data-placeholder='Company Name']")
    private WebElement editCompanyName;

    @FindBy(xpath = "//app-company-details//input[@aria-owns='industry_type_options']")
    private WebElement editIndustryTypeField;

    @FindBy(xpath = "//span[@class='e-chips-close e-close-hooker']")
    private WebElement clearIndustryTypeField;

    @FindBy(xpath = "//app-company-details//input[@name='tel_no']")
    private WebElement editCompanyTelephone;
    @FindBy(xpath = "//app-company-details//input[@name='mobile_no1']")
    private WebElement editCompanyFax;

    @FindBy(xpath = "//app-company-details//input[@name='city']")
    private WebElement editCompanyCity;

    @FindBy(xpath = "//app-company-details//input[@name='email']")
    private WebElement editCompanyEmail;

    @FindBy(xpath = "//app-company-details//input[@name='website']")
    private WebElement editCompanyWebsite;
    @FindBy(xpath = "//app-company-details//input[@placeholder='Enter Tags']")
    private WebElement editCompanyTags;
    @FindBy(xpath = "//app-company-details//form//textarea[@name='address']")
    private WebElement editCompanyAddress;
    @FindBy(xpath = "//app-company-details//input[@name='zip']")
    private WebElement editCompanyZipCode;

    @FindBy(xpath = "//app-company-details//mat-select[@placeholder='Country']")
    private WebElement editCompanyCountry;

    @FindBy(xpath = "//app-company-details//input[@name='state']")
    private WebElement editCompanyState;

    @FindBy(xpath = "//form//button[.='Update']")
    private WebElement updateCompanyButton;

    @FindBy(xpath = "//mat-chip//mat-icon[.='cancel']")
    private WebElement cancelTags;

    @FindBy(xpath = "//app-company-details//button[.='Add Contact']")
    private WebElement addContactButtonInDetailsPage;

    @FindBy(xpath = "//h2[.='Update Company']")
    private WebElement updateCompanyForm;
    private String detailsPageTitle = ".studio | Company Details";

    @FindBy(xpath = " //app-no-records-found[@message='No Contacts Available']")
    private WebElement noContactsAvailable;


    @FindBy(xpath = "//app-create-contact//form//input[@name='name']")
    private WebElement contactNameInsideCompany;
    @FindBy(xpath = "//app-create-contact//form//input[@name='email']")
    private WebElement contactEmailInsideCompany;

    @FindBy(xpath = "//app-create-contact//form//input[@name='designation'] ")
    private WebElement contactDesignationInsideCompany;
    @FindBy(xpath = "//app-create-contact//form//input[@name='leadSource'] ")
    private WebElement contactLeadSourceInsideCompany;

    @FindBy(xpath = "//app-create-contact//form//input[@name='mobile_no1'] ")
    private WebElement contactMobileNoInsideCompany;
    @FindBy(xpath = "//app-create-contact//form//input[@name='tel_no1'] ")
    private WebElement contactTelephoneNoInsideCompany;
    @FindBy(xpath = "//app-create-contact//form//input[@name='linked_in_url'] ")
    private WebElement contactLinkedInUrlInsideCompany;
    @FindBy(xpath = "//app-create-contact//form//input[@placeholder='Tags'] ")
    private WebElement contactTagsInsideCompany;
    @FindBy(xpath = "//app-create-contact//form//button[@type='submit'] ")
    private WebElement addcontactButtonInsideCompany;

    @FindBy(xpath = "//app-create-contact//h2[.='Add Contact']")
    private WebElement addContactFormInsideCompany;


    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Company updated successfully']")
    private WebElement companyUpdateMessage;

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Contact added successfully']")
    private WebElement contactCreationMessage;

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Contact updated successfully']")
    private WebElement contactUpdateMessage;

    @FindBy(xpath = "//app-create-contact//h2[.='Edit Contact Details']")
    private WebElement   editContactFormInsideCompany;

    @FindBy(xpath = "//button[@name='action-menu-trigger']")
    private WebElement actionMenu;

    @FindBy(xpath = "//button[@name='action-menu-edit-trigger']/mat-icon[@data-mat-icon-name='inv-pen']")
    private WebElement editContactInActionMenu;

    @FindBy(xpath = "//button[@name='action-menu-delete-trigger']/mat-icon[@data-mat-icon-name='inv-trash-o']")
    private WebElement deleteContactInActionMenu;

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Contact deleted successfully']")
    private WebElement contactDeleteMessage;

    @FindBy(xpath = "//app-msg-dialog//button[.='Delete']")
    private WebElement deleteButtonInPopUp;

    @FindBy(xpath="//mat-icon[@svgicon='inv-filter']")
    private WebElement filter;

    @FindBy(id="filter-panel-clear-all")
    private WebElement clearAll;

    @FindBy(xpath="//tbody/tr[1]//b")
    private WebElement firstResult;

    @FindBy(xpath="//app-msg-dialog//button[.='cancel']")
    private WebElement cancelButtonInPopUp;

    @FindBy(xpath="//app-msg-dialog//button[.='Discard Changes']")
    private WebElement discardChangesButtonInPopUp;

    @FindBy(xpath = "//h2[.='Update Company']")
    private WebElement updateCompanyHeader;

    @FindBy(xpath="//app-create-company//mat-icon[@svgicon='inv-times-circle']")
    private WebElement closeButtonInForm;
    public boolean isCompanyDetailsPageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.titleIs(detailsPageTitle),
                    ExpectedConditions.elementToBeClickable(addContactButtonInDetailsPage),
                    ExpectedConditions.elementToBeClickable(editCompanyButton)));
            ExpectedConditions.invisibilityOf(loader);
         //   ExpectedConditions.elementToBeClickable(noContactsAvailable);
            return true;

        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }
    }

    private boolean isEditCompanyFormDisplayed() {
        return PageHelper.isElementDisplayed(driver, updateCompanyForm);
    }

    public <T extends BaseData> boolean editCompany(T obj, HashMap<String, String>[] editCompanyTestData, HashMap<String, String>[] createCompanyTestData) {
        boolean isCompanyEdited = false;
        try {
            obj.generateDataForUpdateCompany();
            for (int i = 0; i < editCompanyTestData.length; i++) {
                this.addressbookPage.clickAddressbook();
                Assert.assertTrue(this.addressbookPage.isDisplayed());
                searchValue(driver, this.addressbookPage.getCompaniesMenu(), createCompanyTestData[i].get("Company Name"));
                PageHelper.invisibilityOfElement(driver, loader);
                Thread.sleep(3000);
                Assert.assertTrue(isCompanyDetailsPageDisplayed());
                PageHelper.scrollToView(driver, editCompanyButton);
                PageHelper.javascriptClick(driver, editCompanyButton);
                PageHelper.invisibilityOfElement(driver, loader);
                Assert.assertTrue(isEditCompanyFormDisplayed());
                PageHelper.sendData(driver, editCompanyName, editCompanyTestData[i], "Company Name");
                PageHelper.sendData(driver, editCompanyCity, editCompanyTestData[i], "Company City");
                clearIndustryType();
                PageHelper.selectElementInDropdown(driver, editIndustryTypeField, editCompanyTestData[i].get("Company Industry Type"));
                PageHelper.selectElementInDropdown(driver, editCompanyCountry, editCompanyTestData[i].get("Company Country"));
                PageHelper.sendData(driver, editCompanyState, editCompanyTestData[i], "Company State");
                PageHelper.sendData(driver, editCompanyZipCode, editCompanyTestData[i], "Company Zip");
                PageHelper.sendData(driver, editCompanyAddress, editCompanyTestData[i], "Company Address");
                PageHelper.sendData(driver, editCompanyTelephone, editCompanyTestData[i], "Company Telephone");
                PageHelper.sendData(driver, editCompanyFax, editCompanyTestData[i], "Company Fax");
                PageHelper.sendData(driver, editCompanyEmail, editCompanyTestData[i], "Company Email");
                PageHelper.cancelTags(driver, cancelTags);
                PageHelper.sendData(driver, editCompanyTags, editCompanyTestData[i], "Company Tags");
                PageHelper.sendData(driver, editCompanyWebsite, editCompanyTestData[i], "Company Website");
                Assert.assertTrue(PageHelper.isButtonEnabled(driver, updateCompanyButton));
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, updateCompanyButton);
                PageHelper.invisibilityOfElement(driver, loader);
                boolean outcome = isCompanySuccessfullyUpdated();
                if (outcome) {
                    isCompanyEdited = true;
                } else {
                    isCompanyEdited = false;
                    break;
                }
            }
        } catch (Exception ae) {
            Assert.fail(String.valueOf(ae));
            return isCompanyEdited;
        }
        return isCompanyEdited;
    }

    public <T extends BaseData> boolean editCompanyNegative(T obj, HashMap<String, String>[] editCompanyTestData, HashMap<String, String>[] editCompanyValidationMessages) {
        boolean  isMessageDisplayed = false;
        try {
            obj.generateEditCompanyValidationMessages();
            obj.generateDataForEditCompanyNegativeTesting();
            getFirstCompany();
            for (int i = 0; i < editCompanyValidationMessages.length; i++) {
                PageHelper.scrollToView(driver, editCompanyButton);
                Thread.sleep(2000);
                PageHelper.javascriptClick(driver, editCompanyButton);
                PageHelper.invisibilityOfElement(driver, loader);
                Assert.assertTrue(isEditCompanyFormDisplayed());
                PageHelper.sendData(driver, editCompanyName, editCompanyTestData[i], "Company Name");
                PageHelper.sendData(driver, editCompanyCity, editCompanyTestData[i], "Company City");
                clearIndustryType();
                PageHelper.selectElementInDropdownForNegativeTesting(driver,editCompanyTestData[i],editIndustryTypeField,cancelButtonInPopUp,"Company Industry Type", editCompanyTestData[i].get("Company Industry Type"));
                PageHelper.sendData(driver, editCompanyState, editCompanyTestData[i], "Company State");
                PageHelper.sendData(driver, editCompanyZipCode, editCompanyTestData[i], "Company Zip");
                PageHelper.sendData(driver, editCompanyAddress, editCompanyTestData[i], "Company Address");
                PageHelper.sendData(driver, editCompanyTelephone, editCompanyTestData[i], "Company Telephone");
                PageHelper.sendData(driver, editCompanyFax, editCompanyTestData[i], "Company Fax");
                PageHelper.sendData(driver, editCompanyEmail, editCompanyTestData[i], "Company Email");
                PageHelper.cancelTags(driver, cancelTags);
                PageHelper.sendData(driver, editCompanyTags, editCompanyTestData[i], "Company Tags");
                PageHelper.sendData(driver, editCompanyWebsite, editCompanyTestData[i], "Company Website");
                updateCompanyHeader.click();
                Thread.sleep(2000);
                Assert.assertFalse(PageHelper.isButtonEnabled(driver, updateCompanyButton));
                Assert.assertTrue(validateErrors(editCompanyValidationMessages[i],getAllErrorMessages()));
                PageHelper.javascriptClick(driver,closeButtonInForm);
                PageHelper.javascriptClick(driver,discardChangesButtonInPopUp);
                isMessageDisplayed = true;
            }
        } catch (Exception ae) {
            Assert.fail(String.valueOf(ae));
      //      return  isMessageDisplayed;
        }
        return  isMessageDisplayed;
    }


    public boolean validateCompanyDetails(HashMap<String, String>[] companyData) {
        for (int i = 0; i < companyData.length; i++) {
            addressbookPage.clickAddressbook();
            searchValue(driver, addressbookPage.getCompaniesMenu(), companyData[i].get("Company Name"));
            Assert.assertTrue(PageHelper.isTitleDisplayed(driver, detailsPageTitle));
            for (String key : companyData[i].keySet()) {
                switch (key) {
                    case "Company Name": {
                        String company = PageHelper.getText(driver, displayedCompanyName);
                        if (company.equals(companyData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company Industry Type": {
                        String industryType = PageHelper.getText(driver, displayedIndustryType);
                        if (industryType.contains(companyData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company Country": {
                        String country = PageHelper.getText(driver, displayedCompanyCountry);
                        if (country.equals(companyData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company Tags": {
                        String companyTags = PageHelper.getText(driver, displayedCompanyTag);
                        if (companyTags.equals(companyData[i].get(key).toUpperCase())) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company Address": {
                        String companyAddress = PageHelper.getText(driver, displayedCompanyAddress);
                        System.out.println("Displayed address is " + companyAddress);
                        if (companyAddress.equals(companyData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company State": {
                        String companyState = PageHelper.getText(driver, displayedCompanyState);
                        System.out.println("Displayed companyState is " + companyState);
                        if (companyState.equals(companyData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company Zip": {
                        String companyZip = PageHelper.getText(driver, displayedCompanyZip);
                        System.out.println("Displayed companyZip  is " + companyZip);
                        if (companyZip.equals(companyData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    default:
                        System.out.println(companyData[i].get(key) + "is not added in the Test Data or is not displayed because it is  companyEmail/companyTelephone/companyFax)");

                }
            }
        }
        return true;
    }

    public boolean isCompanySuccessfullyUpdated() {
        return PageHelper.validateConfirmationMessage(driver, companyUpdateMessage);
    }


    public <T extends BaseData> boolean addContactInsideCompany(T obj, HashMap<String, String>[] contactTestData) {
        boolean isContactCreated = false;
        try {
            obj.generateDataForCreateContactInsideCompany();
            for (int i = 0; i < contactTestData.length; i++) {
                PageHelper.javascriptClick(driver, addContactButtonInDetailsPage);
                Assert.assertTrue(isAddNewContactFormDisplayed());
                PageHelper.sendData(driver, contactNameInsideCompany, contactTestData[i], "Contact Name");
                PageHelper.sendData(driver, contactEmailInsideCompany, contactTestData[i], "Contact Email");
                PageHelper.sendData(driver, contactDesignationInsideCompany, contactTestData[i], "Contact Designation");
                PageHelper.sendData(driver, contactLeadSourceInsideCompany, contactTestData[i], "Contact Lead Source");
                PageHelper.sendData(driver, contactLinkedInUrlInsideCompany, contactTestData[i], "Contact LinkedinUrl");
                PageHelper.sendData(driver, contactTelephoneNoInsideCompany, contactTestData[i], "Contact Telephone");
                PageHelper.sendData(driver, contactMobileNoInsideCompany, contactTestData[i], "Contact Mobile");
                PageHelper.sendData(driver, contactTagsInsideCompany, contactTestData[i], "Contact Tags");
                contactTagsInsideCompany.sendKeys(Keys.ENTER);
                Assert.assertTrue(PageHelper.isButtonEnabled(driver, addcontactButtonInsideCompany));
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, addcontactButtonInsideCompany);
                PageHelper.invisibilityOfElement(driver, loader);
                boolean outcome = isContactSuccessfullyCreated();
                if (outcome) {
                    isContactCreated = true;

                } else {
                    isContactCreated = false;
                    break;
                }

            }


        } catch (Exception e) {
        }
        return isContactCreated;
    }


    public <T extends BaseData> boolean editContactInsideCompany(T obj, HashMap<String, String>[]  editContactTestData) {
        boolean isContactUpdated = false;
        try {
            obj.generateDataForEditContactInsideCompany();
            for (int i = 0; i <  editContactTestData.length; i++) {
                PageHelper.javascriptClick(driver, actionMenu);
                PageHelper.javascriptClick(driver,editContactInActionMenu);
                Assert.assertTrue(isEditContactFormDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.sendData(driver, contactNameInsideCompany, editContactTestData[i], "Contact Name");
                PageHelper.sendData(driver, contactEmailInsideCompany, editContactTestData[i], "Contact Email");
                PageHelper.sendData(driver, contactDesignationInsideCompany, editContactTestData[i], "Contact Designation");
                PageHelper.sendData(driver, contactLeadSourceInsideCompany, editContactTestData[i], "Contact Lead Source");
                PageHelper.sendData(driver, contactLinkedInUrlInsideCompany, editContactTestData[i], "Contact LinkedinUrl");
                PageHelper.sendData(driver, contactTelephoneNoInsideCompany, editContactTestData[i], "Contact Telephone");
                PageHelper.sendData(driver, contactMobileNoInsideCompany, editContactTestData[i], "Contact Mobile");
                PageHelper.cancelTags(driver, cancelTags);
                PageHelper.sendData(driver, contactTagsInsideCompany, editContactTestData[i], "Contact Tags");
                contactTagsInsideCompany.sendKeys(Keys.ENTER);
                Assert.assertTrue(PageHelper.isButtonEnabled(driver, addcontactButtonInsideCompany));
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, addcontactButtonInsideCompany);
                PageHelper.invisibilityOfElement(driver, loader);
                boolean outcome = isContactSuccessfullyUpdated();
                if (outcome) {
                    isContactUpdated = true;

                } else {
                    isContactUpdated = false;
                    break;
                }

            }


        } catch (Exception e) {
        }
        return isContactUpdated;
    }



    public boolean isAddNewContactFormDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(addContactFormInsideCompany),
                    ExpectedConditions.elementToBeClickable(contactEmailInsideCompany),
                    ExpectedConditions.elementToBeClickable(contactNameInsideCompany),
                    ExpectedConditions.elementToBeClickable(contactLeadSourceInsideCompany)));
            return true;
        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }
    }

    public boolean isEditContactFormDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(editContactFormInsideCompany),
                    ExpectedConditions.elementToBeClickable(contactEmailInsideCompany),
                    ExpectedConditions.elementToBeClickable(contactNameInsideCompany),
                    ExpectedConditions.elementToBeClickable(contactLeadSourceInsideCompany)));
            return true;
        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }
    }

    public boolean isContactSuccessfullyCreated() {
        return PageHelper.validateConfirmationMessage(driver, contactCreationMessage);
    }

    public boolean isContactSuccessfullyUpdated() {
        return PageHelper.validateConfirmationMessage(driver, contactUpdateMessage);
    }

    public boolean validateDeleteContact(HashMap<String, String>[] editContactTestData) {
        boolean flag = false;
        for (int i = 0; i < editContactTestData.length; i++)
        {
            System.out.println("This contact is being deleted " + editContactTestData[i].get("Contact Email"));
            deleteContact(driver);
            boolean outcome = isContactSuccessfullyDeleted();
            if (outcome) {
                flag = true;

            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void deleteContact(WebDriver driver) {
try {
    PageHelper.invisibilityOfElement(driver, loader);
    PageHelper.javascriptClick(driver, actionMenu);
    PageHelper.javascriptClick(driver, deleteContactInActionMenu);
    PageHelper.javascriptClick(driver, deleteButtonInPopUp);
    PageHelper.invisibilityOfElement(driver, loader);
}
catch(Exception e)
{
    e.printStackTrace();
    Assert.fail(String.valueOf(e));
}

    }

    public boolean isContactSuccessfullyDeleted() {
        return PageHelper.validateConfirmationMessage(driver, contactDeleteMessage);}

        public boolean validateErrors(HashMap<String, String> companyValidationMessage, ArrayList<String> capturedMessages) {
            boolean isErrorPresent = false;
            for (Map.Entry<String, String> entry : companyValidationMessage.entrySet())
            {
                String value = entry.getValue();
                if (capturedMessages.contains(value)) {
                    isErrorPresent = true;
                } else {
                    isErrorPresent = false;
                    break;
                }
            }
            return isErrorPresent;
        }

        public ArrayList<String> getAllErrorMessages() {
            List<WebElement> errorMessages = driver.findElements(By.xpath("//mat-error[@role='alert']"));
            ArrayList<String> message = new ArrayList<>();
            for (WebElement e : errorMessages) {
                message.add(e.getText());
            }
            System.out.println(message);
            return message;

        }


        public void clearIndustryType()
        {
            List<WebElement>chips=driver.findElements(By.xpath("//span[@class='e-chips']"));
            for(WebElement e:chips)
            {
                e.findElement(By.xpath("//span[@class='e-chips-close']")).click();
            }
        }

    public <T extends BaseData>boolean addCompanyNotes(T obj, HashMap<String, String>[] notesTestData)
    {
        getFirstCompany();
        return  notesPage.addNotes(obj,notesTestData);
    }

    public <T extends BaseData>boolean addCompanyNotesNegative(T obj, HashMap<String, String>[] notesTestData,HashMap<String, String>[] notesValidationMessages)
    {
        getFirstCompany();
        return  notesPage.addNotesNegative(obj,notesTestData,notesValidationMessages);
    }

    public <T extends BaseData>boolean editCompanyNotesNegative(T obj, HashMap<String, String>[] notesTestData,HashMap<String, String>[] notesValidationMessages)
    {
        getFirstCompany();
        return  notesPage.editNotesNegative(obj,notesTestData,notesValidationMessages);
    }

    public void getFirstCompany()
    {
            this.addressbookPage.clickAddressbook();
            Assert.assertTrue(this.addressbookPage.isDisplayed());
            PageHelper.invisibilityOfElement(driver, loader);
            PageHelper.javascriptClick(driver, this.addressbookPage.getCompaniesMenu());
            clearFiltersAndSearch(driver, filter, clearAll);
            PageHelper.javascriptClick(driver, firstResult);
            Assert.assertTrue(isCompanyDetailsPageDisplayed());
            PageHelper.invisibilityOfElement(driver, loader);
    }

    public <T extends BaseData>boolean editCompanyNotes(T obj, HashMap<String, String>[] notesTestData)
    {

            getFirstCompany();
            return notesPage.editNotes(obj, notesTestData);

    }


    public boolean validateDeleteCompanyNotes()
    {
        getFirstCompany();
        return notesPage.validateDeleteNotes();
    }

    public <T extends BaseData>boolean addCompanyDocuments(T obj, HashMap<String, String>[] documentsTestData)

    {
        getFirstCompany();
        return  documentsPage.addDocuments(obj,documentsTestData);
    }

    public <T extends BaseData>boolean addCompanyDocumentsNegative(T obj, HashMap<String, String>[] documentsTestData,HashMap<String, String>[] documentsValidationMessages)
    {
        getFirstCompany();
        return  documentsPage.addDocumentsNegative(obj,documentsTestData,documentsValidationMessages);
    }

    public <T extends BaseData>boolean editCompanyDocuments(T obj, HashMap<String, String>[] documentsTestData)
    {
        getFirstCompany();
        return  documentsPage.editDocuments(obj,documentsTestData);
    }

    public boolean deleteCompanyDocuments()
    {
        getFirstCompany();
        return documentsPage.validateDeleteDocument();
    }

}