package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testData.BaseData;
import util.PageHelper;

import java.io.File;
import java.util.HashMap;

public class DocumentsPage {

    private AddressbookPage addressbookPage;
    private WebDriver driver;
    public DocumentsPage (WebDriver driver) {
        // super(driver);
        this.driver = driver;
        this.addressbookPage = new AddressbookPage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[contains(text(),'Documents')]")
    private WebElement documentsMenu;

    @FindBy(xpath="//p[.='Click or drag documents here to upload.']")
    private WebElement uploadDocumentArea;

    @FindBy(xpath="//input[@type='file']")
    private WebElement attachDocument;

    @FindBy(xpath="(//button[@name='action-menu-trigger']/span[@class='mat-button-wrapper']/mat-icon[@svgicon='inv-ellipsis-h'])[1]")
    private WebElement viewDocument;

    @FindBy(xpath="//mat-select[@id='opportunityDocumentTypesMenu0']")
    private WebElement documentTypeDropdown;

    @FindBy(xpath="//textarea[@data-placeholder='Description']")
    private WebElement documentDescription;
    @FindBy(xpath="//button[@id='opportunityDocumentUpdateButton0']")
    private WebElement documentSaveButton;

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Documents updated']")
    private WebElement documentAddedMessage;

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Document deleted successfully']")
    private WebElement documentDeleteMessage;

    @FindBy(xpath = "//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;

    @FindBy(xpath="//button[contains(text(),'Edit')]")
    private WebElement editButton;

    @FindBy(xpath="(//mat-icon[@svgicon='inv-ellipsis-h'])")
    private WebElement clickFirstNotes;

    @FindBy(xpath="//button[contains(text(),'Delete')]")
    private WebElement deleteButtonForDocuments;

    @FindBy(xpath = "//app-msg-dialog//button[.='Delete']")
    private WebElement deleteButtonInPopUp;

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and contains(., 'File format is not supported.')]")
    private WebElement invalidFileAlertMessage;

    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification')]")
    private WebElement notification;



    public <T extends BaseData> boolean addDocuments(T obj, HashMap<String, String>[] documentsTestData)
    {
        boolean isDocumentAdded = false;
        try {
            obj.generateDataForAddDocuments();
            for (int i = 0; i < documentsTestData.length; i++)
            {
                System.out.println("Iteration is "+i);
                PageHelper.invisibilityOfElement(driver,loader);
                //documentsMenu.click();
                //Thread.sleep(3000);
                PageHelper.javascriptClick(driver, documentsMenu);
                PageHelper.invisibilityOfElement(driver, loader);

                    File f = new File(documentsTestData[i].get("Attachment"));
                    System.out.println("File path is " + f.getAbsolutePath());
                    PageHelper.uploadFile(driver, attachDocument, f.getAbsolutePath());
                    PageHelper.invisibilityOfElement(driver, loader);
                    
                if(isDocumentSuccessfullyAdded())
                {
                    isDocumentAdded =true;
                }
                else {
                    isDocumentAdded=false;
                    break;
                }

            }
        }
        catch (Exception e)
        {
            Assert.fail(String.valueOf(e));
            return isDocumentAdded;
        }

        return isDocumentAdded;
    }

    public <T extends BaseData> boolean addDocumentsNegative(T obj, HashMap<String, String>[] documentsTestData, HashMap<String, String>[] documentsValidationMessages)
    {
        boolean isFileAlertDisplayed = false;
        try {
            obj.generateDataForAddDocumentsNegativeTesting();
            obj.generateAddDocumentsValidationMessages();
            for (int i = 0; i < documentsTestData.length; i++)
            {
                PageHelper.invisibilityOfElement(driver,loader);
                PageHelper.javascriptClick(driver, documentsMenu);
                PageHelper.invisibilityOfElement(driver, loader);
                File f = new File(documentsTestData[i].get("Attachment"));
                System.out.println("File path is " + f.getAbsolutePath());
                PageHelper.uploadFile(driver, attachDocument, f.getAbsolutePath());
                PageHelper.invisibilityOfElement(driver, loader);
                boolean outcome=isDocumentAlertDisplayed();

                if(outcome) {
                    String text = PageHelper.getText(driver, notification);
                    System.out.println("Text is "+text);
                    if (text.contains(documentsValidationMessages[i].get("File Type Error"))) {
                        isFileAlertDisplayed = true;
                    }
                }
                else {
                    isFileAlertDisplayed=false;
                    break;
                }

            }
        }
        catch (Exception e)
        {
            Assert.fail(String.valueOf(e));
            return isFileAlertDisplayed;
        }

        return  isFileAlertDisplayed;
    }


    public <T extends BaseData> boolean editDocuments(T obj, HashMap<String, String>[] documentsTestData)
    {
        boolean isDocumentUpdated = false;
        try {
            obj.generateDataForEditDocuments();
            for (int i = 0; i < documentsTestData.length; i++)
            {
                PageHelper.invisibilityOfElement(driver,loader);
                PageHelper.javascriptClick(driver, documentsMenu);
                PageHelper.invisibilityOfElement(driver, loader);
                PageHelper.javascriptClick(driver, viewDocument);
                PageHelper.javascriptClick(driver, editButton);
                PageHelper.selectElementInDropdown(driver,documentTypeDropdown,documentsTestData[i].get("Document Type"));
                PageHelper.sendKeysToElement(driver,documentDescription,documentsTestData[i].get("Document Description"));
                PageHelper.javascriptClick(driver,documentSaveButton);
                PageHelper.invisibilityOfElement(driver, loader);

                if(isDocumentSuccessfullyUpdated())
                {
                    isDocumentUpdated =true;
                }
                else {
                    isDocumentUpdated=false;
                    break;
                }

            }
        }
        catch (Exception e)
        {
            Assert.fail(String.valueOf(e));
            return isDocumentUpdated;
        }

        return  isDocumentUpdated;
    }

    public boolean isDocumentSuccessfullyAdded()
    {
        return PageHelper.validateConfirmationMessage(driver, documentAddedMessage);
    }

    public boolean isDocumentAlertDisplayed()
    {
        return PageHelper.validateConfirmationMessage(driver,invalidFileAlertMessage );
    }


    public boolean isDocumentSuccessfullyUpdated()
    {
        return PageHelper.validateConfirmationMessage(driver, documentAddedMessage);
    }

    public void deleteDocument(WebDriver driver)
    {
        try {
            PageHelper.invisibilityOfElement(driver, loader);
            PageHelper.javascriptClick(driver, documentsMenu);
            PageHelper.javascriptClick(driver, viewDocument);
            PageHelper.javascriptClick(driver, deleteButtonForDocuments);
            PageHelper.javascriptClick(driver, deleteButtonInPopUp);
            PageHelper.invisibilityOfElement(driver, loader);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean validateDeleteDocument()
    {
        deleteDocument(driver);
        return  isDocumentSuccessfullyDeleted();
    }


    public boolean isDocumentSuccessfullyDeleted()
    {
        return PageHelper.validateConfirmationMessage(driver, documentDeleteMessage);
    }
}