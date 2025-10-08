package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CustomerFormPage;
import utils.Config;

public class CustomerFormNegativeTest {
	
WebDriver driver;
	
	CustomerFormPage cp;
	
	@BeforeMethod
	
	public void setup() {
		driver = new ChromeDriver();
		driver.get(Config.base_Url);
		driver.manage().window().maximize();
		cp = new CustomerFormPage(driver);

	}
	
	
	
	
	@Test(priority = 1) // language field not filled	
	public void missingLanguage() {
		
		cp.enterCurrency("AED");
		cp.enterName("Dicaprio");
		cp.enterEmail("leo123@gmail.com");
		cp.residenceCountry("United States");
		cp.enterContact("88776655443322");
		cp.selectType("Office");
		cp.enterCountry("United Kingdom");
		cp.enterCity("Kennington");
		cp.enterObjective("Rental Income");
		cp.enterBudget("40000");
		
		cp.clickSubmit();
			
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted with language missing");	
		System.out.println("Form stayed on the same page – Language validation working");
	}
	
	
	@Test(priority = 2) // currency field not filled
	
	public void missingCurrency() {
		cp.enterLanguage("Tamil");
		cp.enterName("mark");
		cp.enterEmail("mark@gail.com");
		cp.residenceCountry("United States");
		cp.enterContact("9876543210");
		cp.selectType("Office");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterObjective("Rental Income");
		cp.enterBudget("30000");
		
		cp.clickSubmit();
				
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted Currency missing");	
		System.out.println("Form stayed on the same page – Currency validation working");
	}
	
	
	@Test(priority = 3) // name field not filled
	public void missingName() {
		cp.enterLanguage("Tamil");
		cp.enterCurrency("AED");
		cp.enterEmail("marky222@gmail.com");
		cp.residenceCountry("United States");
		cp.enterContact("123456543");
		cp.selectType("Office");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterObjective("Rental Income");
		cp.enterBudget("30000");
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted with name missing");
		System.out.println("Form stayed on the same page – name validation working");
	}
	
	@Test(priority = 4) // email field empty
	public void missingEmail() {
		cp.enterLanguage("Tamil");
		cp.enterCurrency("AED");
		cp.enterName("mark");
		cp.residenceCountry("United States");
		cp.enterContact("9876543210");
		cp.selectType("Office");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterObjective("Rental Income");
		cp.enterBudget("30000");
		
		cp.clickSubmit();
	
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted with email missing");
		System.out.println("Form stayed on the same page – email validation working");
	}
	
	@Test(priority = 5) // residence country field empty
	public void missingResidence() {
		cp.enterLanguage("Tamil");
		cp.enterCurrency("AED");
		cp.enterName("mark");
		cp.enterEmail("mark121@gmail.com");
		cp.enterContact("9876543210");
		cp.selectType("Office");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterObjective("Rental Income");
		cp.enterBudget("30000");
		
		cp.clickSubmit();
		
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted with residence country missing");
		System.out.println("Form stayed on the same page – residence country validation working");	
	}	
	
	@Test(priority = 6) // contact number field empty
	
	public void missingContact() {
		cp.enterLanguage("Tamil");
		cp.enterCurrency("AED");
		cp.enterName("mark");
		cp.enterEmail("mark123@gmail.com");
		cp.residenceCountry("United States");
		cp.selectType("Office");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterObjective("Rental Income");
		cp.enterBudget("30000");
		
		cp.clickSubmit();
			
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted with contact number missing");
		System.out.println("Form stayed on the same page – Contact validation working");
	
	}
	
	@Test(priority = 7, enabled	= false) // Type empty
	
	public void missingType() {
		cp.enterLanguage("Tamil");
		cp.enterCurrency("AED");
		cp.enterName("mark");
		cp.enterEmail("mark123@gmail.com");
		cp.residenceCountry("United States");
		cp.enterContact("9876543210");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterObjective("Rental Income");
		cp.enterBudget("30000");
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted with type missing");
		System.out.println("Form stayed on the same page – type validation working");	
	}
	
	@Test(priority = 8) // Country field empty
	
	public void missingCountry() {
		
		cp.enterLanguage("English");
		cp.enterCurrency("AED");
		cp.enterName("mark");
		cp.enterEmail("mark123@gmail.com");
		cp.residenceCountry("United States");
		cp.enterContact("9876543210");
		cp.selectType("Office");	
		//City will not be entered since country is not selected
		cp.enterObjective("Rental Income");
		cp.enterBudget("30000");
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted with country and city missing");
		System.out.println("Form stayed on the same page – Country validation working");
		
	}
	
	@Test(priority = 9) // City field empty
	
	public void missingCity() {
		cp.enterLanguage("Tamil");
		cp.enterCurrency("INR");
		cp.enterName("Martin");
		cp.enterEmail("marty123@gmail.com");
		cp.residenceCountry("United States");
		cp.enterContact("88776655443322");
		cp.selectType("Office");
		cp.enterCountry("United Kingdom");
		cp.enterObjective("Rental Income");
		cp.enterBudget("40000");		
		
		cp.clickSubmit();
	
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted with city missing");
		System.out.println("Form stayed on the same page – city validation working");	
	}
	
	@Test(priority = 10) // Investment objective field empty
	
	public void missingObjective() {
		cp.enterLanguage("Tamil");
		cp.enterCurrency("INR");
		cp.enterName("Martin");
		cp.enterEmail("marty123@gmail.com");
		cp.residenceCountry("United States");
		cp.enterContact("88776655443322");
		cp.selectType("Office");
		cp.enterCountry("United Kingdom");
		cp.enterCity("Kennington");
		cp.enterBudget("40000");		
		
		cp.clickSubmit();
			
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted with missing investment objective");
		System.out.println("Form stayed on the same page – Investment objective validation working");
	}
	
	@Test(priority = 11) // Budget field empty
	
	public void missingBudget() {
		cp.enterLanguage("Tamil");
		cp.enterCurrency("INR");
		cp.enterName("Martin");
		cp.enterEmail("marty123@gmail.com");
		cp.residenceCountry("United States");
		cp.enterContact("88776655443322");
		cp.selectType("Office");
		cp.enterCountry("United Kingdom");
		cp.enterCity("Kennington");
		cp.enterObjective("Rental Income");		
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted with missing budget");
		System.out.println("Form stayed on the same page – Budget validation working");	
	}
	
	
	
	@Test(priority = 12) // All fields empty
	
	public void submitFormWithAllFieldsEmpty() {

		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Config.base_Url, "Test Failed: Form submitted with all fields empty");
		System.out.println("Form stayed on the same page – All fields empty validation working");			
	} 
	
	@AfterMethod(enabled = false)
	public void teardown() {
		
			driver.quit();	

	}

}
