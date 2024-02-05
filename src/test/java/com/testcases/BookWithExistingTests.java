package com.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjects.BookWithExisting;
import com.base.TestBase;
import com.utils.Utils;

public class BookWithExistingTests extends TestBase {

private BookWithExisting book;
	
	private final String sheetName = "Existcredentials";

	public BookWithExistingTests() {
		super();
	}

	@DataProvider
	public String[][] loginData() throws Throwable {
		return Utils.readData(sheetName);
	}

	@BeforeMethod
	public void Initi() {
		Setup();
		book=new BookWithExisting(driver);
		
	}


	@Test(priority = 1, dataProvider = "loginData", dataProviderClass = BookWithExistingTests.class)
	public void validatelogin(String[] rowindex) throws Throwable {

		book.verifyBookTicket(rowindex[0],rowindex[1]);
		
		Thread.sleep(2000);
		
		boolean ordermessage=driver.findElement(By.xpath("//button[text()='View Your Tickets']")).isDisplayed();
		//Assert.assertEquals("https://admin.tickets99.com/event/orderdetails/623FmFOheTEsQuT6FshYXQ==/52nd-national-conference-of-indian-association-of-",url);
		
		Assert.assertTrue(ordermessage);
		
	}
	
	
	
}
