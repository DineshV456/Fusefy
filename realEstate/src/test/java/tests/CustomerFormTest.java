package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CustomerFormPage;

public class CustomerFormTest {
	
WebDriver driver;
	
	CustomerFormPage cp;
	
	@BeforeClass
	
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:5173/");
		driver.manage().window().maximize();
		cp = new CustomerFormPage(driver);

	}
	
	@Test
	
	private void custForm() {
		cp.enterName("Martin Scorsese");
		cp.enterEmail("marty@gmail.com");
		cp.enterContact("9876543210");
		cp.residenceCountry("United States");
		cp.enterLanguage("English");
		cp.enterCurrency("AED");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterBudget("30000");
		cp.enterObjective("Rental Income");
		cp.clickSubmit();
		
		
	}

}
