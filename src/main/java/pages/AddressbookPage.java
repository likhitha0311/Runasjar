package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.PageHelper;

import java.time.Duration;

public class AddressbookPage
{
    private WebDriver driver;

    public AddressbookPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    @FindBy(id="headNavAddressBook")
    private WebElement addressBookNavMenu;
    @FindBy( xpath="//a[@routerlink='contacts']")
    private WebElement contactsMenu;

            @FindBy(xpath="//a[@routerlink='companies']")
    private WebElement companiesMenu;

    @FindBy(xpath="//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;

    public void clickAddressbook()
    {
        PageHelper.invisibilityOfElement(driver,loader);
        PageHelper.javascriptClick(driver,addressBookNavMenu);
    }

    public boolean isDisplayed()
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(contactsMenu),
                    ExpectedConditions.visibilityOf(companiesMenu)));
            return true;
        }
        catch(TimeoutException te)
        {
            return false;
        }
    }

    public WebElement getCompaniesMenu()
    {
        return companiesMenu;
    }

    public WebElement getContactsMenu()
    {
        return contactsMenu;
    }


}