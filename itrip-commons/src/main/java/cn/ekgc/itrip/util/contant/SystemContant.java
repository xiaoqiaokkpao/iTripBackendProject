package cn.ekgc.itrip.util.contant;

import java.util.Properties;

/**
 * <b>系统常量工具类</b>
 */
public class SystemContant {
	private static Properties properties = new Properties();

	static {
		try {
			properties.load(SystemContant.class.getClassLoader().getResourceAsStream("props/commons.properties"));

		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public static final String SECRET_KEY = properties.getProperty("secret.key");
}
