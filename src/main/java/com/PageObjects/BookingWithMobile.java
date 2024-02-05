package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.TestBase;

public class BookingWithMobile extends TestBase {

	@FindBy(xpath = "//span[@onclick='redirecttoticket(this)']")
	WebElement register;
	
	@FindBy(xpath = "(//span[@class='input-number-increment rounded-circle border border-indigo iconSize-bac d-flexy cursor-pointer'])[2]")
	WebElement ticketsbuy;
	
	@FindBy (id="txtguestcheckoutphonenum")
	WebElement mobilenumbervalue;
	
	@FindBy (xpath="//button[@onclick='registernewuser()']")
	WebElement continuewithmobile;
	
	@FindBy (id="VerifyWhatsapp")
	WebElement WhatsappOtp;
	
	
	
	
}
