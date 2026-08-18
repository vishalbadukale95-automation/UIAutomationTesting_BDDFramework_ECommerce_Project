package UtilityLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import BaseLayer.BaseClass;

public class JavaScriptExecutor extends BaseClass {

	private static JavascriptExecutor js;

	public static void sendKeys(WebElement wb, String value) {

		js = (JavascriptExecutor) ThreadLocalClass.getDriver();

		js.executeScript("arguments[0].value=" + value + ";", wb);
	}

	public static void click(WebElement wb) {

		js = (JavascriptExecutor) ThreadLocalClass.getDriver();

		js.executeScript("arguments[0].click();", wb);
	}

}
