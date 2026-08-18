package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import UtilityLayer.PropertyReader;
import UtilityLayer.ThreadLocalClass;

public class BaseClass {

	public static void initialization() {
		
		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(opt);
		
		ThreadLocalClass.setDriver(driver);
		
		WebDriver ThreadLocal = ThreadLocalClass.getDriver();

		ThreadLocal.manage().window().maximize();

		ThreadLocal.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ThreadLocal.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));

		ThreadLocal.manage().deleteAllCookies();

		String url = PropertyReader.getProperty("Url");

		ThreadLocal.get(url);

	}
}
