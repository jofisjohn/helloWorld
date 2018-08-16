package com.gibin.ftp;

import com.gibin.ftp.forms.UiSample1;
import com.gibin.ftp.model.BeanNtpServer;
import com.gibin.ftp.utils.FtpUtils;
import com.gibin.ftp.utils.TimeServer;

public class FtpApplication {

	public static void main(String[] args) {
		
		//ftp access
		FtpUtils ftpUtils = new FtpUtils();
		ftpUtils.login();
		
		//nntp server
		try
		{
			BeanNtpServer beanNtpServer = new BeanNtpServer();
			beanNtpServer.setHost("time.nist.gov");
			beanNtpServer.setPort(13);
			TimeServer timeServer =  new TimeServer();
			String response = timeServer.getResponse(beanNtpServer);
			System.out.println(" Response "+response);
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e.getMessage());
		}
		
		//uisample1
		UiSample1 sample1 = new UiSample1();
		sample1.setVisible(true);
		
	}

}
