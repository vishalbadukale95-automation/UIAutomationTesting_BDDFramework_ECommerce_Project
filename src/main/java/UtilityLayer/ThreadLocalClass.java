package UtilityLayer;

import org.openqa.selenium.WebDriver;

public class ThreadLocalClass {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {

		return driver.get();
	}

	public static void setDriver(WebDriver newdriver) {

		driver.set(newdriver);
	}
}
