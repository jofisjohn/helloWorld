package com.indocosmo.posupdaterinstaller.samples;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SampleJFileChooser {

	public static void main(String[] args) {
		
		try {
			
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(3);
			
				JFileChooser chooser  = new  JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int fileSelection = chooser.showOpenDialog(null);
				if(fileSelection == JFileChooser.APPROVE_OPTION) {
					System.out.println("PATH :"+chooser.getSelectedFile());
				}
					
				frame.add(chooser);
				frame.setVisible(true);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
