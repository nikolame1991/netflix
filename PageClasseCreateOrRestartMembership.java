package netflix;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Page Object klasa za korake tokom "Create or Restart Membership" Netflix
 * registra. Ova klasa sadrži sve interakcije od unosa e-mail adrese, lozinke,
 * izbora plana, do prikaza koraka sa plaćanjem.
 *
 * Page Object class representing the "Create or Restart Membership" flow on
 * Netflix. Includes all interactions: email entry, password setup, plan
 * selection, and navigating to the payment step.
 */

public class PageClasseCreateOrRestartMembership {
	WebDriver driver;
	WebDriverWait wait;

	public PageClasseCreateOrRestartMembership(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(css = "#\\:r13\\:")
	WebElement inputFieldEmailMember;

	@FindBy(css = "#appMountPoint > div > div > div > div > div > div > div.default-ltr-cache-pw7jst > div > div.default-ltr-cache-1tlz4mq.ebqi7bx1 > div > div.default-ltr-cache-15fecvd > div.default-ltr-cache-2lmy8v.ebqi7bx0 > div > div.default-ltr-cache-tzpj5x > div > form > div > button")
	WebElement clickButtonGetStarted;

	@FindBy(xpath = "//*[@id='id_password']")
	private WebElement passwordField;

	@FindBy(xpath = "//*[@id=\"appMountPoint\"]/div/div/div/div/div[2]/div/form/div/div[4]/button")
	private WebElement clickButtonNext;

	@FindBy(css = "#appMountPoint > div > div > div > div > div.simpleContainer > div > div > div > div > div > div > div.layout-container_wrapperStyles__12wd1go1d.hawkinsBaseLayout.default-ltr-cache-1u8qly9 > div > div > button")
	private WebElement buttonClickNext;

	@FindBy(xpath = "//*[@id=\"appMountPoint\"]/div/div/div/div/div[2]/div/div/div/div/div/div/div/form/div/div[2]/div/div")
	WebElement clickStandard;

	@FindBy(xpath = "//*[@id=\"appMountPoint\"]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[3]/button")
	WebElement clickStandardButtonNext;

	@FindBy(xpath = "//*[@id=\"creditOrDebitCardDisplayStringId\"]")
	WebElement clickHowToPay;

	@FindBy(xpath = "//*[@id=\":rs:\"]")
	WebElement inputFieldCardNumber;

	/*--------------------------*/
	@FindBy(xpath = "//*[@id=\":r14:\"]")
	WebElement errorEmailMember;

	/*--------------------------*/
	/**
	 * Unosi korisnikov e-mail u input polje. Inputs user email address in the
	 * corresponding field.
	 */
	public void checkInputFieldEmailMember(String email) {
		inputFieldEmailMember.clear();
		inputFieldEmailMember.sendKeys(email);
	}

	/**
	 * Klik na dugme "Get Started". Clicks the "Get Started" button.
	 */
	public void buttonCLickStarted() {
		wait.until(ExpectedConditions.elementToBeClickable(clickButtonGetStarted)).click();
	}

	/**
	 * Unos korisničke lozinke. Enters the user's password.
	 */
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	/**
	 * Klik na prvo dugme "Next" nakon unosa lozinke. Clicks the initial "Next"
	 * button after password entry.
	 */
	public void buttonNextClick() {
		wait.until(ExpectedConditions.elementToBeClickable(clickButtonNext)).click();
	}

	/**
	 * Klik na dugme "Next" nakon naslova. Clicks the next continuation button on
	 * the plan page.
	 */
	public void nextClickButton() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonClickNext)).click();
	}

	/**
	 * Klik na "Standard Plan" opciju. Selects the "Standard" plan option.
	 */
	public void isStandardClick() {
		wait.until(ExpectedConditions.elementToBeClickable(clickStandard)).click();
	}

	/**
	 * Klik na dugme "Next" nakon izbora plana. Clicks "Next" after selecting the
	 * plan.
	 */
	public void isStandardButtonClick() {
		wait.until(ExpectedConditions.elementToBeClickable(clickStandardButtonNext)).click();
	}

	/**
	 * Klik na opciju "Credit or Debit Card" kao metod plaćanja. Clicks the "Credit
	 * or Debit Card" payment option.
	 */
	public void isWorkClickButtonHowToPay() {
		wait.until(ExpectedConditions.elementToBeClickable(clickHowToPay)).click();
	}

	/**
	 * Unosi broj kartice. Enters the credit card number.
	 *
	 * @param number Broj kartice kao Long / Credit card number as Long
	 */
	public void enterFieldCardNumber(Long number) {
		wait.until(ExpectedConditions.visibilityOf(inputFieldCardNumber));
		inputFieldCardNumber.clear();
		inputFieldCardNumber.sendKeys(String.valueOf(number));
	}

	/**
	 * Proverava prikaz poruke o grešci za nevalidnu e-mail adresu. Verifies that
	 * the error message for invalid email input is displayed.
	 */
	public void errorEmailMember() {
		wait.until(ExpectedConditions.visibilityOf(errorEmailMember));
		Assert.assertTrue(errorEmailMember.isDisplayed(), "Please enter a valid email address.");
		System.out.println("Greska email: " + errorEmailMember.getText());
	}
}
