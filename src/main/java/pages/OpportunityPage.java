package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testData.BaseData;
import util.PageHelper;

import java.time.Duration;
import java.util.HashMap;

public class OpportunityPage extends AbstractBasePage
{
    private WebDriver driver;

    public OpportunityPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="headNavOpportunities")
    private WebElement opportunitiesNavMenu;

    @FindBy(xpath="//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;

    @FindBy(xpath="//a[@routerlink='/opportunities/list']")
    private WebElement listMenu;

    @FindBy(xpath="//button[.='Create Opportunity']")
    private WebElement createOpportunityButton;

    public void clickOpportunitiesMenu()
    {
        PageHelper.invisibilityOfElement(driver,loader);
        PageHelper.javascriptClick(driver,opportunitiesNavMenu);
    }

    public boolean isOpportunityPageDisplayed()
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(createOpportunityButton)));
            return true;
        }
        catch(TimeoutException te)
        {
            return false;
        }
    }
    public WebElement getListMenu()
    {
return listMenu;
    }

}