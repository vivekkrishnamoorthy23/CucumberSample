package StepDefinition;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {

	public static WebDriver driver;

	@Given("The Automation Exercise site is open")

	public void the_automation_exercise_page_is_open() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		// options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.get("https://automationexercise.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@And("click on signup or login menu")

	public void the_user_is_able_to_navigate_to_register_page() {

		By SignupOrLogin = By.linkText("Signup / Login");
		By SignupName = By.xpath("//input[@name='name']");
		driver.findElement(SignupOrLogin).click();
		boolean SignupNameDisplayed = driver.findElement(SignupName).isDisplayed();
		if (SignupNameDisplayed) {
			System.out.println("*******In Signup Or Login Page********");
		} else {
			System.out.println("*******some error occured when clicking Signup or Login menu********");
			driver.quit();
		}
	}

	@When("user enters name {string} and emailid {string}")

	public void the_user_enters_name_and_emailid(String name, String emailid) {

		By SignupName1 = By.xpath("//input[@name='name']");
		By RegisterEmailid = By.xpath("(//input[@name='email'])[2]");
		driver.findElement(SignupName1).sendKeys(name);
		driver.findElement(RegisterEmailid).sendKeys(emailid);
	}

	@And("user clicks signup button and account information page is displayed")

	public void the_user_clicks_signup_and_account_infopage_displayed() {

		try {

			By Signupbutton = By.xpath("//button[contains(text(),'Signup')]");
			driver.findElement(Signupbutton).click();
			By AccountInformationHeading = By.xpath("//b[contains(text(),'Enter Account Information')]");
			boolean AccountInformationHeadingDisplayed = driver.findElement(AccountInformationHeading).isDisplayed();
			if (AccountInformationHeadingDisplayed) {
				System.out.println("*******In Account Information********");
			} else {
				System.out.println(
						"*******some error occured when clicking Signup button from registration page********");
			}
		} catch (Exception e) {
			System.out.println("*******Email id already exist, change the email id********");
			driver.quit();
		}
	}

	@And("user enters account information and clicks create account")

	public void the_user_provide_the_details_and_click_create_account() {

		By Title = By.id("id_gender1");
		By Password = By.id("password");
		Select DobDay = new Select(driver.findElement(By.name("days")));
		Select DobMonth = new Select(driver.findElement(By.name("months")));
		Select DobYear = new Select(driver.findElement(By.name("years")));
		By FirstName = By.id("first_name");
		By LastName = By.id("last_name");
		By Company = By.id("company");
		By Address1 = By.id("address1");
		By Address2 = By.id("address2");
		By State = By.id("state");
		By City = By.id("city");
		By Zipcode = By.id("zipcode");
		By MobileNumber = By.id("mobile_number");

		By CreateAccountButton = By.xpath("//button[contains(text(),'Create Account')]");

		driver.findElement(Title).click();
		driver.findElement(Password).sendKeys("Password01");
		DobDay.selectByValue("23");
		DobMonth.selectByValue("6");
		DobYear.selectByValue("1992");

		driver.findElement(FirstName).sendKeys("vivek");

		driver.findElement(LastName).sendKeys("krishnamoorthy");

		driver.findElement(Company).sendKeys("HCL Technologies");

		driver.findElement(Address1).sendKeys("No 5, 1st main street");

		driver.findElement(Address2).sendKeys("vel murugan nagar, kosapalayam");

		driver.findElement(State).sendKeys("Pondicherry");

		driver.findElement(City).sendKeys("Pondicherry");

		driver.findElement(Zipcode).sendKeys("605013");

		driver.findElement(MobileNumber).sendKeys("9176532324");
		driver.findElement(CreateAccountButton).click();
	}

	@And("check account is created succefully and click continue")

	public void check_account_and_click_continue() throws InterruptedException {

		try {
			By AccountCreatedTxt = By.xpath("//b[contains(text(),'Account Created!')]");

			boolean AccountCreatedTxtIsDisplayed = driver.findElement(AccountCreatedTxt).isDisplayed();
			if (AccountCreatedTxtIsDisplayed) {
				System.out.println("*******Account created successfully********");
			} else {
				System.out.println("*******Account not created successfully********");
			}
		} catch (Exception e) {
			System.out.println("*******Account not created successfully catch********");
		}
		// driver.navigate().refresh();
		// Thread.sleep(5000);
		/*
		 * try { By frame1 = By.id("google_esf");
		 * driver.switchTo().frame(driver.findElement(frame1)); By DismissButton =
		 * By.id("dismiss-button"); driver.findElement(DismissButton).click();
		 * driver.switchTo().defaultContent(); Thread.sleep(5000); } catch (Exception e)
		 * { System.out.println("No Ads"); }
		 */

		By ContinueButton = By.xpath("//a[contains(text(),'Continue')]");
		driver.findElement(ContinueButton).click();
		Thread.sleep(3000);
	}

	@Then("validate correct name is displayed on the landing screen {string}")

	public void check_correct_name_displayed(String name) throws InterruptedException {

		// Thread.sleep(5000);
		// driver.navigate().refresh();
		By LoggedInName = By.xpath("//a[contains(text(),'Logged in as')]");
		// WebDriverWait wait=new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(LoggedInName));

		String LoggedInNameActual = driver.findElement(LoggedInName).getText();
		if (LoggedInNameActual.contains(name)) {
			System.out.println("*****Logged in as " + name + " properly*****");
		} else {
			System.out.println("*****Not Logged in as " + name + " properly*****");
		}

		// driver.navigate().refresh();
		// Thread.sleep(5000);
		/*
		 * try { By frame1 = By.id("google_esf");
		 * driver.switchTo().frame(driver.findElement(frame1)); By DismissButton =
		 * By.id("dismiss-button"); driver.findElement(DismissButton).click();
		 * driver.switchTo().defaultContent(); Thread.sleep(5000); } catch (Exception e)
		 * { System.out.println("No Ads"); }
		 */
	}

	@Then("click logout and check logged out successfully")

	public void logout_from_application() {

		By LogoutButton = By.linkText("Logout");
		driver.findElement(LogoutButton).click();
		By LoginPageTxt = By.xpath("//h2[contains(text(),'Login to your account')]");
		String LoginPageTxtActual = driver.findElement(LoginPageTxt).getText();
		if (LoginPageTxtActual.contains("Login to your account")) {
			System.out.println("*****Logged out successfully*****");
		} else {
			System.out.println("*****Logged out is not successfully*****");
		}

	}

	@When("user enters email {string} and password {string} and clicks login")

	public void the_user_enters_emailid_and_password(String email, String Password) {

		By EmailIdLoc = By.xpath("(//input[@name='email'])[1]");
		By PasswordLoc = By.name("password");
		driver.findElement(EmailIdLoc).sendKeys(email);
		driver.findElement(PasswordLoc).sendKeys(Password);

		By LoginButton = By.xpath("//button[contains(text(),'Login')]");
		driver.findElement(LoginButton).click();
	}

	@When("user add product in cart")

	public void the_user_add_product_in_cart() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		By Product1 = By.xpath("(//a[contains(text(),'View Product')])[1]");
		driver.findElement(Product1).click();
		By Product1AddToCart = By.xpath("//button[@type='button']");
		driver.findElement(Product1AddToCart).click();
		By ViewCart = By.xpath("//u[contains(text(),'View Cart')]");
		driver.findElement(ViewCart).click();
		Thread.sleep(5000);
	}
	
	@And("user procced to checkout")

	public void user_procced_to_checkout() throws InterruptedException {
		
		By ProccedToCheckOut = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
		driver.findElement(ProccedToCheckOut).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		By CheckProduct = By.xpath("//td[@class='cart_description']//h4/a");
		String CheckProductdescription = driver.findElement(CheckProduct).getText();
		if(CheckProductdescription.contains("Blue Top")) {
			System.out.println("****Correct product is added*****");
		} else {
			System.out.println("****Correct product is not added*****");
		}
		
		By PlaceOrder = By.xpath("//a[contains(text(),'Place Order')]");
		driver.findElement(PlaceOrder).click();
		
		Thread.sleep(5000);
	}
	
	@When("check whether payment page is displayed")

	public void check_whether_payment_page_is_displayed() {
		

		By PaymentPage = By.xpath("//h2[@class='heading']");
		String PaymentPageTxt = driver.findElement(PaymentPage).getText();
		if(PaymentPageTxt.contains("Payment")) {
			System.out.println("****Payment Page is displayed*****");
		} else {
			System.out.println("****Payment Page is not displayed*****");
		}
		
		By ClickCart = By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),' Cart')]");
		driver.findElement(ClickCart).click();
		
		By RemoveCart = By.xpath("//a[@class='cart_quantity_delete']");
		driver.findElement(RemoveCart).click();
		
	}
	
	@Then("close the browser")
	public void close_the_browser()  {
		driver.quit();
	}

}