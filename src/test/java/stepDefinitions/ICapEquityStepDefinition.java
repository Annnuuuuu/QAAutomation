package stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.ICapPageObjects;
import utils.Driver;
import utils.PropertyFileReader;



public class ICapEquityStepDefinition {

	ICapPageObjects icapPageObject =new ICapPageObjects();
	public WebDriver driver=Driver.getDriver();	
	

	@Given("user opens application")
	public void user_opens_application() throws InterruptedException {
		driver.get(PropertyFileReader.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("user enters userName and password")
	public void user_enters_userName_and_password() throws InterruptedException {
		icapPageObject.userName.sendKeys(PropertyFileReader.getUserName());
		icapPageObject.password.sendKeys(PropertyFileReader.getPassword());
	}
	
	@And("user signs in")
	public void user_signs_in() throws InterruptedException {
		icapPageObject.loginBtn.click();
	}
	
	@And("user clicks on Subscription number {string} link")
	public void user_clicks_on_Subscription_number_link(String subscriptionNumber) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		icapPageObject.clickOnSubscriptionNumberLink(subscriptionNumber);
	}

	@And("user clicks on Add Funds Button")
	public void user_clicks_on_Add_Funds_Button() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			icapPageObject.addFundsBtn.click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button/span[text()='Add Funds']")));
		  }
	}

	@And("user selects bank account {string}")
	public void user_selects_bank_account(String accountNumber) {
    	icapPageObject.selectBankAccount.click();
    	icapPageObject.selectBankAccountNumberFromDropdown(accountNumber);
	}

	@And("user enters amount {string}")
	public void user_enters_amount(String amount) throws InterruptedException {
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			icapPageObject.amount.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			icapPageObject.amount.sendKeys(amount);
			Thread.sleep(5000);
		}
	
	@When("user clicks on submit Button")
	public void user_clicks_on_submit_Button() {
		icapPageObject.submitBtn.click();  
	}
	
	@When("user clicks on confirm Button")
	public void user_clicks_on_confirm_Button() throws InterruptedException {
		icapPageObject.confirmBtn.click();   
		Thread.sleep(15000);
	}
	
	@When("user signs out")
	public void user_signs_out() throws InterruptedException {
		try {
			icapPageObject.hiForLogout.click();
			Thread.sleep(1000);
			icapPageObject.logoutBtn.click();
			} catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[contains(text(),'Hi')])[1]")));
		     Thread.sleep(1000);
		     icapPageObject.logoutBtn.click();
		    }
	
		
	}
}
