package com.gibin.ftp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import com.gibin.ftp.model.BeanNtpServer;

public class TimeServer {
	
	public String getResponse(BeanNtpServer beanNtpServer) throws UnknownHostException, IOException
	{
		
		String response = "";
		Socket socket = new Socket(beanNtpServer.getHost(), beanNtpServer.getPort());
		
		BufferedReader br = new BufferedReader(
				 new InputStreamReader(socket.getInputStream())
               );
		
		String line;
	    while ((line = br.readLine()) != null) {
	        //System.out.println(line);
	    	response += line;
	    }
	    
	    br.close();
	    socket.close();
		
		
		return response;
	}

}
