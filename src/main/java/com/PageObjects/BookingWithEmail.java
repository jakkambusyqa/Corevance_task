package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class BookingWithEmail extends TestBase {

	@FindBy(xpath = "//span[@onclick='redirecttoticket(this)']")
	WebElement proceednext;

	@FindBy(xpath = "(//span[@class='input-number-increment rounded-circle border border-indigo iconSize-bac d-flexy cursor-pointer'])[2]")
	WebElement incrementtickets;

	@FindBy(xpath = "//div[@onclick='proceedwithtickets()']")
	WebElement nextbtn;

	@FindBy(id = "txtguestcheckoutemail")
	WebElement emailvalue;
	
	@FindBy (xpath="//button[@onclick='registernewuser()']")
	WebElement continuebtn;
	
	@FindBy(id = "VerifyMail")
	WebElement verifyemailbtn;

	@FindBy(id = "textbuyerfirstname")
	WebElement firstname;

	@FindBy(id = "textbuyerlastname")
	WebElement lastname;

	@FindBy(id = "textbuyercompany")
	WebElement organisation;

	@FindBy(id = "textbuyertitle")
	WebElement jobtitle;

	@FindBy(id = "btnproceed")
	WebElement verifyEmail;

	public BookingWithEmail(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void VerifyBookingEmail( String fname, String lname, String orgname, String designation)
			throws Throwable {

		proceednext.click();

		incrementtickets.click();

		nextbtn.click();
		
		emailvalue.sendKeys(props.getProperty("email"));
		
		continuebtn.click();

		Thread.sleep(30000);

		verifyemailbtn.click();

		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		organisation.sendKeys(orgname);
		jobtitle.sendKeys(designation);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", verifyEmail);

	}

}
