package com.indocosmo.posupdaterinstaller.samples;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SampleUIScreenInstallerMinimal {

	public static void main(String[] args) {
	SampleUIScreenInstallerMinimal installerMinimal = new SampleUIScreenInstallerMinimal();
	installerMinimal.init();

	}
	
	private String filepath;
	private JTextField textFieldInstallPath;
	private JButton btnBrowse;
	private JButton btnCancel;
	private JButton btnNext;
	private JLabel labelInstallPath;
	private JLabel labelInstallStatus;
	public void init()
	{
		final int PANEL_H_GAP = 5;
		final int PANEL_V_GAP = 5;
		
		final int FRAME_WIDTH = 400;
		final int FRAME_HEIGHT = 120;
		
		final int LABEL_WIDTH = 160;
		final int LABEL_HEIGHT = 20;
		
		final int TEXTFIELD_WIDTH = 295;
		final int TEXTFIELD_HEIGHT = 30;
		
		final int BUTTON__WIDTH = 90;
		final int BUTTON__HEIGHT = 30;
		
		final int LABEL_STATUS_WIDTH = 190;
		final int LABEL_STATUS_HEIGHT = 20;
				
		JFrame mainWindow = new JFrame();
		mainWindow.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		mainWindow.setTitle("POS-Updater-Installer");
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setLayout(null);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//mainWindow.setResizable(false);
		
		labelInstallPath = new  JLabel();
		labelInstallPath.setSize(LABEL_WIDTH, LABEL_HEIGHT);
		labelInstallPath.setLocation(PANEL_H_GAP, PANEL_V_GAP);
		labelInstallPath.setText("Installation Directory");
		mainWindow.add(labelInstallPath);
	
		textFieldInstallPath = new JTextField();
		textFieldInstallPath.setSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		textFieldInstallPath.setLocation(PANEL_H_GAP, labelInstallPath.getHeight()+(PANEL_H_GAP*2));
		mainWindow.add(textFieldInstallPath);
		
		btnBrowse = new JButton();
		btnBrowse.setSize(BUTTON__WIDTH, BUTTON__HEIGHT);
		btnBrowse.setText("Browse");
		btnBrowse.setLocation((PANEL_V_GAP*2)+textFieldInstallPath.getWidth(), labelInstallPath.getHeight()+(PANEL_H_GAP*2));
		btnBrowse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				filepath=showFileChooser();
				textFieldInstallPath.setText(filepath);
			}
		});
		mainWindow.add(btnBrowse);
				
		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setSize(BUTTON__WIDTH, BUTTON__HEIGHT);
		btnCancel.setLocation(mainWindow.getWidth()-PANEL_V_GAP-btnCancel.getWidth(), mainWindow.getHeight()-PANEL_H_GAP-btnCancel.getHeight());
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mainWindow.add(btnCancel);
		
		btnNext = new JButton();
		btnNext.setText("Next");
		btnNext.setSize(BUTTON__WIDTH,BUTTON__HEIGHT);
		btnNext.setLocation(mainWindow.getWidth()-(PANEL_V_GAP*2)-btnCancel.getWidth()-btnNext.getWidth(), mainWindow.getHeight()-PANEL_H_GAP-btnCancel.getHeight());
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					checkTargetPath();
				} catch (Exception e) {
					e.printStackTrace();
					hideAll("Installation Failed");
				}
			}
		});
		mainWindow.add(btnNext);
		
		
		
		labelInstallStatus = new JLabel();
		labelInstallStatus.setSize(LABEL_STATUS_WIDTH, LABEL_HEIGHT);
		
		labelInstallStatus.setLocation(PANEL_V_GAP*3, textFieldInstallPath.getY());
		labelInstallStatus.setText("Installation Successfull");
		
		mainWindow.add(labelInstallStatus);
	
		mainWindow.setVisible(true);
	}
	/**
	 * showing file chooser
	 * 
	 * @return
	 */
	public String showFileChooser()
	{
		String filePath = null;
		JFileChooser fileChooser  = new  JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int fileSelection = fileChooser.showOpenDialog(null);
		if(fileSelection == JFileChooser.APPROVE_OPTION) {
			System.out.println("PATH :"+fileChooser.getSelectedFile());
			filePath = fileChooser.getSelectedFile().getAbsolutePath();
		}
		return filePath;
	}
	/**
	 * validate target location
	 * 
	 */
	public void checkTargetPath() throws Exception
	{
		System.out.println("Fetching files from "+textFieldInstallPath.getText());
		if(!textFieldInstallPath.getText().equals(""))
		{
			boolean flag = false;
			File[] fileList = new File(textFieldInstallPath.getText()).listFiles();
			for (File file : fileList) {
			    if (file.isFile() && file.getName().equals("pos-terminal.properties")) {
			    	flag=true;
			    }
			}
			if(flag == true){
				System.out.println("Installation folder");
				copyFiles();
			}
			else{
				System.out.println("Not an installation folder");
				JOptionPane.showMessageDialog(null, "Invalid Directory", "POS-Updater Installer",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			System.out.println("Error");
			JOptionPane.showMessageDialog(null, "Please Select Installation Path", "POS-Updater Installer",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * copy files to this location
	 * 
	 * @throws Exception
	 */
	public void copyFiles() throws Exception
	{
		System.out.println("Inside copy files ");
		File downloadableFiles = new File("./Downloads");
		System.out.println("Files in Downloads "+downloadableFiles.listFiles()[0]);
		File[] fileList = downloadableFiles.listFiles();
		for(int i=0;i<fileList.length;i++){
			System.out.println("File "+fileList[i]+" "+filepath);
			File tempFile = new File(fileList[i].toString());
			FileInputStream fileInputStream = new FileInputStream(tempFile);
			System.out.println(" "+fileList[i].getName());
			FileOutputStream outputStream = new FileOutputStream(filepath+"/"+fileList[i].getName());
			byte[] buffer = new byte[4096];
			int bytesread;
			while((bytesread = fileInputStream.read(buffer)) > 0){
				outputStream.write(buffer, 0, bytesread);
			}
			fileInputStream.close();
			outputStream.close();
			hideAll("Installation Completed");
			
		}
		
		
	}
	/**
	 * 
	 * @param message
	 */
	public void hideAll(String message){
		labelInstallPath.setVisible(false);
		textFieldInstallPath.setVisible(false);
		btnBrowse.setVisible(false);
		btnNext.setVisible(false);
		btnCancel.setText("Finish");
		labelInstallStatus.setText(message);
		labelInstallStatus.setVisible(true);
		
	}
}
