package netflix;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test klasa za proveru login funkcionalnosti na Netflix platformi. Obuhvata
 * pozitivan scenario uspešnog logovanja i negativan scenario sa greškama u
 * unosu.
 *
 * Test class for verifying Netflix login functionality. Covers positive login
 * scenario and negative scenario with validation errors.
 */
public class PageClassLoginTest extends BaseTestClass {

	/**
	 * Navigira na početnu stranicu Netflix Srbija pre svakog testa. Navigates to
	 * Netflix Serbia homepage before each test.
	 */
	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://www.netflix.com/rs/");
	}

	/**
	 * Briše sve kolačiće nakon izvršenja testa radi izolacije sesije. Clears all
	 * cookies after each test to ensure clean session.
	 */
	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	/**
	 * Pozitivni test: uspešna prijava korisnika sa ispravnim podacima. Positive
	 * scenario: logs in using correct email and password.
	 */
	@Test
	public void loginCorrect() {
		loginNetflix.clickFirstButtonSign();
		loginNetflix.inputFieldEmailSing("nikolamedan85@gmail.com");
		loginNetflix.inputFieldPasswordSign("N!k0L@91");
		loginNetflix.clickButtonSignIn();
	}

	/**
	 * Negativni test: pokušaj prijave sa neispravnim kredencijalima. Proverava da
	 * li se prikazuju poruke o greškama.
	 *
	 * Negative scenario: attempts login with invalid credentials. Verifies that
	 * proper error messages are displayed.
	 */
	@Test
	public void loginWrong() {
		loginNetflix.clickFirstButtonSign();
		loginNetflix.inputFieldEmailSing("weq");
		loginNetflix.inputFieldPasswordSign("dsa");
		loginNetflix.clickButtonSignIn();

		// Provera prikaza grešaka
		loginNetflix.printAllErrors();
	}

}
