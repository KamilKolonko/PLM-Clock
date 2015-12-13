package clock;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import clock.utils.CSSParser;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

public class PML extends JFrame {

    private JPanel contentPane;
    private JPanel panelMenu;
    private JPanel panelClock;
    private JPanel panelAnalogClock;
    private JPanel panelDigitalClock;
    private JPanel panelColour;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    PML frame = new PML();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public PML() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 693, 577);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new CardLayout(0, 0));
	
	new CSSParser("Clock.properties");
	Properties properties = CSSParser.getProperties();

	// PANELS
	final JPanel panelMenu = new JPanel();
	contentPane.add(panelMenu, "name_7233690561092");
	panelMenu.setLayout(null);
	panelMenu.setVisible(true);

	final JPanel panelClock = new JPanel();
	contentPane.add(panelClock, "name_7243774115766");
	panelClock.setLayout(null);
	panelClock.setVisible(false);

	final JPanel panelAnalogClock = new JPanel();
	contentPane.add(panelAnalogClock, "name_7246054185559");
	panelAnalogClock.setLayout(null);
	panelAnalogClock.setVisible(false);

	final JPanel panelDigitalClock = new JPanel();
	contentPane.add(panelDigitalClock, "name_8387595132456");
	panelDigitalClock.setLayout(null);
	panelDigitalClock.setVisible(false);

	final JPanel panelColour = new JPanel();
	contentPane.add(panelColour, "name_8402095556199");
	panelColour.setLayout(null);
	panelColour.setVisible(false);

	JButton btnStartButton = new JButton("START");
	btnStartButton.setFont(new Font("Tahoma", Font.BOLD, 51));
	btnStartButton.setForeground(Color.BLUE);
	btnStartButton.setToolTipText("Press if you want to make a Clock Widget");
	btnStartButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		panelClock.setVisible(true);
		panelMenu.setVisible(false);
	    }
	});
	btnStartButton.setBounds(94, 316, 473, 114);
	panelMenu.add(btnStartButton);

	JLabel lblMenuLabel = new JLabel("Clock Widget Maker");
	lblMenuLabel.setFont(new Font("Calibri", Font.BOLD, 35));
	lblMenuLabel.setForeground(Color.BLACK);
	lblMenuLabel.setBounds(173, 52, 316, 70);
	panelMenu.add(lblMenuLabel);

	JLabel lblWelcomeToThe = new JLabel("Welcome to the Widget Maker program for Clock Enthusiasts!");
	lblWelcomeToThe.setForeground(Color.BLACK);
	lblWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblWelcomeToThe.setBounds(64, 138, 555, 22);
	panelMenu.add(lblWelcomeToThe);

	JLabel lblGetStartedBy = new JLabel("Get started by pressing the button below!");
	lblGetStartedBy.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblGetStartedBy.setBounds(151, 259, 372, 22);
	panelMenu.add(lblGetStartedBy);

	JButton btnANALOGButton = new JButton("ANALOG");
	btnANALOGButton.setFont(new Font("Tahoma", Font.BOLD, 28));
	btnANALOGButton.setForeground(Color.BLUE);
	btnANALOGButton.setToolTipText("Press if you want a Analog clock");
	btnANALOGButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		panelAnalogClock.setVisible(true);
		panelClock.setVisible(false);
	    }
	});
	btnANALOGButton.setBounds(65, 166, 200, 285);
	panelClock.add(btnANALOGButton);

	JButton btnDigitalButton = new JButton("DIGITAL");
	btnDigitalButton.setForeground(Color.BLUE);
	btnDigitalButton.setFont(new Font("Tahoma", Font.BOLD, 28));
	btnDigitalButton.setToolTipText("Press if you want a Digital clock\r\n");
	btnDigitalButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		panelDigitalClock.setVisible(true);
		panelClock.setVisible(false);
	    }
	});
	btnDigitalButton.setBounds(397, 166, 200, 285);
	panelClock.add(btnDigitalButton);

	JLabel lblChoose = new JLabel("Choose Your Desired Clock Type");
	lblChoose.setForeground(Color.MAGENTA);
	lblChoose.setFont(new Font("Tahoma", Font.BOLD, 30));
	lblChoose.setBounds(90, 52, 486, 37);
	panelClock.add(lblChoose);

	JLabel lblForAnAnalog = new JLabel("For an analog one");
	lblForAnAnalog.setBounds(90, 467, 128, 20);
	panelClock.add(lblForAnAnalog);

	JLabel lblForADigital = new JLabel("For a digital one");
	lblForADigital.setBounds(461, 467, 115, 20);
	panelClock.add(lblForADigital);

	JLabel lblAnalogNumeralsLabel = new JLabel("Numerals:");
	lblAnalogNumeralsLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	lblAnalogNumeralsLabel.setBounds(122, 145, 95, 20);
	panelAnalogClock.add(lblAnalogNumeralsLabel);

	JLabel lblAnalogShapeLabel = new JLabel("Shape:");
	lblAnalogShapeLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	lblAnalogShapeLabel.setBounds(148, 221, 69, 20);
	panelAnalogClock.add(lblAnalogShapeLabel);

	JLabel lblAnalogLabel = new JLabel("Analog Clock Settings");
	lblAnalogLabel.setForeground(Color.MAGENTA);
	lblAnalogLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
	lblAnalogLabel.setBounds(164, 51, 328, 78);
	panelAnalogClock.add(lblAnalogLabel);

	JComboBox AnalogNumeralscomboBox = new JComboBox();
	AnalogNumeralscomboBox.setModel(new DefaultComboBoxModel(new String[] { "Roman", "Arabic" }));
	AnalogNumeralscomboBox.setBounds(234, 137, 158, 41);
	panelAnalogClock.add(AnalogNumeralscomboBox);

	JComboBox AnalogShapecomboBox = new JComboBox();
	AnalogShapecomboBox.setModel(new DefaultComboBoxModel(new String[] { "Circle", "Square", "Triangle" }));
	AnalogShapecomboBox.setBounds(232, 213, 158, 41);
	panelAnalogClock.add(AnalogShapecomboBox);

	JButton btnAnalogCOLOURButton = new JButton("COLOUR");
	btnAnalogCOLOURButton.setForeground(Color.BLUE);
	btnAnalogCOLOURButton.setFont(new Font("Tahoma", Font.BOLD, 20));
	btnAnalogCOLOURButton.setToolTipText("Press to choose your colour scheme");
	btnAnalogCOLOURButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		panelColour.setVisible(true);
		panelAnalogClock.setVisible(false);
	    }
	});
	btnAnalogCOLOURButton.setBounds(229, 420, 205, 60);
	panelAnalogClock.add(btnAnalogCOLOURButton);

	JLabel lblOtherFunctionalitiesLabel = new JLabel("Other Functionalities:");
	lblOtherFunctionalitiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	lblOtherFunctionalitiesLabel.setBounds(12, 285, 205, 20);
	panelAnalogClock.add(lblOtherFunctionalitiesLabel);

	JRadioButton rdbtnAlarmRadioButton = new JRadioButton("Alarm");
	rdbtnAlarmRadioButton.setBounds(234, 283, 75, 29);
	panelAnalogClock.add(rdbtnAlarmRadioButton);

	JRadioButton rdbtnStopWatchRadioButton_1 = new JRadioButton("Stop Watch");
	rdbtnStopWatchRadioButton_1.setBounds(316, 283, 155, 29);
	panelAnalogClock.add(rdbtnStopWatchRadioButton_1);

	JLabel lblPrecisionLabel = new JLabel("Precision:");
	lblPrecisionLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	lblPrecisionLabel.setBounds(127, 345, 90, 26);
	panelAnalogClock.add(lblPrecisionLabel);

	JRadioButton rdbtnSeconds = new JRadioButton("Sec, Min, Hour");
	rdbtnSeconds.setBounds(234, 346, 137, 29);
	panelAnalogClock.add(rdbtnSeconds);

	JRadioButton rdbtnHoursMin = new JRadioButton("Min, Hour");
	rdbtnHoursMin.setBounds(378, 346, 103, 29);
	panelAnalogClock.add(rdbtnHoursMin);

	ButtonGroup group = new ButtonGroup();
	group.add(rdbtnHoursMin);
	group.add(rdbtnSeconds);

	JButton btnDigitalCOLOURButton = new JButton("COLOUR");
	btnDigitalCOLOURButton.setForeground(Color.BLUE);
	btnDigitalCOLOURButton.setFont(new Font("Tahoma", Font.BOLD, 20));
	btnDigitalCOLOURButton.setToolTipText("Press here to choose your colour scheme");
	btnDigitalCOLOURButton.setBounds(229, 420, 205, 60);
	panelDigitalClock.add(btnDigitalCOLOURButton);

	JLabel lblDigitalLabel = new JLabel("Digital Clock Settings");
	lblDigitalLabel.setForeground(Color.MAGENTA);
	lblDigitalLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
	lblDigitalLabel.setBounds(166, 51, 322, 78);
	panelDigitalClock.add(lblDigitalLabel);

	JLabel lblDigitalNumeralsLabel = new JLabel("Numerals:");
	lblDigitalNumeralsLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	lblDigitalNumeralsLabel.setBounds(122, 145, 95, 26);
	panelDigitalClock.add(lblDigitalNumeralsLabel);

	JLabel lblDigitalShapeLabel = new JLabel("Shape:");
	lblDigitalShapeLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	lblDigitalShapeLabel.setBounds(151, 198, 65, 26);
	panelDigitalClock.add(lblDigitalShapeLabel);

	JLabel lblDigitalHourLabel = new JLabel("Hour display:");
	lblDigitalHourLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	lblDigitalHourLabel.setBounds(94, 252, 123, 26);
	panelDigitalClock.add(lblDigitalHourLabel);

	JComboBox DigitalHourComboBox = new JComboBox();
	DigitalHourComboBox.setModel(new DefaultComboBoxModel(new String[] { "24h Display", "12h Display" }));
	DigitalHourComboBox.setBounds(243, 247, 158, 41);
	panelDigitalClock.add(DigitalHourComboBox);

	JComboBox DigitalShapeComboBox = new JComboBox();
	DigitalShapeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Circle", "Rectangle", "Triangle"}));
	DigitalShapeComboBox.setBounds(243, 193, 158, 41);
	panelDigitalClock.add(DigitalShapeComboBox);

	JComboBox DigitalNumeralsComboBox = new JComboBox();
	DigitalNumeralsComboBox.setEnabled(false);
	DigitalNumeralsComboBox.setModel(new DefaultComboBoxModel(new String[] { "Arabic" }));
	DigitalNumeralsComboBox.setBounds(243, 140, 158, 41);
	panelDigitalClock.add(DigitalNumeralsComboBox);

	JLabel label = new JLabel("Precision:");
	label.setFont(new Font("Tahoma", Font.PLAIN, 21));
	label.setBounds(127, 346, 90, 26);
	panelDigitalClock.add(label);

	JRadioButton rdbtnSecDig = new JRadioButton("Sec, Min, Hour");
	rdbtnSecDig.setBounds(243, 347, 137, 29);
	rdbtnSecDig.setSelected(true);
	panelDigitalClock.add(rdbtnSecDig);

	JRadioButton rdbtnHourMinDig = new JRadioButton("Min, Hour");
	rdbtnHourMinDig.setBounds(387, 347, 203, 29);
	panelDigitalClock.add(rdbtnHourMinDig);

	ButtonGroup group2 = new ButtonGroup();
	group.add(rdbtnHourMinDig);
	group.add(rdbtnSecDig);

	JLabel label_1 = new JLabel("Other Functionalities:");
	label_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
	label_1.setBounds(12, 310, 205, 20);
	panelDigitalClock.add(label_1);

	JRadioButton radioButton_2 = new JRadioButton("Alarm");
	radioButton_2.setBounds(243, 300, 75, 29);
	panelDigitalClock.add(radioButton_2);

	JRadioButton radioButton_3 = new JRadioButton("Stop Watch");
	radioButton_3.setBounds(325, 300, 155, 29);
	panelDigitalClock.add(radioButton_3);

	JLabel lblColourBorderLabel = new JLabel("Border:");
	lblColourBorderLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	lblColourBorderLabel.setBounds(121, 145, 70, 20);
	panelColour.add(lblColourBorderLabel);

	JLabel lblColourBackgroundLabel = new JLabel("Background:");
	lblColourBackgroundLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	lblColourBackgroundLabel.setBounds(72, 227, 118, 20);
	panelColour.add(lblColourBackgroundLabel);

	JLabel lblColourFontLabel = new JLabel("Font:");
	lblColourFontLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	lblColourFontLabel.setBounds(136, 306, 55, 20);
	panelColour.add(lblColourFontLabel);

	JComboBox ColourBorderComboBox = new JComboBox();
	ColourBorderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Black", "Red", "Green", "Blue", "Yellow"}));
	ColourBorderComboBox.setBounds(233, 137, 158, 41);
	panelColour.add(ColourBorderComboBox);

	JComboBox ColourBackgroundComboBox = new JComboBox();
	ColourBackgroundComboBox.setModel(new DefaultComboBoxModel(new String[] {"White", "Green", "Red", "Blue", "Yellow"}));
	ColourBackgroundComboBox.setBounds(233, 219, 158, 41);
	panelColour.add(ColourBackgroundComboBox);

	JComboBox ColourFontComboBox = new JComboBox();
	ColourFontComboBox.setModel(new DefaultComboBoxModel(new String[] {"Black", "Blue", "Green", "Red", "Yellow"}));
	ColourFontComboBox.setBounds(233, 298, 158, 41);
	panelColour.add(ColourFontComboBox);

	JLabel lblColourLabel = new JLabel("Colour Schemes");
	lblColourLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
	lblColourLabel.setForeground(Color.MAGENTA);
	lblColourLabel.setBounds(192, 51, 261, 47);
	panelColour.add(lblColourLabel);
	
	btnDigitalCOLOURButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		switch((String)DigitalShapeComboBox.getSelectedItem()){
		case "Circle":
		    properties.setProperty("-shape", "circle");
		    properties.setProperty("-fx-background-radius", "150");
		    properties.setProperty("-fx-border-radius", "150");
		    properties.setProperty("-fx-border-width", "3");
		    properties.setProperty("-width", "300");
		    properties.setProperty("-height", "300");
		    break;
		case "Rectangle":
		    properties.setProperty("-shape", "rectangle");
		    properties.setProperty("-fx-background-radius", "0");
		    properties.setProperty("-fx-border-radius", "0");
		    properties.setProperty("-width", "300");
		    properties.setProperty("-height", "200");
		    break;
		case "Triangle":
		    properties.setProperty("-shape", "triangle");
		    properties.setProperty("-fx-background-radius", "0");
		    properties.setProperty("-fx-border-radius", "0");
		    properties.setProperty("-width", "300");
		    properties.setProperty("-height", "300");
		    break;
		}
		
		if(radioButton_3.isSelected()){
		    properties.setProperty("-stopwatch", "true");
		} else {
		    properties.setProperty("-stopwatch", "false");
		}
		if(rdbtnSecDig.isSelected()){
		    properties.setProperty("-hour-format", "HH:mm:ss");
		}
		if(rdbtnHourMinDig.isSelected()){
		    properties.setProperty("-hour-format", "HH:mm");
		}
		//properties.setProperty(key, value)
		panelColour.setVisible(true);
		panelDigitalClock.setVisible(false);
	    }
	});

	JButton btnColourFinishButton = new JButton("FINISH");
	btnColourFinishButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		properties.setProperty("-fx-border-color", (String)ColourBorderComboBox.getSelectedItem());
		properties.setProperty("-fx-background-color", (String)ColourBackgroundComboBox.getSelectedItem());
		properties.setProperty("-fx-fill", (String)ColourFontComboBox.getSelectedItem());
		try {
		    properties.store(new OutputStreamWriter(new FileOutputStream("bin/Clock.properties"), "UTF-8"), "");
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		setVisible(false);
		javafx.application.Application.launch(Clock.class);
	    }
	});
	btnColourFinishButton.setFont(new Font("Tahoma", Font.BOLD, 20));
	btnColourFinishButton.setForeground(Color.BLUE);
	btnColourFinishButton.setToolTipText("Press here to finish your Widget");
	btnColourFinishButton.setBounds(229, 420, 203, 60);
	panelColour.add(btnColourFinishButton);
    }
}
