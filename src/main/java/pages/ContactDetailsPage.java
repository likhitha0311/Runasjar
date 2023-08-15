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

public class ContactDetailsPage extends AbstractBasePage {

    private WebDriver driver;
    private AddressbookPage addressbookPage;
    private NotesPage notesPage;

    private DocumentsPage documentsPage;

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.addressbookPage = new AddressbookPage(driver);
        this.notesPage = new NotesPage(driver);
        this.documentsPage = new DocumentsPage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[.='Contact Name']/following-sibling::h5")
    private WebElement displayedContactName;

    @FindBy(xpath = "//label[.='Designation']/following-sibling::h5")
    private WebElement displayedDesignation;

    @FindBy(xpath = "//label[.='Lead Source']/following-sibling::h5")
    private WebElement displayedLeadSource;

    @FindBy(xpath = "//label[.='Email']/following-sibling::h5")
    private WebElement displayedContactEmail;

    @FindBy(xpath = "//label[.='Mobile Number']/following-sibling::h5")
    private WebElement displayedContactMobileNumber;

    @FindBy(xpath = "//label[.='Telephone']/following-sibling::h5")
    private WebElement displayedContactTelephone;
    @FindBy(xpath = "//label[.='Company Name']/following-sibling::h5")
    private WebElement displayedContactCompany;
    @FindBy(xpath = "//label[.='Industry Type']/following-sibling::h5")
    private WebElement displayedIndustryType;
    @FindBy(xpath = "//label[.='Country']/following-sibling::h5")
    private WebElement displayedCompanyCountry;

    @FindBy(xpath = "//b[.='Contact Details']/ancestor::mat-expansion-panel//mat-chip-list//mat-chip")
    private WebElement displayedContactTag;

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
    private WebElement editContactButton;

    @FindBy(xpath = "//h2[.='Edit Contact Details']")
    private WebElement editContactDetails;

    @FindBy(xpath = "//form//button[.='Update']")
    private WebElement updateContactButton;

    @FindBy(xpath = " //mat-chip//mat-icon[.='cancel']")
    private WebElement cancelTags;

    @FindBy(xpath = "//div[contains(@class,'medium-scrollbar')]")
    private WebElement scrollbar;
    private String detailsPageTitle = ".studio | Contact Details";

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Contact updated successfully']")
    private WebElement contactUpdateMessage;

