package UtilityLayer;

import org.openqa.selenium.Alert;

import BaseLayer.BaseClass;

public class HandleAlertPopup extends BaseClass {

	private static Alert alt;

	public static void accept() {

		alt = ThreadLocalClass.getDriver().switchTo().alert();

		alt.accept();
	}

	public static void dismiss() {
		alt = ThreadLocalClass.getDriver().switchTo().alert();
		alt.dismiss();
	}

	public static String getText() {
		alt = ThreadLocalClass.getDriver().switchTo().alert();
		return alt.getText();
	}

	public static void sendKeys(String value) {
		alt = ThreadLocalClass.getDriver().switchTo().alert();
		alt.sendKeys(value);

	}
}
