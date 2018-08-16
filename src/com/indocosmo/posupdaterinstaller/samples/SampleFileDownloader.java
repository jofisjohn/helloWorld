package com.indocosmo.posupdaterinstaller.samples;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class SampleFileDownloader {

	
	private String url;
	private int contentLength;
	private String fileName;
	private InputStream inputStream;
	
	public static void main(String[] args) {
		System.out.println(" Welcome ");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
		
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void getDownloadFile() throws IOException
	{
		URL urlString = new URL(getUrl());
		HttpURLConnection connection = (HttpURLConnection)urlString.openConnection();
		int responseCode = connection.getResponseCode();
		
		//checking status code
		if(responseCode == HttpURLConnection.HTTP_OK) {
			String disposition = connection.getHeaderField("Content-Disposition");
			String contentType = connection.getContentType();
			contentLength = connection.getContentLength();
			if(disposition != null) {
				int index = disposition.indexOf("filename=");
				if(index > 0)
				{
					fileName = disposition.substring(index+10,disposition.length()-1);
										
				}
				else
				{
					fileName = getUrl().substring(getUrl().lastIndexOf("/")+1, getUrl().length());
				}
				
				 System.out.println("Content-Type = " + contentType);
		         System.out.println("Content-Disposition = " + disposition);
		         System.out.println("Content-Length = " + contentLength);
		         System.out.println("fileName = " + fileName);
		         
		         inputStream = connection.getInputStream();
			}
			else
			{
				throw new IOException("File Download Error "+responseCode);
			}
			
			
		}
	}

}
