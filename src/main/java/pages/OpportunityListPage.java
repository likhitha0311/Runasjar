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

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpportunityListPage extends AbstractBasePage {

        private WebDriver driver;

        private OpportunityPage opportunityPage;

        public OpportunityListPage(WebDriver driver)
        {
            super(driver);
            this.driver=driver;
            this.opportunityPage = new OpportunityPage(driver);
            PageFactory.initElements(driver,this);
        }
        @FindBy(xpath="//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
        private WebElement loader;

        @FindBy(xpath="//button[.='Create Opportunity']")
        private WebElement createOpportunityButton;

        @FindBy(id="opportunityDialogOpportunityName")
        private WebElement opportunityName;

        @FindBy(xpath="//app-create-opportunity//form//input[@aria-owns='opportunity-type_options']")
        private WebElement serviceTypeDropdown;

        @FindBy(xpath="//input[@data-placeholder='Opportunity Folder']")
        private WebElement opportunityFolder;

        @FindBy(xpath="//input[@data-placeholder='Reference Number']")
        private WebElement referenceNumber;

        @FindBy(xpath="//mat-icon[@svgicon='inv-calendar']")
        private WebElement calenderIcon;

        @FindBy(xpath="//td//div[.=' 8 ']")
        private WebElement closeDate;

        @FindBy(xpath="//app-create-opportunity//mat-select[@placeholder='Project Type']")
    private WebElement projectTypeDropdown;

    @FindBy(xpath="//mat-option[@role='option']")
    private WebElement projectTypeDropdownOptions;

        @FindBy(id="opportunityDialogEstimateValue")
        private WebElement opportunityEstimatedAmount;

    @FindBy(id="opportunityDialogOwnerMenu")
    private WebElement opportunityOwner;

        @FindBy(id="opportunityVat")
        private WebElement opportunityTax;

        @FindBy(xpath="//app-create-opportunity//mat-select[@placeholder='Country']")
        private WebElement opportunityCountry;

        @FindBy(xpath="//app-create-opportunity//form//input[@name='state']")
        private WebElement opportunityState;

        @FindBy(xpath="//app-create-opportunity//form//input[@name='city']")
        private WebElement opportunityCity;

        @FindBy(xpath="//app-create-opportunity//form//input[@name='zip']")
        private WebElement opportunityZipCode;

        @FindBy(xpath="//app-create-opportunity//form//input[@placeholder='Tags']")
        private WebElement opportunityTags;

        @FindBy(xpath="//button[@type='submit']")
        private WebElement createOpportunityButtonInsideForm;
        @FindBy(id="opportunityDialogCustomer")
        private WebElement opportunityCustomer;

        @FindBy(xpath ="//app-create-opportunity//form//button[contains(.,'Next')]")
        private WebElement nextButton;

        @FindBy(xpath = "//app-new-company//form//input[@aria-owns='industry_type_options']")
        private WebElement companyIndustryType;


        @FindBy(xpath = "//app-new-company//form//mat-select[@placeholder='Country']")
        private WebElement companyCountry;


        @FindBy(xpath = "//app-new-company//form//input[@name='state']")
        private WebElement companyState;


        @FindBy(xpath = "//app-new-company//form//input[@name='city']")
        private WebElement companyCity;


        @FindBy(xpath = "//app-new-company//form//input[@name='zip']")
        private WebElement companyZipCode;


        @FindBy(xpath = "//app-new-company//form//textarea[@name='address']")
        private WebElement companyAddress;


        @FindBy(xpath = "//app-new-company//form//input[@name='tel_no']")
        private WebElement companyTelephone;

        @FindBy(xpath = "//app-new-company//form//input[@ data-placeholder='Fax Number']")
        private WebElement companyFax;


        @FindBy(xpath = "//app-new-company//form//input[@name='email']")
        private WebElement companyEmail;
        @FindBy(xpath = "//app-new-company//form//input[@name='website']")
        private WebElement companyWebsite;

        @FindBy(xpath = "//app-new-company//form//input[@placeholder='Enter Tags']")
        private WebElement companyTags;


        @FindBy(xpath ="//app-new-company//form//button[contains(.,'Create')]")
        private WebElement createButton;

        @FindBy(xpath ="//h2[.='Create Opportunity']")
        private WebElement createOpportunityHeaderInForm;

    @FindBy(xpath="//app-msg-dialog//button[.='cancel']")
    private WebElement cancelButtonInPopUp;

        @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Opportunity added successfully']")
        private WebElement opportunityCreationMessage;

        @FindBy(xpath = "//mat-option[@role='option']")
        private WebElement firstElementInDropdown;

    @FindBy(xpath = "//app-create-opportunity//h2[.='Add Customer']")
    private WebElement addNewCustomerHeaderInForm;

    String detailsPageTitle=".studio | Opportunities Details";

    @FindBy(xpath="//app-create-opportunity//mat-icon[@svgicon='inv-times-circle']")
    private WebElement closeButtonInForm;

    @FindBy(xpath="//app-msg-dialog//button[.='Discard Changes']")
    private WebElement discardChangesButtonInPopUp;

public void getOpportunityPage()
    {
        this.opportunityPage.clickOpportunitiesMenu();
        Assert.assertTrue(this.opportunityPage.isOpportunityPageDisplayed());
    }

        public <T extends BaseData> boolean addOpportunity(T obj, HashMap<String, String>[] opportunityTestData) {
                boolean isOpportunityCreated = false;
                try {
                        obj.generateDataForCreateOpportunity();
                        for (int i = 0; i < opportunityTestData.length; i++) {
                            getOpportunityPage();
                                PageHelper.invisibilityOfElement(driver, loader);
                                PageHelper.javascriptClick(driver, createOpportunityButton);
                                Assert.assertTrue(isAddNewOpportunityFormDisplayed());
                                PageHelper.invisibilityOfElement(driver, loader);
                                PageHelper.sendData(driver, opportunityName, opportunityTestData[i], "Opportunity Name");
                                PageHelper.selectElementInDropdown(driver, serviceTypeDropdown, opportunityTestData[i].get("Service Type"));
                                PageHelper.selectElementInMatOptionDropdown(driver,projectTypeDropdown,opportunityTestData[i].get("Project Type"));
                                projectTypeDropdown.sendKeys(Keys.ESCAPE);
                                PageHelper.sendData(driver, opportunityFolder, opportunityTestData[i], "Opportunity Folder");
                                PageHelper.javascriptClick(driver, calenderIcon);
                                PageHelper.javascriptClick(driver, closeDate);
                                PageHelper.sendData(driver, opportunityEstimatedAmount, opportunityTestData[i], "Opportunity Estimated Amount");
                                PageHelper.sendData(driver, opportunityTax, opportunityTestData[i], "Opportunity Tax");
                                selectAccountOwner(driver, opportunityOwner, opportunityTestData[i].get("Opportunity Owner"));
                                PageHelper.selectElementInDropdown(driver, opportunityCountry, opportunityTestData[i].get("Opportunity Country"));
                                PageHelper.sendData(driver, opportunityCity, opportunityTestData[i], "Opportunity City");
                                PageHelper.sendData(driver, opportunityState, opportunityTestData[i], "Opportunity State");
                                PageHelper.sendData(driver, opportunityZipCode, opportunityTestData[i], "Opportunity Zip");
                                PageHelper.sendData(driver, opportunityTags, opportunityTestData[i], "Opportunity Tags");
                                opportunityTags.sendKeys(Keys.ENTER);
                              if (opportunityTestData[i].get("Customer Type").equals("Existing"))
                              {
                                  PageHelper.selectElementInDropdown(driver,opportunityCustomer,opportunityTestData[i].get("Customer"));
                                  Assert.assertTrue(PageHelper.isButtonEnabled(driver, createOpportunityButtonInsideForm));
                                  PageHelper.javascriptClick(driver, createOpportunityButtonInsideForm);
                                  PageHelper.invisibilityOfElement(driver, loader);

                                } else if (opportunityTestData[i].get("Customer Type").equals("New Customer")) {

                                        PageHelper.sendData(driver, opportunityCustomer, opportunityTestData[i], "Customer");
                                        Assert.assertTrue(PageHelper.isButtonEnabled(driver, nextButton));
                                        PageHelper.javascriptClick(driver, nextButton);
                                        PageHelper.invisibilityOfElement(driver, loader);
                                        Assert.assertTrue(isAddNewCompanyFormDisplayed());
                                        PageHelper.selectElementInDropdown(driver, companyIndustryType, opportunityTestData[i].get("Customer Industry Type"));
                                        PageHelper.selectElementInDropdown(driver, companyCountry, opportunityTestData[i].get("Customer Country"));
                                        PageHelper.sendData(driver, companyCity, opportunityTestData[i], "Customer City");
                                        PageHelper.sendData(driver, companyState, opportunityTestData[i], "Customer State");
                                        PageHelper.sendData(driver, companyZipCode, opportunityTestData[i], "Customer Zip");
                                        PageHelper.sendData(driver, companyAddress, opportunityTestData[i], "Customer Address");
                                        PageHelper.sendData(driver, companyTelephone, opportunityTestData[i], "Customer Telephone");
                                        PageHelper.sendData(driver, companyFax, opportunityTestData[i], "Customer Fax");
                                        PageHelper.sendData(driver, companyEmail, opportunityTestData[i], "Customer Email");
                                        PageHelper.sendData(driver, companyTags, opportunityTestData[i], "Customer Tags");
                                        PageHelper.sendData(driver, companyWebsite, opportunityTestData[i], "Customer Website");
                                        Assert.assertTrue(PageHelper.isButtonEnabled(driver, createButton));
                                        PageHelper.invisibilityOfElement(driver, loader);
                                        PageHelper.javascriptClick(driver, createButton);
                                        PageHelper.invisibilityOfElement(driver, loader);

                                }
                                boolean outcome = isOpportunitySuccessfullyCreated();
                                if (outcome) {
                                        isOpportunityCreated = true;

                                } else {
                                        isOpportunityCreated = false;
                                        break;
                                }
                        }


                } catch (Exception ae) {
                        Assert.fail(String.valueOf(ae));
                        return isOpportunityCreated;
                }
                return isOpportunityCreated;
        }

    public <T extends BaseData> boolean addOpportunityNegative(T obj, HashMap<String, String>[] opportunityTestData,HashMap<String, String>[] opportunityValidationMessages) {
        boolean isMessageDisplayed = false;
        try {
            obj.generateAddOpportunityValidationMessages();
            obj.generateDataForAddOpportunityNegativeTesting();
            for (int i = 0; i < opportunityTestData.length; i++)
            {
                isMessageDisplayed = false;
                this.opportunityPage.clickOpportunitiesMenu();
                Assert.assertTrue(this.opportunityPage.isOpportunityPageDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, createOpportunityButton);
                Assert.assertTrue(isAddNewOpportunityFormDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.sendData(driver, opportunityName, opportunityTestData[i], "Opportunity Name");
                PageHelper.selectElementInDropdown(driver, serviceTypeDropdown, opportunityTestData[i].get("Service Type"));
                PageHelper.selectElementInMatOptionDropdown(driver, projectTypeDropdown, opportunityTestData[i].get("Project Type"));
                projectTypeDropdown.sendKeys(Keys.ESCAPE);
                PageHelper.sendData(driver, opportunityFolder, opportunityTestData[i], "Opportunity Folder");
                PageHelper.javascriptClick(driver, calenderIcon);
                PageHelper.javascriptClick(driver, closeDate);
                PageHelper.sendData(driver, opportunityEstimatedAmount, opportunityTestData[i], "Opportunity Estimated Amount");
                PageHelper.sendData(driver, opportunityTax, opportunityTestData[i], "Opportunity Tax");
                selectAccountOwner(driver, opportunityOwner, opportunityTestData[i].get("Opportunity Owner"));
                PageHelper.selectElementInDropdownForNegativeTesting(driver, opportunityTestData[i], opportunityCountry, cancelButtonInPopUp, "Opportunity Country", opportunityTestData[i].get("Opportunity Country"));
                PageHelper.sendData(driver, opportunityCity, opportunityTestData[i], "Opportunity City");
                PageHelper.sendData(driver, opportunityState, opportunityTestData[i], "Opportunity State");
                PageHelper.sendData(driver, opportunityZipCode, opportunityTestData[i], "Opportunity Zip");
                PageHelper.sendData(driver, opportunityTags, opportunityTestData[i], "Opportunity Tags");
                opportunityTags.sendKeys(Keys.ENTER);
                if (opportunityTestData[i].get("Customer Type").equals("Existing")) {

                    PageHelper.sendData(driver, opportunityCustomer, opportunityTestData[i], "Customer");
                    createOpportunityHeaderInForm.click();
                    if (PageHelper.isButtonEnabled(driver, createOpportunityButtonInsideForm))
                    {
                        Assert.assertTrue(getAllErrorMessages().size() == 0);
                        PageHelper.javascriptClick(driver, createOpportunityButtonInsideForm);
                        PageHelper.invisibilityOfElement(driver, loader);
                        isMessageDisplayed =false;
                        break;
                    }
                    else
                    {
                        Assert.assertTrue(validateErrors(opportunityValidationMessages[i], getAllErrorMessages()));
                        PageHelper.javascriptClick(driver, closeButtonInForm);
                        isMessageDisplayed = true;
                    }
                }
                else if (opportunityTestData[i].get("Customer Type").equals("New Customer"))
                {
                    PageHelper.sendData(driver, opportunityCustomer, opportunityTestData[i], "Customer");
                    createOpportunityHeaderInForm.click();
                    if (PageHelper.isButtonEnabled(driver, nextButton)) {
                        Assert.assertTrue(getAllErrorMessages().size() == 0);
                        PageHelper.javascriptClick(driver, nextButton);
                        PageHelper.invisibilityOfElement(driver, loader);
                        Assert.assertTrue(isAddNewCompanyFormDisplayed());
                        selectIndustryTypeDropdown(driver, opportunityTestData[i], companyIndustryType,  "Customer Industry Type", opportunityTestData[i].get("Customer Industry Type"));
                        PageHelper.selectElementInDropdownForNegativeTesting(driver, opportunityTestData[i], companyCountry, cancelButtonInPopUp, "Customer Country", opportunityTestData[i].get("Customer Country"));
                        PageHelper.sendData(driver, companyCity, opportunityTestData[i], "Customer City");
                        PageHelper.sendData(driver, companyState, opportunityTestData[i], "Customer State");
                        PageHelper.sendData(driver, companyZipCode, opportunityTestData[i], "Customer Zip");
                        PageHelper.sendData(driver, companyAddress, opportunityTestData[i], "Customer Address");
                        PageHelper.sendData(driver, companyTelephone, opportunityTestData[i], "Customer Telephone");
                        PageHelper.sendData(driver, companyFax, opportunityTestData[i], "Customer Fax");
                        PageHelper.sendData(driver, companyEmail, opportunityTestData[i], "Customer Email");
                        PageHelper.sendData(driver, companyTags, opportunityTestData[i], "Customer Tags");
                        PageHelper.sendData(driver, companyWebsite, opportunityTestData[i], "Customer Website");
                        addNewCustomerHeaderInForm.click();
                        if (PageHelper.isButtonEnabled(driver, createButton))
                        {
                            Assert.assertTrue(getAllErrorMessages().size() == 0);
                            PageHelper.javascriptClick(driver, createButton);
                            PageHelper.invisibilityOfElement(driver, loader);
                            isMessageDisplayed =false;
                            break;

                        }
                        else {
                            Assert.assertTrue(validateErrors(opportunityValidationMessages[i], getAllErrorMessages()));
                            PageHelper.javascriptClick(driver, closeButtonInForm);
                            isMessageDisplayed = true;
                        }

                    } else
                    {
                        Assert.assertTrue(validateErrors(opportunityValidationMessages[i], getAllErrorMessages()));
                        PageHelper.javascriptClick(driver, closeButtonInForm);
                        isMessageDisplayed = true;
                    }

                }

            }
        } catch(Exception ae)
        {
            Assert.fail(String.valueOf(ae));
            return isMessageDisplayed;
        }
        System.out.println("Status of isMessageDisplayed "+isMessageDisplayed);
        return isMessageDisplayed;
    }


    public boolean isOpportunitySuccessfullyCreated() {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.titleIs(detailsPageTitle));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean isAddNewOpportunityFormDisplayed() {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.and(
                        ExpectedConditions.visibilityOf(createOpportunityHeaderInForm),
                        ExpectedConditions.elementToBeClickable(opportunityName),
                        ExpectedConditions.elementToBeClickable(opportunityFolder),
                        ExpectedConditions.elementToBeClickable(opportunityEstimatedAmount)));
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
                            ExpectedConditions.visibilityOf(addNewCustomerHeaderInForm),
                            ExpectedConditions.elementToBeClickable(companyIndustryType),
                            ExpectedConditions.elementToBeClickable(companyCountry),
                            ExpectedConditions.elementToBeClickable(companyTags)));
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

    public boolean validateErrors(HashMap<String, String> opportunityValidationMessage, ArrayList<String> capturedMessages) {
        boolean isErrorPresent = false;
        for (Map.Entry<String, String> entry : opportunityValidationMessage.entrySet())
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

    public  <T> void selectIndustryTypeDropdown(WebDriver driver, HashMap<T, T> hashmap, WebElement element, String keyName,String option) {
        String xPath = "//*[contains(., '" + option + "')]";
        if (hashmap.containsKey(keyName)) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            try {
                if (option == null || option.isEmpty())
                {
                    addNewCustomerHeaderInForm.click();
                }
                else {
                    List<WebElement> elements = driver.findElements(By.xpath(xPath));
                    Thread.sleep(1000);
                    WebElement selection = elements.get(elements.size() - 1);
                    wait.until(ExpectedConditions.elementToBeClickable(selection));
                    Thread.sleep(1000);
                    selection.click();
                    Thread.sleep(1000);
                }


            } catch (Exception e)
            {
                Assert.fail(String.valueOf(e));
            }
        }
    }

    public static void selectAccountOwner(WebDriver driver, WebElement element, String option) {

        String xPath = "//mat-option//span[contains(., '" + option + "')]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            Thread.sleep(1000);
            List<WebElement> elements = driver.findElements(By.xpath(xPath));
            Thread.sleep(1000);
            WebElement selection = elements.get(elements.size() - 1);
            wait.until(ExpectedConditions.elementToBeClickable(selection));
            Thread.sleep(1000);
            selection.click();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(String.valueOf(e));
        }
    }

}