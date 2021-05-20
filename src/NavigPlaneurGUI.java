import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class NavigPlaneurGUI extends JFrame {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NavigPlaneurGUI frame = new NavigPlaneurGUI();
				frame.setVisible(true);
			}
		});
	}
	
	/**
	 * 
	 */
	public NavigPlaneurGUI() {
		this.initComponents();
	}
	
	/**
	 * 
	 */
	private void initComponents() {
		setTitle("NavigPlaneur");
		setSize(800,600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//
		ImageIcon fond = new ImageIcon("data/fond.png");
		JLabel j = new JLabel(fond);
		JPanel main = new JPanel();
		main.add(j);
		
		//
		JLabel title = new JLabel("<html><body><u>NavigPlaneur</u></body></html>");
		Font f1 = new Font("Sherif",Font.PLAIN, 25);
		title.setFont(f1);
		JButton settings = new JButton("Settings");
		title.setHorizontalAlignment(JLabel.CENTER);
		settings.setSize(120, 35);
		Font f2 = new Font("Sherif",Font.PLAIN, 15);
		settings.setFont(f2);
		JPanel stateBar = new JPanel();
		add(title, BorderLayout.NORTH);
		add(settings);

		//
		JLabel nav = new JLabel("<html><body><u>Navigation</u></body></html>",JLabel.CENTER);	
		JRadioButton choice1 = new JRadioButton();
		JRadioButton choice2 = new JRadioButton();
		JLabel alt = new JLabel("Altitude actuelle");
		JPanel menu = new JPanel();
		JTextField altitude = new JTextField("Entrer altitude");
		JButton darkTheme = new JButton("Thème sombre");
		nav.setFont(f2);
		alt.setFont(f2);
		altitude.setFont(f2);
		darkTheme.setFont(f2);
		choice1.setHorizontalAlignment(JLabel.CENTER);
		choice2.setHorizontalAlignment(JLabel.CENTER);
		alt.setHorizontalAlignment(JLabel.CENTER);
		altitude.setHorizontalAlignment(JLabel.CENTER);
		darkTheme.setHorizontalAlignment(JLabel.CENTER);
		menu.setLayout(new GridLayout(7,1,0,-5));
		menu.add(nav);
		menu.add(choice1);
		menu.add(choice2);
		menu.add(alt);
		menu.add(altitude);
		menu.add(darkTheme);
		add(menu, BorderLayout.WEST);

		//
		settings.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				settings(evt);
			}
		});
		
		//
		darkTheme.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				darkTheme(evt);
			}
		});
		
		//
		main.add(stateBar, BorderLayout.NORTH);
		main.setAlignmentX(CENTER_ALIGNMENT);
		main.add(j, BorderLayout.EAST);
		getContentPane().add(main);
		
	}
	
	/**
	 * 
	 * @param evt
	 */
	private void settings(ActionEvent evt) {
		System.out.println("Settings");
	}

	/**
	 * 
	 * @param evt
	 */
	private void darkTheme(ActionEvent evt) {
		System.out.println("Dark theme");
	}
}
