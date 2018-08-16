package com.indocosmo.posupdaterinstaller.samples;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

public class SampleConnectionTimeout {
	
	private static String CONNECTION_URL = "";
	public static void main(String[] args) {
		
		URL url;
		 
		URLConnection urlConnection;
		try {
			
			if(!CONNECTION_URL.contains("http://"))
			{
				MalformedURLException e = new MalformedURLException("Malformed url exception");
				throw e;
			}
			url = new URL(CONNECTION_URL);
			urlConnection = url.openConnection();
			System.out.println(urlConnection.getReadTimeout());	
		} catch (Exception e) {
			
			String exceptionClass = e.getClass().toString();
			System.out.println(""+exceptionClass.substring(exceptionClass.lastIndexOf(".")+1, exceptionClass.length()));
		}
		
			
		
		
	}

}
