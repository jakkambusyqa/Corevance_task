package com.base;




	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;



	import io.github.bonigarcia.wdm.WebDriverManager;

	//public class TestBase {
	
	public class TestBase {
		

		FileInputStream file;
		public  Properties props;
		public static WebDriver driver;
	//	public WebDriverWait wait;
	//	public String window1;
		
		//EventFiringWebDriver edriver;
		public TestBase() {	
			props = new Properties();

			try {
				file = new FileInputStream("./src/main/java/configprop/prop");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				props.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void Setup() {

			String browsername = props.getProperty("browser");

			if (browsername.equalsIgnoreCase("chrome")) {
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

			else if (browsername.equalsIgnoreCase("edge")) {

				driver = new EdgeDriver();
			}

			else if (browsername.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			


			driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get(props.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			//driver.manage().deleteAllCookies();
		}
		
	
}
