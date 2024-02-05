package com.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjects.BookingToAttendee;
import com.PageObjects.BookingWithEmail;
import com.base.TestBase;
import com.utils.Utils;

public class BookToAttendeeTest extends TestBase {

	
	BookingToAttendee bookattendee;

	private final String sheetName = "Attendee_details";

	public BookToAttendeeTest() {
	
		super();
	}

	@DataProvider
	public String[][] loginData() throws Throwable {
		return Utils.readData(sheetName);
	}

	@BeforeMethod
	public void Initi() {
		Setup();
		bookattendee=new BookingToAttendee(driver);

	}

	@Test(priority = 1, dataProvider = "loginData", dataProviderClass = BookToAttendeeTest.class)
	public void validatelogin(String[] rowindex) throws Throwable {

		bookattendee.verifyBookingAttendee(rowindex[0], rowindex[1], rowindex[2], rowindex[3], rowindex[4], rowindex[5], rowindex[6]);

		Thread.sleep(2000);

		boolean ordermessage = driver.findElement(By.xpath("//h5[text()='Your order is pending.']")).isDisplayed();
		// Assert.assertEquals("https://admin.tickets99.com/event/orderdetails/623FmFOheTEsQuT6FshYXQ==/52nd-national-conference-of-indian-association-of-",url);

		Assert.assertTrue(ordermessage);

	}

	
	
	
	
	
	
	
}
