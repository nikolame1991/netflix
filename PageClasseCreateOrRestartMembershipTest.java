package netflix;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for the "Create or Restart Membership" Netflix flow. Covers both
 * happy path and validation scenario.
 *
 * Test klasa za Netflix proces registracije i ponovne aktivacije članstva.
 * Pokriva i pozitivan scenario i provere validacije e-mail adrese.
 */
public class PageClasseCreateOrRestartMembershipTest extends BaseTestClass {

	/**
	 * Navigates to Netflix Serbia homepage before each test.
	 *
	 * Navigacija do Netflix početne strane (Srbija) pre svakog testa.
	 */
	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://www.netflix.com/rs/");
	}

	/**
	 * Clears all cookies after each test to reset session.
	 *
	 * Briše sve kolačiće nakon svakog testa radi čiste sesije.
	 */
	@AfterMethod
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	/**
	 * Test that completes the full membership creation flow: email → password →
	 * plan selection → payment method screen.
	 *
	 * Test koji prolazi kroz kompletan tok registracije: e-mail → lozinka → izbor
	 * plana → prikaz načina plaćanja.
	 */
	@Test
	public void checkMember() {
		membershipPageClass.checkInputFieldEmailMember("brucewaynebatman1901@gmail.com");
		membershipPageClass.buttonCLickStarted();
		membershipPageClass.enterPassword("N!k0L@91");
		membershipPageClass.buttonNextClick();
		membershipPageClass.nextClickButton();
		membershipPageClass.isStandardClick();
		membershipPageClass.isStandardButtonClick();
		membershipPageClass.isWorkClickButtonHowToPay();
	}

	/**
	 * Test email validation by entering invalid email. Asserts that proper error
	 * message is shown.
	 *
	 * Testira validaciju e-mail-a unosom neispravne adrese. Proverava da li je
	 * prikazana odgovarajuća poruka o grešci.
	 */
	@Test
	public void checkMemberValidation() {
		membershipPageClass.checkInputFieldEmailMember("asdasd");
		membershipPageClass.buttonCLickStarted();
		membershipPageClass.errorEmailMember();
	}
}
