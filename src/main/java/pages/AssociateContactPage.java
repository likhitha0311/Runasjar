package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testData.BaseData;
import util.PageHelper;
import util.PropertyFileWriter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssociateContactPage extends AbstractBasePage {
    private WebDriver driver;
    private AddressbookPage addressbookPage;
    private OpportunityListPage opportunityListPage;

    private OpportunityDetailsPage opportunityDetailsPage;

    private ContactsPage contactsPage;

    @FindBy(id = "contactPanelassociateContactTrigger")
    private WebElement associateContactButton;
    @FindBy(xpath = "//app-create-edit-contact-vendor//h2[.='Associate Contact']")
    private WebElement associateContactHeader;
    @FindBy(xpath = "//app-create-edit-contact-vendor//input[@name='search']")
    private WebElement searchField;
    @FindBy(xpath = "//app-create-edit-contact-vendor//mat-checkbox//input[@type='checkbox']")
    private WebElement firstContact;
    @FindBy(xpath = "//app-create-edit-contact-vendor//button[.='Add']")
    private WebElement addRoleButton;

    @FindBy(xpath = "//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;

    @FindBy(xpath = "//mat-select[@placeholder='Role']")
    private WebElement roleDropdown;

    @FindBy(xpath = "//app-create-edit-contact-vendor//h2[.='Company Role']")
    private WebElement companyRoleHeader;

    @FindBy(id = "associateContactCreateNew")
    private WebElement createNewContactButton;

    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@name='contactName']")
    private WebElement contactName;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@name='email']")
    private WebElement contactEmail;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@name='company_name']")
    private WebElement companyOfContact;


    @FindBy(xpath = "//app-create-edit-contact-vendor//h2//span[contains(.,'Add New Contact')]")
    private WebElement contactDetailsHeaderInForm;

    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@ name='designation']")
    private WebElement contactDesignation;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@ name='leadSource']")
    private WebElement contactLeadSource;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@ name='linked_in_url']")
    private WebElement contactLinkedinUrl;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@ name='mobile_no1']")
    private WebElement contactMobileNo;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@name='tel_no1']")
    private WebElement contactTelephoneNo;

    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@placeholder='Enter Tags']")
    private WebElement contactTags;
    @FindBy(xpath = "//app-create-edit-contact-vendor//form//button[.='Next']")
    private WebElement nextButton;

    @FindBy(xpath = "//app-create-edit-contact-vendor//mat-select[@name='industry_type_codes']")
    private WebElement industryType;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//mat-select[@placeholder='Country']")
    private WebElement country;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@name='state']")
    private WebElement state;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@name='city']")
    private WebElement city;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@name='zip']")
    private WebElement zipcode;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//textarea[@name='address']")
    private WebElement address;


    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@name='website']")
    private WebElement companyWebsite;

    @FindBy(xpath = "//app-create-edit-contact-vendor//form//input[@placeholder='Enter Tags']")
    private WebElement companyTags;

    @FindBy(id = "associateContactCreateNewCompany")
    private WebElement addCompanyButton;

    @FindBy(xpath = "//app-create-edit-contact-vendor//h2[.='Add New Company']")
    private WebElement addNewCompanyHeader;

    @FindBy(xpath = "//app-msg-dialog//button[.='cancel']")
    private WebElement cancelButtonInPopUp;

    @FindBy(xpath = "//app-create-edit-contact-vendor//mat-icon[@svgicon='inv-times-circle']")
    private WebElement closeButtonInForm;
    @FindBy(xpath = "//mat-icon[@svgicon='inv-trash-o']")
    private WebElement deleteIcon;
    @FindBy(xpath = "//app-msg-dialog//button[.='Discard Changes']")
    private WebElement discardChangesButtonInPopUp;

    @FindBy(xpath = "//app-msg-dialog//button[.='Delete']")
    private WebElement deleteButtonInPopUp;

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Contact deleted successfully']")
    private WebElement contactDeleteMessage;

    @FindBy(xpath = "//mat-expansion-panel//mat-card-content")
    private WebElement matIconContent;


    public AssociateContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.addressbookPage = new AddressbookPage(driver);
        this.contactsPage = new ContactsPage(driver);
        this.opportunityListPage = new OpportunityListPage(driver);
        this.opportunityDetailsPage = new OpportunityDetailsPage(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public boolean addExistingContactToOpportunity() {
        this.opportunityDetailsPage.getFirstOpportunity();
        PageHelper.scrollToView(driver, associateContactButton);
        PageHelper.javascriptClick(driver, associateContactButton);
        Assert.assertTrue(isAssociateContactFormDisplayed());
        PageHelper.sendKeysToElement(driver, searchField, PropertyFileWriter.readFile("config.properties", "Contact_Email"));
        PageHelper.invisibilityOfElement(driver, loader);
        PageHelper.javascriptClick(driver, firstContact);
        PageHelper.isButtonEnabled(driver, addRoleButton);
        PageHelper.javascriptClick(driver, addRoleButton);
        Assert.assertTrue(isCompanyRoleFormDisplayed());
        PageHelper.selectElementInDropdown(driver, roleDropdown, "Contractor");
        PageHelper.javascriptClick(driver, addRoleButton);
        PageHelper.invisibilityOfElement(driver, loader);
        return isContactSuccessfullyAdded(PropertyFileWriter.readFile("config.properties", "Contact_Email"));

    }

    public boolean isContactSuccessfullyAdded(String email) {
        List<WebElement> emailAddressInCard = driver.findElements(By.xpath("//mat-card-content//a//span"));
        for (WebElement e : emailAddressInCard) {
            if (e.getText().contains(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAssociateContactFormDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(associateContactHeader),
                    ExpectedConditions.elementToBeClickable(searchField),
                    ExpectedConditions.invisibilityOf(loader)));
            return true;
        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }

    }

    public boolean isCompanyRoleFormDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(companyRoleHeader),
                    ExpectedConditions.elementToBeClickable(roleDropdown),
                    ExpectedConditions.invisibilityOf(loader)));
            return true;
        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }

    }

    public <T extends BaseData> boolean addNewContactToOpportunity(T obj, HashMap<String, String>[] contactTestData) {
        boolean isContactCreated = false;
        try {
            obj.generateDataForCreateNewContact();
            this.opportunityDetailsPage.getFirstOpportunity();
            for (int i = 0; i < contactTestData.length; i++) {
                PageHelper.scrollToView(driver, associateContactButton);
                PageHelper.javascriptClick(driver, associateContactButton);
                Assert.assertTrue(isAssociateContactFormDisplayed());
                PageHelper.javascriptClick(driver, createNewContactButton);
                PageHelper.invisibilityOfElement(driver, loader);
                if (contactTestData[i].get("Company Type").equals("Existing")) {
                    PageHelper.selectElementInDropdown(driver, companyOfContact, contactTestData[i].get("Company"));
                } else if (contactTestData[i].get("Company Type").equals("New Company")) {
                    PageHelper.sendData(driver, companyOfContact, contactTestData[i], "Company");
                }
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.sendData(driver, contactName, contactTestData[i], "Contact Name");
                PageHelper.sendData(driver, contactEmail, contactTestData[i], "Contact Email");
                PageHelper.sendData(driver, contactDesignation, contactTestData[i], "Contact Designation");
                PageHelper.sendData(driver, contactLeadSource, contactTestData[i], "Contact Lead Source");
                PageHelper.sendData(driver, contactTelephoneNo, contactTestData[i], "Contact Telephone");
                PageHelper.sendData(driver, contactMobileNo, contactTestData[i], "Contact Mobile");
                PageHelper.scrollToView(driver, contactTags);
                PageHelper.sendData(driver, contactTags, contactTestData[i], "Contact Tags");
                contactTags.sendKeys(Keys.ENTER);
                PageHelper.javascriptClick(driver, nextButton);
                if (contactTestData[i].get("Company Type").equals("New Company")) {
                    Assert.assertTrue(isAddNewCompanyFormDisplayed());
                    PageHelper.selectElementInDropdown(driver, industryType, contactTestData[i].get("Company Industry Type"));
                    industryType.sendKeys(Keys.ESCAPE);
                    PageHelper.selectElementInDropdown(driver, country, contactTestData[i].get("Company Country"));
                    PageHelper.sendData(driver, city, contactTestData[i], "Company City");
                    PageHelper.sendData(driver, state, contactTestData[i], "Company State");
                    PageHelper.sendData(driver, zipcode, contactTestData[i], "Company Zip");
                    PageHelper.sendData(driver, address, contactTestData[i], "Company Address");
                    PageHelper.sendData(driver, companyTags, contactTestData[i], "Company Tags");
                    PageHelper.sendData(driver, companyWebsite, contactTestData[i], "Company Website");
                    Assert.assertTrue(PageHelper.isButtonEnabled(driver, addCompanyButton));
                    PageHelper.invisibilityOfElement(driver, loader);
                    PageHelper.javascriptClick(driver, addCompanyButton);
                    PageHelper.invisibilityOfElement(driver, loader);
                }
                Assert.assertTrue(isCompanyRoleFormDisplayed());
                PageHelper.selectElementInDropdown(driver, roleDropdown, contactTestData[i].get("Company Role"));
                PageHelper.javascriptClick(driver, addRoleButton);
                PageHelper.invisibilityOfElement(driver, loader);
                boolean outcome = isContactSuccessfullyAdded(contactTestData[i].get("Contact Email"));
                if (outcome) {
                    isContactCreated = true;

                } else {
                    isContactCreated = false;
                    break;
                }
            }


        } catch (Exception ae) {
            ae.printStackTrace();
            Assert.fail(String.valueOf(ae));
            return isContactCreated;
        }
        return isContactCreated;
    }

    public <T extends BaseData> boolean validateDeleteContactOfOpportunity(T obj, HashMap<String, String>[] contactTestData) {
        boolean isContactDeleted = false;
        try {
            for (int i = 0; i < contactTestData.length; i++) {
                PageHelper.scrollToView(driver, associateContactButton);
                Actions act = new Actions(driver);
                act.moveToElement(matIconContent).build().perform();
                PageHelper.javascriptClick(driver, deleteIcon);
                PageHelper.javascriptClick(driver, deleteButtonInPopUp);
                isContactDeleted = isContactSuccessfullyDeleted();
                if (isContactDeleted) {
                    return true;
                } else {
                    isContactDeleted = false;
                    break;
                }

            }

        } catch (Exception e) {
            isContactDeleted = false;
            Assert.fail(String.valueOf(e));
        }
        return isContactDeleted;
    }

    public boolean isContactSuccessfullyDeleted() {
        return PageHelper.validateConfirmationMessage(driver, contactDeleteMessage);
    }

    public <T extends BaseData> boolean addNewContactToOpportunityNegative(T obj, HashMap<String, String>[] contactTestData, HashMap<String, String>[] contactValidationMessages) {
        boolean isMessageDisplayed = false;
        try {
            obj.generateDataForCreateNewContactNegativeTesting();
            obj.generateCreateNewContactValidationMessages();
            this.opportunityDetailsPage.getFirstOpportunity();
            for (int i = 0; i < contactTestData.length; i++) {
                PageHelper.scrollToView(driver, associateContactButton);
                PageHelper.javascriptClick(driver, associateContactButton);
                Assert.assertTrue(isAssociateContactFormDisplayed());
                PageHelper.javascriptClick(driver, createNewContactButton);
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.sendData(driver, companyOfContact, contactTestData[i], "Company");
                companyOfContact.sendKeys(Keys.ENTER);
                Thread.sleep(2000);
                PageHelper.sendData(driver, contactDesignation, contactTestData[i], "Contact Designation");
                PageHelper.sendData(driver, contactLeadSource, contactTestData[i], "Contact Lead Source");
                PageHelper.sendData(driver, contactTelephoneNo, contactTestData[i], "Contact Telephone");
                PageHelper.sendData(driver, contactMobileNo, contactTestData[i], "Contact Mobile");
                PageHelper.sendData(driver, contactName, contactTestData[i], "Contact Name");
                PageHelper.sendData(driver, contactEmail, contactTestData[i], "Contact Email");
                PageHelper.scrollToView(driver, contactTags);
                PageHelper.sendData(driver, contactTags, contactTestData[i], "Contact Tags");
                contactTags.sendKeys(Keys.ENTER);
                contactDetailsHeaderInForm.click();
                Thread.sleep(2000);
                if (PageHelper.isButtonEnabled(driver, nextButton)) {
                    Assert.assertTrue(getAllErrorMessages().size() == 0);
                    PageHelper.javascriptClick(driver, nextButton);
                    if (contactTestData[i].get("Company Type").equals("Existing")) {
                        Assert.assertTrue(isCompanyRoleFormDisplayed());
                        PageHelper.selectElementInDropdownForNegativeTesting(driver, contactTestData[i], roleDropdown, cancelButtonInPopUp, "Company Role", contactTestData[i].get("Company Role"));
                        if (PageHelper.isButtonEnabled(driver, addRoleButton)) {
                            Assert.assertTrue(getAllErrorMessages().size() == 0);
                            PageHelper.javascriptClick(driver, addRoleButton);
                            isMessageDisplayed = false;
                            break;
                        } else {
                            Assert.assertTrue(validateErrors(contactValidationMessages[i], getAllErrorMessages()));
                            PageHelper.javascriptClick(driver, closeButtonInForm);
                            isMessageDisplayed = true;
                        }

                    } else if (contactTestData[i].get("Company Type").equals("New Company")) {
                        Assert.assertTrue(isAddNewCompanyFormDisplayed());
                        PageHelper.selectElementInDropdownForNegativeTesting(driver, contactTestData[i], industryType, cancelButtonInPopUp, "Company Industry Type", contactTestData[i].get("Company Industry Type"));
                        PageHelper.sendData(driver, companyTags, contactTestData[i], "Company Tags");
                        companyTags.sendKeys(Keys.ENTER);
                        PageHelper.selectElementInDropdownForNegativeTesting(driver, contactTestData[i], country, cancelButtonInPopUp, "Company Country", contactTestData[i].get("Company Country"));
                        PageHelper.sendData(driver, city, contactTestData[i], "Company City");
                        PageHelper.sendData(driver, state, contactTestData[i], "Company State");
                        PageHelper.sendData(driver, zipcode, contactTestData[i], "Company Zip");
                        PageHelper.sendData(driver, address, contactTestData[i], "Company Address");
                        PageHelper.sendData(driver, companyWebsite, contactTestData[i], "Company Website");
                        addNewCompanyHeader.click();
                        if (PageHelper.isButtonEnabled(driver, addRoleButton)) {
                            Assert.assertTrue(getAllErrorMessages().size() == 0);
                            PageHelper.javascriptClick(driver, addRoleButton);
                            Assert.assertTrue(isCompanyRoleFormDisplayed());
                            PageHelper.selectElementInDropdownForNegativeTesting(driver, contactTestData[i], roleDropdown, cancelButtonInPopUp, "Company Role", contactTestData[i].get("Company Role"));
                            if (PageHelper.isButtonEnabled(driver, addRoleButton)) {
                                Assert.assertTrue(getAllErrorMessages().size() == 0);
                                PageHelper.javascriptClick(driver, addRoleButton);
                                isMessageDisplayed = false;
                                break;
                            } else {
                                Assert.assertTrue(validateErrors(contactValidationMessages[i], getAllErrorMessages()));
                                PageHelper.javascriptClick(driver, closeButtonInForm);
                                isMessageDisplayed = true;
                            }
                        } else {
                            Assert.assertTrue(validateErrors(contactValidationMessages[i], getAllErrorMessages()));
                            PageHelper.javascriptClick(driver, closeButtonInForm);
                            isMessageDisplayed = true;
                        }
                    }
                } else {
                    Assert.assertTrue(validateErrors(contactValidationMessages[i], getAllErrorMessages()));
                    PageHelper.javascriptClick(driver, closeButtonInForm);
                    isMessageDisplayed = true;
                }

            }
        } catch (Exception ae) {
            Assert.fail(String.valueOf(ae));
            return isMessageDisplayed;
        }
        System.out.println("Status of isdisplayed " + isMessageDisplayed);
        return isMessageDisplayed;

    }

    public boolean isAddNewCompanyFormDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(addNewCompanyHeader),
                    ExpectedConditions.elementToBeClickable(industryType),
                    ExpectedConditions.elementToBeClickable(companyWebsite),
                    ExpectedConditions.elementToBeClickable(country)));
            return true;
        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }
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

}