package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CustomerFormPage;
import utils.Config;

public class CustomerFormTest {
	
WebDriver driver;
	
	CustomerFormPage cp;
	
	@BeforeClass
	
	public void setup() {
		driver = new ChromeDriver();
		driver.get(Config.base_Url);
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
		verifySubmission();

		
	}	
	
	//To validate submission popup
	private void verifySubmission() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement successPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Thank you for your submission!']")));
		
		//validate popup displayed
		Assert.assertTrue(successPopup.isDisplayed(), "Success popup not displayed");
		
		//Close popup
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		System.out.println("Form submitted successfully and popup closed");

	}
	}
	
	
	


