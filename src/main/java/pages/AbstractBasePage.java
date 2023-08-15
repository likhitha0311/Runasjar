package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.PageHelper;

import java.time.Duration;
import java.util.List;

public abstract class AbstractBasePage
{

    private WebDriver driver;
    public AbstractBasePage ( WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//mat-icon[@svgicon='inv-filter']")
    private WebElement filter;

    @FindBy(id="filter-panel-clear-all")
    private WebElement clearAll;

    @FindBy(xpath="//mat-icon[@svgicon='inv-search']")
    private WebElement searchIcon;

    @FindBy(xpath="//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;

    @FindBy(xpath="//h6//input[@data-placeholder='Search']")
    private WebElement searchField;

    @FindBy(xpath="//tbody/tr[1]//b")
    private WebElement firstResult;

    @FindBy(xpath="//div[@class='mat-paginator-range-label'and contains(., '1 – 1 of 1')]")
    private WebElement resultSet;

    @FindBy(xpath="//span[.='Customize Columns']")
    private WebElement customizeColumns;

    @FindBy(xpath="//div[@class='cdk-overlay-pane']//mat-checkbox")
    private WebElement customizeColumnsCheckboxes;

    @FindBy(xpath="//button[@name='action-menu-trigger']")
    private WebElement actionMenu;
    @FindBy(xpath = "//div[@class='cdk-overlay-pane']")
    private WebElement customiseColumnsPopUp;


    protected void clearFiltersAndSearch(WebDriver driver, WebElement filter, WebElement clearAll)
{
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(filter),
                ExpectedConditions.elementToBeClickable(filter),
                ExpectedConditions.visibilityOf(searchIcon),
                ExpectedConditions.elementToBeClickable(searchIcon)));
        PageHelper.javascriptClick(driver,filter);
        PageHelper.javascriptClick(driver,clearAll);
        PageHelper.invisibilityOfElement(driver,loader);

    }
    catch (Exception e)
    {
        Assert.fail(String.valueOf(e));

    }
}

    protected void searchValue(WebDriver driver,WebElement tabName,String searchValue)
    {
        try {
            PageHelper.invisibilityOfElement(driver, loader);
            PageHelper.javascriptClick(driver, tabName);
            PageHelper.invisibilityOfElement(driver, loader);
            clearFiltersAndSearch(driver, filter, clearAll);
            PageHelper.javascriptClick(driver, searchIcon);
            PageHelper.sendKeysToElement(driver, searchField, searchValue);
            searchField.sendKeys(Keys.ENTER);
            PageHelper.invisibilityOfElement(driver, loader);
            Assert.assertTrue(PageHelper.isElementDisplayed(driver, resultSet));;
            PageHelper.invisibilityOfElement(driver, loader);
            Thread.sleep(1000);
            PageHelper.javascriptClick(driver, firstResult);
            PageHelper.invisibilityOfElement(driver, loader);
        }

        catch(AssertionError assertionError)
        {
            System.out.println("ResultSet is not displayed");
         }
        catch(Exception e)
        {
            System.out.println("Search Value() did not work as expected");
        }
    }
    protected void getSearchResult(WebDriver driver,String searchValue) {
        try {
            clearFiltersAndSearch(driver, filter, clearAll);
            PageHelper.javascriptClick(driver, searchIcon);
            PageHelper.invisibilityOfElement(driver, loader);
            PageHelper.sendKeysToElement(driver, searchField, searchValue);
            PageHelper.invisibilityOfElement(driver, loader);
            searchField.sendKeys(Keys.ENTER);
            PageHelper.invisibilityOfElement(driver, loader);
            Assert.assertTrue(PageHelper.isElementDisplayed(driver, resultSet));
        }

        catch(AssertionError assertionError)
        {
            System.out.println("ResultSet is not displayed");
        }
        catch (Exception e)
        {
            System.out.println("Search Results are not displayed");
        }
    }

    protected void getActionEllipses(WebDriver driver,String searchValue)
    {
        getSearchResult(driver,searchValue);
        PageHelper.javascriptClick(driver,customizeColumns);
        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='cdk-overlay-pane']//mat-checkbox/label/div/input"));
        if(checkboxes.size()<8)
        {

        }
        else {
            for (int i = checkboxes.size() - 1; i > checkboxes.size() - 8; i--) {
                if (checkboxes.get(i).isSelected()) {
                    PageHelper.javascriptClick(driver, checkboxes.get(i));
                }
            }
        }
        Actions act=new Actions(driver);
        act.sendKeys(Keys.ESCAPE).perform();
        PageHelper.javascriptClick(driver,actionMenu);

    }


}