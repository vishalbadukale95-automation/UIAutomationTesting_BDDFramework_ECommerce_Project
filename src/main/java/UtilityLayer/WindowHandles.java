package UtilityLayer;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import BaseLayer.BaseClass;

public class WindowHandles extends BaseClass {

	public static WebDriver getWindow(int indexNo) {

		Set<String> multipleWin = ThreadLocalClass.getDriver().getWindowHandles();

		ArrayList<String> arr = new ArrayList<String>(multipleWin);

		return ThreadLocalClass.getDriver().switchTo().window(arr.get(indexNo));
	}

}
