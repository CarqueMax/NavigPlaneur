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
    private NavigPlaneurGUI navig;
    private JButton validerFin;
    private JPanel choicesAlt;
    private JPanel choicesVit;
    private JRadioButton choice1Alt;
    private JRadioButton choice2Alt;
    private JRadioButton choice1Vit;
    private JRadioButton choice2Vit;
	
    /**
	 * Settings menu
	 */
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Settings frame = new Settings(navig.dark);
				frame.setVisible(true);
			}
		});
	}
	
	/**
	 * Constructor of the NavigPlaneurGui
	 */
	public Settings(boolean dark) {
        navig = new NavigPlaneurGUI(dark);
		this.initComponents();
        darkTheme();
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
		welcomMenu = new JButton("Home");
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
        alt.setForeground(Color.BLACK);
        altitude = new JPanel(new GridLayout(2,1));
        altitude.add(alt);
        choicesAlt = new JPanel(new GridLayout(1,4));
        choice1Alt = new JRadioButton();
        choice2Alt = new JRadioButton();
        choicesAlt.add(choice1Alt);
        choicesAlt.add(new JLabel("m"),Color.BLACK);
        choicesAlt.add(choice2Alt);
        choicesAlt.add(new JLabel("ft"),Color.BLACK);
        altitude.add(choicesAlt);

        // vitesse
        JLabel vit = new JLabel("Unité de vitesse");
        vit.setForeground(Color.BLACK);
        vitesse = new JPanel(new GridLayout(2,1));
        vitesse.add(vit);
        choicesVit = new JPanel(new GridLayout(1,4));
        choice1Vit = new JRadioButton();
        choice2Vit = new JRadioButton();
        choicesVit.add(choice1Vit);
        choicesVit.add(new JLabel("km/h"),Color.BLACK);
        choicesVit.add(choice2Vit);
        choicesVit.add(new JLabel("kn"),Color.BLACK);
        vitesse.add(choicesVit);

        // finesse
        JLabel fin = new JLabel("Unité de finesse");
        fin.setForeground(Color.BLACK);
        finesse = new JPanel(new GridLayout(2,1));
        finesse.add(fin);
        JPanel menuFin = new JPanel(new GridLayout(1,2));
        saisieFin = new JTextField();
        validerFin = new JButton("Valider");
        validerFin.setForeground(Color.BLACK);
        
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
		NavigPlaneurGUI s = new NavigPlaneurGUI(navig.dark);
        s.setVisible(true);
	}

    /**
	 * Get finesse
	 * @param evt
	 */
    private void getFinesse(ActionEvent evt) {
        try {
            if(Integer.parseInt(saisieFin.getText()) > 0 && Integer.parseInt(saisieFin.getText()) < 100) {
                System.out.println("Finesse :"+saisieFin.getText());
                navig.radius.setGlide(Integer.parseInt(saisieFin.getText()));
            }else {
                System.out.println("Veuillez rentrer une valeur comprise entre 1 et 100");
            }
        }catch(NumberFormatException e) {
            System.out.println("Veuillez rentrer une valeur !");
        }
    }

    private void darkTheme() {
        if(navig.dark){
            getContentPane().setBackground(Color.DARK_GRAY);
            title.setBackground(Color.DARK_GRAY);
            welcomMenu.setBackground(Color.DARK_GRAY);
            menu.setBackground(Color.DARK_GRAY);
            altitude.setBackground(Color.DARK_GRAY);
            vitesse.setBackground(Color.DARK_GRAY);
            finesse.setBackground(Color.DARK_GRAY);
            saisieFin.setBackground(Color.DARK_GRAY);
            navig.setBackground(Color.DARK_GRAY);
            validerFin.setBackground(Color.DARK_GRAY);
            choicesAlt.setBackground(Color.DARK_GRAY);
            choicesVit.setBackground(Color.DARK_GRAY);

            choice1Alt.setBackground(Color.DARK_GRAY);
            choice2Alt.setBackground(Color.DARK_GRAY);
            choice1Vit.setBackground(Color.DARK_GRAY);
            choice2Vit.setBackground(Color.DARK_GRAY);

        }
    }
}