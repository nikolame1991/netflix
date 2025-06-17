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
 * Page Object klasa za Netflix login funkcionalnost. Ova klasa mapira sve
 * elemente za prijavu korisnika i obuhvata metode za unos kredencijala i
 * validaciju grešaka.
 *
 * Page Object class for handling Netflix login functionality. Maps all required
 * login fields and buttons, and provides methods for entering credentials and
 * validating input errors.
 */
public class PageClassLogin {
	WebDriver driver;
	WebDriverWait wait;

	/**
	 * Konstruktor koji inicijalizuje WebDriver, PageFactory i eksplicitni
	 * WebDriverWait.
	 *
	 * Initializes WebDriver, PageFactory elements, and explicit WebDriverWait.
	 */
	// Konstruktor
	public PageClassLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Element
	@FindBy(xpath = "//*[@id=\"appMountPoint\"]/div/div/div/div/div/div/div[1]/div/div[2]/div/div/header/div[2]/div/div/div[2]/a")
	WebElement clickButtonSign;

	@FindBy(xpath = "//*[@id=\":r0:\"]")
	WebElement inputFieldEmailAddress;

	@FindBy(xpath = "//*[@id=\":r3:\"]")
	WebElement inputFieldPassword;

	@FindBy(css = ".pressable_styles__a6ynkg0.button_styles__1kwr4ym0.default-ltr-cache-1mbafvh.e1ax5wel2")
	WebElement clickSignIn;

	@FindBy(xpath = "//*[@id=\":r1:\"]")
	WebElement inputFieldEmailError;

	@FindBy(xpath = "//*[@id=\":r4:\"]")
	WebElement inputFieldPasswordError;

	// Metod
	/**
	 * Klik na gornje dugme "Sign In" na početnoj strani. Clicks the top-right "Sign
	 * In" button on the homepage.
	 */
	public void clickFirstButtonSign() {
		wait.until(ExpectedConditions.elementToBeClickable(clickButtonSign)).click();
	}

	/**
	 * Unos e-mail adrese u formu za prijavu. Inputs email into login form.
	 *
	 * @param email E-mail adresa korisnika / User's email address
	 */
	public void inputFieldEmailSing(String email) {
		wait.until(ExpectedConditions.visibilityOf(inputFieldEmailAddress));
		inputFieldEmailAddress.clear();
		inputFieldEmailAddress.sendKeys(email);
	}

	/**
	 * Unos lozinke u login formu. Inputs password into login form.
	 *
	 * @param password Lozinka korisnika / User's password
	 */
	public void inputFieldPasswordSign(String password) {
		wait.until(ExpectedConditions.visibilityOf(inputFieldPassword));
		inputFieldPassword.clear();
		inputFieldPassword.sendKeys(password);
	}

	/**
	 * Klik na dugme "Sign In" radi pokušaja prijave. Clicks "Sign In" button to
	 * attempt login.
	 */
	public void clickButtonSignIn() {
		wait.until(ExpectedConditions.elementToBeClickable(clickSignIn)).click();
	}

	/**
	 * Proverava i ispisuje greške za prazna login polja. Waits for and asserts that
	 * email/password error messages are visible.
	 */
	public void printAllErrors() {
		wait.until(ExpectedConditions.visibilityOf(inputFieldEmailError));
		wait.until(ExpectedConditions.visibilityOf(inputFieldPasswordError));

		Assert.assertTrue(inputFieldEmailError.isDisplayed(), "Nije prikazana greška za prazan email!");
		Assert.assertTrue(inputFieldPasswordError.isDisplayed(), "Nije prikazana greška za praznu lozinku!");

		System.out.println("🟡 Greška email: " + inputFieldEmailError.getText());
		System.out.println("🟡 Greška lozinka: " + inputFieldPasswordError.getText());
	}
}
