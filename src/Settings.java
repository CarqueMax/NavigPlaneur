import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Settings extends JFrame {
    private JLabel title;
	private JButton welcomMenu;
	private JPanel menu;
    private JPanel altitude;
    private JPanel vitesse;
    private JPanel finesse;
    private JTextField saisieFin;
	
    /**
	 * Settings menu
	 */
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Settings frame = new Settings();
				frame.setVisible(true);
			}
		});
	}
	
	/**
	 * Constructor of the NavigPlaneurGui
	 */
	public Settings() {
		this.initComponents();
	}

    /**
	 * Initialize the components
	 */
	private void initComponents() {
        setTitle("NavigPlaneur");
		setSize(915,600);
        setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

        // Add the title at the top
		title = new JLabel("<html><body><u>NavigPlaneur</u></body></html>");
		Font f1 = new Font("Sherif",Font.PLAIN, 25);
		title.setFont(f1);
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(JLabel.CENTER);

        // Add the parameters button at top left
		welcomMenu = new JButton("Settings");
		welcomMenu.setSize(134, 34);
		Font f2 = new Font("Sherif",Font.PLAIN, 15);
		welcomMenu.setFont(f2);
		welcomMenu.setBorderPainted(true);
		welcomMenu.setBackground(Color.WHITE);
		welcomMenu.setForeground(Color.BLACK);

        JPanel stateBar = new JPanel();
		add(title, BorderLayout.NORTH);
		add(welcomMenu);

        // altitude
        JLabel alt = new JLabel("Unité d'altitude");
        altitude = new JPanel(new GridLayout(2,1));
        altitude.add(alt);
        JPanel choicesAlt = new JPanel(new GridLayout(1,4));
        JRadioButton choice1Alt = new JRadioButton();
        JRadioButton choice2Alt = new JRadioButton();
        choicesAlt.add(choice1Alt);
        choicesAlt.add(new JLabel("m"));
        choicesAlt.add(choice2Alt);
        choicesAlt.add(new JLabel("ft"));
        altitude.add(choicesAlt);

        // vitesse
        JLabel vit = new JLabel("Unité de vitesse");
        vitesse = new JPanel(new GridLayout(2,1));
        vitesse.add(vit);
        JPanel choicesVit = new JPanel(new GridLayout(1,4));
        JRadioButton choice1Vit = new JRadioButton();
        JRadioButton choice2Vit = new JRadioButton();
        choicesVit.add(choice1Vit);
        choicesVit.add(new JLabel("km/h"));
        choicesVit.add(choice2Vit);
        choicesVit.add(new JLabel("kn"));
        vitesse.add(choicesVit);

        // finesse
        JLabel fin = new JLabel("Unité de finesse");
        finesse = new JPanel(new GridLayout(2,1));
        finesse.add(fin);
        JPanel menuFin = new JPanel(new GridLayout(1,2));
        saisieFin = new JTextField();
        JButton validerFin = new JButton("Valider");
        menuFin.add(saisieFin);
        menuFin.add(validerFin);
        finesse.add(menuFin);


        // Initializes the settings menu
        menu = new JPanel();
        menu.setLayout(new FlowLayout(100, 100, 100));
        menu.add(altitude);
        menu.add(vitesse);
        menu.add(finesse);
        

        // Listener of welcomMenu button
		welcomMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				welcomMenu(evt);
			}
		});

        // Listener of validerFin
		validerFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				getFinesse(evt);
			}
		});
        
		// Place the components on the panel
		menu.add(stateBar, BorderLayout.NORTH);
		getContentPane().add(menu);
    }

    /**
	 * Open the welcomMenu page
	 */
	private void welcomMenu(ActionEvent evt) {
		this.dispose();
		NavigPlaneurGUI s = new NavigPlaneurGUI();
	}

    /**
	 * Get finesse
	 * @param evt
	 */
    private void getFinesse(ActionEvent evt) {
        try {
            if(Integer.parseInt(saisieFin.getText()) > 0 && Integer.parseInt(saisieFin.getText()) < 100) {
                System.out.println("Finesse :"+saisieFin.getText());
                NavigPlaneurGUI navig = new NavigPlaneurGUI();
                navig.radius.setGlide(Integer.parseInt(saisieFin.getText()));
            }else {
                System.out.println("Veuillez rentrer une valeur comprise entre 1 et 100");
            }
        }catch(NumberFormatException e) {
            System.out.println("Veuillez rentrer une valeur !");
        }
    }
}