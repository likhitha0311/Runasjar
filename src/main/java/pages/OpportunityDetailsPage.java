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

public class OpportunityDetailsPage extends AbstractBasePage
{

    private WebDriver driver;
    private OpportunityPage opportunityPage;
    private NotesPage notesPage;

    private DocumentsPage documentsPage;

    public OpportunityDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.opportunityPage = new OpportunityPage(driver);
        this.notesPage = new NotesPage(driver);
        this.documentsPage = new DocumentsPage(driver);
        PageFactory.initElements(driver, this);
    }

    String detailsPageTitle=".studio | Opportunities Details";

    @FindBy(xpath="//button[.='Create Opportunity']")
    private WebElement createOpportunityButton;

    @FindBy(xpath = "//label[.='Name']/following-sibling::h5")
    private WebElement displayedOpportunityName;

    @FindBy(xpath = "//label[.='Customer']/following-sibling::h5")
    private WebElement displayedCustomer;

    @FindBy(xpath = "//label[.='Estimated Value']/following-sibling::h5")
    private WebElement displayedEstimatedValue;

    @FindBy(xpath = "//label[.='Tax']/following-sibling::h5")
    private WebElement displayedTax;

    @FindBy(xpath = "//label[.='Opportunity Folder']/following-sibling::h5/u")
    private WebElement displayedOpportunityFolder;

    @FindBy(xpath = "//label[.='Project Type']/ancestor::div/mat-chip-list//mat-chip")
    private WebElement displayedProjectType;

    @FindBy(xpath = "//label[.='Service Type']/ancestor::div/mat-chip-list//mat-chip")
    private WebElement displayedServiceType;

    @FindBy(xpath = "//label[.='Tags']/ancestor::div/mat-chip-list//mat-chip")
    private WebElement displayedOpportunityTags;

    @FindBy(xpath = "//label[.='State']/following-sibling::h5")
    private WebElement displayedOpportunityState;

    @FindBy(xpath = "//label[.='ZIP/Postal Code']/following-sibling::h5")
    private WebElement displayedOpportunityZip;

    @FindBy(xpath = "//label[.='Address']/following-sibling::h5")
    private WebElement displayedOpportunityAddress;

    @FindBy(xpath = "//label[.='City']/following-sibling::h5")
    private WebElement displayedOpportunityCity;

    @FindBy(xpath = "//label[.='Country']/following-sibling::h5")
    private WebElement displayedOpportunityCountry;

    @FindBy(xpath = "//mat-expansion-panel//button[contains(.,'Edit')]")
    private WebElement editOpportunityButton;

    @FindBy(xpath = "(//mat-expansion-panel//button[contains(.,'Edit')])[2]")
    private WebElement editOpportunityLocationButton;

    @FindBy(xpath = "//h2[.='Edit Opportunity']")
    private WebElement editOpportunityheader;

    @FindBy(id="opportunityDialogOwnerMenu")
    private WebElement opportunityOwner;
    @FindBy(xpath = "//form//button[contains(.,'Update Opportunity')]")
    private WebElement updateOpportunityButton;

    @FindBy(xpath = " //mat-chip//mat-icon[.='cancel']")
    private WebElement cancelTags;

    @FindBy(xpath = "//div[contains(@class,'medium-scrollbar')]")
    private WebElement scrollbar;

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Opportunity updated successfully']")
    private WebElement opportunityUpdateMessage;

    @FindBy(xpath = "//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;

    @FindBy(id="opportunityDialogOpportunityName")
    private WebElement opportunityName;

    @FindBy(xpath="//app-create-opportunity//form//input[@aria-owns='opportunity-type_options']")
    private WebElement serviceTypeDropdown;

    @FindBy(xpath="//input[@data-placeholder='Opportunity Folder']")
    private WebElement opportunityFolder;

    @FindBy(xpath="//input[@data-placeholder='Reference Number']")
    private WebElement referenceNumber;

    @FindBy(xpath="//app-create-opportunity//mat-icon[@svgicon='inv-calendar']")
    private WebElement calenderIcon;

    @FindBy(xpath="//td//div[.=' 20 ']")
    private WebElement closeDate;

    @FindBy(xpath="//app-create-opportunity//mat-select[@placeholder='Project Type']")
    private WebElement projectTypeDropdown;

    @FindBy(id="opportunityDialogEstimateValue")
    private WebElement opportunityEstimatedAmount;

    @FindBy(id="opportunityVat")
    private WebElement opportunityTax;

    @FindBy(xpath="//app-create-opportunity//mat-select[@placeholder='Country']")
    private WebElement opportunityCountry;

    @FindBy(xpath="//app-create-opportunity//form//input[@name='state']")
    private WebElement opportunityState;

    @FindBy(id="opportunityDialogCity")
    private WebElement opportunityCity;

    @FindBy(xpath="//app-create-opportunity//form//input[@name='zip']")
    private WebElement opportunityZipCode;

    @FindBy(id="opportunityDialogAddress")
    private WebElement opportunityAddress;


    @FindBy(xpath="//app-create-opportunity//form//input[@placeholder='Tags']")
    private WebElement opportunityTags;

    @FindBy(id="opportunityDialogCustomer")
    private WebElement opportunityCustomer;

    @FindBy(xpath ="//app-create-opportunity//form//button[contains(.,'Next')]")
    private WebElement nextButton;


    @FindBy(xpath = "//app-new-company//form//input[@aria-owns='industry_type_options']")
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
    private WebElement createButtonInsideEditOpportunityForm;

    @FindBy(xpath = "//app-msg-dialog//button[.='Discard Changes']")
    private WebElement discardChangesButtonInPopUp;

    @FindBy(xpath = "//app-msg-dialog//button[.='cancel']")
    private WebElement cancelButtonInPopUp;

    @FindBy(xpath = "//app-create-opportunity//mat-icon[@svgicon='inv-times-circle']")
    private WebElement closeButtonInForm;

    @FindBy(xpath = "//mat-icon[@svgicon='inv-filter']")
    private WebElement filter;

    @FindBy(id = "filter-panel-clear-all")
    private WebElement clearAll;

    @FindBy(xpath = "//tbody/tr[1]//b")
    private WebElement firstResult;

    @FindBy(xpath = "//h2[.='Add Customer']")
    private WebElement addCustomerHeaderInForm;

    @FindBy(xpath="//button[.='New Note']")
    private WebElement newNoteButton;

    @FindBy(xpath = "//app-create-opportunity//h2[.='Add Customer']")
    private WebElement addNewCustomerHeaderInForm;

    @FindBy(xpath = "//h2[.='Edit Location']")
    private WebElement  editLocationHeader;



    public <T extends BaseData> boolean editOpportunity(T obj, HashMap<String, String>[] editOpportunityTestData, HashMap<String, String>[] createOpportunityTestData) {
        boolean isOpportunityEdited = false;
        try {
            obj.generateDataForUpdateOpportunity();
            for (int i = 0; i < editOpportunityTestData.length; i++) {
                this.opportunityPage.clickOpportunitiesMenu();
                Assert.assertTrue(this.opportunityPage.isOpportunityPageDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                searchValue(driver, this.opportunityPage.getListMenu(), createOpportunityTestData[i].get("Opportunity Name"));
                Assert.assertTrue(isOpportunityDetailsPageDisplayed());
                PageHelper.scrollToView(driver, editOpportunityButton);
                PageHelper.javascriptClick(driver, editOpportunityButton);
                Assert.assertTrue(isEditOpportunityFormDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.sendData(driver, opportunityName, editOpportunityTestData[i], "Opportunity Name");
                serviceTypeDropdown.click();
                Thread.sleep(1000);
                clearChips();
                PageHelper.selectElementInDropdown(driver, serviceTypeDropdown, editOpportunityTestData[i].get("Service Type"));
                PageHelper.selectElementInDropdown(driver,projectTypeDropdown,editOpportunityTestData[i].get("Project Type"));
                projectTypeDropdown.sendKeys(Keys.ESCAPE);
                PageHelper.sendData(driver, opportunityFolder, editOpportunityTestData[i], "Opportunity Folder");
                PageHelper.javascriptClick(driver, calenderIcon);
                PageHelper.javascriptClick(driver, closeDate);
                PageHelper.sendData(driver, opportunityEstimatedAmount, editOpportunityTestData[i], "Opportunity Estimated Amount");
                PageHelper.sendData(driver, opportunityTax, editOpportunityTestData[i], "Opportunity Tax");
                PageHelper.cancelTags(driver, cancelTags);
                PageHelper.sendData(driver,opportunityTags, editOpportunityTestData[i], "Opportunity Tags");
                opportunityTags.sendKeys(Keys.ENTER);
                PageHelper.clearText(driver, opportunityCustomer);
                Thread.sleep(2000);
                if (editOpportunityTestData[i].get("Customer Type").equals("Existing")) {
                    PageHelper.sendData(driver, opportunityCustomer, editOpportunityTestData[i], "Customer");
                    PageHelper.javascriptClick(driver, updateOpportunityButton);
                    PageHelper.invisibilityOfElement(driver, loader);
                }
                else if (editOpportunityTestData[i].get("Customer Type").equals("New Customer")) {
                    PageHelper.sendData(driver, opportunityCustomer, editOpportunityTestData[i], "Customer");
                    Assert.assertTrue(PageHelper.isButtonEnabled(driver, nextButton));
                    PageHelper.javascriptClick(driver, nextButton);
                    PageHelper.invisibilityOfElement(driver, loader);
                    Assert.assertTrue(isAddCustomerFormDisplayed());
                    PageHelper.selectElementInDropdown(driver, editIndustryType, editOpportunityTestData[i].get("Customer Industry Type"));
                    PageHelper.selectElementInDropdown(driver, editCountry, editOpportunityTestData[i].get("Customer Country"));
                    PageHelper.sendData(driver, editCity, editOpportunityTestData[i], "Customer City");
                    PageHelper.sendData(driver, editState, editOpportunityTestData[i], "Customer State");
                    PageHelper.sendData(driver, editZipcode, editOpportunityTestData[i], "Customer Zip");
                    PageHelper.sendData(driver, editAddress, editOpportunityTestData[i], "Customer Address");
                    PageHelper.sendData(driver, editCompanyTelephone, editOpportunityTestData[i], "Customer Telephone");
                    PageHelper.sendData(driver, editCompanyFax, editOpportunityTestData[i], "Customer Fax");
                    PageHelper.sendData(driver, editCompanyEmail, editOpportunityTestData[i], "Customer Email");
                    PageHelper.sendData(driver, editCompanyTags, editOpportunityTestData[i], "Customer Tags");
                    PageHelper.sendData(driver, editCompanyWebsite, editOpportunityTestData[i], "Customer Website");
                    Assert.assertTrue(PageHelper.isButtonEnabled(driver, createButtonInsideEditOpportunityForm));
                    PageHelper.invisibilityOfElement(driver, loader);
                    PageHelper.javascriptClick(driver, createButtonInsideEditOpportunityForm);
                    PageHelper.invisibilityOfElement(driver, loader);
                }
                boolean outcome = isOpportunitySuccessfullyUpdated();
                if (outcome) {
                    isOpportunityEdited = true;

                } else {
                    isOpportunityEdited = false;
                    break;
                }
            }

        } catch (Exception ae) {
            Assert.fail(String.valueOf(ae));
            return isOpportunityEdited;
        }
        return isOpportunityEdited;
    }

    public <T extends BaseData> boolean editOpportunityLocation(T obj, HashMap<String, String>[] editOpportunityTestData, HashMap<String, String>[] createOpportunityTestData) {
        boolean isOpportunityEdited = false;
        try {
            obj.generateDataForUpdateOpportunityLocation();
            for (int i = 0; i < editOpportunityTestData.length; i++)
            {
                this.opportunityPage.clickOpportunitiesMenu();
                Assert.assertTrue(this.opportunityPage.isOpportunityPageDisplayed());
                PageHelper.invisibilityOfElement(driver, loader);
                searchValue(driver, this.opportunityPage.getListMenu(), createOpportunityTestData[i].get("Opportunity Name"));
                Assert.assertTrue(isOpportunityDetailsPageDisplayed());
                PageHelper.scrollToView(driver,  editOpportunityLocationButton);
                PageHelper.javascriptClick(driver, editOpportunityLocationButton);
                Assert.assertTrue(isOpportunityLocationDetailsPageDisplayed());
                PageHelper.sendData(driver, opportunityCity, editOpportunityTestData[i], "Opportunity City");
                PageHelper.sendData(driver, opportunityState, editOpportunityTestData[i], "Opportunity State");
                PageHelper.sendData(driver, opportunityZipCode, editOpportunityTestData[i], "Opportunity Zip");
                PageHelper.sendData(driver, opportunityZipCode, editOpportunityTestData[i], "Opportunity Address");
                PageHelper.selectElementInDropdown(driver, opportunityCountry, editOpportunityTestData[i].get("Opportunity Country"));
                PageHelper.javascriptClick(driver, updateOpportunityButton);
                PageHelper.invisibilityOfElement(driver, loader);
                boolean outcome = isOpportunitySuccessfullyUpdated();
                if (outcome) {
                    isOpportunityEdited = true;

                } else
                {
                    isOpportunityEdited = false;
                    break;
                }
            }

        } catch (Exception ae) {
            Assert.fail(String.valueOf(ae));
            return isOpportunityEdited;
        }
        return isOpportunityEdited;
    }

    public <T extends BaseData> boolean editOpportunityLocationNegative(T obj, HashMap<String, String>[] editOpportunityTestData,  HashMap<String, String>[] opportunityLocationValidationMessages) {
        boolean isMessageDisplayed = false;
        try {
            obj.generateDataForEditOpportunityLocationNegativeTesting();
            obj.generateEditOpportunityLocationValidationMessages();
            for (int i = 0; i < editOpportunityTestData.length; i++) {
                isMessageDisplayed = false;
                getFirstOpportunity();
                PageHelper.scrollToView(driver, editOpportunityLocationButton);
                PageHelper.javascriptClick(driver,editOpportunityLocationButton);
                Assert.assertTrue(isOpportunityLocationDetailsPageDisplayed());
                Thread.sleep(2000);
                PageHelper.sendData(driver, opportunityCity, editOpportunityTestData[i], "Opportunity City");
                PageHelper.sendData(driver, opportunityState, editOpportunityTestData[i], "Opportunity State");
                PageHelper.sendData(driver, opportunityZipCode, editOpportunityTestData[i], "Opportunity Zip");
                PageHelper.sendData(driver, opportunityAddress, editOpportunityTestData[i], "Opportunity Address");
                PageHelper.selectElementInDropdown(driver, opportunityCountry, editOpportunityTestData[i].get("Opportunity Country"));
                editLocationHeader.click();
                if(PageHelper.isButtonEnabled(driver,updateOpportunityButton))
                {
                    Assert.assertTrue(getAllErrorMessages().size()==0);
                    PageHelper.javascriptClick(driver, updateOpportunityButton);
                    PageHelper.invisibilityOfElement(driver, loader);
                    isMessageDisplayed = true;
                    break;
                    
                }
                else
                {
                    Assert.assertTrue(validateErrors(opportunityLocationValidationMessages[i], getAllErrorMessages()));
                    PageHelper.javascriptClick(driver, closeButtonInForm);
                    isMessageDisplayed = true;
                }

            }

        } catch (Exception ae)
        {
            Assert.fail(String.valueOf(ae));
            return isMessageDisplayed;
        }
        return isMessageDisplayed;
    }

    public <T extends BaseData> boolean editOpportunityNegative(T obj, HashMap<String, String>[] editOpportunityTestData,HashMap<String, String>[] opportunityValidationMessages) {
        boolean isMessageDisplayed = false;
        try {
            obj.generateEditOpportunityValidationMessages();
            obj.generateDataForEditOpportunityNegativeTesting();
            for (int i = 0; i < editOpportunityTestData.length; i++)
            {
                isMessageDisplayed = false;
                getFirstOpportunity();
                PageHelper.scrollToView(driver, editOpportunityButton);
                PageHelper.javascriptClick(driver, editOpportunityButton);
                Assert.assertTrue(isEditOpportunityFormDisplayed());
                Thread.sleep(3000);
                PageHelper.sendData(driver, opportunityName, editOpportunityTestData[i], "Opportunity Name");
                Thread.sleep(1000);
                serviceTypeDropdown.click();
                clearChips();
                Thread.sleep(1000);
                PageHelper.selectElementInDropdown(driver, serviceTypeDropdown, editOpportunityTestData[i].get("Service Type"));
                PageHelper.selectElementInMatOptionDropdown(driver, projectTypeDropdown, editOpportunityTestData[i].get("Project Type"));
                projectTypeDropdown.sendKeys(Keys.ESCAPE);
                PageHelper.sendData(driver, opportunityFolder, editOpportunityTestData[i], "Opportunity Folder");
                PageHelper.javascriptClick(driver, calenderIcon);
                PageHelper.javascriptClick(driver, closeDate);
                PageHelper.sendData(driver, opportunityEstimatedAmount, editOpportunityTestData[i], "Opportunity Estimated Amount");
                PageHelper.sendData(driver, opportunityTax, editOpportunityTestData[i], "Opportunity Tax");
                selectAccountOwner(driver, opportunityOwner, editOpportunityTestData[i].get("Opportunity Owner"));
                Thread.sleep(1000);
                PageHelper.sendData(driver, opportunityCustomer, editOpportunityTestData[i], "Customer");
                PageHelper.cancelTags(driver, cancelTags);
                PageHelper.sendData(driver, opportunityTags, editOpportunityTestData[i], "Opportunity Tags");
                opportunityTags.sendKeys(Keys.ENTER);
                editOpportunityheader.click();
                if (editOpportunityTestData[i].get("Customer Type").equals("Existing")) {
                    if (PageHelper.isButtonEnabled(driver,updateOpportunityButton))
                    {
                        Assert.assertTrue(getAllErrorMessages().size() == 0);
                        PageHelper.javascriptClick(driver, updateOpportunityButton);
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
                else if (editOpportunityTestData[i].get("Customer Type").equals("New Customer"))
                {
                    if (PageHelper.isButtonEnabled(driver, nextButton)) {
                        Assert.assertTrue(getAllErrorMessages().size() == 0);
                        PageHelper.javascriptClick(driver, nextButton);
                        PageHelper.invisibilityOfElement(driver, loader);
                        Assert.assertTrue(isAddCustomerFormDisplayed());
                        selectIndustryTypeDropdown(driver, editOpportunityTestData[i], editIndustryType,  "Customer Industry Type", editOpportunityTestData[i].get("Customer Industry Type"));
                        PageHelper.selectElementInDropdownForNegativeTesting(driver, editOpportunityTestData[i], editCountry, cancelButtonInPopUp, "Customer Country", editOpportunityTestData[i].get("Customer Country"));
                        PageHelper.sendData(driver, editCity, editOpportunityTestData[i], "Customer City");
                        PageHelper.sendData(driver, editState, editOpportunityTestData[i], "Customer State");
                        PageHelper.sendData(driver, editZipcode, editOpportunityTestData[i], "Customer Zip");
                        PageHelper.sendData(driver, editAddress, editOpportunityTestData[i], "Customer Address");
                        PageHelper.sendData(driver, editCompanyTelephone, editOpportunityTestData[i], "Customer Telephone");
                        PageHelper.sendData(driver, editCompanyFax, editOpportunityTestData[i], "Customer Fax");
                        PageHelper.sendData(driver, editCompanyEmail, editOpportunityTestData[i], "Customer Email");
                        PageHelper.sendData(driver, editCompanyTags, editOpportunityTestData[i], "Customer Tags");
                        PageHelper.sendData(driver, editCompanyWebsite, editOpportunityTestData[i], "Customer Website");
                        addNewCustomerHeaderInForm.click();
                        if (PageHelper.isButtonEnabled(driver, createButtonInsideEditOpportunityForm))
                        {
                            Assert.assertTrue(getAllErrorMessages().size() == 0);
                            PageHelper.javascriptClick(driver, createButtonInsideEditOpportunityForm);
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
            ae.printStackTrace();
            Assert.fail(String.valueOf(ae));
            return isMessageDisplayed;
        }
        System.out.println("Status of isMessageDisplayed "+isMessageDisplayed);
        return isMessageDisplayed;
    }
    public boolean validateOpportunityDetails(HashMap<String, String>[] opportunityData) {
        for (int i = 0; i < opportunityData.length; i++) {
            this.opportunityPage.clickOpportunitiesMenu();
            Assert.assertTrue(this.opportunityPage.isOpportunityPageDisplayed());
            PageHelper.invisibilityOfElement(driver, loader);
            searchValue(driver, this.opportunityPage.getListMenu(), opportunityData[i].get("Opportunity Name"));
            Assert.assertTrue(PageHelper.isTitleDisplayed(driver, detailsPageTitle));
            for (String key : opportunityData[i].keySet()) {
                switch (key) {
                    case "Opportunity Name": {
                        String name = PageHelper.getText(driver, displayedOpportunityName);
                        if (name.equals(opportunityData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Customer": {
                        String customer = PageHelper.getText(driver, displayedCustomer);
                        if (customer.equals(opportunityData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Opportunity Estimated Value": {
                        String estimatedValue = PageHelper.getText(driver, displayedEstimatedValue);
                        if (estimatedValue.contains(opportunityData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Opportunity Tax": {
                        String tax = PageHelper.getText(driver, displayedTax);
                        if (tax.contains(opportunityData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Opportunity Folder": {
                        String opportunityFolder = PageHelper.getText(driver, displayedOpportunityFolder);
                        System.out.println("opportunityFolder text from UI is "+opportunityFolder);
                        System.out.println("opportunityFolder text from data is "+opportunityData[i].get(key));
                        if (opportunityFolder.equals(opportunityData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Service Type": {
                        String serviceType = PageHelper.getText(driver, displayedServiceType);
                        if (serviceType.equals(opportunityData[i].get(key).toUpperCase())) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }

                    case "Project Type": {
                        String projectType = PageHelper.getText(driver, displayedProjectType);
                        if (projectType.equals(opportunityData[i].get(key).toUpperCase())) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Opportunity Tags": {
                        String OpportunityTags = PageHelper.getText(driver, displayedOpportunityTags);
                        if (OpportunityTags.equals(opportunityData[i].get(key).toUpperCase())) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                   
                    case "Opportunity Country": {
                        String country = PageHelper.getText(driver, displayedOpportunityCountry);
                        if (country.equals(opportunityData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                   
                    case "Opportunity Address": {
                        String OpportunityAddress = PageHelper.getText(driver, displayedOpportunityAddress);
                        System.out.println("Displayed address is " + OpportunityAddress);
                        if (OpportunityAddress.equals(opportunityData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Opportunity State": {
                        String OpportunityState = PageHelper.getText(driver, displayedOpportunityState);
                        System.out.println("Displayed OpportunityState is " + OpportunityState);
                        if (OpportunityState.equals(opportunityData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Opportunity Zip": {
                        String OpportunityZip = PageHelper.getText(driver, displayedOpportunityZip);
                        System.out.println("Displayed OpportunityZip  is " + OpportunityZip);
                        if (OpportunityZip.equals(opportunityData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + key);
                        break;
                    }
                    case "Opportunity City": {
                        String OpportunityCity = PageHelper.getText(driver, displayedOpportunityCity);
                        System.out.println("Displayed OpportunityCity  is " + OpportunityCity);
                        if (OpportunityCity.equals(opportunityData[i].get(key))) {
                            Assert.assertTrue(true);
                            break;
                        }
                        Assert.fail("Text on the UI is different from testdata for " + OpportunityCity);
                        break;
                    }
                    default:
                        System.out.println(opportunityData[i].get(key) + " is not displayed because info is related to customer");

                }
            }
        }
        return true;
    }
    public boolean isOpportunityDetailsPageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.titleIs(detailsPageTitle),
                    ExpectedConditions.elementToBeClickable(editOpportunityButton),
                    ExpectedConditions.elementToBeClickable(newNoteButton)));
            ExpectedConditions.invisibilityOf(loader);
            return true;

        } catch (TimeoutException te) {
            //Assert.fail(String.valueOf(te));
            te.printStackTrace();
            return false;
        }
    }

    public boolean isEditOpportunityFormDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(editOpportunityheader),
                    ExpectedConditions.elementToBeClickable(opportunityName),
                    ExpectedConditions.elementToBeClickable(opportunityFolder),
                    ExpectedConditions.elementToBeClickable(opportunityEstimatedAmount)));
            return true;
        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }
    }

    public boolean isOpportunityLocationDetailsPageDisplayed()
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(editLocationHeader),
                    ExpectedConditions.invisibilityOf(loader),
                    ExpectedConditions.elementToBeClickable(opportunityAddress),
                    ExpectedConditions.elementToBeClickable(opportunityZipCode),
                    ExpectedConditions.elementToBeClickable(opportunityCountry)));
            return true;
        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }
    }

    public boolean isOpportunitySuccessfullyUpdated() {
        return PageHelper.validateConfirmationMessage(driver, opportunityUpdateMessage);
    }

    public boolean isAddCustomerFormDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(addCustomerHeaderInForm),
                    ExpectedConditions.elementToBeClickable(editIndustryType),
                    ExpectedConditions.elementToBeClickable(editCountry),
                    ExpectedConditions.elementToBeClickable(editCompanyTags)));
            return true;
        } catch (TimeoutException te) {
            Assert.fail(String.valueOf(te));
            return false;
        }
    }

    public void clearChips()
    {

            List<WebElement> chips = driver.findElements(By.xpath("//span[@class='e-chips']"));
            for (WebElement e : chips) {
                e.findElement(By.xpath("//span[@class='e-chips-close']")).click();
            }

    }

    public <T extends BaseData> boolean addOpportunityNotes(T obj, HashMap<String, String>[] notesTestData) {
        getFirstOpportunity();
        return notesPage.addNotes(obj, notesTestData);
    }

    public <T extends BaseData> boolean addOpportunityNotesNegative(T obj, HashMap<String, String>[] notesTestData, HashMap<String, String>[] notesValidationMessages) {
        getFirstOpportunity();
        return notesPage.addNotesNegative(obj, notesTestData, notesValidationMessages);
    }

    public <T extends BaseData> boolean editOpportunityNotesNegative(T obj, HashMap<String, String>[] notesTestData, HashMap<String, String>[] notesValidationMessages) {
        getFirstOpportunity();
        return notesPage.editNotesNegative(obj, notesTestData, notesValidationMessages);
    }


    public <T extends BaseData> boolean editOpportunityNotes(T obj, HashMap<String, String>[] notesTestData)
    {

        getFirstOpportunity();
        return notesPage.editNotes(obj, notesTestData);

    }


    public boolean validateDeleteOpportunityNotes()
    {   getFirstOpportunity();
        return notesPage.validateDeleteNotes();
    }

    public <T extends BaseData> boolean addOpportunityDocuments(T obj, HashMap<String, String>[] documentsTestData)
    {
        getFirstOpportunity();
        return documentsPage.addDocuments(obj, documentsTestData);
    }

    public <T extends BaseData> boolean addOpportunityDocumentsNegative(T obj, HashMap<String, String>[] documentsTestData, HashMap<String, String>[] documentsValidationMessages) {
        getFirstOpportunity();
        return documentsPage.addDocumentsNegative(obj, documentsTestData, documentsValidationMessages);
    }

    public <T extends BaseData> boolean editOpportunityDocuments(T obj, HashMap<String, String>[] documentsTestData)
    {
        getFirstOpportunity();
        return documentsPage.editDocuments(obj, documentsTestData);
    }

    public boolean deleteOpportunityDocuments()
    {
        getFirstOpportunity();
        return documentsPage.validateDeleteDocument();
    }

    public void getFirstOpportunity() {

        this.opportunityPage.clickOpportunitiesMenu();
        Assert.assertTrue(this.opportunityPage.isOpportunityPageDisplayed());
        PageHelper.invisibilityOfElement(driver, loader);
        clearFiltersAndSearch(driver, filter, clearAll);
        PageHelper.javascriptClick(driver,firstResult);;
        Assert.assertTrue(isOpportunityDetailsPageDisplayed());
        PageHelper.invisibilityOfElement(driver, loader);

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


}