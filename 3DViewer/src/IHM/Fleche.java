package IHM;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Fleche extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton flecheD;
	JButton flecheB;
	JButton flecheG;
	JButton flecheH;

	public Fleche() {

		flecheD = new JButton(new ImageIcon("res/FlecheDroite.png"));
		flecheB = new JButton(new ImageIcon("res/FlecheBas.png"));
		flecheG = new JButton(new ImageIcon("res/FlecheGauche.png"));
		flecheH = new JButton(new ImageIcon("res/FlecheHaut.png"));
		flecheD.setPreferredSize(new Dimension(50, 50));
		flecheH.setPreferredSize(new Dimension(50, 50));
		flecheG.setPreferredSize(new Dimension(50, 50));
		flecheB.setPreferredSize(new Dimension(50, 50));
		GridBagConstraints gril = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		gril.gridx = 1;
		gril.gridy = 2;
		this.add(flecheB, gril);
		gril.gridx = 2;
		gril.gridy = 1;
		this.add(flecheD, gril);
		gril.gridx = 1;
		gril.gridy = 0;
		this.add(flecheH, gril);
		gril.gridx = 0;
		gril.gridy = 1;
		this.add(flecheG, gril);
	}
}
