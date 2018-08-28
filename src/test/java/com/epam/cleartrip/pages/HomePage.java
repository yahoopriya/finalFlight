package com.epam.cleartrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.epam.cleartrip.data.TripBooking;
import com.epam.cleartrip.suitbase.AbstractSuitSteps;
import com.epam.cleartrip.suitbase.BaseUtilityClearTrip;

public class HomePage extends BaseUtilityClearTrip {

	String date = "Thu, 23 Aug, 2018";
	String fdest = "pune";
	String tolocation = "Nagpur, IN - Dr. Babasaheb Ambedkar (NAG)";
	static String adultCount = "1";
    String useremailid = "vyawaharepriya@gmail.com";
    String title = "Mrs";
    String uName = "Priya";
    String uLastName ="Vyawahare";
    String umobileNo = "6767867867";
	
	@FindBy(how = How.XPATH, using = ".//input[@id='FromTag']")
	WebElement fromdest;

	@FindBy(how = How.XPATH, using = ".//input[@id='ToTag']")
	WebElement todest;

	@FindBy(how = How.XPATH, using = "//*[@id='DepartDate']")
	WebElement departdate;

	@FindBy(how = How.XPATH, using = "//*[@id='Adults']")
	static WebElement select_adult;

	@FindBy(how = How.XPATH, using = "//input[@id=\"SearchBtn\"]")
	WebElement searchflightbutton;

	// need to imlpement for dynamic date
	@FindBy(how = How.XPATH, using = ".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td/a[text()='29']")
	@CacheLookup
	WebElement journeydate;

	@FindBy(how = How.XPATH, using = ".//*[@id='flightForm']/section[2]/div/div/nav/ul/li[2]/preceding::button")
	WebElement firstflight;

	@FindBy(how = How.XPATH, using = "//*[@id='flightForm']/section[2]/div[4]/div/nav/ul/li[1]/table/tbody[2]/tr[2]/td[3]/button")
	WebElement firstflight1;

	@FindBy(how = How.XPATH, using = ".//*[@id='itineraryBtn']")
	WebElement continue_To_Payment;

	@FindBy(how = How.XPATH, using = ".//*[@id='insurance_confirm']")
	WebElement confirmpolicy;
	
	@FindBy(how=How.XPATH,using=".//*[@id='username']")
	WebElement emailId;
	
	@FindBy(how=How.XPATH,using="//input[@id=\"LoginContinueBtn_1\"]")
	WebElement continuewithemail;
	
	@FindBy(how=How.XPATH,using=".//*[@id='AdultTitle1']")
	WebElement selectTitle;
	
	@FindBy(how=How.XPATH,using=".//*[@id='AdultFname1']")
	WebElement firstName;

	@FindBy(how=How.XPATH,using=".//*[@id='AdultLname1']")
	WebElement lastName;
	
	@FindBy(how=How.XPATH,using="//*[@id='mobileNumber']")
	WebElement mobilenumber;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterFromDest(String fdest) {
		fromdest.sendKeys(fdest);
	}

	public void enterToLocation(String tolocation) {
		todest.sendKeys(tolocation);
	}

	public void selectDateOfJourney(String date) {
		departdate.sendKeys(date);
		journeydate.click();
	}

	public void selectAdult() {

		select_adult.click();
	}

	public void selectadultCount() {
		AbstractSuitSteps.selectOptions(adultCount, select_adult);
	}

	public void searchFlight() {

		searchflightbutton.click();
		AbstractSuitSteps.waitFor(500);
	}

	public void selectFirstFlight() {

		AbstractSuitSteps.waitFor(1000);
		try {
			safeJavaScriptClick(firstflight1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void continuePayment() {
		AbstractSuitSteps.scrollToElement();
		AbstractSuitSteps.waitFor(500);
		continue_To_Payment.click();
	}

	public void clickPolicyCheck() {
		if(AbstractSuitSteps.isEnabledElement(confirmpolicy)) {
			 AbstractSuitSteps.waitForElementToBeEnabled(confirmpolicy);
		     AbstractSuitSteps.checkBoxCheck(confirmpolicy);
	    }
    }
	
	public void enterEmail(String usermailid) {
		 AbstractSuitSteps.insertText(emailId, usermailid);	
		}
	
	public void ClickonContinue2() {
		AbstractSuitSteps.clickOnBtton(continuewithemail);
	}
	
	public void selectTitle(String title) {
		AbstractSuitSteps.waitFor(1000);
		AbstractSuitSteps.selectOptions(title, selectTitle);
	}
	
	public void enterFirstName(String uName) {
		AbstractSuitSteps.waitFor(1000);
		 AbstractSuitSteps.insertText(firstName,uName);
	}
	
	public void enterLastName(String uLastName) {
		AbstractSuitSteps.waitFor(500);
		 AbstractSuitSteps.insertText(lastName,uLastName);
	}
	
	public void enterMobileNo(String umobileNo) {
		AbstractSuitSteps.waitFor(500);
		 AbstractSuitSteps.insertText(mobilenumber,umobileNo);
	}
	
	public void continueFinalPaymnt() {
		AbstractSuitSteps.clickOnBtton(continuewithemail);
	}
	
	public boolean travelBooking(TripBooking booking) {
		 enterFromDest(booking.getFdest());
		 enterToLocation(booking.getTolocation());
		 selectDateOfJourney(booking.getDate());
		 selectAdult();
		 selectadultCount();
		 searchFlight();	
		 selectFirstFlight();
		 clickPolicyCheck();
		 continuePayment();
		 enterEmail(booking.getUseremailid());
		 ClickonContinue2();
		 selectTitle(booking.getTitle());
		 enterFirstName(booking.getuName());
		 enterLastName(booking.getuLastName());
		 enterMobileNo(booking.getUmobileNo());
		 continueFinalPaymnt();
		 return true;
	}
  }