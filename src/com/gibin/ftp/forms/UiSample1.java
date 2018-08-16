package com.gibin.ftp.forms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class UiSample1 extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1113086472504663629L;
	
	private static int PANEL_CONTENT_H_GAP=8;
	private static int PANEL_CONTENT_V_GAP=8;
	
	private static int MESSAGE_PANEL_HEIGHT=100;
	private static final int FORM_WIDTH=550;
	
	private static final int MESSAGE_PANEL_WIDTH=FORM_WIDTH-PANEL_CONTENT_H_GAP*2;
	
	private static final int ICON_HEIGHT=60;
	private static final int ICON_WIDTH=60;
	
	private JPanel mContentPane;
	private JPanel mMessagePanel;
	
	private JLabel mMessageLabel;
	private JLabel mMessageIconLabel;
	
	public UiSample1() {
		super();
		initControl();
	}
	
	public void initControl()
	{
		setUndecorated(true);
		setLocationRelativeTo(null);
//		UIManager.put("TitledBorder.border", false);
//		UIManager.put("nimbusBase",new Color(0xBB,0xC3,0xFF));
//        UIManager.put("TitledBorder.position",TitledBorder.CENTER);
//        UIManager.put("nimbusBlueGrey",new Color(0xD1,0xD1,0xD1));
//        UIManager.put("control",new Color(0xFA,0xFA,0xFA));
// UIManager.setLookAndFeel(info.getClassName());
        
		setSize(FORM_WIDTH,MESSAGE_PANEL_HEIGHT);
		mContentPane = new JPanel();
		mContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mContentPane.setLayout(null);
		setContentPane(mContentPane);
		createPanels();
		
	}
	public void createPanels()
	{
		mMessagePanel=new JPanel();
		mMessagePanel.setBounds(PANEL_CONTENT_H_GAP, PANEL_CONTENT_V_GAP, MESSAGE_PANEL_WIDTH, MESSAGE_PANEL_HEIGHT);
		mMessagePanel.setLayout(null);
		mMessagePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		add(mMessagePanel);
		
		int top=(mMessagePanel.getHeight()/2)-(ICON_HEIGHT/2);
		mMessageIconLabel=new JLabel();
		mMessageIconLabel.setBounds(PANEL_CONTENT_H_GAP, top, ICON_WIDTH,ICON_HEIGHT);
		//mMessageIconLabel.setIcon(getImageIconFromResource(ICON_SRC));
		mMessagePanel.add(mMessageIconLabel);
		
		int left=mMessageIconLabel.getX()+mMessageIconLabel.getWidth()+ PANEL_CONTENT_H_GAP;
		int width=MESSAGE_PANEL_WIDTH-ICON_WIDTH-PANEL_CONTENT_H_GAP*3;
		mMessageLabel=new JLabel();
		mMessageLabel.setBounds(left,PANEL_CONTENT_V_GAP,width, MESSAGE_PANEL_HEIGHT-PANEL_CONTENT_V_GAP*2);
		mMessageLabel.setFont(new Font("Arial",Font.PLAIN,20));
		mMessagePanel.add(mMessageLabel);
		
		
	}
	
	

}
