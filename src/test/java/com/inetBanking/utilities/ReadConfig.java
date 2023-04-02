package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties po;
	
	public ReadConfig(){
		
		File src=new File("./Configurations/config.properties");
		
		try {
			po=new Properties();
			FileInputStream fis=new FileInputStream(src);
			po.load(fis);		
		}
		catch(Exception e){
			System.out.println("Exception is "+e.getMessage());
		}	
	}
	
	public String getApplicationUrl() {
		String url=po.getProperty("appURL");
		return url;
	}
	
	public String getUsername() {
		String uname=po.getProperty("UserID");
		return uname;
	}
	
	public String getPassword() {
		String pwd=po.getProperty("Password");
		return pwd;
	}
	
	public String getChromePath() {
		String chromepath=po.getProperty("chromepath");
		return chromepath;
	}
	
	public String getMsEdgePath() {
		String edge=po.getProperty("msedgepath");
		return edge;
	}
}
