package commonClassesReusable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import componentDefinition.GlobalComponents;

public class ReadDataFromPropertiesFile {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static String readProperty_CommonData(String varname) throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(GlobalComponents.commonData);
		properties.load(fis);
		String varname1 = properties.getProperty(varname);
		return varname1;

	}
	
}
