package netflix;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Page Object klasa koja predstavlja početnu (landing) stranicu Netflix sajta.
 * Sadrži sve potrebne elemente i metode za validaciju jezika, zaglavlja, cene,
 * sekcija i FAQ-ova.
 *
 * Page Object class representing the main (landing) page of the Netflix
 * website. Contains all necessary WebElements and methods for validating
 * language, headers, pricing info, feature sections, and FAQ blocks.
 */
public class PageClasses {
	WebDriver driver;
	WebDriverWait wait;

	public PageClasses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Element
	@FindBy(css = "#appMountPoint > div > div > div > div > div > div > div.default-ltr-cache-pw7jst > div > div.default-ltr-cache-180snrw.e1r6dvsr3 > div > div > header > div:nth-child(1) > div.default-ltr-cache-1sdmy2l.e1r6dvsr0 > span > svg")
	WebElement icon;

	@FindBy(css = "select.select_nativeElementStyles__1ewemfi0")
	WebElement languageDropdown;

	@FindBy(css = "h1.default-ltr-cache-jmnaey.euy28770")
	WebElement textHeaderDisplay;

	@FindBy(css = "#appMountPoint > div > div > div > div > div > div > div.default-ltr-cache-pw7jst > div > div.default-ltr-cache-1tlz4mq.ebqi7bx1 > div > div.default-ltr-cache-15fecvd > div.default-ltr-cache-2lmy8v.ebqi7bx0 > div > div.default-ltr-cache-vpfwpr > div > div > p")
	WebElement textParagraphPrice;

	@FindBy(css = "#appMountPoint > div > div > div > div > div > div > div.default-ltr-cache-pw7jst > div > div.default-ltr-cache-1tlz4mq.ebqi7bx1 > div > div.default-ltr-cache-15fecvd > div.default-ltr-cache-2lmy8v.ebqi7bx0 > div > div.default-ltr-cache-tzpj5x > div > form > h3")
	WebElement textParagraphSmallLowerr;

	@FindBy(xpath = "//*[@id='appMountPoint']/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/ul")
	private WebElement listContainer;

	@FindBy(xpath = "//*[@id='appMountPoint']/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/ul/li")
	private List<WebElement> listItems;

	@FindBy(xpath = "//*[@id=\"appMountPoint\"]/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/ul/li[1]")
	private List<WebElement> cacheElements;

	@FindBy(xpath = "//*[@id=\"nmhp-full-value-props\"]/div[2]")
	private WebElement firstDiv;

	@FindBy(xpath = "//*[@id='nmhp-full-value-props']/div[2]/div/div[1]")
	WebElement firstDivSection;

	@FindBy(xpath = "//*[@id='nmhp-full-value-props']/div[2]/div/div[1]/div/div/div/div/div[1]/h3")
	WebElement firstDivSectionHeader;

	@FindBy(xpath = "//*[@id='nmhp-full-value-props']/div[2]/div/div[1]/div/div/div/div/div[2]/p")
	WebElement firstDivSectionParagraph;

	@FindBy(xpath = "//*[@id='television-core-small']")
	WebElement firstDivSectionIcon;

	@FindBy(css = ".accordion-item_styles__1kliwn50.default-ltr-cache-y0rrtk.e164gv2o2")
	private List<WebElement> faqItems;

	// Metod
	/**
	 * Proverava da li je glavni Netflix SVG ikonica vidljiva. Checks if the main
	 * Netflix SVG icon is displayed.
	 */
	public void isIconDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(icon));
	}

	/**
	 * Selektuje jezik sa dropdown-a po vrednosti. Selects language from dropdown
	 * using the value.
	 */
	public void selectLanguage(String languageValue) {
		Select select = new Select(languageDropdown);
		select.selectByValue(languageValue); // Selektuje opciju po vrednosti
	}

	/**
	 * Vraća tekst iz glavnog h1 zaglavlja. Returns the main header text from the
	 * landing section.
	 */
	public String isFirstHeaderDisplayed() {
		return textHeaderDisplay.getText();
	}

	/**
	 * Vraća tekst cene/ponude iz odgovarajućeg paragrafa. Returns price/offer text
	 * from the paragraph below the header.
	 */
	public String isFirstParagraphPriceDisplayed() {
		return textParagraphPrice.getText();
	}

	/**
	 * Vraća tekst iz sekundarnog informativnog paragrafa. Returns the secondary
	 * info paragraph displayed under the form.
	 */
	public String isSecondParagraphLowerrDisplayed() {
		return textParagraphSmallLowerr.getText();
	}

	/**
	 * Broji
	 * <li>elemente unutar liste ponuda/prednosti. Counts number of
	 * <li>elements in the feature list.
	 */
	public int countListItems() {
		wait.until(ExpectedConditions.visibilityOf(listContainer)); // Čekamo da se `ul` učita
		return listItems.size();
	}

	/**
	 * Broji keširane elemente (ul/li) sa preddefinisanim stilovima. Counts
	 * cached/styled list elements in a predefined container.
	 */
	public int countCacheElements() {
		wait.until(ExpectedConditions.visibilityOfAllElements(cacheElements));
		return cacheElements.size();
	}

	/**
	 * Klikće kroz sve cache elemente i ispisuje njihov tekst. Iteratively clicks
	 * each cached list item and prints its text.
	 */
	public void clickAllCacheElements() {
		wait.until(ExpectedConditions.visibilityOfAllElements(cacheElements));

		for (WebElement item : cacheElements) {
			item.click();
			System.out.println("Kliknuto na: " + item.getText());
		}
	}

	/**
	 * Proverava da li su svi keširani elementi prikazani. Asserts that all cached
	 * list elements are visible.
	 */
	public void verifyCacheElementsVisibility() {
		wait.until(ExpectedConditions.visibilityOfAllElements(cacheElements));

		for (WebElement item : cacheElements) {
			Assert.assertTrue(item.isDisplayed(), "Element nije vidljiv!");
		}
	}

	/**
	 * Proverava da li je prikazana glavna div sekcija sa feature prikazom. Checks
	 * if the first main value proposition block is displayed.
	 */
	public boolean isFirstDivDisplayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nmhp-full-value-props\"]/div[2]")));
		return firstDiv.isDisplayed();
	}

	/**
	 * Proverava vidljivost glavnog wrapper div-a unutar feature sekcije. Checks
	 * visibility of the first inner feature block container.
	 */
	public boolean isFirstDicSectionDisplayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='nmhp-full-value-props']/div[2]/div/div[1]")));
		return firstDivSection.isDisplayed();
	}

	/**
	 * Proverava prikaz glavnog h3 naslova u feature sekciji. Checks whether the
	 * header inside the value proposition block is visible.
	 */
	public boolean isFirstDivSectionHeaderDisplayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id='nmhp-full-value-props']/div[2]/div/div[1]/div/div/div/div/div[1]/h3")));
		return firstDivSectionHeader.isDisplayed();
	}

	/**
	 * Proverava prikaz opisa/teksta u paragrafu feature sekcije. Checks visibility
	 * of the paragraph text inside the feature section.
	 */
	public boolean isFirstDivSectionParagraphDisplayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id='nmhp-full-value-props']/div[2]/div/div[1]/div/div/div/div/div[2]/p")));
		return firstDivSectionParagraph.isDisplayed();
	}

	/**
	 * Proverava da li je ikonica televizora u prvoj sekciji prikazana. Checks if
	 * the television icon is displayed in the first visual section.
	 */
	public boolean isFirstDivSectionIconDisplayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='television-core-small']")));
		return firstDivSectionIcon.isDisplayed();
	}

	/*----------------------*/

}
