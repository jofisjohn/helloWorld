package com.indocosmo.posupdaterinstaller.samples;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SampleUIScreen2 {

	public static void main(String[] args) {
		SampleUIScreen2 sampleUIScreen2 = new SampleUIScreen2();
		sampleUIScreen2.init();
	}
	
	public void init()
	{
		JFrame mainWindow = new JFrame();
		mainWindow.setSize(600, 400);
		mainWindow.setDefaultCloseOperation(3);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setSize(200, 350);
		leftPanel.setLayout(null);
		leftPanel.setLocation(0,0);
		leftPanel.setBackground(Color.CYAN);
		mainWindow.add(leftPanel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setSize(400, 350);
		rightPanel.setLayout(null);
		rightPanel.setLocation(leftPanel.getWidth(), 0);
		rightPanel.setBackground(Color.BLUE);
		mainWindow.add(rightPanel);
		
		JPanel bottomPanel = contentBottomPanel();
		bottomPanel.setSize(600, 50);
		//bottomPanel.setLayout(null);
		bottomPanel.setLocation(0, rightPanel.getHeight());
		//bottomPanel.setBackground(Color.ORANGE);
		mainWindow.add(bottomPanel);
		
		mainWindow.setVisible(true);
		
		
	}
	
	public JPanel contentBottomPanel()
	{
		final int PANEL_V_GAP = 5;
		final int PANEL_H_GAP = 5;
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
		bottomPanel.setVisible(true);
		bottomPanel.setSize(600, 50);
		
		//bottomPanel.setLocation(0, rightPanel.getHeight());
		bottomPanel.setBackground(Color.ORANGE);
		
		JButton cancelButton = new JButton();
		cancelButton.setText("Cancel");
		cancelButton.setSize(90, 25);
		//cancelButton.setLocation(0,0);
		System.out.println(" "+(bottomPanel.getWidth()-cancelButton.getWidth()-PANEL_V_GAP));
		cancelButton.setLocation(bottomPanel.getWidth()-cancelButton.getWidth()-PANEL_V_GAP,bottomPanel.getHeight()/2);
		
		bottomPanel.add(cancelButton);
		
		JButton preButton = new JButton();
		preButton.setText("Back");
		preButton.setSize(100, 50);
		
		return bottomPanel;	
		
	}

}
