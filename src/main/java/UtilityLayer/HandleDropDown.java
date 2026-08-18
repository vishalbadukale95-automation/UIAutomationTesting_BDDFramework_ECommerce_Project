package UtilityLayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class HandleDropDown extends BaseClass {

	public static void handleDropDown(WebElement wb, String text) {
		JavaScriptExecutor.click(wb);
		new Select(new WebDriverWait(ThreadLocalClass.getDriver(), Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(wb))).selectByVisibleText(text);
	}
}
