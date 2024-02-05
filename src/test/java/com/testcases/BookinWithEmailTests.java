package com.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjects.BookWithExisting;
import com.PageObjects.BookingWithEmail;
import com.base.TestBase;
import com.utils.Utils;

public class BookinWithEmailTests extends TestBase {

	BookingWithEmail bookEmail;

	private final String sheetName = "Email";

	public BookinWithEmailTests() {
		super();
	}

	@DataProvider
	public String[][] loginData() throws Throwable {
		return Utils.readData(sheetName);
	}

	@BeforeMethod
	public void Initi() {
		Setup();
		bookEmail = new BookingWithEmail(driver);

	}

	@Test(priority = 1, dataProvider = "loginData", dataProviderClass = BookinWithEmailTests.class)
	public void validatelogin(String[] rowindex) throws Throwable {

		bookEmail.VerifyBookingEmail(rowindex[0], rowindex[1], rowindex[2], rowindex[3]);

		Thread.sleep(2000);

		boolean ordermessage = driver.findElement(By.xpath("//h5[text()='Your order is pending.']")).isDisplayed();
		// Assert.assertEquals("https://admin.tickets99.com/event/orderdetails/623FmFOheTEsQuT6FshYXQ==/52nd-national-conference-of-indian-association-of-",url);

		Assert.assertTrue(ordermessage);

	}

}
