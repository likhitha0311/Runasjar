package util;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageHelper {

    public static void javascriptClick(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element),
                    ExpectedConditions.elementToBeClickable(element)));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(String.valueOf(e));
        }
    }


    public static boolean isElementDisplayed(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed())
            {
                return true;
            }
        } catch (Exception e)
        {
            Assert.fail(String.valueOf(e));
            return false;
        }
        return false;
    }

    public static void sendKeysToElement(WebDriver driver, WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element),
                   ExpectedConditions.elementToBeClickable(element)));
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            Assert.fail(String.valueOf(e));
        }
    }

    public static void scrollToView(WebDriver driver, WebElement element)
    {try {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    catch(Exception e)
    {
        e.printStackTrace();
        Assert.fail(String.valueOf(e));
    }
    }


    public static boolean radioValueWebelement(String value, WebElement container, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(container)
            ));
            List<WebElement> radioList = container.findElements(By.cssSelector("input[type='radio']"));
            for (WebElement element : radioList) {
                if (element.getAttribute("value").equals(value)) {
                    wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
                    js.executeScript("arguments[0].click()", element);
                    wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void selectElementInDropdown(WebDriver driver, WebElement element, String option) {
//        String xPath = "//*[text() = '" + option + "']";
//        System.out.println(xPath);
        String xPath = "//*[contains(., '" + option + "')]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            Thread.sleep(1000);
            List<WebElement> elements = driver.findElements(By.xpath(xPath));
                Thread.sleep(1000);
                WebElement selection = elements.get(elements.size() - 1);
                wait.until(ExpectedConditions.elementToBeClickable(selection));
                Thread.sleep(2000);
                selection.click();
                Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(String.valueOf(e));
        }
    }

    public static void selectElementInMatOptionDropdown(WebDriver driver, WebElement element, String option) {
//        String xPath = "//*[text() = '" + option + "']";
//        System.out.println(xPath);
        String xPath = "//mat-option//span//div[contains(., '" + option + "')]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            Thread.sleep(1000);
            List<WebElement> elements = driver.findElements(By.xpath(xPath));
            Thread.sleep(1000);
            WebElement selection = elements.get(elements.size() - 1);
            wait.until(ExpectedConditions.visibilityOf(selection));
            wait.until(ExpectedConditions.elementToBeClickable(selection));
            Thread.sleep(1000);
            selection.click();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(String.valueOf(e));
        }
    }

    public static void selectFirstElementInDropdown(WebDriver driver,WebElement element1,WebElement dropdown, String element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element1));
            element1.click();
            Thread.sleep(1000);
            String xPath = "//*[contains(., '" + element + "')]";
            System.out.println("Text is "+dropdown.findElement(By.xpath(xPath)).getText());;
            WebElement result =  dropdown.findElement(By.xpath(xPath));
            wait.until(ExpectedConditions.elementToBeClickable(result));
            Thread.sleep(1000);
            result.click();
            Thread.sleep(1000);

        } catch (Exception e) {
            Assert.fail(String.valueOf(e));
        }
    }

    public static void selectElementWhenDropdownIsOfSelectType(WebDriver driver, WebElement element, String option) {
        Select select = new Select(element);
        select.selectByVisibleText(option);

    }

    public static boolean invisibilityOfElement(WebDriver driver, WebElement ele)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.invisibilityOf(ele));
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(String.valueOf(e));
            return false;
        }

    }

    public static boolean isButtonEnabled(WebDriver driver, WebElement ele) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(ele));
            return ele.isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(String.valueOf(e));
            return false;
        }
    }
