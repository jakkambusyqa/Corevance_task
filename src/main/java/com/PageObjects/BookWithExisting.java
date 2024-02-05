package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class BookWithExisting extends TestBase{

	
	@FindBy(xpath = "//span[@onclick='redirecttoticket(this)']")
	WebElement proceed;
	
	@FindBy(xpath = "(//span[@class='input-number-increment rounded-circle border border-indigo iconSize-bac d-flexy cursor-pointer'])[1]")
	WebElement increment;
	
	@FindBy (xpath = "//div[@onclick='proceedwithtickets()']")
	WebElement next;
	
	@FindBy(xpath = "//span[text()=' Login']")
	WebElement existingLogin;
	
	
	@FindBy(id = "txtusername")
	WebElement username;
	
	@FindBy(id="txtpassword")
	WebElement password;
	
	@FindBy(xpath = "(//button[@class='btn py-2 btn-block btn-danger bg-red-col w-100'])[1]")
	WebElement loginButton;
	
	@FindBy (id="btnproceed")
	WebElement finalProceed;
	
	public BookWithExisting(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyBookTicket(String user,String pass) throws Throwable 
	{
	
		proceed.click();
		increment.click();
		next.click();
		existingLogin.click();
		
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", finalProceed);
	}
	
	
	
}
