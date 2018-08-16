package com.gibin.ftp.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SmtpServer {
	
	Socket smtpSocket = null;
	PrintWriter sockOut = null;
	InputStream sockIn = null;
	
	  public void connect(String server, String myDomain) {
		    try {
		      smtpSocket = new Socket(server, 25);
		      sockOut = 
		        new PrintWriter(
		              new OutputStreamWriter(smtpSocket.getOutputStream(), "UTF-8"),
		              true);
		      sockIn = smtpSocket.getInputStream();

		      // Is the connection established?
		      // Read the server response and
		      // check whether it is 220.

		      		readResponse(220);

		      // Introduce ourselves to the server
		      // If he accepts us he returns 250
		      
		      		doRequest("HELO " + myDomain, 250);


		    } catch (UnknownHostException e) {
		        System.err.println("Unknown host: " + server);
		        	cleanExit(1);
		    } catch (IOException exc) {
		        System.err.println(exc);
		        	cleanExit(2);
		    }
		  }
	  // Sending e-mail
	  public void send(String from, String to, String fname) {
	    try {

	      // Initialize
	      // The code 250 means OK
	      doRequest("MAIL FROM:<" + from + ">", 250);

	      // Specify the recipient
	      // The code 250 means OK
	      doRequest("RCPT TO:<" + to + ">", 250);

	      // Send data
	      // The response 354 means the server is ready for receiving data
	      doRequest("DATA", 354);

	      // Now we write the data to the socket's output stream 
	      // First the headers:
	      sockOut.println("From: " + from);
	      sockOut.println("To: " + to);

	      // Read the mail contents from the file
	      // We change each line consisting of a single dot into double dots
	      // because a single dot specifies the end of message
	      BufferedReader br = new BufferedReader(
	                            new FileReader(fname));
	      String line;
	      while ((line = br.readLine()) != null) {
	        if (line.equals(".")) line += ".";
	        sockOut.println(line);
	      }
	      // The sequence CRLF.CRLF denotes the end of message
	      // The second CRLF is added in the doRequest by println
	      doRequest("\r\n.", 250);

	    } catch (IOException e) {
	        System.err.println(e);
	        cleanExit(2);
	    }
	  }
	  

	  // Close the connection
	  public void closeConnection() {
	    try {
	      doRequest("QUIT", 221);
	    } catch (Exception exc) {
	      System.err.println(exc);
	    }
	    cleanExit(0);
	  }
	  
	  private void doRequest(String req, int checkCode)
              throws IOException {
		  sockOut.println(req);
		  System.out.println("Client: " + req);
		  readResponse(checkCode);
	  }
	  
	  private void readResponse(int checkCode) throws IOException {
		    byte[] readBytes = new byte[10000];
		    int num = sockIn.read(readBytes);
		    String resp = new String(readBytes, 0, num);
		    System.out.println("Server: " + resp);
		    if (!resp.startsWith(String.valueOf(checkCode)))
		     throw new IOException("Unexpected response from the server");
		  }
	  
	  private void cleanExit(int code) {
		    try {
		      sockIn.close();
		      sockOut.close();
		      smtpSocket.close();
		    }
		    catch (Exception exc) {}
		    System.exit(code);
		  }
	  
	  public static void main(String[] args) {
	 
		  String server = "pop3.indocosmo.in";
		    String myDomain = "70.32.106.137";
		    String from = "gibin@indocosmo.in";
		    String to = "gibin.indocosmo@gmail.com";
		    SmtpServer email = new SmtpServer();
		    email.connect(server, myDomain);
		    email.send(from, to, "mail1");
		    email.send(from, to, "mail2");
		    email.closeConnection();
		  
	  }

}
