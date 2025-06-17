## 📌 Netflix UI Automation Testing

Automated tests for the Netflix web application using **Selenium WebDriver**, **TestNG**, and **Java**, based on the **Page Object Model (POM)** design pattern.

---

### 📂 Project Structure

| Module | Description |
|--------|-------------|
| `PageClasses.java` | Validates elements on the Netflix landing page (icons, language dropdown, headers, FAQ, etc.) |
| `PageClassLogin.java` | Tests login form functionality (email, password, error handling) |
| `PageClasseCreateOrRestartMembership.java` | Tests the onboarding flow: email → password → plan → payment |
| `BaseTestClass.java` | Base test class for WebDriver setup and lifecycle hooks |
| `test` classes | TestNG-based scenarios (happy path and negative path) |

---

### 🚀 Technologies Used

- [x] Java 21  
- [x] Selenium 4.22.0  
- [x] TestNG  
- [x] Maven  
- [x] ChromeDriver 137+

---

### ✅ Test Coverage

#### 🔹 Netflix Landing Page

- Display of SVG logo
- Language dropdown options (`English`, `Hrvatski`)
- Main header, price, and description sections
- Dynamic validation of feature list (`ul > li`)
- Click actions on all cached list elements
- Validation of the value-section block (title, text, icon)

#### 🔹 Login Flow

- Positive login test (valid credentials)
- Negative login test (displays correct error messages)

#### 🔹 Membership Flow

- Email → password → plan selection → payment method screen
- Validation of page content and button clicks
- Error handling for invalid email input

---

### 🧪 How to Run the Tests

```bash
# Using Maven
mvn test
```

Or run `@Test` methods directly from your IDE (IntelliJ, Eclipse, etc).

---

### 📝 Notes

- Real card details are not used — the flow stops before payment.
- XPath and CSS selectors have been carefully refactored for stability.
- Optional screenshot support can be added via `ITestListener` on test failure.

