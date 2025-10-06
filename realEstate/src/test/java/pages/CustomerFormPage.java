package pages;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerFormPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//constructor	
	public CustomerFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Locators	
	@FindBy(name="full_name")
	private WebElement fullname;
	
	@FindBy(name="email")
	private WebElement emailid;
	
	@FindBy(name="contact_number")
	private WebElement contNumber;
	
	@FindBy(xpath="(//input[@role='combobox'])[1]")
	private WebElement countryResidence;
	
	@FindBy(xpath="(//input[@role='combobox'])[2]")
	private WebElement language;
	
	@FindBy(xpath="(//input[@role='combobox'])[3]")
	private WebElement currency;
	
	@FindBy(xpath="(//input[@role='combobox'])[4]")
	private WebElement country;
	
	@FindBy(xpath="(//input[@role='combobox'])[5]")
	private WebElement city;
	
	@FindBy(name="budget")
	private WebElement budget;
	
	@FindBy(xpath="(//input[@role='combobox'])[6]")
	private WebElement investement;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitButton;
	
	
	//helper for dropdowns	
	private void selectFromDropdown(WebElement element, String value) {
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    element.click();
	    element.sendKeys(value);
	    element.sendKeys(Keys.ARROW_DOWN);
	    element.sendKeys(Keys.ENTER);
	}

	
	//Actions	
	public void enterName(String name) {
		fullname.sendKeys(name);
	}
	
	public void enterEmail(String email) {
		emailid.sendKeys(email);
	}
	
	public void enterContact(String number) {
		contNumber.sendKeys(number);
	}
	
	public void residenceCountry(String countryRes) {
		selectFromDropdown(countryResidence, countryRes);		
	}
	
	public void enterLanguage(String lang) {
		selectFromDropdown(language, lang);	
	}
	
	public void enterCurrency(String cur) {
		selectFromDropdown(currency, cur);
	}
	
	public void enterCountry(String cont) {
		selectFromDropdown(country, cont);
	}
	
	public void enterCity(String contCity) {
		selectFromDropdown(city, contCity);	
	}
	
	public void enterBudget(String Pbudget) {
		budget.sendKeys(Pbudget);	
	}
	
	public void enterObjective(String invObj) {
		selectFromDropdown(investement, invObj);
	}
	
	public void clickSubmit() {
		submitButton.click();
		
	}

}
