package UtilityLayer;

import java.io.FileInputStream;
import java.util.Properties;

import BaseLayer.BaseClass;

public class PropertyReader extends BaseClass {

	public static String getProperty(String value) {

		Properties prop;

		try {

			FileInputStream fis = new FileInputStream("src//main//java//ConfigueLayer//configue.Properties");

			prop = new Properties();

			prop.load(fis);

			return prop.getProperty(value);

		} catch (Exception f) {

			f.printStackTrace();
		}
		return null;

	}

}
