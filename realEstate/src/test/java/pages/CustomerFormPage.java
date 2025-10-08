package pages;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerFormPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//***constructor***	
	public CustomerFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//***Locators***
	
	//🧑‍💼Preferences
	
	@FindBy(xpath="(//input[@role='combobox'])[1]")
	private WebElement language;
	
	@FindBy(xpath="(//input[@role='combobox'])[2]")
	private WebElement currency;
	
	
	
	//👤Your Details
	
	@FindBy(name="full_name")
	private WebElement fullname;
	
	@FindBy(name="email")
	private WebElement emailid;
	
	@FindBy(xpath="(//input[@role='combobox'])[3]")
	private WebElement countryResidence;
	
	@FindBy(name="contact_number")
	private WebElement contNumber;
	
	@FindBy(xpath = "//select[@aria-describedby=\":rj:-helper-text\"]")
	private WebElement contactType;
	
	
	//💼Investment Details
	
	@FindBy(xpath="(//input[@role='combobox'])[4]")
	private WebElement country;
	
	@FindBy(xpath="(//input[@role='combobox'])[5]")
	private WebElement city;;
	
	@FindBy(xpath="(//input[@role='combobox'])[6]")
	private WebElement investementObjective;
	
	@FindBy(name="budget")
	private WebElement budget;
	
	//Submit button
	
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

	
	//***Actions***
	
	//🧑‍💼	Preferences
	
	public void enterLanguage(String lang) {
		selectFromDropdown(language, lang);	
	}
	
	public void enterCurrency(String cur) {
		selectFromDropdown(currency, cur);
	}
	
	
	//👤 Your Details
	
	public void enterName(String name) {
		fullname.sendKeys(name);
	}
	
	public void enterEmail(String email) {
		emailid.sendKeys(email);
	}
	
	public void residenceCountry(String countryRes) {
		selectFromDropdown(countryResidence, countryRes);		
	}
	
	public void enterContact(String number) {
		contNumber.sendKeys(number);
	}
	
	public void selectType(String type) {
		Select s = new Select(contactType);	
		s.selectByVisibleText(type);
		
	}
	
	//💼 Investment Details
		
	public void enterCountry(String cont) {
		selectFromDropdown(country, cont);
	}
	
	public void enterCity(String contCity) {
		selectFromDropdown(city, contCity);	
	}
	
	public void enterObjective(String invObj) {
		selectFromDropdown(investementObjective, invObj);
	}

	public void enterBudget(String Pbudget) {
		budget.sendKeys(Pbudget);	
	}
	
	
	//Submit button
	
	public void clickSubmit() {
		submitButton.click();
		
	}
		
	

}
