package com.Rang.maven.Rang_SecurityForEveryone;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.awt.geom.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.twilio.rest.voice.v1.dialingpermissions.Settings;

public class App extends JFrame implements ActionListener, WebcamMotionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Color background;
	private Color fontColor;
	private Color buttonColor;
	JLabel imageHolder;
	JLabel videoHolder;
	static Webcam webcam;
	static WebcamPanel webcamPanel;
	private JPanel topStuffPanel;
	private JButton startStop;
	private VideoWriter writer;
	private WebcamMotionDetector detector;
	private JButton security;
	public static String phoneNum;


	private String toEmailAddress;
	private final String fromEmailAddress = "destroyingbigcorporate@gmail.com";
	final String emailUsername = "destroyingbigcorporate@gmail.com"; //will always be the from address
	final String emailPassword = "jduslfsmegehdiee"; //app password needs to be changed when we make our final business email

	private boolean startedVid = false;
	private boolean startedSec = false;
	private InfiniteVideoWriter previous;
	private VideoWriter next;
	
	
	private JButton chooseFilePath;


	public static void main(String[] args)
	{
		App app = new App();

		webcam.addWebcamListener(new WebcamListener() 
		{

			@Override
			public void webcamOpen(WebcamEvent we) {
				System.out.println("Webcam Opened");

			}

			@Override
			public void webcamClosed(WebcamEvent we) {
				System.out.println("Webcam Closed");				
			}

			@Override
			public void webcamDisposed(WebcamEvent we) {
				System.out.println("Webcam Disposed");				
			}

			@Override
			public void webcamImageObtained(WebcamEvent we) {
				//System.out.println("Image Taken");				
			}
		});
	}

	public App()
	{
		background = Color.BLACK;
		fontColor = Color.WHITE;
		buttonColor = Color.BLACK;

		webcam = Webcam.getDefault();
		webcam.setViewSize(new Dimension(320,240));

		imageHolder = new JLabel();		
		videoHolder = new JLabel();

		setTitle("Rang - Security for Everyone");
		setSize(960, 720);

		JPanel panel = new JPanel();
		panel.setBackground(background);

		GridBagLayout gblMain = new GridBagLayout();
		gblMain.rowWeights = new double[] {1, 5, .3333, .1};
		gblMain.columnWeights = new double[] {2,1};

		panel.setLayout(gblMain);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		panel.add(topStuff(), c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		panel.add(middleButtons(), c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		panel.add(buttonMaker("View Files", "seeall"), c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		panel.add(new JLabel(" "), c);    

		setContentPane(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public JPanel topStuff()
	{
		topStuffPanel = new JPanel();
		topStuffPanel.setLayout(new GridLayout(1, 2));
		topStuffPanel.setBackground(background);

		String image = "Rang.jpeg";
		ImageIcon logo = new ImageIcon(new ImageIcon(image).getImage()
				.getScaledInstance(getWidth() / 2, getHeight() / 2, Image.SCALE_DEFAULT));


		JLabel logo2 =new JLabel();
		logo2.setIcon(logo);

		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(background);
		GridBagLayout gbl = new GridBagLayout();
		logoPanel.setLayout(gbl);
		gbl.rowWeights = new double[] {.1, 1, .1};
		GridBagConstraints c = new GridBagConstraints();

		JPanel settingsPanel = new JPanel(new GridLayout(1, 3));
		settingsPanel.setBackground(background);
		settingsPanel.add(buttonMaker("Settings", "settings"));
		settingsPanel.add(new JLabel(" "));
		settingsPanel.add(new JLabel(" "));

		c.gridx = -1;
		c.gridy = 0;
		settingsPanel.add(new JLabel(" "));
		logoPanel.add(settingsPanel, c);

		c.gridx = 0;
		c.gridy = 1;
		logoPanel.add(logo2, c);

		c.gridx = 0;
		c.gridy = 2;
		logoPanel.add(new JLabel(" "), c);

		topStuffPanel.add(logoPanel);

		webcamPanel = new WebcamPanel(webcam);
		//webcam.close();
		webcam.open();
		webcamPanel = new WebcamPanel(webcam);
		webcamPanel.setFPSDisplayed(true);
		webcamPanel.setDisplayDebugInfo(false);
		webcamPanel.setImageSizeDisplayed(true);
		webcamPanel.setMirrored(true);
		webcamPanel.setVisible(true);
		webcamPanel.setFPSLimit(25.0);
		topStuffPanel.add(webcamPanel);

		return topStuffPanel;
	}

	public JPanel middleButtons()
	{
		JPanel panel = new JPanel();
		panel.setBackground(background);

		GridBagLayout gblMain = new GridBagLayout();
		gblMain.rowWeights = new double[] {1, 1, 1, 1, 1};
		gblMain.columnWeights = new double[] {1, 1, 1, 1, 1, 1};
		panel.setLayout(gblMain);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.gridx = 0;
		c.gridy = 4;
		panel.add(new JLabel(), c);

		c.gridx = 6;
		c.gridy = 4;
		panel.add(new JLabel(), c);

		c.gridx = 1;
		c.gridy = 1;
		panel.add(buttonMaker("Capture Photo", "capture"), c);

		c.gridx = 4;
		c.gridy = 1;
		startStop = buttonMaker("Start Video Recording", "startstop");
		panel.add(startStop, c);

		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 4;
		security = buttonMaker("Security Mode Off", "security");
		panel.add(security,c);

		return panel;
	}

	public JButton buttonMaker(String buttonText, String alText)
	{
		JButton button = new JButton(buttonText);
		button.setBackground(buttonColor);
		button.setForeground(fontColor);
		AbstractBorder border = new TextBubbleBorder(Color.WHITE,2,16,0);
		button.setBorder(border);
		button.setFocusPainted(false);
		button.setFont(new Font("DejaVa Sans", Font.BOLD, 25));
		//HelveticaNeue-Light
		button.addActionListener(this);
		button.setActionCommand(alText);
		return button;
	}

	public String checkForPhoneNumber() //returns phone number entered, or null if cancelled
	{
		try
		{
			File file = new File("phonenumber.txt");
			Scanner scan = new Scanner(file);
			if(scan.hasNext())
			{
				return scan.next();
			}

			else
			{
				String str = (String) JOptionPane.showInputDialog(this,
						"Please Enter Your Phone Number",
						"Phone Number",
						JOptionPane.QUESTION_MESSAGE,
						null,
						null,
						"xxxxxxxxxx");
				FileWriter myWriter = new FileWriter("phonenumber.txt");
				if(str!= null && str.length() == 10) myWriter.write("+1" + str);
				else return null;
				myWriter.close();
				return "+1" + str;
			}
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public String checkForEmail()
	{
		try 
		{
			File file = new File("userEmailAddresses.txt");
			Scanner scan = new Scanner(file);
			if(scan.hasNext())
			{
				return scan.next();
			}

			else
			{
				String str = (String) JOptionPane.showInputDialog(this,
						"Please Enter Your Email Address",
						"Email Address",
						JOptionPane.QUESTION_MESSAGE,
						null,
						null,
						"text@domain.com");
				FileWriter myWriter = new FileWriter("userEmailAddresses.txt");
				if(str!= null) myWriter.write(str);
				else return null;
				myWriter.close();
				return str;
			}
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		String text = e.getActionCommand();

		if(text.equals("capture"))
		{
			webcam.open();
			Image image = webcam.getImage();
			imageHolder.setIcon(new ImageIcon(image));

			try 
			{
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH-mm-ss");
				LocalDateTime now = LocalDateTime.now();
				String path = "Captures\\" + dtf.format(now) + ".png";
				File file = new File(path);

				ImageIO.write(webcam.getImage(), "PNG", file);
				file.createNewFile();
			} 

			catch (IOException f) 
			{
				f.printStackTrace();
			}

		}

		else if(text.equals("startstop"))
		{
			InfiniteVideoWriter writer = new InfiniteVideoWriter(webcam);
			if(!startedVid) 
			{
				if(!startedSec)
				{
					writer.start();
					startStop.setText("Stop Video Recording");
				}
			}

			else 
			{
				previous.cont = false;
				startStop.setText("Start Video Recording");
			}

			previous = writer;

			startedVid = !startedVid;
		}

		else if(text.equals("security"))
		{
			phoneNum = checkForPhoneNumber();
			toEmailAddress = checkForEmail();

			if(phoneNum != null || toEmailAddress != null)
			{
				writer = new VideoWriter(webcam);
				detector = new WebcamMotionDetector(Webcam.getDefault());
				detector.setInterval(500); // one check per 500 ms
				if(!startedSec)
				{
					if(!startedVid)
					{
						detector.addMotionListener(this);
						detector.start();
						security.setText("Security Mode ON");
					}
				}
				else
				{
					writer.isRunning = true;
					next.isRunning =false;
					security.setText("Security Mode OFF");
				}
				next = writer;
				startedSec = !startedSec;
			}
		}
		else if(text.equals("seeall"))
		{
			try {
				Desktop.getDesktop().open(new File("Captures\\"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		else if(text.equals("settings"))
		{
			displaySettings();
		}
		else if(text.equals("choose file path"))
		{
			System.out.println("hi");
		}
	}

	public void motionDetected(WebcamMotionEvent wme) 
	{
		try 
		{
			if(!writer.isRunning)
			{
				System.out.println("Motion Detected - Starting Recording");
				writer.start();
				Thread.sleep(40000);
				TextMessage.sendText(phoneNum);
				File file = new File(VideoWriter.getFileName());
				SendMailJavaAPI.sendEmail(toEmailAddress, fromEmailAddress, emailUsername, emailPassword, file);
			}
		} 

		catch (Exception e1) 
		{
			System.out.println("New Writer Created");
			writer = new VideoWriter(webcam);
		}
	}

	private void displaySettings()
	{

		JFrame settingsMenu = new JFrame("Settings");
		settingsMenu.setBackground(background);
		JPanel settingsWindowLeft = new JPanel();
		JPanel settingsWindowRight = new JPanel();
		settingsMenu.setSize(640, 480);
		settingsMenu.setLocationRelativeTo(this);

		settingsWindowLeft.setBackground(background);
		GridBagLayout gbl = new GridBagLayout();
		settingsWindowLeft.setLayout(gbl);

		settingsMenu.add(settingsWindowLeft);
		settingsMenu.add(settingsWindowRight);
		settingsMenu.setVisible(true);
		
		chooseFilePath = buttonMaker("Choose File Path", "choose file path");
		chooseFilePath.setVisible(true);
		settingsMenu.add(chooseFilePath);
	}
}

class TextBubbleBorder extends AbstractBorder {

	private static final long serialVersionUID = 1L;
	private Color color;
	private int thickness = 4;
	private int radii = 8;
	private int pointerSize = 7;
	private Insets insets = null;
	private BasicStroke stroke = null;
	private int strokePad;
	private int pointerPad = 4;
	private boolean left = true;
	RenderingHints hints;

	TextBubbleBorder(
			Color color) {
		this(color, 4, 8, 7);
	}

	TextBubbleBorder(
			Color color, int thickness, int radii, int pointerSize) {
		this.thickness = thickness;
		this.radii = radii;
		this.pointerSize = pointerSize;
		this.color = color;

		stroke = new BasicStroke(thickness);
		strokePad = thickness / 2;

		hints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		int pad = radii + strokePad;
		int bottomPad = pad + pointerSize + strokePad;
		insets = new Insets(pad, pad, bottomPad, pad);
	}

	TextBubbleBorder(
			Color color, int thickness, int radii, int pointerSize, boolean left) {
		this(color, thickness, radii, pointerSize);
		this.left = left;
	}

	@Override
	public Insets getBorderInsets(Component c) {
		return insets;
	}

	@Override
	public Insets getBorderInsets(Component c, Insets insets) {
		return getBorderInsets(c);
	}

	@Override
	public void paintBorder(
			Component c,
			Graphics g,
			int x, int y,
			int width, int height) {

		Graphics2D g2 = (Graphics2D) g;

		int bottomLineY = height - thickness - pointerSize;

		RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(
				0 + strokePad,
				0 + strokePad,
				width - thickness,
				bottomLineY,
				radii,
				radii);

		Polygon pointer = new Polygon();

		if (left) {
			// left point
			pointer.addPoint(
					strokePad + radii + pointerPad,
					bottomLineY);
			// right point
			pointer.addPoint(
					strokePad + radii + pointerPad + pointerSize,
					bottomLineY);
			// bottom point
			pointer.addPoint(
					strokePad + radii + pointerPad + (pointerSize / 2),
					height - strokePad);
		} else {
			// left point
			pointer.addPoint(
					width - (strokePad + radii + pointerPad),
					bottomLineY);
			// right point
			pointer.addPoint(
					width - (strokePad + radii + pointerPad + pointerSize),
					bottomLineY);
			// bottom point
			pointer.addPoint(
					width - (strokePad + radii + pointerPad + (pointerSize / 2)),
					height - strokePad);
		}

		Area area = new Area(bubble);
		area.add(new Area(pointer));

		g2.setRenderingHints(hints);

		// Paint the BG color of the parent, everywhere outside the clip
		// of the text bubble.
		Component parent  = c.getParent();
		if (parent!=null) {
			Color bg = parent.getBackground();
			Rectangle rect = new Rectangle(0,0,width, height);
			Area borderRegion = new Area(rect);
			borderRegion.subtract(area);
			g2.setClip(borderRegion);
			g2.setColor(bg);
			g2.fillRect(0, 0, width, height);
			g2.setClip(null);
		}

		g2.setColor(color);
		g2.setStroke(stroke);
		g2.draw(area);
	}

}

