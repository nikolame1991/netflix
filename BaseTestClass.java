package netflix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestClass {
	WebDriver driver;

	PageClasses netflixPageClasses;
	PageClassLogin loginNetflix;
	PageClasseCreateOrRestartMembership membershipPageClass;

	@BeforeTest
	public void initalization() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		netflixPageClasses = new PageClasses(driver);
		loginNetflix = new PageClassLogin(driver);
		membershipPageClass = new PageClasseCreateOrRestartMembership(driver);
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
