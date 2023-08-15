package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.PageHelper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CustomiseColumnsPage extends AbstractBasePage {
    private WebDriver driver;
    private AddressbookPage addressbookPage;

    private OpportunityListPage opportunityListPage;

    public CustomiseColumnsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.addressbookPage = new AddressbookPage(driver);
        this.opportunityListPage=new OpportunityListPage(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    @FindBy(xpath = "//span[.='Customize Columns']")
    private WebElement customizeColumns;

    @FindBy(xpath = "//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;
//    @FindBy(xpath = "")
//    private WebElement;
//    @FindBy(xpath = "")
//    private WebElement;
//    @FindBy(xpath = "")
//    private WebElement;
//    @FindBy(xpath = "")
//    private WebElement;
//    @FindBy(xpath = "")
//    private WebElement;
//    @FindBy(xpath = "")
//    private WebElement;


    List<String> contactColumnHeaders = new ArrayList<String>();

    List<String> companyColumnHeaders = new ArrayList<String>();

    List<String> opportunityColumnHeaders = new ArrayList<String>();

    public void buildContactColumnHeaderList() {
        contactColumnHeaders.add("Contact");
        contactColumnHeaders.add("Email");
        contactColumnHeaders.add("Company");
        contactColumnHeaders.add("Designation");
        contactColumnHeaders.add("Mobile");
        contactColumnHeaders.add("Country");
        contactColumnHeaders.add("City");
        contactColumnHeaders.add("Added On");
        contactColumnHeaders.add("Updated On");
        contactColumnHeaders.add("Lead Source");
        contactColumnHeaders.add("Last Note");
        contactColumnHeaders.add("Last Note Updated");
        contactColumnHeaders.add("Industry Type");
        contactColumnHeaders.add("State");
        contactColumnHeaders.add("ZIP/Postal Code");
        //contactColumnHeaders.add("Unknown");
    }

    public void  buildCompanyColumnHeaderList() {
        companyColumnHeaders.add("Owner");
        companyColumnHeaders.add("Industry");
        companyColumnHeaders.add("Country");
        companyColumnHeaders.add("City");
        companyColumnHeaders.add("State");
        companyColumnHeaders.add("ZIP/Postal Code");

    }

    public void  buildOpportunityColumnHeaderList()
    {
        
            opportunityColumnHeaders.add("Owner");
            opportunityColumnHeaders.add("Reference No.");
            opportunityColumnHeaders.add("Customer");
            opportunityColumnHeaders.add("Stage");
            opportunityColumnHeaders.add("Close Date");
            opportunityColumnHeaders.add("Country");
            opportunityColumnHeaders.add("City");
            opportunityColumnHeaders.add("Value");
            opportunityColumnHeaders.add("Estimated Hours");
            opportunityColumnHeaders.add("Email");
            opportunityColumnHeaders.add("Last Note");
            opportunityColumnHeaders.add("Project Type");
            opportunityColumnHeaders.add("Submission");
            opportunityColumnHeaders.add("State");
            opportunityColumnHeaders.add("ZIP/Postal Code");
        
    }

    public boolean customiseColumns(List<String> columnHeaders) {
        boolean isColumnNameDisplayed = false;
        try {

            PageHelper.javascriptClick(driver, customizeColumns);
            List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='cdk-overlay-pane']//mat-checkbox/label"));
            for (int j = 0; j < columnHeaders.size(); j++) {
                for (int i = 0; i < checkboxes.size(); i++) {
                    isColumnNameDisplayed = false;
                    if (columnHeaders.get(j).equals(checkboxes.get(i).getText())) {
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                        if (checkboxes.get(i).findElement(By.tagName("input")).isSelected()) {
                            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//thead//th[contains(.,'" + columnHeaders.get(j) + "')]")));
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead//th[contains(.,'" + columnHeaders.get(j) + "')]")));
                            isColumnNameDisplayed = true;
                            break;

                        }
                        if (!checkboxes.get(i).findElement(By.tagName("input")).isSelected()) {
                            PageHelper.javascriptClick(driver, checkboxes.get(i).findElement(By.tagName("input")));
                            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//thead//th[contains(.,'" + columnHeaders.get(j) + "')]")));
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead//th[contains(.,'" + columnHeaders.get(j) + "')]")));
                            isColumnNameDisplayed = true;
                            break;
                        }
                    }

                }

            }
            //System.out.println("isColumnNameDisplayed  is" + isColumnNameDisplayed);
        } catch (Exception e)
        {
            e.printStackTrace();
            isColumnNameDisplayed = false;
        }
        return isColumnNameDisplayed;
    }

    public boolean verifyContactCustomiseColumns()
    {
        buildContactColumnHeaderList();
        addressbookPage.clickAddressbook();
        Assert.assertTrue(addressbookPage.isDisplayed());
        PageHelper.invisibilityOfElement(driver, loader);
        return customiseColumns(contactColumnHeaders);
    }

    public boolean verifyCompanyCustomiseColumns()
    {
        buildCompanyColumnHeaderList();
        addressbookPage.clickAddressbook();
        Assert.assertTrue(addressbookPage.isDisplayed());
        PageHelper.invisibilityOfElement(driver, loader);
        PageHelper.javascriptClick(driver,addressbookPage.getCompaniesMenu());
        PageHelper.invisibilityOfElement(driver, loader);
        return customiseColumns(companyColumnHeaders);
    }

    public boolean verifyOpportunityCustomiseColumns()
    {
        buildOpportunityColumnHeaderList();
        opportunityListPage.getOpportunityPage();
        PageHelper.invisibilityOfElement(driver, loader);
        return customiseColumns(opportunityColumnHeaders);
    }
}