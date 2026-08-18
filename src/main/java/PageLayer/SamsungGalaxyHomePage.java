package PageLayer;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.HandleDropDown;
import UtilityLayer.ThreadLocalClass;
import UtilityLayer.Wait;
import UtilityLayer.WindowHandles;

public class SamsungGalaxyHomePage extends BaseClass {

	@FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']")
	WebElement allButton;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchButton;

	@FindBy(xpath = "//h2[contains(@aria-label,'Galaxy S25 Edge 5G AI Smartphone (Titanium Silver,')]")
	WebElement samsungGalaxyMoblie;

	@FindBy(xpath = "(//span[@class='a-price-whole'])[6]")
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

	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement continueButtonLogin;

	@FindBy(xpath = "(//input[@name='email']/following::i[@aria-hidden='true'])[2]")
	WebElement loginInvalidIcon;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[normalize-space()='Your password is incorrect']")
	WebElement invalidPassword;

	@FindBy(id = "signInSubmit")
	WebElement signInSubmit;

	@FindBy(xpath = "//a[@id='nav-checkout-title-header-text']")
	WebElement SecureCheckout;

	@FindBy(xpath = "//span[@id='checkout-secondary-continue-button-id-announce']")
	WebElement paymentMethodButton;

	@FindBy(xpath = "//h4[@class='a-alert-heading']")
	WebElement itemNotAvailable;

	public SamsungGalaxyHomePage() {

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

		Wait.click(samsungGalaxyMoblie);

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

//		Wait.click(regularPriceSelected);
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

		} catch (Exception e) {

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

			return paymentMethodButton.isDisplayed();

		} catch (Exception e) {

			return false;
		}
		// System.out.println(continueButton.getText());

	}

	public String itemNotAvailable() {

		return Wait.getText(itemNotAvailable);
	}
}
