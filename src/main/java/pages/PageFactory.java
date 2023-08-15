package pages;

import org.openqa.selenium.WebDriver;

import util.ListenerClass;

public class PageFactory {

	private WebDriver driver;

	public PageFactory(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		return new LoginPage(this.driver);
	}

	public ContactsPage getContactsPage() {
		return new ContactsPage(this.driver);
	}

	public CompanyPage getCompanyPage() {
		return new CompanyPage(this.driver);
	}

	//
//	public ListenerClass getListenerClass() {
//		
//		return new ListenerClass(this.driver);
//	}
//
	public CustomiseColumnsPage getCustomiseColumnsPage() {
		return new CustomiseColumnsPage(this.driver);
	}

	public OpportunityListPage getOpportunityListPage() {
		return new OpportunityListPage(this.driver);
	}

	public OpportunityDetailsPage getOpportunityDetailsPage() {
		return new OpportunityDetailsPage(this.driver);
	}

	public AssociateContactPage getAssociateContactPage()
	{
		return new AssociateContactPage(this.driver);
	}
}