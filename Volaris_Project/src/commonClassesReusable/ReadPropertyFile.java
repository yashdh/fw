package commonClassesReusable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import componentDefinition.GlobalComponents;

public class ReadPropertyFile {

	/**
	 * @param args
	 * @throws IOException
	 */
	static String value;

	public static String read(String varname) {
		try {
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream(GlobalComponents.commonData);
			properties.load(fis);
			value = properties.getProperty(varname);

		} catch (IOException e) {

		}
		return value;
	}
}
