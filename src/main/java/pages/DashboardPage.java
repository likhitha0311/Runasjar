package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PageHelper;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;

    @FindBy(xpath = "//h1[.='Dashboard']")
    private WebElement dashboard;

    @FindBy(xpath="//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isDisplayed() {
        try {
            PageHelper.invisibilityOfElement(driver,loader);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(ExpectedConditions.titleIs(".studio | Dashboard"),
                    ExpectedConditions.visibilityOf(dashboard)));
            return true;

        } catch (TimeoutException t) {
            return false;
        }
    }
}