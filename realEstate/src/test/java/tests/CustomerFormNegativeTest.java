package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CustomerFormPage;

public class CustomerFormNegativeTest {
	
WebDriver driver;
	
	CustomerFormPage cp;
	
	@BeforeMethod
	
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:5173/");
		driver.manage().window().maximize();
		cp = new CustomerFormPage(driver);

	}
	
	
	@Test(priority = 1) // FirstName field missing
	private void missingName() {
		cp.enterEmail("dk456@gmail.com");
		cp.enterContact("9876543210");
		cp.residenceCountry("United States");
		cp.enterLanguage("English");
		cp.enterCurrency("AED");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterBudget("30000");
		cp.enterObjective("Rental Income");
		
		cp.clickSubmit();
		
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://localhost:5173/", "Test Failed: Form submitted with missing name");	
		System.out.println("Form stayed on the same page – Name validation working");
	}
	
	
	@Test(priority = 2) // Email field missing
	
	private void missingEmail() {
		cp.enterName("Mark");
		cp.enterContact("9876543210");
		cp.residenceCountry("United States");
		cp.enterLanguage("English");
		cp.enterCurrency("AED");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterBudget("30000");
		cp.enterObjective("Rental Income");
		
		cp.clickSubmit();
		
			
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://localhost:5173/", "Test Failed: Form submitted with missing email");	
		System.out.println("Form stayed on the same page – Email validation working");
	}
	
	
	@Test(priority = 3) // Contact number field missing
	
	private void missingContact() {
		cp.enterName("mark");
		cp.enterEmail("mark444@gmail.com");
		cp.residenceCountry("United States");
		cp.enterLanguage("English");
		cp.enterCurrency("AED");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterBudget("30000");
		cp.enterObjective("Rental Income");
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://localhost:5173/", "Test Failed: Form submitted with missing contact number");
		System.out.println("Form stayed on the same page – Contact number validation working");
	}
	
	@Test(priority = 4) // Residence country field missing
	private void missingResidenceCountry() {
		cp.enterName("mark");
		cp.enterEmail("mark345@gmail.com");
		cp.enterContact("9876543210");
		cp.enterLanguage("English");
		cp.enterCurrency("AED");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterBudget("30000");
		cp.enterObjective("Rental Income");
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://localhost:5173/", "Test Failed: Form submitted with missing residence country");
		System.out.println("Form stayed on the same page – Residence country validation working");
	}
	
	@Test(priority = 5) // Language field empty
	private void missingLanguage() {
		cp.enterName("mark");
		cp.enterEmail("mark234@gmail.com");
		cp.enterContact("9876543210");
		cp.residenceCountry("United States");
		cp.enterCurrency("AED");
		cp.clearLanguage();
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterBudget("30000");
		cp.enterObjective("Rental Income");
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://localhost:5173/", "Test Failed: Form submitted with missing language");
		System.out.println("Form stayed on the same page – Language validation working");	
	}	
	
	@Test(priority = 6) // Currency field empty
	
	private void missingCurrency() {
		cp.enterName("mark");
		cp.enterEmail("mark234@gmail.com");
		cp.enterContact("9876543210");
		cp.residenceCountry("United States");
		cp.enterLanguage("English");
		cp.clearCurrency();
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterBudget("30000");
		cp.enterObjective("Rental Income");
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://localhost:5173/", "Test Failed: Form submitted with missing currency");
		System.out.println("Form stayed on the same page – Currency validation working");
	
	}
	
	@Test(priority = 7) // Country field empty
	
	private void missingCountry() {
		cp.enterName("mark");
		cp.enterEmail("mark456@gmail.com");
		cp.enterContact("9876543210");
		cp.residenceCountry("United States");
		cp.enterLanguage("English");
		cp.enterCurrency("AED");
		//cp.enterCity("Sharjah");  //City will not enable until country is selected
		cp.enterBudget("30000");
		cp.enterObjective("Rental Income");
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://localhost:5173/", "Test Failed: Form submitted with missing country");
		System.out.println("Form stayed on the same page – Country validation working");	
	}
	
	@Test(priority = 8) // City field empty
	
	private void missingCity() {
		cp.enterName("mark");
		cp.enterEmail("mark123@gmail.com");
		cp.enterContact("9876543210");
		cp.residenceCountry("United States");
		cp.enterLanguage("English");
		cp.enterCurrency("AED");
		cp.enterCountry("United Arab Emirates");
		cp.enterBudget("30000");
		cp.enterObjective("Rental Income");
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://localhost:5173/", "Test Failed: Form submitted with missing city");
		System.out.println("Form stayed on the same page – City validation working");
		
	}
	
	@Test(priority = 9) // Budget field empty
	
	private void missingBudget() {
		cp.enterName("Martin Scorsese");
		cp.enterEmail("marty@gmail.com");
		cp.enterContact("9876543210");
		cp.residenceCountry("United States");
		cp.enterLanguage("English");
		cp.enterCurrency("AED");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterObjective("Rental Income");
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://localhost:5173/", "Test Failed: Form submitted with missing budget");
		System.out.println("Form stayed on the same page – Budget validation working");	
	}
	
	@Test(priority = 10) // Investment objective field empty
	
	private void missingObjective() {
		cp.enterName("Martin Scorsese");
		cp.enterEmail("marty@gmail.com");
		cp.enterContact("9876543210");
		cp.residenceCountry("United States");
		cp.enterLanguage("English");
		cp.enterCurrency("AED");
		cp.enterCountry("United Arab Emirates");
		cp.enterCity("Sharjah");
		cp.enterBudget("30000");
		
		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://localhost:5173/", "Test Failed: Form submitted with missing investment objective");
		System.out.println("Form stayed on the same page – Investment objective validation working");
				
	}
	
	@Test(priority = 11) // All fields empty
	
	private void submitFormWithAllFieldsEmpty() {

		cp.clickSubmit();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://localhost:5173/", "Test Failed: Form submitted with all fields empty");
		System.out.println("Form stayed on the same page – All fields empty validation working");			

	} 
	
	@AfterMethod
	public void teardown() {
		
			driver.quit();
		
	}

}
