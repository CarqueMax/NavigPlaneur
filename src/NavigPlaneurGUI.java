import java.awt.BorderLayout;
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
	
	public NavigPlaneurGUI() {
		this.initComponents();
	}
	
	public void initComponents() {
		setTitle("NavigPlaneur");
		setSize(800,600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//setExtendedState(this.MAXIMIZED_BOTH);
		
		ImageIcon fond = new ImageIcon("data/fond.png");
		JLabel j = new JLabel(fond);
		
		JPanel main = new JPanel();
		main.add(j);
	
		JLabel title = new JLabel("NavigPlaneur");
		JButton settings = new JButton("Settings");
		
		JPanel stateBar = new JPanel();
		stateBar.setLayout(new GridLayout(1,3,260,5));
		stateBar.add(title);
		stateBar.add(settings);
		
		JLabel nav = new JLabel("Navigation");		
		JRadioButton choice1 = new JRadioButton();
		JRadioButton choice2 = new JRadioButton();
		JLabel alt = new JLabel("Altitude actuelle");
		JPanel menu = new JPanel();
		JTextField altitude = new JTextField("Entrer altitude");
		JButton darkTheme = new JButton("Thème sombre");
		menu.setLayout(new GridLayout(7,1));
		menu.add(nav);
		menu.add(choice1);
		menu.add(choice2);
		menu.add(alt);
		menu.add(altitude);
		menu.add(darkTheme);
		
		add(menu, BorderLayout.WEST);

		
		settings.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				settings(evt);
			}
		});
		
		main.add(stateBar, BorderLayout.NORTH);
		main.setAlignmentX(CENTER_ALIGNMENT);
		main.add(j, BorderLayout.EAST);
		getContentPane().add(main);
		
	}
	
	private void settings(ActionEvent evt) {
		System.out.println("Settings");
	}

}
