import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class NavigPlaneurGUI extends JFrame {
	
	// Home components
	private JLabel title;
	private JButton settings;
	private JPanel menu;
	private JLabel navigation;
	private JRadioButton choice1;
	private JRadioButton choice2;
	private JLabel altitude;
	private JTextField altitudeTextField;
	private JButton darkTheme;
	private boolean dark;
	
	/**
	 * Launch the application
	 */
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NavigPlaneurGUI frame = new NavigPlaneurGUI();
				frame.setVisible(true);
			}
		});
	}
	
	/**
	 * Constructor of the NavigPlaneurGui
	 */
	public NavigPlaneurGUI() {
		this.initComponents();
	}
	
	/**
	 * Initialize the components
	 */
	private void initComponents() {
		setTitle("NavigPlaneur");
		setSize(915,600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		dark = false;
		
		// Add the map image
		ImageIcon fond = new ImageIcon("data/fond.png");
		JLabel j = new JLabel(fond);
		JPanel main = new JPanel();
		
		// Add the title at the top
		title = new JLabel("<html><body><u>NavigPlaneur</u></body></html>");
		Font f1 = new Font("Sherif",Font.PLAIN, 25);
		title.setFont(f1);
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		// Add the parameters button at top left
		settings = new JButton("Settings");
		settings.setSize(134, 34);
		Font f2 = new Font("Sherif",Font.PLAIN, 15);
		settings.setFont(f2);
		settings.setBorderPainted(true);
		settings.setBackground(Color.WHITE);
		settings.setForeground(Color.BLACK);
		
		JPanel stateBar = new JPanel();
		add(title, BorderLayout.NORTH);
		add(settings);

		// Initializes the menu components
		menu = new JPanel();
		navigation = new JLabel("<html><body><u>Navigation</u></body></html>",JLabel.CENTER);	
		choice1 = new JRadioButton();
		choice2 = new JRadioButton();
		altitude = new JLabel("Altitude actuelle");
		altitudeTextField = new JTextField("Entrer altitude");
		darkTheme = new JButton("Thème sombre");
		navigation.setFont(f2);
		altitude.setFont(f2);
		altitudeTextField.setFont(f2);
		darkTheme.setFont(f2);
		navigation.setForeground(Color.BLACK);
		altitude.setForeground(Color.BLACK);
		choice1.setForeground(Color.BLACK);
		choice2.setForeground(Color.BLACK);
		altitudeTextField.setForeground(Color.BLACK);
		darkTheme.setForeground(Color.BLACK);
		choice1.setHorizontalAlignment(JLabel.CENTER);
		choice2.setHorizontalAlignment(JLabel.CENTER);
		altitude.setHorizontalAlignment(JLabel.CENTER);
		altitudeTextField.setHorizontalAlignment(JLabel.CENTER);
		darkTheme.setHorizontalAlignment(JLabel.CENTER);
		menu.setBackground(Color.WHITE);
		choice1.setBackground(Color.WHITE);
		choice2.setBackground(Color.WHITE);
		altitudeTextField.setBackground(Color.WHITE);
		darkTheme.setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		
		// Add the two images in the menu with the radio buttons
		JPanel choice1Layout = new JPanel();
		JPanel choice2Layout = new JPanel();
		choice1Layout.setLayout(new GridLayout(2,1));
		ImageIcon plan = new ImageIcon(new ImageIcon("data/plan.jpg").getImage().getScaledInstance(134, 60, Image.SCALE_DEFAULT));
		JLabel p = new JLabel(plan);
		ImageIcon satellite = new ImageIcon(new ImageIcon("data/satellite.jpg").getImage().getScaledInstance(134, 60, Image.SCALE_DEFAULT));
		JLabel s = new JLabel(satellite);
		choice1Layout.add(choice1);
		choice1Layout.add(p);
		choice2Layout.setLayout(new GridLayout(2,1));
		choice2Layout.add(choice2);
		choice2Layout.add(s);
		
		// Add all the components in the menu on the left
		menu.setLayout(new GridLayout(7,1,0,-5));
		menu.add(navigation);
		menu.add(choice1Layout);
		menu.add(choice2Layout);
		menu.add(altitude);
		menu.add(altitudeTextField);
		menu.add(darkTheme);
		add(menu, BorderLayout.WEST);

		// Listener of settings button
		settings.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				settings(evt);
			}
		});
		
		// Listener of dark theme button
		darkTheme.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				darkTheme(evt);
			}
		});
		
		// Place the components on the panel
		main.add(stateBar, BorderLayout.NORTH);
		main.setAlignmentX(CENTER_ALIGNMENT);
		main.add(j, BorderLayout.CENTER);
		getContentPane().add(main);
		
	}
	
	/**
	 * Open the settings page
	 */
	private void settings(ActionEvent evt) {
		this.dispose();
		Settings s = new Settings();
	}

	/**
	 * Put the application in dark theme
	 */
	private void darkTheme(ActionEvent evt) {
		if(!dark) {
			settings.setBackground(Color.DARK_GRAY);
			menu.setBackground(Color.DARK_GRAY);
			choice1.setBackground(Color.DARK_GRAY);
			choice2.setBackground(Color.DARK_GRAY);
			altitudeTextField.setBackground(Color.DARK_GRAY);
			darkTheme.setBackground(Color.DARK_GRAY);
			getContentPane().setBackground(Color.DARK_GRAY);
			dark = true;
		}else {
			settings.setBackground(Color.WHITE);
			menu.setBackground(Color.WHITE);
			choice1.setBackground(Color.WHITE);
			choice2.setBackground(Color.WHITE);
			altitudeTextField.setBackground(Color.WHITE);
			darkTheme.setBackground(Color.WHITE);
			getContentPane().setBackground(Color.WHITE);
			dark = false;
		}
	}
}
