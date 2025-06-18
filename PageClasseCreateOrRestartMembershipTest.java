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
	}

	/**
	 * Test validation message when an invalid email is entered.
	 *
	 * Testira validaciju i poruku greške kada se unese neispravan e-mail.
	 */
	@Test
	public void checkInvalidEmail() {
		membershipPageClass.checkInputFieldEmailMember("bru");
		membershipPageClass.buttonCLickStarted();
		membershipPageClass.errorEmailMember();
	}

	/**
	 * Test scenario where password does not meet the expected criteria.
	 *
	 * Negativni test gde uneta lozinka nije validna.
	 */
	@Test
	public void checkInvalidPassword() {
		membershipPageClass.checkInputFieldEmailMember("brucewaynebatman1901@gmail.com");
		membershipPageClass.buttonCLickStarted();
		membershipPageClass.enterPassword("123");
		membershipPageClass.buttonNextClick();
	}

	/**
	 * Uses reusable test data class for login credentials.
	 *
	 * Koristi klasu sa testnim podacima za validaciju protoka.
	 */
	@Test
	public void checkMemberTestData() {
		membershipPageClass.checkInputFieldEmailMember(netflixTestData.VALID_EMAIL);
		membershipPageClass.buttonCLickStarted();
		membershipPageClass.enterPassword(netflixTestData.VALID_PASSWORD);
		membershipPageClass.buttonNextClick();
	}
}
