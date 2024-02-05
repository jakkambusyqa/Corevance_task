package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class BookingToAttendee extends TestBase {

	@FindBy(xpath = "//span[@onclick='redirecttoticket(this)']")
	WebElement registerfree;

	@FindBy(xpath = "(//span[@class='input-number-increment rounded-circle border border-indigo iconSize-bac d-flexy cursor-pointer'])[1]")
	WebElement incrementattendee;

	@FindBy(xpath = "//div[@onclick='proceedwithtickets()']")
	WebElement next;

	@FindBy(id = "txtguestcheckoutemail")
	WebElement emailvalues;

	@FindBy(xpath = "//button[@onclick='registernewuser()']")
	WebElement continuebtns;

	@FindBy(id = "VerifyMail")
	WebElement verifyemailbtns;
	
	@FindBy(id="checkingforsomeone")
	WebElement checkboxattendee;
	@FindBy(id = "textbuyercompany")
	WebElement organisation;

	@FindBy(id = "textbuyertitle")
	WebElement jobtitle;

	@FindBy(id = "textattendeefirstname")
	WebElement Attendeefname;

	@FindBy(id = "textattendeelastname")
	WebElement Attendeelname;

	@FindBy(id = "textattendeeemail")
	WebElement AttendeEmail;

	@FindBy(id = "textattendeecompany")
	WebElement Attendeecompanyname;

	@FindBy(id = "textattendeetitle")
	WebElement attnedeejob;

	@FindBy(id = "btnproceed")
	WebElement BookAttendee;

	public BookingToAttendee(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void verifyBookingAttendee(String orgname, String jbtitle, String A_fname, String A_lname, String A_email,
			String A_orgname, String A_jbtitle) throws Throwable {

		registerfree.click();
		incrementattendee.click();
		next.click();
		emailvalues.sendKeys(props.getProperty("email"));
		continuebtns.click();
		Thread.sleep(30000);
		verifyemailbtns.click();
		
		checkboxattendee.click();
		organisation.sendKeys(orgname);
		jobtitle.sendKeys(jbtitle);
		Attendeefname.sendKeys(A_fname);
		Attendeelname.sendKeys(A_lname);
		AttendeEmail.sendKeys(A_email);
		Attendeecompanyname.sendKeys(A_orgname);
		attnedeejob.sendKeys(A_jbtitle);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", BookAttendee);

	}

}
