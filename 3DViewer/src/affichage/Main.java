package affichage;

import parser.Modele;
import vues.Vue;

public class Main {
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application’s GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				// Exemple 2D
				double[] p = new double[] { 400.0, 400.0, 0.0, 500.0, 400.0,
						0.0, 400.0, 350.0, 0.0 };

				int[][] s = new int[3][3];
				s[0][0] = 1;
				s[0][1] = 2;
				s[1][0] = 2;
				s[1][1] = 3;
				s[2][0] = 1;
				s[2][1] = 3;

				int[][] f = new int[1][3];
				f[0][0] = 1;
				f[0][1] = 2;
				f[0][2] = 3;

				Modele m = new Modele(p, s, f, 3, 3, 1);
				Vue v = new Vue(m);

				Affichage a = new Affichage(v);
				v.doHomotetie(2.0);
			}

		});
	}
}
