package com.Rang.maven.Rang_SecurityForEveryone;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.text.MaskFormatter;

public class SettingsMenu extends JFrame implements ActionListener
{

	private static final long serialVersionUID = -349462070390486555L;
	private Color background, buttonColor, fontColor;
	private JFrame app;
	private JTextField mail, phoneNum;
	private JRadioButton low, med, high, text, email, None;

	public SettingsMenu(Color background, Color buttonColor, Color fontColor, JFrame app)
	{
		this.background = background;
		this.buttonColor = buttonColor; 
		this.fontColor = fontColor;
		this.app = app;

		setTitle("Settings");
		setBackground(background);
		setSize(640, 480);
		setLocationRelativeTo(app);

		setContentPane(generateOutput());
		setVisible(true);
	}

	private JPanel generateOutput()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 2));

		mainPanel.add(leftSide());
		mainPanel.add(rightSide());

		return mainPanel;
	}

	private JPanel leftSide()
	{
		JPanel panel = new JPanel();

		panel.setBackground(background);
		GridBagLayout gbl = new GridBagLayout();
		panel.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		gbl.rowWeights = new double[] {3, 2, 2, 1};

		//all cameras
		c.gridy = 0;
		panel.add(allCameras(), c);

		//video quality
		JPanel middleStuff = new JPanel(new GridLayout(1,2));
		middleStuff.add(videoQuality());
		middleStuff.add(notifications());
		c.gridy = 1;
		panel.add(videoQuality(), c);

		//notif method
		c.gridy = 2;
		panel.add(notifications(), c);
		//set filepath
		c.gridy = 3;
		panel.add(filePath(), c);


		return panel;
	}

	private JPanel allCameras()
	{
		JPanel panel = new JPanel(new GridLayout(1, 3));
		panel.setBackground(background);

		JLabel cameraList = new JLabel();
		cameraList.setText("All Cameras:");
		panel.add(cameraList);
		panel.add(new JLabel(" "));

		JPanel buttons = new JPanel();
		buttons.setBackground(background);
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWeights = new double[] {.1, 1, .1};
		gbl.rowWeights = new double[] {.1, 1, .1, 1, .1, 1, .1};
		buttons.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();

		//add padding to buttons
		c.gridx = 0;
		c.gridy = 0;
		buttons.add(new JLabel(" "), c);

		c.gridx = 2;
		c.gridy = 2;
		buttons.add(new JLabel(" "), c);

		c.gridx = 0;
		c.gridy = 4;
		buttons.add(new JLabel(" "), c);

		c.gridx = 0;
		c.gridy = 6;
		buttons.add(new JLabel(" "), c);

		//add buttons
		int fontSize = 12;
		c.gridx = 1;
		c.gridy = 1;
		buttons.add(buttonMaker("Add New", "newCam", fontSize), c);

		c.gridx = 1;
		c.gridy = 3;
		buttons.add(buttonMaker("Apply", "newCamApply", fontSize), c);

		c.gridx = 1;
		c.gridy = 5;
		buttons.add(buttonMaker("Cancel", "newCamCancel", fontSize), c);


		panel.add(buttons);
		return panel;
	}

	private JPanel videoQuality()
	{
		JPanel panel = new JPanel();
		panel.setBackground(background);

		panel.setLayout(new GridLayout(4, 1));

		ButtonGroup bg = new ButtonGroup();
		low = new JRadioButton("Low");
		low.addActionListener(this);
		low.setActionCommand("lowQuality");
		low.setForeground(fontColor);
		low.setBackground(background);
		low.setSelected(rootPaneCheckingEnabled);
		low.setSelected(false);
		bg.add(low);
		
		med = new JRadioButton("Medium");
		med.addActionListener(this);
		med.setActionCommand("medQuality");
		med.setForeground(fontColor);
		med.setBackground(background);
		med.setSelected(true);
		bg.add(med);
		
		high = new JRadioButton("High");
		high.addActionListener(this);
		high.setActionCommand("highQuality");
		high.setForeground(fontColor);
		high.setBackground(background);
		high.setSelected(false);
		bg.add(high);

		panel.add(new JLabel("Video Quality:"));
		panel.add(low);
		panel.add(med);
		panel.add(high);
		return panel;
	}

	private JPanel notifications()
	{
		JPanel panel = new JPanel(new GridLayout(4, 2));
		panel.setBackground(background);
		JLabel notif = new JLabel("Notification Methods:");
		panel.add(notif);
		panel.add(new JLabel(""));

		ButtonGroup txt = new ButtonGroup();
		
		text = new JRadioButton("Text");
		text.setBackground(background);
		text.setForeground(fontColor);
		text.setActionCommand("textMessage");
		text.addActionListener(this);
		txt.add(text);
		text.setSelected(true);
		panel.add(text);

		phoneNum = new JTextField("PhoneNumberTextField");
		phoneNum.setEditable(false);
		phoneNum.setBackground(buttonColor);
		phoneNum.setForeground(fontColor);
		panel.add(phoneNum);

		email = new JRadioButton("Email");
		email.setBackground(background);
		email.setForeground(fontColor);
		email.setActionCommand("emailMessage");
		email.addActionListener(this);
		txt.add(email);
		email.setSelected(false);
		panel.add(email);

		mail = new JTextField("EmailTextField");
		mail.setEditable(false);
		mail.setBackground(buttonColor);
		mail.setForeground(fontColor);
		panel.add(mail);

		None = new JRadioButton("None");
		None.setActionCommand("noMessage");
		None.addActionListener(this);
		None.setBackground(background);
		None.setForeground(fontColor);
		txt.add(None);
		None.setSelected(false);
		panel.add(None);

		return panel;
	}

	private JPanel filePath()
	{
		JPanel panel = new JPanel();
		panel.setBackground(background);
		GridBagLayout gbl = new GridBagLayout();
		gbl.rowWeights = new double[]{.1, 1, .1};
		gbl.columnWeights = new double[]{.1, 1, .1};
		panel.setLayout(gbl);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.gridx = 1;
		c.gridy = 1;
		panel.add(buttonMaker("SetFilePath", "filePath", 12), c);

		//padding
		c.gridx = 0;
		c.gridy = 0;
		panel.add(new JLabel(" "), c);
		c.gridx = 2;
		c.gridy = 2;
		panel.add(new JLabel(" "), c);

		return panel;
	}

	private JPanel rightSide()
	{
		JPanel panel = new JPanel();
		panel.setBackground(background);
		panel.add(new JLabel("Nothing (yet)"));
		return panel;
	}

	public JButton buttonMaker(String buttonText, String alText, int fontSize)
	{
		JButton button = new JButton(buttonText);
		button.setBackground(buttonColor);
		button.setForeground(fontColor);
		AbstractBorder border = new TextBubbleBorder(Color.WHITE,2,16,0);
		button.setBorder(border);
		button.setFocusPainted(false);
		button.setFont(new Font("DejaVa Sans", Font.BOLD, fontSize));
		//HelveticaNeue-Light
		button.addActionListener(this);
		button.setActionCommand(alText);
		return button;
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == "filePath")
		{
			try {
				App.n = 0;
				App.setFilePath();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand() == "textMessage")
		{
			App.isTexting(true);
			App.isEmailing(false);
			mail.setEditable(false);
			phoneNum.setEditable(true);
			
			text.setSelected(true);
			email.setSelected(false);
			None.setSelected(false);
			
			if(((App) app).checkForPhoneNumber() != null)
				{
					phoneNum.setText(((App) app).checkForPhoneNumber());
				}
			else phoneNum.setText("Enter Phone Number Here:");
		}
		else if(e.getActionCommand() == "emailMessage")
		{
			App.isTexting(false);
			App.isEmailing(true);
			mail.setEditable(true);
			phoneNum.setEditable(false);
			text.setSelected(false);
			email.setSelected(true);
			None.setSelected(false);
			if(((App) app).checkForEmail() != null)
				{
					mail.setText(((App) app).checkForEmail());
				}
			else mail.setText("Enter Email Address Here:");
		}
		else if(e.getActionCommand() == "noMessage")
		{
			App.isEmailing(false);
			App.isTexting(false);
			mail.setEditable(false);
			phoneNum.setEditable(false);
			text.setSelected(false);
			email.setSelected(false);
			None.setSelected(true);
		}
		else if(e.getActionCommand() == "PhoneNumberTextField")
		{
			App.phoneNum = phoneNum.getText();
			try {
				FileWriter myWriter = new FileWriter("phonenumber.txt",false);
				PrintWriter pwOb = new PrintWriter(myWriter, false);
		        pwOb.flush();
		        pwOb.print(phoneNum.getText());
		        pwOb.close();
		        myWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand() == "EmailTextField")
		{
			App.toEmailAddress = mail.getText();
			try 
			{
				FileWriter myWriter = new FileWriter("userEmailAddresses.txt");
				PrintWriter pwOb = new PrintWriter(myWriter, false);
		        pwOb.flush();
		        pwOb.print(mail.getText());
		        pwOb.close();
		        myWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand() == "lowQuality")
		{
			VideoWriter.frame.setQuality(33);
			InfiniteVideoWriter.frame.setQuality(33);
			low.setSelected(true);
			med.setSelected(false);
			high.setSelected(false);
		}
		else if(e.getActionCommand() == "medQuality")
		{
			VideoWriter.frame.setQuality(66);
			InfiniteVideoWriter.frame.setQuality(66);
			low.setSelected(false);
			med.setSelected(true);
			high.setSelected(false);
		}
		else if(e.getActionCommand() == "highQuality")
		{
			VideoWriter.frame.setQuality(100);
			InfiniteVideoWriter.frame.setQuality(100);
			low.setSelected(false);
			med.setSelected(false);
			high.setSelected(true);
		}
	}

}