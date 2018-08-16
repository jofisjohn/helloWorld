package com.indocosmo.posupdaterinstaller.samples;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class SampleJProgressBar {

	JProgressBar progressBar=null;
	public static void main(String[] args) {
		
		SampleJProgressBar bar = new SampleJProgressBar();
		bar.init();
		
		
	}
	
	public  void progressUpdate() {
		/*for(int i=0;i<101;i++)
		{
			try{
				Thread.sleep(250);
				System.out.println("Value "+i);
				progressBar.setValue(i);
				
			}catch(Exception e){}
			
		}*/
		try {
			final int BUFFER = 4096;
			byte[] buffer = new byte[BUFFER];
			int byteRead = -1;
			int receivedSize = 0;
			int totalfilesize = 0;
			SampleFileDownloader downloader = new SampleFileDownloader();
			downloader.setUrl("http://4.bp.blogspot.com/-4RdWlJwr2qA/UzrvbBKaU0I/AAAAAAAAACA/ORgPGKhfjMs/s1600/aosb-bg.jpg");
			downloader.getDownloadFile();
			totalfilesize  = downloader.getContentLength();
			
			InputStream inputStream = downloader.getInputStream();
			String filePath = "./Download/"+downloader.getFileName();
			FileOutputStream outputStream = new FileOutputStream(filePath);
			while((byteRead = inputStream.read(buffer)) != -1)
			{
				outputStream.write(buffer, 0, byteRead);
				receivedSize+=byteRead;
				int percentage = (receivedSize/totalfilesize)*100;
				progressBar.setValue(percentage);
				
			}
			outputStream.close();
			
			
		}
		catch(IOException e)
		{
			System.out.println("Exception "+e.getLocalizedMessage());
		}
	}
	
	public void init()
	{
		JFrame frame = new JFrame();
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(3);
		frame.setUndecorated(true);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setSize(frame.getWidth(), 30);
		titlePanel.setLayout(null);
		titlePanel.setLocation(0, 0);
		titlePanel.setBackground(Color.green);
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("POS Updater ");
		titleLabel.setSize(100,20);
		titleLabel.setLocation(2, 2);
		titlePanel.add(titleLabel);
		
		JButton btnExit = new JButton();
		btnExit.setText("Exit");
		btnExit.setSize(100, 50);
		btnExit.setLocation(frame.getWidth()-btnExit.getWidth()-5, frame.getHeight()-btnExit.getHeight()-5);
		
		progressBar = new JProgressBar(0,101);
		progressBar.setSize(frame.getWidth()-5, 50);
		progressBar.setLocation(2, frame.getHeight()/2);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.CYAN);
		progressBar.setForeground(Color.BLUE);
				
		frame.add(titlePanel);
		frame.add(progressBar);
		frame.add(btnExit);
		frame.setVisible(true);
		
		progressUpdate();
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

	}

}
