package UtilityLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import BaseLayer.BaseClass;

public class ChromeOption extends BaseClass {

	public static WebDriver disableNotifications() {

		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(opt);

		ThreadLocalClass.setDriver(driver);

		return ThreadLocalClass.getDriver();
	}
}
