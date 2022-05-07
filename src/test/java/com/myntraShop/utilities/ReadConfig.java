package com.myntraShop.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream f1 = new FileInputStream(src);
			pro = new Properties();
			pro.load(f1);

		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());

		}
	}

	public String getApplicationURL() {
		String baseurl = pro.getProperty("url");
		return baseurl;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;

	}
	
	public String getMozzilaPath() {
		String mozillapath = pro.getProperty("mozillaPath");
		return mozillapath;

	}

}
