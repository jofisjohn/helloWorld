package com.gibin.ftp.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.print.attribute.standard.OutputDeviceAssigned;

import com.gibin.ftp.model.BeanFtpUser;

public class FtpUtils {
	BeanFtpUser beanFtpUser;
	
	public FtpUtils() {
		super();
		
	}
	public FtpUtils(BeanFtpUser beanFtpUser) {
		beanFtpUser =beanFtpUser;
	}

	public void login()
	{
		 String ftpUrl = "ftp://%s:%s@%s/%s";
	     String host = "files.000webhost.com";
	     String user = "gibinindocosmo";
	     String pass = "g7b2n1gibin";
	     String dirPath = "public_html/";
	     
	     ftpUrl = String.format(ftpUrl, user,pass,host,dirPath);
	     System.out.println("FTP URL"+ftpUrl);
	     
	     try
	     {
	    	 URL url = new URL(ftpUrl);
	         URLConnection conn = url.openConnection();
	         InputStream inputStream = conn.getInputStream();
	         BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	         String line = null;
	         System.out.println("--- START ---");
	         while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	         }
	         inputStream.close();
             reader.close();
             
	         System.out.println("--- END ---");
	         /*
	          * Upload file need to complete
	          * 
	          * */
	        /* URLConnection con = url.openConnection();
	         //OutputStream outputstream = con.getOutputStream();
	         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(con.getOutputStream());
	         File mtemp = new File("tempaccesslog.txt");
	         FileOutputStream fileOutputStream  = new FileOutputStream(mtemp);
	         fileOutputStream.write("blabla".getBytes());
	         fileOutputStream.close();
	         
	         FileInputStream fileInputStream = new FileInputStream("tempaccesslog.txt");
	         byte[] bytesin = new byte[4096];
	         int read = 0;
	         while ((read = fileInputStream.read()) != -1) {
	                outputstream.write(bytesin, 0, read);
	         }
	        */
	         
	         
            
	     }
	     catch(Exception e)
	     {
	    	 System.out.println("Exception "+e.getLocalizedMessage());
	     }
	}
	
}