    @FindBy(xpath = "//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement editContactName;
    @FindBy(xpath = "//app-edit-contact//form//input[@type='email']")
    private WebElement editContactEmail;
    @FindBy(xpath = " //app-edit-contact//form//input[@name='company']")
    private WebElement editCompanyOfContact;
    @FindBy(xpath="//button[.='New Note']")
    private WebElement newNoteButton;
    @FindBy(xpath = "//app-edit-contact//form//input[@name='designation']")
    private WebElement editContactDesignation;

    @FindBy(xpath = "//app-edit-contact//form//input[@name='leadSource']")
    private WebElement editContactLeadSource;

    @FindBy(xpath = "//app-edit-contact//form//input[@name='linked_in_url']")
    private WebElement editContactLinkedinUrl;

    @FindBy(xpath = "//app-edit-contact//form//input[@name='mobile_no1']")
    private WebElement editContactMobileNo;

    @FindBy(xpath = "//app-edit-contact//form//input[@name='tel_no1']")
    private WebElement editContactTelephoneNo;

    @FindBy(xpath = "//app-edit-contact//form//input[@placeholder='Tags']")
    private WebElement editContactTags;
    @FindBy(xpath = "//app-edit-contact//form//button[.='Next']")
    private WebElement nextButtonInsideEditContactForm;

    @FindBy(xpath = " //app-new-company//form//input[@aria-owns='industry_type_options']")
    private WebElement editIndustryType;

    @FindBy(xpath = "//app-new-company//form//mat-select[@placeholder='Country']")
    private WebElement editCountry;

    @FindBy(xpath = "//app-new-company//form//input[@name='state']")
    private WebElement editState;

    @FindBy(xpath = "//app-new-company//form//input[@name='city']")
    private WebElement editCity;

    @FindBy(xpath = "//app-new-company//form//input[@name='zip']")
    private WebElement editZipcode;

    @FindBy(xpath = "//app-new-company//form//textarea[@name='address']")
    private WebElement editAddress;

    @FindBy(xpath = "//app-new-company//form//input[@name='tel_no']")
    private WebElement editCompanyTelephone;

    @FindBy(xpath = "//app-new-company//form//input[@data-placeholder='Fax Number']")
    private WebElement editCompanyFax;


    @FindBy(xpath = "//app-new-company//form//input[@name='email']")
    private WebElement editCompanyEmail;
    @FindBy(xpath = "//app-new-company//form//input[@name='website']")
    private WebElement editCompanyWebsite;

    @FindBy(xpath = "//app-new-company//form//input[@placeholder='Enter Tags']")
    private WebElement editCompanyTags;

    @FindBy(xpath = "//app-new-company//form//button[contains(.,'Create')]")
    private WebElement createButtonInsideEditContactForm;

    @FindBy(xpath = "//app-msg-dialog//button[.='Discard Changes']")
    private WebElement discardChangesButtonInPopUp;

    @FindBy(xpath = "//app-msg-dialog//button[.='cancel']")
    private WebElement cancelButtonInPopUp;

    @FindBy(xpath = "//app-edit-contact//mat-icon[@svgicon='inv-times-circle']")
    private WebElement closeButtonInForm;

    @FindBy(xpath = "//mat-icon[@svgicon='inv-filter']")
    private WebElement filter;

    @FindBy(id = "filter-panel-clear-all")
    private WebElement clearAll;

    @FindBy(xpath = "//tbody/tr[1]//b")
    private WebElement firstResult;

    @FindBy(xpath = "//h2[.='Add New Company']")
    private WebElement addNewCompanyHeaderInForm;

    @FindBy(xpath = "//h2[.='Edit Contact Details']")
    private WebElement editContactDetailsHeader;

    public <T extends BaseData> boolean editContact(T obj, HashMap<String, String>[] editContactTestData, HashMap<String, String>[] createContactTestData) {
        boolean isContactEdited = false;
        try {
            obj.generateDataForUpdateContact();
            for (int i = 0; i < editContactTestData.length; i++) {
                this.addressbookPage.clickAddressbook();
                Assert.assertTrue(this.addressbookPage.isDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                searchValue(driver, addressbookPage.getContactsMenu(), createContactTestData[i].get("Contact Email"));
                Assert.assertTrue(PageHelper.isTitleDisplayed(driver, detailsPageTitle));
                PageHelper.scrollToView(driver, editContactButton);
                PageHelper.javascriptClick(driver, editContactButton);
                Assert.assertTrue(isEditContactFormDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.sendData(driver, editContactName, editContactTestData[i], "Contact Name");
                PageHelper.sendData(driver, editContactEmail, editContactTestData[i], "Contact Email");
                PageHelper.sendData(driver, editContactDesignation, editContactTestData[i], "Contact Designation");
                PageHelper.sendData(driver, editContactLeadSource, editContactTestData[i], "Contact Lead Source");
                PageHelper.sendData(driver, editContactLinkedinUrl, editContactTestData[i], "Contact LinkedinUrl");
                PageHelper.sendData(driver, editContactTelephoneNo, editContactTestData[i], "Contact Telephone");
                PageHelper.sendData(driver, editContactMobileNo, editContactTestData[i], "Contact Mobile");
                PageHelper.cancelTags(driver, cancelTags);
                PageHelper.sendData(driver, editContactTags, editContactTestData[i], "Contact Tags");
                editContactTags.sendKeys(Keys.ENTER);
                PageHelper.clearText(driver, editCompanyOfContact);
                Thread.sleep(2000);
                editContactDetailsHeader.click();
                if (editContactTestData[i].get("Company Type").equals("Existing")) {
                    PageHelper.sendData(driver, editCompanyOfContact, editContactTestData[i], "Company");
                    PageHelper.javascriptClick(driver, updateContactButton);
                    PageHelper.invisibilityOfElement(driver, loader);
                }
                if (editContactTestData[i].get("Company Type").equals("Without Company")) {
                    PageHelper.javascriptClick(driver, updateContactButton);
                    PageHelper.invisibilityOfElement(driver, loader);
                } else if (editContactTestData[i].get("Company Type").equals("New Company")) {
                    PageHelper.sendData(driver, editCompanyOfContact, editContactTestData[i], "Company");
                    Assert.assertTrue(PageHelper.isButtonEnabled(driver, nextButtonInsideEditContactForm));
                    PageHelper.javascriptClick(driver, nextButtonInsideEditContactForm);
                    PageHelper.invisibilityOfElement(driver, loader);
                    PageHelper.selectElementInDropdown(driver, editIndustryType, editContactTestData[i].get("Company Industry Type"));
                    PageHelper.selectElementInDropdown(driver, editCountry, editContactTestData[i].get("Company Country"));
                    PageHelper.sendData(driver, editCity, editContactTestData[i], "Company City");
                    PageHelper.sendData(driver, editState, editContactTestData[i], "Company State");
                    PageHelper.sendData(driver, editZipcode, editContactTestData[i], "Company Zip");
                    PageHelper.sendData(driver, editAddress, editContactTestData[i], "Company Address");
                    PageHelper.sendData(driver, editCompanyTelephone, editContactTestData[i], "Company Telephone");
                    PageHelper.sendData(driver, editCompanyFax, editContactTestData[i], "Company Fax");
                    PageHelper.sendData(driver, editCompanyEmail, editContactTestData[i], "Company Email");
                    PageHelper.sendData(driver, editCompanyTags, editContactTestData[i], "Company Tags");
                    PageHelper.sendData(driver, editCompanyWebsite, editContactTestData[i], "Company Website");
                    Assert.assertTrue(PageHelper.isButtonEnabled(driver, createButtonInsideEditContactForm));
                    PageHelper.invisibilityOfElement(driver, loader);
                    PageHelper.javascriptClick(driver, createButtonInsideEditContactForm);
                    PageHelper.invisibilityOfElement(driver, loader);
                }
                boolean outcome = isContactSuccessfullyUpdated();
                if (outcome) {
                    isContactEdited = true;

                } else {
                    isContactEdited = false;
                    break;
                }
            }

        } catch (Exception ae) {
            Assert.fail(String.valueOf(ae));
            return isContactEdited;
        }
        return isContactEdited;
    }

    public <T extends BaseData> boolean editContactNegative(T obj, HashMap<String, String>[] editContactTestData, HashMap<String, String>[] contactValidationMessages) {
        boolean isMessageDisplayed = false;
        try {
            obj.generateEditContactValidationMessages();
            obj.generateDataForEditContactNegativeTesting();
            getFirstContact();
            PageHelper.scrollToView(driver, editContactButton);
            Thread.sleep(2000);
            for (int i = 0; i < contactValidationMessages.length; i++) {
                //isMessageDisplayed = false;
                System.out.println("Iteration is " + i);
                PageHelper.javascriptClick(driver,editContactButton);
                Assert.assertTrue(isEditContactFormDisplayed());
                PageHelper.sendData(driver, editContactName, editContactTestData[i], "Contact Name");
                PageHelper.clearText(driver, editCompanyOfContact);
                PageHelper.sendData(driver, editContactEmail, editContactTestData[i], "Contact Email");
                PageHelper.sendData(driver, editContactDesignation, editContactTestData[i], "Contact Designation");
                PageHelper.sendData(driver, editContactLeadSource, editContactTestData[i], "Contact Lead Source");
                PageHelper.sendData(driver, editContactLinkedinUrl, editContactTestData[i], "Contact LinkedinUrl");
                PageHelper.sendData(driver, editContactTelephoneNo, editContactTestData[i], "Contact Telephone");
                PageHelper.sendData(driver, editContactMobileNo, editContactTestData[i], "Contact Mobile");
                PageHelper.cancelTags(driver, cancelTags);
                PageHelper.sendData(driver, editContactTags, editContactTestData[i], "Contact Tags");
                editContactTags.sendKeys(Keys.ENTER);
                editContactDetailsHeader.click();
                if (editContactTestData[i].get("Company Type").equals("Without Company")) {
                    if (PageHelper.isButtonEnabled(driver, updateContactButton)) {
                        Assert.assertTrue(getAllErrorMessages().size() == 0);
                        PageHelper.javascriptClick(driver, updateContactButton);
                        PageHelper.invisibilityOfElement(driver, loader);
                    } else {
                        Assert.assertTrue(validateErrors(contactValidationMessages[i], getAllErrorMessages()));
                        PageHelper.javascriptClick(driver, closeButtonInForm);
                        PageHelper.javascriptClick(driver, discardChangesButtonInPopUp);
                        isMessageDisplayed = true;

                    }

                } else if (editContactTestData[i].get("Company Type").equals("Existing")) {
                    if (PageHelper.isButtonEnabled(driver, updateContactButton)) {
                        Assert.assertTrue(getAllErrorMessages().size() == 0);
                        PageHelper.javascriptClick(driver, updateContactButton);
                        PageHelper.invisibilityOfElement(driver, loader);
                    } else {
                        Assert.assertTrue(validateErrors(contactValidationMessages[i], getAllErrorMessages()));
                        PageHelper.javascriptClick(driver, closeButtonInForm);
                        PageHelper.javascriptClick(driver, discardChangesButtonInPopUp);
                        isMessageDisplayed = true;

                    }


                } else if (editContactTestData[i].get("Company Type").equals("New Company")) {
                    PageHelper.sendData(driver, editCompanyOfContact, editContactTestData[i], "Company");
                    if (PageHelper.isButtonEnabled(driver, nextButtonInsideEditContactForm)) {
                        Assert.assertTrue(getAllErrorMessages().size() == 0);
                        PageHelper.javascriptClick(driver, nextButtonInsideEditContactForm);
                        PageHelper.invisibilityOfElement(driver, loader);
                        PageHelper.selectElementInDropdownForNegativeTesting(driver, editContactTestData[i], editIndustryType, cancelButtonInPopUp, "Company Industry Type", editContactTestData[i].get("Company Industry Type"));
                        PageHelper.selectElementInDropdownForNegativeTesting(driver, editContactTestData[i], editCountry, cancelButtonInPopUp, "Company Country", editContactTestData[i].get("Company Country"));
                        PageHelper.sendData(driver, editCity, editContactTestData[i], "Company City");
                        PageHelper.sendData(driver, editState, editContactTestData[i], "Company State");
                        PageHelper.sendData(driver, editZipcode, editContactTestData[i], "Company Zip");
                        PageHelper.sendData(driver, editAddress, editContactTestData[i], "Company Address");
                        PageHelper.sendData(driver, editCompanyTelephone, editContactTestData[i], "Company Telephone");
                        PageHelper.sendData(driver, editCompanyFax, editContactTestData[i], "Company Fax");
                        PageHelper.sendData(driver, editCompanyEmail, editContactTestData[i], "Company Email");
                        PageHelper.sendData(driver, editCompanyTags, editContactTestData[i], "Company Tags");
                        PageHelper.sendData(driver, editCompanyWebsite, editContactTestData[i], "Company Website");
                        addNewCompanyHeaderInForm.click();
                        if (PageHelper.isButtonEnabled(driver, createButtonInsideEditContactForm)) {
                            Assert.assertTrue(getAllErrorMessages().size() == 0);
                            PageHelper.javascriptClick(driver, createButtonInsideEditContactForm);
                            PageHelper.invisibilityOfElement(driver, loader);
                        } else {
                            Assert.assertTrue(validateErrors(contactValidationMessages[i], getAllErrorMessages()));
                            PageHelper.javascriptClick(driver, closeButtonInForm);
                            PageHelper.javascriptClick(driver, discardChangesButtonInPopUp);
                            isMessageDisplayed = true;
                            //break;
                        }

                    } else {
                        Assert.assertTrue(validateErrors(contactValidationMessages[i], getAllErrorMessages()));
                        PageHelper.javascriptClick(driver, closeButtonInForm);
                        PageHelper.javascriptClick(driver, discardChangesButtonInPopUp);
                        isMessageDisplayed = true;
                        //break;
                    }

                }
                Thread.sleep(1000);


            }

 } catch (Exception ae) {
//            PageHelper.javascriptClick(driver, closeButtonInForm);
//            PageHelper.javascriptClick(driver, discardChangesButtonInPopUp);
            Assert.fail(String.valueOf(ae));
            return isMessageDisplayed;
        }
        return isMessageDisplayed;

    }

    public boolean isContactSuccessfullyUpdated() {
        return PageHelper.validateConfirmationMessage(driver, contactUpdateMessage);
    }

    public boolean isEditContactFormDisplayed() {
        return PageHelper.isElementDisplayed(driver, editContactDetails);
    }

    public boolean validateContactDetails(HashMap<String, String>[] contactData) {
        for (int i = 0; i < contactData.length; i++) {
            addressbookPage.clickAddressbook();
            searchValue(driver, addressbookPage.getContactsMenu(), contactData[i].get("Contact Email"));
            Assert.assertTrue(PageHelper.isTitleDisplayed(driver, detailsPageTitle));
            for (String key : contactData[i].keySet()) {
                switch (key) {
                    case "Contact Name": {
                        String name = PageHelper.getText(driver, displayedContactName);
                        if (name.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Contact Designation": {
                        String designation = PageHelper.getText(driver, displayedDesignation);
                        if (designation.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Contact Lead Source": {
                        String leadSource = PageHelper.getText(driver, displayedLeadSource);
                        if (leadSource.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Contact Email": {
                        String email = PageHelper.getText(driver, displayedContactEmail);
                        if (email.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Contact Telephone": {
                        String phone = PageHelper.getText(driver, displayedContactTelephone);
                        if (phone.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Contact Mobile": {
                        String mobile = PageHelper.getText(driver, displayedContactMobileNumber);
                        if (mobile.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Contact Tags": {
                        String contactTags = PageHelper.getText(driver, displayedContactTag);
                        if (contactTags.equals(contactData[i].get(key).toUpperCase())) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company": {
                        String company = PageHelper.getText(driver, displayedContactCompany);
                        if (company.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company Industry Type": {
                        String industryType = PageHelper.getText(driver, displayedIndustryType);
                        if (industryType.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company Country": {
                        String country = PageHelper.getText(driver, displayedCompanyCountry);
                        if (country.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company Tags": {
                        String companyTags = PageHelper.getText(driver, displayedCompanyTag);
                        if (companyTags.equals(contactData[i].get(key).toUpperCase())) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company Address": {
                        String companyAddress = PageHelper.getText(driver, displayedCompanyAddress);
                        System.out.println("Displayed address is " + companyAddress);
                        if (companyAddress.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company State": {
                        String companyState = PageHelper.getText(driver, displayedCompanyState);
                        System.out.println("Displayed companyState is " + companyState);
                        if (companyState.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company Zip": {
                        String companyZip = PageHelper.getText(driver, displayedCompanyZip);
                        System.out.println("Displayed companyZip  is " + companyZip);
                        if (companyZip.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Company City": {
                        String companyCity = PageHelper.getText(driver, displayedCompanyCity);
                        System.out.println("Displayed companyCity  is " + companyCity);
                        if (companyCity.equals(contactData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + companyCity);
                        break;
                    }
                    default:
                        System.out.println(contactData[i].get(key) + "is not added in the Test Data or is not displayed because it is  companyEmail/companyTelephone/companyFax)");

                }
            }
        }
        return true;
    }

    public boolean validateErrors(HashMap<String, String> contactValidationMessage, ArrayList<String> capturedMessages) {
        boolean isErrorPresent = false;
        for (Map.Entry<String, String> entry : contactValidationMessage.entrySet()) {
            System.out.println("Values from hashmap " + entry.getValue());
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

    public <T extends BaseData> boolean addContactNotes(T obj, HashMap<String, String>[] notesTestData) {
        getFirstContact();
        return notesPage.addNotes(obj, notesTestData);
    }

    public <T extends BaseData> boolean addContactNotesNegative(T obj, HashMap<String, String>[] notesTestData, HashMap<String, String>[] notesValidationMessages) {
        getFirstContact();
        return notesPage.addNotesNegative(obj, notesTestData, notesValidationMessages);
    }

    public <T extends BaseData> boolean editContactNotesNegative(T obj, HashMap<String, String>[] notesTestData, HashMap<String, String>[] notesValidationMessages) {
        getFirstContact();
        return notesPage.editNotesNegative(obj, notesTestData, notesValidationMessages);
    }


    public <T extends BaseData> boolean editContactNotes(T obj, HashMap<String, String>[] notesTestData)
    {

            getFirstContact();
            return notesPage.editNotes(obj, notesTestData);

    }


    public boolean validateDeleteContactNotes()
    {   getFirstContact();
        return notesPage.validateDeleteNotes();
    }

    public <T extends BaseData> boolean addContactDocuments(T obj, HashMap<String, String>[] documentsTestData)
    {
        getFirstContact();
        return documentsPage.addDocuments(obj, documentsTestData);
    }

    public <T extends BaseData> boolean addContactDocumentsNegative(T obj, HashMap<String, String>[] documentsTestData, HashMap<String, String>[] documentsValidationMessages) {
        getFirstContact();
        return documentsPage.addDocumentsNegative(obj, documentsTestData, documentsValidationMessages);
    }

    public <T extends BaseData> boolean editContactDocuments(T obj, HashMap<String, String>[] documentsTestData)
    {
        getFirstContact();
        return documentsPage.editDocuments(obj, documentsTestData);
    }

    public boolean deleteContactDocuments()
    {
        getFirstContact();
        return documentsPage.validateDeleteDocument();
    }

    public void getFirstContact() {

            this.addressbookPage.clickAddressbook();
            Assert.assertTrue(this.addressbookPage.isDisplayed());
            PageHelper.invisibilityOfElement(driver, loader);
            clearFiltersAndSearch(driver, filter, clearAll);
            PageHelper.javascriptClick(driver,firstResult);;
            Assert.assertTrue(isContactDetailsPageDisplayed());
            PageHelper.invisibilityOfElement(driver, loader);

    }

    public boolean isContactDetailsPageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.titleIs(detailsPageTitle),
                    ExpectedConditions.elementToBeClickable(editContactButton),
                    ExpectedConditions.elementToBeClickable(newNoteButton)));
            ExpectedConditions.invisibilityOf(loader);
            return true;

        } catch (TimeoutException te) {
            //Assert.fail(String.valueOf(te));
            te.printStackTrace();
            return false;
        }
    }

}