//	public static boolean isFormDisplayed(WebDriver driver, <T>formElements) {
//		for (WebElement ele : formElements) {
//			try {
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//				wait.until(ExpectedConditions.visibilityOf(ele));
//				return true;
//			} catch (Exception e) {
//				return false;
//			}
//		}
//		return false;
//	}

    public static boolean validateConfirmationMessage(WebDriver driver, WebElement ele) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(ele));
            return true;
        } catch (Exception e) {
            Assert.fail(String.valueOf(e));
            return false;
        }
    }

    public static String getText(WebDriver driver, WebElement ele) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(ele));
            return ele.getText().replaceAll("[^a-zA-Z/:0-9.//@\\s-,]+", "");
        } catch (Exception e)
        {
            return String.valueOf(e);
        }

    }

    public static void clearText(WebDriver driver, WebElement ele)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(ele));
            ele.clear();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(String.valueOf(e));
        }

    }

    public static boolean isTitleDisplayed(WebDriver driver, String title) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleIs(title));
            return true;

        } catch (Exception e) {
            Assert.fail(String.valueOf(e));
            return false;
        }
    }

    public static void scroll(WebDriver driver, WebElement scrollbar, int scrollAmount) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(800,0)");
        }

    }

    public static <T> void sendData(WebDriver driver, WebElement fieldName, HashMap<T, T> hashmap, T keyName) {
        if (hashmap.containsKey(keyName))
        {
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //wait.until(ExpectedConditions.visibilityOf(fieldName));
            //fieldName.clear();
            PageHelper.sendKeysToElement(driver, fieldName, (String) hashmap.get(keyName));
        } else {
            //System.out.println(keyName + " is not present in the test data");
        }
    }

    public static <T> void clearTextAndSendData(WebDriver driver, WebElement fieldName, HashMap<T, T> hashmap, T keyName) {
        if (hashmap.containsKey(keyName))
        {
            PageHelper.clearText(driver, fieldName);
            PageHelper.sendKeysToElement(driver, fieldName, (String) hashmap.get(keyName));
        } else
        {
            System.out.println(keyName + " is not present in the test data");
        }
    }

    public static <T> boolean validateDetails(WebDriver driver, WebElement fieldName, HashMap<T, T> hashmap, T keyName) {
        if (hashmap.containsKey(keyName)) {
            String text = PageHelper.getText(driver, fieldName);
            if (text.equals(hashmap.get(keyName))) {
                return true;
            }
        }
        return false;

    }


    public static void cancelTags(WebDriver driver, WebElement fieldname) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(fieldname));
            PageHelper.javascriptClick(driver, fieldname);
        } catch (Exception e) {
            System.out.println("Tags are not present in the test data");
        }
    }

    public static void uploadFile(WebDriver driver,WebElement fieldname, String filepath)
    {

        fieldname.sendKeys(filepath);

    }
    public static <T> void selectElementInDropdownForNegativeTesting(WebDriver driver, HashMap<T, T> hashmap, WebElement element, WebElement cancel, String keyName,String option) {
        String xPath = "//*[contains(., '" + option + "')]";
        if (hashmap.containsKey(keyName)) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            try {
                if (option == null || option.isEmpty()) {
                    Actions act = new Actions(driver);
                    act.sendKeys(Keys.ESCAPE).perform();
                    try {
                        if (cancel.isDisplayed()) {
                            cancel.click();
                        }
                    }
                    catch(NoSuchElementException e)
                    {
                        System.out.println("Cancel popup is not found");
                    }
                } else {
                    List<WebElement> elements = driver.findElements(By.xpath(xPath));
                    Thread.sleep(1000);
                    WebElement selection = elements.get(elements.size() - 1);
                    wait.until(ExpectedConditions.elementToBeClickable(selection));
                    Thread.sleep(1000);
                    selection.click();
                    Thread.sleep(1000);
                    try {
                        if (driver.findElement(By.xpath("//div[@class='cdk-overlay-pane']")).isDisplayed()) {
                            Actions act = new Actions(driver);
                            act.sendKeys(Keys.ESCAPE).perform();
                        }
                    }
                    catch(NoSuchElementException ne)
                    {
                        System.out.println("Dropdown is closed");
                    }
                }


            } catch (Exception e) {
                Assert.fail(String.valueOf(e));
            }
        }
    }
}