package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testData.BaseData;
import testData.ContactsData;
import util.PageHelper;


public class ContactsPage extends AbstractBasePage {

    private WebDriver driver;


    private AddressbookPage addressbookPage;


    public ContactsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.addressbookPage = new AddressbookPage(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//button[.='Add Contact'])[1]")
    private WebElement addContactButton;

    @FindBy(xpath = "//app-add-contact//form")
    private WebElement addNewContactForm;

    @FindBy(xpath = "//h2[.=' Contact Details']")
    private WebElement contactDetailsHeader;


    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement contactName;


    @FindBy(xpath = "//app-add-contact//form//input[@formcontrolname='email']")
    private WebElement contactEmail;


    @FindBy(xpath = "//app-add-contact//form//input[@name='company']")
    private WebElement companyOfContact;


    @FindBy(xpath = "//form//button[.='Add Contact']")
    private WebElement addContactButtonInsideForm;

    @FindBy(xpath = "//app-add-contact//h2//span[contains(.,'Contact Details')]")
    private WebElement contactDetailsHeaderInForm;

    @FindBy(xpath = "//app-add-contact//form//input[@ name='designation']")
    private WebElement contactDesignation;


    @FindBy(xpath = "//app-add-contact//form//input[@ name='leadSource']")
    private WebElement contactLeadSource;


    @FindBy(xpath = "//app-add-contact//form//input[@ name='linked_in_url']")
    private WebElement contactLinkedinUrl;


    @FindBy(xpath = "//app-add-contact//form//input[@ name='mobile_no1']")
    private WebElement contactMobileNo;


    @FindBy(xpath = "//app-add-contact//form//input[@name='tel_no1']")
    private WebElement contactTelephoneNo;


    ;
    @FindBy(xpath = "//app-add-contact//form//input[@placeholder='Tags']")
    private WebElement contactTags;


    @FindBy(xpath = "//app-add-contact//form//button[@id='action-add-or-update-button']")
    private WebElement submitContact;

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Contact added successfully']")
    private WebElement contactCreationMessage;


    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Contact deleted successfully']")
    private WebElement contactDeleteMessage;


    @FindBy(xpath = "//app-add-contact//form//button[@id='next-button']")
    private WebElement nextButton;


    @FindBy(xpath = "//app-add-contact//form//input[@aria-owns='industry_type_options']")
    private WebElement industryType;


    @FindBy(xpath = "//app-add-contact//form//mat-select[@placeholder='Country']")
    private WebElement country;


    @FindBy(xpath = "//app-add-contact//form//input[@name='state']")
    private WebElement state;


    @FindBy(xpath = "//app-add-contact//form//input[@name='city']")
    private WebElement city;


    @FindBy(xpath = "//app-add-contact//form//input[@name='zip']")
    private WebElement zipcode;


    @FindBy(xpath = "//app-add-contact//form//textarea[@name='address']")
    private WebElement address;


    @FindBy(xpath = "//app-add-contact//form//input[@name='tel_no']")
    private WebElement companyTelephone;

    @FindBy(xpath = "//app-add-contact//form//input[@ data-placeholder='Fax Number']")
    private WebElement companyFax;


    @FindBy(xpath = "//app-new-company//form//input[@name='email']")
    private WebElement companyEmail;
    @FindBy(xpath = "//app-new-company//form//input[@name='website']")
    private WebElement companyWebsite;

    @FindBy(xpath = "//app-new-company//form//input[@placeholder='Enter Tags']")
    private WebElement companyTags;


    @FindBy(xpath = "//app-add-contact//form//button[contains(.,'Create')]")
    private WebElement createButton;

    @FindBy(xpath = "//h2[.='Add New Company']")
    private WebElement addNewCompanyHeaderInForm;


    @FindBy(xpath = "//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;


    @FindBy(xpath = "//button[@name='action-menu-delete-trigger']")
    private WebElement deleteButton;
    @FindBy(xpath = "//app-msg-dialog//button[.='Delete']")
    private WebElement deleteButtonInPopUp;

    @FindBy(xpath="//app-msg-dialog//button[.='Discard Changes']")
    private WebElement discardChangesButtonInPopUp;

    @FindBy(xpath="//app-msg-dialog//button[.='cancel']")
    private WebElement cancelButtonInPopUp;

    @FindBy(xpath="//app-add-contact//mat-icon[@svgicon='inv-times-circle']")
    private WebElement closeButtonInForm;

    @FindBy(xpath="//mat-icon[@svgicon='inv-filter']")
    private WebElement filter;

    @FindBy(id="filter-panel-clear-all")
    private WebElement clearAll;

    @FindBy(xpath="//tbody/tr[1]//b")
    private WebElement firstResult;


    public <T extends BaseData> boolean addContact(T obj, HashMap<String, String>[] contactTestData) {
        boolean isContactCreated = false;
        try {
            obj.generateDataForCreateContact();
            for (int i = 0; i < contactTestData.length; i++) {
                this.addressbookPage.clickAddressbook();
                Assert.assertTrue(this.addressbookPage.isDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, addContactButton);
                Assert.assertTrue(isAddNewContactFormDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.sendData(driver, contactName, contactTestData[i], "Contact Name");
                PageHelper.sendData(driver, contactEmail, contactTestData[i], "Contact Email");
                if (contactTestData[i].get("Company Type").equals("Existing")) {
                    System.out.println("contactTestData[i].get(\"Company\") is "+contactTestData[i].get("Company"));
                    PageHelper.selectElementInDropdown(driver, companyOfContact, contactTestData[i].get("Company"));
                } else if (contactTestData[i].get("Company Type").equals("New Company")) {
                    PageHelper.sendData(driver, companyOfContact, contactTestData[i], "Company");
                }
                Assert.assertTrue(PageHelper.isButtonEnabled(driver, addContactButtonInsideForm));
                PageHelper.javascriptClick(driver, addContactButtonInsideForm);
                PageHelper.sendData(driver, contactDesignation, contactTestData[i], "Contact Designation");
                PageHelper.sendData(driver, contactLeadSource, contactTestData[i], "Contact Lead Source");
                PageHelper.sendData(driver, contactLinkedinUrl, contactTestData[i], "Contact LinkedinUrl");
                PageHelper.sendData(driver, contactTelephoneNo, contactTestData[i], "Contact Telephone");
                PageHelper.sendData(driver, contactMobileNo, contactTestData[i], "Contact Mobile");
                PageHelper.scrollToView(driver,contactTags);
                PageHelper.sendData(driver, contactTags, contactTestData[i], "Contact Tags");
                contactTags.sendKeys(Keys.ENTER);

                if (contactTestData[i].get("Company Type").equals("Without Company")) {
                    Assert.assertTrue(PageHelper.isButtonEnabled(driver, createButton));
                    //PageHelper.invisibilityOfElement(driver,loader);
                    PageHelper.javascriptClick(driver, createButton);
                    PageHelper.invisibilityOfElement(driver, loader);
                } else if (contactTestData[i].get("Company Type").equals("Existing")) {
                    Assert.assertTrue(PageHelper.isButtonEnabled(driver, submitContact));
                    PageHelper.invisibilityOfElement(driver, loader);
                    PageHelper.javascriptClick(driver, submitContact);
                    PageHelper.invisibilityOfElement(driver, loader);
                } else if (contactTestData[i].get("Company Type").equals("New Company")) {
                    PageHelper.sendData(driver, companyOfContact, contactTestData[i], "Company");
                    Assert.assertTrue(PageHelper.isButtonEnabled(driver, nextButton));
                    PageHelper.javascriptClick(driver, nextButton);
                    PageHelper.invisibilityOfElement(driver, loader);
                    Assert.assertTrue(isAddNewCompanyFormDisplayed());
                    PageHelper.selectElementInDropdown(driver, industryType, contactTestData[i].get("Company Industry Type"));
                    PageHelper.selectElementInDropdown(driver, country, contactTestData[i].get("Company Country"));
                    PageHelper.sendData(driver, city, contactTestData[i], "Company City");
                    PageHelper.sendData(driver, state, contactTestData[i], "Company State");
                    PageHelper.sendData(driver, zipcode, contactTestData[i], "Company Zip");
                    PageHelper.sendData(driver, address, contactTestData[i], "Company Address");
                    PageHelper.sendData(driver, companyTelephone, contactTestData[i], "Company Telephone");
                    PageHelper.sendData(driver, companyFax, contactTestData[i], "Company Fax");
                    PageHelper.sendData(driver, companyEmail, contactTestData[i], "Company Email");
                    PageHelper.sendData(driver, companyTags, contactTestData[i], "Company Tags");
                    PageHelper.sendData(driver, companyWebsite, contactTestData[i], "Company Website");
                    Assert.assertTrue(PageHelper.isButtonEnabled(driver, createButton));
                    PageHelper.invisibilityOfElement(driver, loader);
                    PageHelper.javascriptClick(driver, createButton);
                    PageHelper.invisibilityOfElement(driver, loader);

                }
                boolean outcome = isContactSuccessfullyCreated();
                if (outcome) {
                    isContactCreated = true;

                } else {
                    isContactCreated = false;
                    break;
                }
            }


        } catch (Exception ae) {
            ae.printStackTrace();
            //Assert.fail(String.valueOf(ae));
            return isContactCreated;
        }
        return isContactCreated;
    }

    public <T extends BaseData> boolean addContactNegative(T obj, HashMap<String, String>[] contactTestData,HashMap<String, String>[] contactValidationMessages) {
        boolean isMessageDisplayed = false;
        try {
            obj.generateAddContactValidationMessages();
            obj.generateDataForAddContactNegativeTesting();

            for (int i = 0; i < contactValidationMessages.length; i++)
            {
                System.out.println("Iteration is "+i);
                this.addressbookPage.clickAddressbook();
                Assert.assertTrue(this.addressbookPage.isDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, addContactButton);
                Assert.assertTrue(isAddNewContactFormDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.sendData(driver, contactName, contactTestData[i], "Contact Name");
                PageHelper.sendData(driver, contactEmail, contactTestData[i], "Contact Email");
                addNewContactForm.click();
                Thread.sleep(2000);
                if (PageHelper.isButtonEnabled(driver, addContactButtonInsideForm))
                {
                    Assert.assertTrue(getAllErrorMessages().size() == 0);
                    if (contactTestData[i].get("Company Type").equals("Existing")) {
                        PageHelper.selectElementInDropdown(driver, companyOfContact, contactTestData[i].get("Company"));
                    } else if (contactTestData[i].get("Company Type").equals("New Company")) {
                        PageHelper.sendData(driver, companyOfContact, contactTestData[i], "Company");
                    }
                    PageHelper.javascriptClick(driver, addContactButtonInsideForm);
                    PageHelper.sendData(driver, contactDesignation, contactTestData[i], "Contact Designation");
                    PageHelper.sendData(driver, contactLeadSource, contactTestData[i], "Contact Lead Source");
                    PageHelper.sendData(driver, contactLinkedinUrl, contactTestData[i], "Contact LinkedinUrl");
                    PageHelper.sendData(driver, contactTelephoneNo, contactTestData[i], "Contact Telephone");
                    PageHelper.sendData(driver, contactMobileNo, contactTestData[i], "Contact Mobile");
                    PageHelper.scrollToView(driver,contactTags);
                    PageHelper.sendData(driver, contactTags, contactTestData[i], "Contact Tags");
                    contactTags.sendKeys(Keys.ENTER);
                    contactDetailsHeaderInForm.click();
                    if (contactTestData[i].get("Company Type").equals("Without Company"))
                    {
                        if (PageHelper.isButtonEnabled(driver, createButton)) {
                            Assert.assertTrue(getAllErrorMessages().size() == 0);
                            PageHelper.javascriptClick(driver, createButton);
                            PageHelper.invisibilityOfElement(driver, loader);
                        } else {
                            Assert.assertTrue(validateErrors(contactValidationMessages[i], getAllErrorMessages()));
                            PageHelper.javascriptClick(driver, closeButtonInForm);
                            PageHelper.javascriptClick(driver, discardChangesButtonInPopUp);
                            isMessageDisplayed = true;
                            //break;
                        }

                    }
                    else if (contactTestData[i].get("Company Type").equals("Existing"))
                    {
                        if (PageHelper.isButtonEnabled(driver, submitContact)) {
                            Assert.assertTrue(getAllErrorMessages().size() == 0);
                            PageHelper.javascriptClick(driver, submitContact);
                            PageHelper.invisibilityOfElement(driver, loader);
                        }
                        else {
                            Assert.assertTrue(validateErrors(contactValidationMessages[i], getAllErrorMessages()));
                            PageHelper.javascriptClick(driver, closeButtonInForm);
                            PageHelper.javascriptClick(driver, discardChangesButtonInPopUp);
                            isMessageDisplayed = true;
                            //break;
                        }


                    }
                    else if (contactTestData[i].get("Company Type").equals("New Company"))
                    {
                       // PageHelper.sendData(driver, companyOfContact, contactTestData[i], "Company");
                        if (PageHelper.isButtonEnabled(driver, nextButton))
                        {
                            Assert.assertTrue(getAllErrorMessages().size() == 0);
                            PageHelper.javascriptClick(driver, nextButton);
                            PageHelper.invisibilityOfElement(driver, loader);
                            PageHelper.selectElementInDropdownForNegativeTesting(driver, contactTestData[i],industryType,cancelButtonInPopUp,"Company Industry Type", contactTestData[i].get("Company Industry Type"));
                            PageHelper.selectElementInDropdownForNegativeTesting(driver,contactTestData[i],country,cancelButtonInPopUp,"Company Country",contactTestData[i].get("Company Country"));
                            PageHelper.sendData(driver, city, contactTestData[i], "Company City");
                            PageHelper.sendData(driver, state, contactTestData[i], "Company State");
                            PageHelper.sendData(driver, zipcode, contactTestData[i], "Company Zip");
                            PageHelper.sendData(driver, address, contactTestData[i], "Company Address");
                            PageHelper.sendData(driver, companyTelephone, contactTestData[i], "Company Telephone");
                            PageHelper.sendData(driver, companyFax, contactTestData[i], "Company Fax");
                            PageHelper.sendData(driver, companyEmail, contactTestData[i], "Company Email");
                            PageHelper.sendData(driver, companyTags, contactTestData[i], "Company Tags");
                            PageHelper.sendData(driver, companyWebsite, contactTestData[i], "Company Website");
                            addNewCompanyHeaderInForm.click();

                            if (PageHelper.isButtonEnabled(driver, createButton)) {
                                Assert.assertTrue(getAllErrorMessages().size() == 0);
                                PageHelper.javascriptClick(driver, createButton);
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
                } 
                else {
                    Assert.assertTrue(validateErrors(contactValidationMessages[i], getAllErrorMessages()));
                    PageHelper.javascriptClick(driver, closeButtonInForm);
                    PageHelper.javascriptClick(driver, discardChangesButtonInPopUp);
                    isMessageDisplayed = true;
                    //break;
                }

            } 
            
        }
        catch(Exception ae)
        {
            Assert.fail(String.valueOf(ae));
            return isMessageDisplayed;
        }
        System.out.println("Status of isdisplayed "+isMessageDisplayed);
        return isMessageDisplayed;

    }





    public boolean isContactSuccessfullyCreated() {
        return PageHelper.validateConfirmationMessage(driver, contactCreationMessage);
    }


    public boolean isContactSuccessfullyDeleted() {
        return PageHelper.validateConfirmationMessage(driver, contactDeleteMessage);
    }

    public boolean isAddNewContactFormDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(addNewContactForm),
                    ExpectedConditions.elementToBeClickable(contactName),
                    ExpectedConditions.elementToBeClickable(contactEmail),
                    ExpectedConditions.elementToBeClickable(companyOfContact)));
            return true;
        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }
    }

    public boolean isAddNewCompanyFormDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(addNewCompanyHeaderInForm),
                    ExpectedConditions.elementToBeClickable(industryType),
                    ExpectedConditions.elementToBeClickable(country),
                    ExpectedConditions.elementToBeClickable(companyTags)));
            return true;
        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }
    }


    public boolean validateDeleteContact(HashMap<String, String>[] editContactTestData) {
        boolean flag = false;
        for (int i = 0; i < editContactTestData.length; i++) {
            System.out.println("This contact is being deleted " + editContactTestData[i].get("Contact Email"));
            deleteContact(driver, editContactTestData[i].get("Contact Email"));
            flag = isContactSuccessfullyDeleted();
            if (!flag) {
                Assert.fail("Contact is not successfully deleted");
                return false;
            }
        }
        return true;
    }

    public void deleteContact(WebDriver driver, String ele) {
        this.addressbookPage.clickAddressbook();
        Assert.assertTrue(this.addressbookPage.isDisplayed());
        PageHelper.invisibilityOfElement(driver, loader);
        getActionEllipses(driver, ele);
        PageHelper.javascriptClick(driver, deleteButton);
        PageHelper.javascriptClick(driver, deleteButtonInPopUp);
        PageHelper.invisibilityOfElement(driver, loader);

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
        for (Map.Entry<String, String> entry : contactValidationMessage.entrySet())
        {
            System.out.println("Values from hashmap "+entry.getValue());
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