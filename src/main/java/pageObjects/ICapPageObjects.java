package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


public class ICapPageObjects {
public WebDriver driver;	
	
	
	public ICapPageObjects()  
	{
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
 
	@FindBy(xpath = "//span[text()='Login']")
	public WebElement loginBtn;
	
	
	public String subscriptionNumberLink ="//span[text()='<SubscriptionNumber>']";
	
	public void clickOnSubscriptionNumberLink(String subscriptionNumber) {
		subscriptionNumberLink=subscriptionNumberLink.replace("<SubscriptionNumber>",subscriptionNumber);
		driver.findElement(By.xpath(subscriptionNumberLink)).click();
	}
	
	@FindBy(xpath = "//button/span[text()='Add Funds']")
	public WebElement addFundsBtn;
	
	
	@FindBy(xpath = "//input[@name='bankAccount']/../div")
	public WebElement selectBankAccount;
	
public String selectAccountNumber ="//div/ul/li[text()='<AccountNumber>']";
	
	public void selectBankAccountNumberFromDropdown(String accountNumber) {
		selectAccountNumber=selectAccountNumber.replace("<AccountNumber>",accountNumber);
		driver.findElement(By.xpath(selectAccountNumber)).click();
	}
	
	
	@FindBy(xpath = "//div/input[@name='amount']")
	public WebElement amount;
	
	@FindBy(xpath = "//span[text()='Submit']")
	public WebElement submitBtn;
	
	@FindBy(xpath = "//span[text()='Confirm']")
	public WebElement confirmBtn;
	
	@FindBy(xpath = "(//div[contains(text(),'Hi')])[1]")
	public WebElement hiForLogout;
	
	@FindBy(xpath = "//ul/li[text()='Logout']")
	public WebElement logoutBtn;
}
