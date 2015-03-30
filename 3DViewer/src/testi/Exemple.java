package testi;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Exemple extends JFrame {
	public Exemple(String titre, int largeur, int hauteur, int posX, int posY) {
		super(titre);
		// titre de la fenêtre
		setLocation(posX, posY);
		// position de la fenêtre
		setSize(largeur, hauteur); // taille de la fenêtre
		setVisible(true);
		// rend visible l'objet
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// fermeture automatique
	}

	public void paint(Graphics g) {
		int X[] = { 700, 750, 650 };
		int Y[] = { 425, 500, 500 };
		String s = "WANTED";

		// fond de couler
		g.setColor(Color.blue); // fixe la couleur courante
		g.fillRect(450, 150, 500, 600); // dessine un rectangle plein

		// les oreilles
		g.setColor(new Color(255, 92, 44));
		g.fillOval(455, 350, 75, 175);
		g.fillOval(875, 350, 75, 175);

		// interieur oreille
		g.setColor(Color.red);
		g.drawOval(890, 375, 40, 130);
		g.drawOval(475, 375, 40, 130);

		// cheveux
		g.setColor(new Color(255, 92, 44));
		g.fillArc(500, 180, 400, 300, 0, 180);

		// visage
		g.setColor(new Color(255, 182, 193)); // modifie la couleur courante
		g.fillOval(500, 200, 400, 500); // dessine un oval en mode filaire

		// yeux + dents
		g.setColor(Color.white);
		for (int i = 0; i < 8; i++) {
			g.fillRect(655 + (13 * i), 570, 10, 15);
			g.fillRect(655 + (13 * i), 590, 10, 15);
		}
		g.fillOval(620, 325, 75, 50);
		g.fillOval(705, 325, 75, 50);

		// interieur des yeux
		g.setColor(Color.blue);
		g.drawRoundRect(620, 325, 75, 50, 0, 0);

		// suite des dents
		g.setColor(new Color(255, 182, 193));
		g.fillOval(605, 595, 200, 100);
		g.fillOval(605, 480, 200, 100);

		// nez
		g.setColor(Color.red);
		g.fillPolygon(X, Y, 3);

		// MOT
		g.drawString(s, 1200, 400);

	}

	public static void main(String[] args) {
		new Exemple("Premier dessin", 2000, 1600, 5000, 1500);
	}
}
