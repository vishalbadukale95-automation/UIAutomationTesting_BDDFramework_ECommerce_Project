package StepDefination_Samsung;

import java.time.Duration;

import org.testng.Assert;

import BaseLayer.BaseClass;
import PageLayer.SamsungGalaxyHomePage;
import UtilityLayer.CustomizeException;
import UtilityLayer.PropertyReader;
import UtilityLayer.Screenshot;
import UtilityLayer.ThreadLocalClass;
import UtilityLayer.Wait;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationSamsungTestClass extends BaseClass {

	private SamsungGalaxyHomePage samsungGalaxyPage;

	@Given("user is on Amazon home page for Samsung")
	public void user_is_on_amazon_home_page_for_samsung() {

		BaseClass.initialization();
	}

	@When("search {string} mobile in search bar for Samsung")
	public void search_mobile_in_search_bar_for_samsung(String string) {
		samsungGalaxyPage = new SamsungGalaxyHomePage();
		samsungGalaxyPage.searchFunctionality(string);
	}

	@When("select if contains {string} in text for Samsung")
	public void select_if_contains_in_text_for_samsung(String string) {

		samsungGalaxyPage.clickToMobile(string);
	}

	@When("capture the price and check the {string} text is contains in the description or not for Samsung")
	public void capture_the_price_and_check_the_text_is_contains_in_the_description_or_not_for_samsung(String string) {

		samsungGalaxyPage.switchToNewWindow();
		String price = samsungGalaxyPage.capturePrice();
		System.out.println(price);
		String description = samsungGalaxyPage.textContainsInTitleOrNot();

		if (description.contains(string)) {
			System.out.println("Valid mobile Selected");
		} else {
			System.out.println("Invalid mobile selected");
		}
	}

	@When("add samsung mobile to cart")
	public void add_samsung_mobile_to_cart() {
		samsungGalaxyPage.addToCart();
	}

	@When("click on Proceed to Buy samsung")
	public void click_on_proceed_to_buy_samsung() {
		samsungGalaxyPage.proceedToBuy();
	}

	@When("enter mobile number as username to login amazon page and click on continue button for samsung")
	public void enter_mobile_number_as_username_to_login_amazon_page_and_click_on_continue_button_for_samsung()
			throws CustomizeException {
		boolean executed = samsungGalaxyPage.usernamePageFunctionality(PropertyReader.getProperty("loginUsername"));
		if (executed) {

			throw new CustomizeException(
					"\033[1;31m PLEASE SET YOUR VALID USERNAME IN CONFIGUE FILE TO GET SUCCESSFULL LOGIN \033[0m");
		}
	}

	@When("Enter password as user amazon login password to login")
	public void enter_password_as_user_amazon_login_password_to_login() throws CustomizeException {
		boolean executed = samsungGalaxyPage.passwordPageFunctionality(PropertyReader.getProperty("password"));

		if (executed) {

			throw new CustomizeException(
					"\033[1;31m PLEASE SET YOUR VALID PASSWORD IN CONFIGUE FILE TO GET SUCCESSFULL LOGIN \033[0m");
		}
	}

	@Then("user should be navigated to secure checkout page and user captures {string} text and verifies useThisPaymentMethod button is displayed and if the selected item is not available from the selected seller, the flow of testing is finished of samsung and verify {string} text")
	public void user_should_be_navigated_to_secure_checkout_page_and_user_captures_text_and_verifies_use_this_payment_method_button_is_displayed_and_if_the_selected_item_is_not_available_from_the_selected_seller_the_flow_of_testing_is_finished_of_samsung_and_verify_text(
			String string, String string2) {
		ThreadLocalClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		if (samsungGalaxyPage.getSecureCheckoutPageName() && samsungGalaxyPage.paymentMethodButton()) {
			System.out.println("\033[1;32m Validation Successfull" + " = " + samsungGalaxyPage.getSecureCheckoutText()
					+ " " + "\033[0m");
			Assert.assertTrue(samsungGalaxyPage.getSecureCheckoutText().contains("Secure checkout"));
		} else if (samsungGalaxyPage.itemNotAvailable().equalsIgnoreCase(string2)) {
			Assert.assertEquals(samsungGalaxyPage.itemNotAvailable(), string2);
			System.out.println(
					"\033[1;31m Validation Successfull because item is not available to seller, flow is completed \033[0m");
		} else {
			System.out.println("\033[1;31m Validation Failed \033[0m");
		}

		ThreadLocalClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterStep
	public void tearDown(Scenario scenario) {

		Wait.waitBeforeScreenshot();
		Screenshot.takesScreenshot(scenario);
	}
}
