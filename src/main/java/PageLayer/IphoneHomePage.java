package PageLayer;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.HandleDropDown;
import UtilityLayer.ThreadLocalClass;
import UtilityLayer.Wait;
import UtilityLayer.WindowHandles;

public class IphoneHomePage extends BaseClass {

	@FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']")
	WebElement allButton;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchButton;

	@FindBy(xpath = "//h2[contains(@aria-label,'iPhone 17 Pro 512 GB')]")
	WebElement iPhoneMoblie;

	public WebElement mobileColour(int value) {

		return ThreadLocalClass.getDriver().findElement(By.xpath("//input[@name='" + value + "']"));
	}

	@FindBy(xpath = "(//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay apex-pricetopay-value'])[1]")
	WebElement price;

	@FindBy(xpath = "//span[@id=\"productTitle\"]")
	WebElement mobileTitle;

	@FindBy(xpath = "//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']")
	WebElement regularPriceSelected;

	@FindBy(xpath = "(//input[@id=\"add-to-cart-button\"])[2]")
	WebElement addToCart;

	@FindBy(xpath = "//span[text()=' Cart subtotal ']/following::input[1]")
	WebElement cart;

	@FindBy(name = "proceedToRetailCheckout")
	WebElement proceedToBuyButton;

	@FindBy(id = "ap_email_login")
	WebElement loginPage;

	@FindBy(xpath = "(//input[@name='email']/following::i[@aria-hidden='true'])[2]")
	WebElement loginInvalidIcon;
	
	@FindBy(xpath = "//div[normalize-space()='Your password is incorrect']")
	WebElement invalidPassword;

	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement continueButtonLogin;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "signInSubmit")
	WebElement signInSubmit;

	@FindBy(xpath = "//a[@id='nav-checkout-title-header-text']")
	WebElement SecureCheckout;

	@FindBy(xpath = "//span[@id='checkout-secondary-continue-button-id-announce']")
	WebElement PaymentMethodButton;

	@FindBy(xpath = "//h4[@class='a-alert-heading']")
	WebElement itemNotAvailable;

	public IphoneHomePage() {

		PageFactory.initElements(ThreadLocalClass.getDriver(), this);
	}

	public void selectCategory(String text) {

		HandleDropDown.handleDropDown(allButton, text);
	}

	public void searchFunctionality(String searchText) {

		Wait.click(searchBox);
		Wait.sendKeys(searchBox, searchText);
		Wait.click(searchButton);

	}

	public void clickToMobile(String contain) {

		if (iPhoneMoblie.getAttribute("aria-label").contains(contain)) {

			Wait.click(iPhoneMoblie);
		} else {

			Wait.click(iPhoneMoblie);

			for (int j = 1; j < 3; j++) {

				WebElement wb = mobileColour(j);

				wb.click();
			}
		}
	}

	public void switchToNewWindow() {

		WindowHandles.getWindow(1);
	}

	public String capturePrice() {

		return Wait.getText(price);
	}

	public String textContainsInTitleOrNot() {

		return Wait.getText(mobileTitle);

	}

	public void addToCart() {
		
		Wait.click(addToCart);
	}

	public void proceedToBuy() {

		Wait.click(proceedToBuyButton);
	}

	public boolean usernamePageFunctionality(String loginUsername) {

		try {
			Wait.sendKeys(loginPage, loginUsername);

			Wait.elementToBeClickable(continueButtonLogin);
			
			return loginInvalidIcon.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public boolean passwordPageFunctionality(String value) {

		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (Exception e) {
			e.printStackTrace();
			;
		}

		try {
			
		Wait.sendKeys(password, value);
		Wait.click(signInSubmit);
		

		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		
		return invalidPassword.isDisplayed();
		
		}catch(Exception e) {
			
			return false;
		}

	}

	public boolean getSecureCheckoutPageName() {

		try {
			return SecureCheckout.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getSecureCheckoutText() {
		
		return SecureCheckout.getText();
	}

	public boolean paymentMethodButton() {

		try {

			return PaymentMethodButton.isDisplayed();

		} catch (Exception e) {

			return false;
		}
		// System.out.println(continueButton.getText());

	}

	public String itemNotAvailable() {

		return Wait.getText(itemNotAvailable);
	}
}
