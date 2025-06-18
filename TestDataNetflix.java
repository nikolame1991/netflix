package netflix;

import org.testng.annotations.DataProvider;

public class TestDataNetflix {
	public String VALID_EMAIL = "nikolamedan1991@gmail.com";
	public String VALID_PASSWORD = "N!k0L@91";

	public String INVALID_EMAIL = "notAnEmail";
	public String INVALID_PASSWORD = "123";

	public String EXPECTED_HEADER = "Unlimited movies, TV shows, and more";
	public String EXPECTED_PRICE_TEXT = "Starts at EUR 4.99. Cancel anytime.";

	@DataProvider(name = "userData")
	public Object[][] userData() {
		return new Object[][] { { "nikolamedan1991@gmail.com", "nikola1991", "notAnEmail", "123" },
				{ "Unlimited movies, TV shows, and more", "Starts at EUR 4.99. Cancel anytime." } };
	}
}
