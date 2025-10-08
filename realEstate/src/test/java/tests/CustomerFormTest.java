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
		
		//🧑‍💼 Preferences
		cp.enterLanguage("Tamil");
		cp.enterCurrency("INR");
		
		//👤 Your Details
		cp.enterName("Martin");
		cp.enterEmail("marty123@gmail.com");
		cp.residenceCountry("United States");
		cp.enterContact("88776655443322");
		cp.selectType("Office");
		
		
		//💼Investment Details
		cp.enterCountry("United Kingdom");
		cp.enterCity("Kennington");
		cp.enterObjective("Rental Income");
		cp.enterBudget("40000");
		
		//Submit
		cp.clickSubmit();
		
		
	}

}
