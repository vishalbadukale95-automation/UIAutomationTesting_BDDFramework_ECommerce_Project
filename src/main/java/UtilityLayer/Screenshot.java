package UtilityLayer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseLayer.BaseClass;
import io.cucumber.java.Scenario;

public class Screenshot extends BaseClass {

	public static void takesScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) ThreadLocalClass.getDriver();

			byte[] b = ts.getScreenshotAs(OutputType.BYTES);

			scenario.attach(b, "image/png", scenario.getName());

			File src = ts.getScreenshotAs(OutputType.FILE);

			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

			try {

				FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//Screenshot//" + date + ".png"));

			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			TakesScreenshot ts = (TakesScreenshot) ThreadLocalClass.getDriver();

			byte[] b = ts.getScreenshotAs(OutputType.BYTES);

			scenario.attach(b, "image/png", scenario.getName());

			File src = ts.getScreenshotAs(OutputType.FILE);

			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

			try {

				FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//Screenshot//" + date + ".png"));

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

}
