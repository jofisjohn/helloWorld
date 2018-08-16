package com.indocosmo.posupdaterinstaller.samples;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SampleUIScreen {

	public static void main(String[] args) {
		
		SampleUIScreen screen = new SampleUIScreen(); 
		try {
			screen.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void init() throws Exception
	{
		JFrame mainWindow = new JFrame();
		mainWindow.setSize(600, 400);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setDefaultCloseOperation(3);
		mainWindow.setLayout(null);
		mainWindow.setVisible(true);
		mainWindow.setBackground(Color.RED);
		
		JPanel topPanel = new JPanel();
		topPanel.setSize(600, 100);
		topPanel.setLocation(0, 0);
		topPanel.setBackground(Color.BLUE);
		
		BufferedImage wPic = ImageIO.read(new File("./src/com/indocosmo/posupdaterinstaller/resource/images/logo.png"));
		JLabel wIcon = new JLabel(new ImageIcon(wPic));
		topPanel.add(wIcon);
		
		mainWindow.add(topPanel);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setSize(200, 400);
		leftPanel.setLocation(0, topPanel.getHeight());
		leftPanel.setLayout(null);
		leftPanel.setBackground(Color.GREEN);
		mainWindow.add(leftPanel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setSize(400, 400);
		rightPanel.setLayout(null);
		rightPanel.setLocation(leftPanel.getWidth(),topPanel.getHeight());
		rightPanel.setBackground(Color.CYAN);
		mainWindow.add(rightPanel);
			
	}
	
	public void createTopPanel() throws Exception
	{
		JPanel topContentPanel = new JPanel();
		topContentPanel.setSize(600, 100);
		topContentPanel.setLocation(0, 0);
		topContentPanel.setBackground(Color.WHITE);
		
		BufferedImage wPic = ImageIO.read(this.getClass().getResource("logo.png"));
		JLabel wIcon = new JLabel(new ImageIcon(wPic));
		
		
		
		
	}
	

}
 