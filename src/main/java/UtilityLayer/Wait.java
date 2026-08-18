package UtilityLayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class Wait extends BaseClass {

	public static void sendKeys(WebElement wb, String value) {

		new WebDriverWait(ThreadLocalClass.getDriver(), Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(wb)).sendKeys(value);

	}

	public static void click(WebElement wb) {

		new WebDriverWait(ThreadLocalClass.getDriver(), Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(wb)).click();

	}

	public static void elementToBeClickable(WebElement wb) {

		new WebDriverWait(ThreadLocalClass.getDriver(), Duration.ofSeconds(60))
				.until(ExpectedConditions.elementToBeClickable(wb)).click();

	}

	public static String getText(WebElement wb) {

		return new WebDriverWait(ThreadLocalClass.getDriver(), Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(wb)).getText();
	}

	public static void waitBeforeScreenshot() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
