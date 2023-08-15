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

public class CompanyPage extends AbstractBasePage {
    private WebDriver driver;
    private AddressbookPage addressbookPage;

    private CompanyDetailsPage companyDetailsPage;

    public CompanyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.addressbookPage = new AddressbookPage(driver);
        this.companyDetailsPage = new CompanyDetailsPage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@routerlink='companies']")
    private WebElement companiesMenu;

    @FindBy(xpath = "//app-company-list//button[.='Add Company']")
    private WebElement addCompanyButton;
    @FindBy(xpath = "//h2[.='Add Company']")
    private WebElement addCompanyHeader;

    @FindBy(xpath = "//app-create-company//input[@data-placeholder='Company Name']")
    private WebElement companyName;

    @FindBy(xpath = "//app-create-company//input[@aria-owns='industry_type_options']")
    private WebElement industryTypeField;
    @FindBy(xpath = "//app-create-company//input[@name='tel_no']")
    private WebElement companyTelephone;
    @FindBy(xpath = "//app-create-company//input[@name='mobile_no1']")
    private WebElement companyFax;

    @FindBy(xpath = "//app-create-company//input[@name='city']")
    private WebElement companyCity;

    @FindBy(xpath = "//app-create-company//input[@name='email']")
    private WebElement companyEmail;

    @FindBy(xpath = "//app-create-company//input[@name='website']")
    private WebElement companyWebsite;
    @FindBy(xpath = "//app-create-company//input[@placeholder='Enter Tags']")
    private WebElement companyTags;
    @FindBy(xpath = "//app-create-company//form//textarea[@name='address']")
    private WebElement companyAddress;
    @FindBy(xpath = "//app-create-company//input[@name='zip']")
    private WebElement companyZipCode;

    @FindBy(xpath = "//app-create-company//mat-select[@placeholder='Country']")
    private WebElement companyCountry;

    @FindBy(xpath = "//app-create-company//input[@name='state']")
    private WebElement companyState;

    @FindBy(xpath = "//app-create-company//button[@type='submit']")
    private WebElement submitCompany;
    @FindBy(xpath = "//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Company added successfully']")
    private WebElement companyCreationMessage;


    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Company deleted successfully']")
    private WebElement companyDeleteMessage;

    @FindBy(xpath = "//app-create-company//form")
    private WebElement addNewCompanyForm;


    @FindBy(xpath = "//button[@name='action-menu-delete-trigger']")
    private WebElement deleteButton;
    @FindBy(xpath = "//app-msg-dialog//button[.='Delete']")
    private WebElement deleteButtonInPopUp;

    @FindBy(xpath="//app-msg-dialog//button[.='cancel']")
    private WebElement cancelButtonInPopUp;

    @FindBy(xpath="//app-msg-dialog//button[.='Discard Changes']")
    private WebElement discardChangesButtonInPopUp;

    @FindBy(xpath="//app-create-company//mat-icon[@svgicon='inv-times-circle']")
    private WebElement closeButtonInForm;

    @FindBy(xpath="//form")
    private WebElement Form;

    public <T extends BaseData> boolean addCompany(T obj, HashMap<String, String>[] companyTestData) {
        boolean isCompanyCreated = false;
        try {
            obj.generateDataForCreateCompany();
            for (int i = 0; i < companyTestData.length; i++) {
                this.addressbookPage.clickAddressbook();
                Assert.assertTrue(this.addressbookPage.isDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, companiesMenu);
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, addCompanyButton);
                Assert.assertTrue(isAddNewCompanyFormDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.sendData(driver, companyName, companyTestData[i], "Company Name");
                PageHelper.selectElementInDropdown(driver, industryTypeField, companyTestData[i].get("Company Industry Type"));
                PageHelper.sendData(driver, companyCity, companyTestData[i], "Company City");
                PageHelper.selectElementInDropdown(driver, companyCountry, companyTestData[i].get("Company Country"));
                PageHelper.sendData(driver, companyState, companyTestData[i], "Company State");
                PageHelper.sendData(driver, companyZipCode, companyTestData[i], "Company Zip");
                PageHelper.sendData(driver, companyAddress, companyTestData[i], "Company Address");
                PageHelper.sendData(driver, companyTelephone, companyTestData[i], "Company Telephone");
                PageHelper.sendData(driver, companyFax, companyTestData[i], "Company Fax");
                PageHelper.sendData(driver, companyEmail, companyTestData[i], "Company Email");
                PageHelper.sendData(driver, companyTags, companyTestData[i], "Company Tags");
                PageHelper.sendData(driver, companyWebsite, companyTestData[i], "Company Website");
                Assert.assertTrue(PageHelper.isButtonEnabled(driver, submitCompany));
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, submitCompany);
                PageHelper.invisibilityOfElement(driver, loader);
                boolean outcome = isCompanySuccessfullyCreated();
                if (outcome) {
                    isCompanyCreated = true;
                } else {
                    isCompanyCreated = false;
                    break;
                }

            }

        } catch (Exception ae) {
            Assert.fail(String.valueOf(ae));
            return isCompanyCreated;
        }
        return isCompanyCreated;
    }

    public boolean isAddNewCompanyFormDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(addNewCompanyForm),
                    ExpectedConditions.visibilityOf(addCompanyHeader),
                    ExpectedConditions.elementToBeClickable(companyName),
                    ExpectedConditions.elementToBeClickable(industryTypeField),
                    ExpectedConditions.elementToBeClickable(companyAddress)));
            return true;
        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }
    }


    public boolean isCompanySuccessfullyCreated() {
        return PageHelper.validateConfirmationMessage(driver, companyCreationMessage);
    }


    public boolean isCompanySuccessfullyDeleted() {
        return PageHelper.validateConfirmationMessage(driver, companyDeleteMessage);
    }


    public boolean validateDeleteCompany(HashMap<String, String>[] editCompanyTestData) {
        boolean flag = false;
        for (int i = 0; i < editCompanyTestData.length; i++) {
            System.out.println("This contact is being deleted " + editCompanyTestData[i].get("Company Name"));
            deleteCompany(driver, editCompanyTestData[i].get("Company Name"));
            flag = isCompanySuccessfullyDeleted();
            if (!flag) {
                Assert.fail("Contact is not successfully deleted");
                return false;
            }
        }
        return true;
    }


    public void deleteCompany(WebDriver driver, String ele) {
        this.addressbookPage.clickAddressbook();
        Assert.assertTrue(this.addressbookPage.isDisplayed());
        PageHelper.invisibilityOfElement(driver, loader);
        PageHelper.javascriptClick(driver, companiesMenu);
        PageHelper.invisibilityOfElement(driver, loader);
        getActionEllipses(driver, ele);
        PageHelper.javascriptClick(driver, deleteButton);
        PageHelper.javascriptClick(driver, deleteButtonInPopUp);
        PageHelper.invisibilityOfElement(driver, loader);

    }

    public <T extends BaseData> boolean addCompanyNegative(T obj, HashMap<String, String>[] companyTestData,HashMap<String, String>[] companyValidationMessages) {
        boolean isMessageDisplayed = false;
        try {
            obj.generateDataForAddCompanyNegativeTesting();
            obj.generateAddCompanyValidationMessages();
            for (int i = 0; i < companyValidationMessages.length; i++) {
                this.addressbookPage.clickAddressbook();
                Assert.assertTrue(this.addressbookPage.isDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, companiesMenu);
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, addCompanyButton);
                Assert.assertTrue(isAddNewCompanyFormDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.sendData(driver, companyName, companyTestData[i], "Company Name");
                PageHelper.selectElementInDropdownForNegativeTesting(driver, companyTestData[i],industryTypeField,cancelButtonInPopUp,"Company Industry Type", companyTestData[i].get("Company Industry Type"));
                PageHelper.sendData(driver, companyCity, companyTestData[i], "Company City");
                PageHelper.selectElementInDropdownForNegativeTesting(driver, companyTestData[i],companyCountry,cancelButtonInPopUp,"Company Country",companyTestData[i].get("Company Country"));
                PageHelper.sendData(driver, companyEmail, companyTestData[i], "Company Email");
                PageHelper.sendData(driver, companyState, companyTestData[i], "Company State");
                PageHelper.sendData(driver, companyZipCode, companyTestData[i], "Company Zip");
                PageHelper.sendData(driver, companyAddress, companyTestData[i], "Company Address");
                PageHelper.sendData(driver, companyTelephone, companyTestData[i], "Company Telephone");
                PageHelper.sendData(driver, companyFax, companyTestData[i], "Company Fax");
                PageHelper.sendData(driver, companyTags, companyTestData[i], "Company Tags");
                PageHelper.sendData(driver, companyWebsite, companyTestData[i], "Company Website");
                addCompanyHeader.click();
                Thread.sleep(2000);
                Assert.assertFalse(PageHelper.isButtonEnabled(driver, submitCompany));
                Assert.assertTrue(validateErrors(companyValidationMessages[i],getAllErrorMessages()));
                PageHelper.javascriptClick(driver,closeButtonInForm);
                PageHelper.javascriptClick(driver,discardChangesButtonInPopUp);
                isMessageDisplayed = true;
            }
        }
        catch (Exception e)
        {
            isMessageDisplayed = false;
          return isMessageDisplayed;
        }
     return isMessageDisplayed;
    }


    public ArrayList<String> getAllErrorMessages() {
        PageHelper.javascriptClick(driver,Form);
        List<WebElement> errorMessages = driver.findElements(By.xpath("//mat-error[@role='alert']"));
        ArrayList<String> message = new ArrayList<>();
        for (WebElement e : errorMessages) {
            message.add(e.getText());
        }
        System.out.println(message);
        return message;

    }

    public boolean validateErrors(HashMap<String, String> companyValidationMessage, ArrayList<String> capturedMessages) {
        boolean isErrorPresent = false;
        for (Map.Entry<String, String> entry : companyValidationMessage.entrySet()) {
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