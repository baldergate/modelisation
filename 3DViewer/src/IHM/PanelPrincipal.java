package IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class PanelPrincipal {

	JFrame fenetre = new JFrame();
	Menu menu = new Menu();
	JPanel panelPrincipal = new JPanel();
	JPanel panelChoixDeCoupe = new JPanel();
	JPanel panelModele = new JPanel();
	JPanel panelBas = new JPanel();
	JButton boutton;
	JButton boutton2;
	JTextField x = new JTextField("x");
	JTextField y = new JTextField("y");
	JTextField z = new JTextField("z");
	JSlider slid = new JSlider(JSlider.VERTICAL);
	JButton flecheD;
	JButton flecheB;
	JButton flecheG;
	JButton flecheH;
	JButton flecheD1;
	JButton flecheB1;
	JButton flecheG1;
	JButton flecheH1;
	JPanel zoom;
	JPanel deplacement;
	JPanel rotation;

	public PanelPrincipal() {

		fenetre.setJMenuBar(menu.menuBar);
		zoom = new JPanel();
		rotation = new JPanel();
		deplacement = new JPanel();
		panelModele.setPreferredSize(new Dimension(1000, 1000));
		x.setPreferredSize(new Dimension(150, 100));
		y.setPreferredSize(new Dimension(150, 100));
		z.setPreferredSize(new Dimension(150, 100));
		boutton = new JButton("Coupe");
		boutton2 = new JButton("3D");
		boutton.setPreferredSize(new Dimension(200, 150));
		boutton2.setPreferredSize(new Dimension(200, 150));

		flecheD = new JButton(new ImageIcon("res/FlecheDroite.png"));
		flecheB = new JButton(new ImageIcon("res/FlecheBas.png"));
		flecheG = new JButton(new ImageIcon("res/FlecheGauche.png"));
		flecheH = new JButton(new ImageIcon("res/FlecheHaut.png"));
		flecheD1 = new JButton(new ImageIcon("res/FlecheDroite.png"));
		flecheB1 = new JButton(new ImageIcon("res/FlecheBas.png"));
		flecheG1 = new JButton(new ImageIcon("res/FlecheGauche.png"));
		flecheH1 = new JButton(new ImageIcon("res/FlecheHaut.png"));
		flecheD.setPreferredSize(new Dimension(75, 75));

		panelChoixDeCoupe.setPreferredSize(new Dimension(500, 150));
		// panelChoixDeCoupe.setLayout(new
		// BoxLayout(panelChoixDeCoupe,BoxLayout.Y_AXIS));
		GridBagConstraints gril = new GridBagConstraints();
		panelChoixDeCoupe.setLayout(new GridBagLayout());
		gril.gridx = 1;
		gril.insets = new Insets(50, 0, 0, 0);
		panelChoixDeCoupe.add(boutton, gril);
		panelChoixDeCoupe.add(boutton2, gril);
		panelChoixDeCoupe.add(x, gril);
		panelChoixDeCoupe.add(y, gril);
		panelChoixDeCoupe.add(z, gril);

		zoom.add(slid);

		/*
		 * rotation.setLayout(new BorderLayout());
		 * rotation.add(flecheB1,BorderLayout.SOUTH);
		 * rotation.add(flecheD1,BorderLayout.EAST);
		 * rotation.add(flecheH1,BorderLayout.NORTH);
		 * rotation.add(flecheG1,BorderLayout.WEST);
		 */

		panelBas.setLayout(new FlowLayout());
		panelBas.add(new Fleche());
		panelBas.add(new Fleche());
		panelBas.add(zoom);

		panelPrincipal.setLayout(new BorderLayout());
		panelPrincipal.add(panelModele, BorderLayout.CENTER);
		panelPrincipal.add(panelChoixDeCoupe, BorderLayout.EAST);
		panelPrincipal.add(panelBas, BorderLayout.PAGE_END);

		fenetre.getContentPane().add(panelPrincipal);
		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
		fenetre.setResizable(false);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PanelPrincipal();
			}
		});
	}
}
