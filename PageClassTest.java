package netflix;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test klasa za verifikaciju elemenata na Netflix početnoj stranici (RS
 * verzija). Obuhvata validaciju ikonica, jezičkog dropdown-a, tekstualnih
 * blokova i dinamičkih elemenata.
 *
 * Test class for validating elements on the Netflix homepage (Serbia region).
 * Includes checks for icons, language dropdown, static text, and dynamic
 * feature blocks.
 */

public class PageClassTest extends BaseTestClass {

	/**
	 * Otvara Netflix RS stranicu pre svakog testa. Navigates to the Netflix Serbia
	 * homepage before each test.
	 */
	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://www.netflix.com/rs/");
	}

	/**
	 * Briše sve kolačiće posle svakog testa radi čiste sesije. Deletes all cookies
	 * after each test to ensure clean session.
	 */
	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	/**
	 * Glavni test koji proverava prikaz UI elemenata, tekstova i jezičkih opcija.
	 * Main test that validates UI elements, expected texts, and language options.
	 */
	@Test
	public void checkWebSite() {

		// Provera da li je Netflix SVG logo prikazan
		// Check if Netflix SVG logo is visible
		netflixPageClasses.isIconDisplayed();
		/*-----------------*/
		// Provera da dropdown sadrži opcije: English i Hrvatski
		// Assert that dropdown includes: English and Croatian
		Select select = new Select(netflixPageClasses.languageDropdown);
		List<WebElement> options = select.getOptions();

		boolean containsEnglish = options.stream().anyMatch(o -> o.getText().equals("English"));
		boolean containsCroatian = options.stream().anyMatch(o -> o.getText().equals("Hrvatski"));

		Assert.assertTrue(containsEnglish, "Opcija 'English' nije pronađena!");
		Assert.assertTrue(containsCroatian, "Opcija 'Hrvatski' nije pronađena!");
		/*-----------------*/
		/*
		 * netflixPageClasses.buttonSignInIsClick();
		 */
		/*-----------------*/
		// Verifikacija H1 naslova
		String actualText = netflixPageClasses.isFirstHeaderDisplayed();
		String expectedText = "Unlimited movies, TV shows, and more";

		Assert.assertEquals(actualText, expectedText, "Tekst nije ispravan!");
		/*-----------------*/
		// Provera teksta sa cenom
		String actualFirstParagraph = netflixPageClasses.isFirstParagraphPriceDisplayed();
		String expectedFirstParagraph = "Starts at EUR 4.99. Cancel anytime.";
		Assert.assertEquals(actualFirstParagraph, expectedFirstParagraph, "Tekst cena nije ispravan");

		/*-----------------*/
		// Provera tekstualne poruke ispod forme
		String actualParagraphSmallLowerr = netflixPageClasses.isSecondParagraphLowerrDisplayed();
		String expectedParagraphSmallLowerr = "Ready to watch? Enter your email to create or restart your membership.";
		Assert.assertEquals(actualParagraphSmallLowerr, expectedParagraphSmallLowerr, "Tekst nije ispravan");

		/*-----------------*/

		// Brojanje <li> elemenata unutar liste prednosti (feature lista)
		netflixPageClasses.countListItems();

		/*-----------------*/
		// Provera da je lista prednosti renderovana (nije prazna)
		int itemCount = netflixPageClasses.countCacheElements();
		System.out.println("Broj elemenata: " + itemCount);
		Assert.assertTrue(itemCount > 0, "Nema elemenata na stranici!");
		/*-----------------*/
		// Provera da su svi elementi vidljivi
		netflixPageClasses.verifyCacheElementsVisibility();
		/*-----------------*/
		// Klik na svaki od njih i ispis
		netflixPageClasses.clickAllCacheElements();

		/*-----------------*/
		// Provera da li je glavna div sekcija prisutna
		netflixPageClasses.isFirstDivDisplayed();
		/*-----------------*/
		// Provera wrapper sekcije unutar div-a
		netflixPageClasses.isFirstDicSectionDisplayed();
		/*-----------------*/
		// Provera naslova, paragrafa i ikonice unutar sekcije
		netflixPageClasses.isFirstDivSectionHeaderDisplayed();
		netflixPageClasses.isFirstDivSectionParagraphDisplayed();
		netflixPageClasses.isFirstDivSectionIconDisplayed();
		/*-----------------*/

	}
}
