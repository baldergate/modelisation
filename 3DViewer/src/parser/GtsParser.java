package parser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class GtsParser {

	private Scanner s;
	private String tab[][];
	private int nbLignes;
	private int nbSommet;
	private int nbSegment;
	private int nbFace;
	private boolean okay = true;
	private boolean type = true;
	private String err = "";

	public GtsParser(Reader r) throws IOException {
		s = new Scanner(r);
		init();
		verify();
	}

	public Modele getModele() {
		return new Modele(sommetToDouble(), segToInt(), faceToInt(), nbSommet,
				nbSegment, nbFace);
	}

	private double[] sommetToDouble() {
		double[] res = new double[3 * nbSommet];
		try {
			for (int i = 0; i < nbSommet; ++i) {
				for (int j = 0; j < 3; ++j) {
					res[j + 3 * i] = Double.parseDouble(tab[i][j]);
				}
			}
		} catch (NumberFormatException e) { // Permet d'éviter l'arrêt du
											// programme suite à une erreur déjà
											// traitée par checkType()
		}
		return res;
	}

	private int[][] segToInt() {
		int[][] res = new int[nbSegment][2];

		for (int i = nbSommet; i < nbSommet + nbSegment; ++i) {
			for (int j = 0; j < 2; ++j) {
				res[i - nbSommet][j] = Integer.parseInt(tab[i][j]);
			}
		}
		return res;
	}

	private int[][] faceToInt() {
		int[][] res = new int[nbFace][2];

		for (int i = nbSommet + nbSegment; i < nbSommet + nbSegment + nbFace; ++i) {
			int seg1 = Integer.parseInt(tab[i][0]);
			int seg2 = Integer.parseInt(tab[i][1]);
			res[i - nbSommet - nbSegment][0] = Integer.parseInt(tab[nbSommet
					+ seg1 - 1][0]);
			res[i - nbSommet - nbSegment][1] = Integer.parseInt(tab[nbSommet
					+ seg1 - 1][1]);
			if (tab[nbSommet + seg2 - 1][0] != tab[nbSommet + seg1 - 1][0]
					&& tab[nbSommet + seg2 - 1][0] != tab[nbSommet + seg1 - 1][1])
				res[i - nbSommet - nbSegment][2] = Integer
						.parseInt(tab[nbSommet + seg2 - 1][0]);
			else
				res[i - nbSommet - nbSegment][2] = Integer
						.parseInt(tab[nbSommet + seg2 - 1][1]);
		}
		return res;
	}

	private boolean verify() {
		checkNbLines();
		checkSommets();
		checkSegments();
		checkFaces();
		checkType();
		if (type) {
			checkCoherenceSegments();
			checkCoherenceFaces();
			checkUniciteSommets();
			checkUniciteSegments();
			checkUniciteFaces();
			checkTriangles();
		}
		if (!okay) {
			System.out.println(err);
		}
		return okay;
	}

	private void init() {
		String[] lAct = s.nextLine().split(" "); // Ligne sur laquelle le parser
													// travaille actuellement
		nbSommet = Integer.parseInt(lAct[0]);
		nbSegment = Integer.parseInt(lAct[1]);
		nbFace = Integer.parseInt(lAct[2]);
		nbLignes = nbSommet + nbSegment + nbFace + 1;
		tab = new String[nbLignes - 1][3];
		boolean diese = false;
		for (int i = 0; i < nbLignes - 1; ++i) {
			lAct = s.nextLine().split(" ");
			for (int j = 0; j < lAct.length; ++j) {
				if (!lAct[0].substring(0, 1).equals("#")) { // Permet de
															// considérer une
															// ligne commençant
															// par "#" comme un
															// commentaire
					tab[i][j] = lAct[j];
				} else {
					diese = true;
				}
			}
			if (diese == true) {
				diese = false;
				--i;
			}
		}
	}

	private int itemPerLine(String[] tab) {
		for (int i = 0; i < tab.length; ++i) {
			if (tab[i] == null) {
				return i;
			}
		}
		return 3;
	}

	private boolean notEquals(String[] tab1, String[] tab2, int taille) {
		boolean notE = false;
		for (int i = 0; i < taille; ++i) {
			if (!tab1[i].equals(tab2[i])) {
				notE = true;
			}
		}
		return notE;

	}

	// Vérification 1 : Nombre de Lignes
	private void checkNbLines() {
		if (s.hasNext()) { // Vérifie qu'il ne reste plus de lignes
			okay = false;
			err = err
					+ "Le nombre de lignes ne correspond pas au nombres de sommets, segments et faces.\n";
		}
	}

	// Vérification 2 : Nombre de Sommets comparé au nombre annoncé dans le
	// fichier
	private void checkSommets() {
		for (int i = 0; i < nbSommet; ++i) {
			if (itemPerLine(tab[i]) != 3) {
				okay = false;
				err = err
						+ "Le nombre de sommets ne correspond pas au nombre attendu.\n";
			}
		}
	}

	// Vérification 3 : Nombre de Segments comparé au nombre annoncé dans le
	// fichier
	private void checkSegments() {
		for (int i = nbSommet; i < nbSommet + nbSegment; ++i) {
			if (itemPerLine(tab[i]) != 2) {
				okay = false;
				err = err
						+ "Le nombre de segments ne correspond pas au nombre attendu.\n";
			}
		}
	}

	// Vérification 4 : Nombre de Faces comparé au nombre annoncé dans le
	// fichier
	private void checkFaces() {
		for (int i = nbSommet + nbSegment; i < nbSommet + nbSegment + nbFace; ++i) {
			if (itemPerLine(tab[i]) != 3) {
				okay = false;
				err = err
						+ "Le nombre de faces ne correspond pas au nombre attendu.\n";
			}
		}
	}

	// Vérification 5 : Vérifie que les données dont bien des double
	private void checkType() {
		try {
			for (int i = 0; i < tab.length; ++i) {
				for (int j = 0; j < tab[0].length; ++j) {
					if (tab[i][j] != null) {
						@SuppressWarnings("unused")
						double test = Double.parseDouble(tab[i][j]);
					}
				}
			}
		} catch (NumberFormatException e) {
			okay = false;
			type = false;
			err = err
					+ "Le fichier contient des items qui ne sont pas des chiffres.\n";
			// throw new NotAFigureInFileException(err);
		}
	}

	// Vérification 6 : Vérifie que les données passées sont cohérentes (Numéro
	// de sommets existants)
	private void checkCoherenceSegments() {
		Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
		for (int i = nbSommet; i < nbSommet + nbSegment; ++i) {
			for (int j = 0; j < 2; ++j) {
				if (Integer.valueOf(tab[i][j]) > nbSommet
						|| Integer.valueOf(tab[i][j]) <= 0) {
					if (!m.containsKey("Ligne " + (i + 1))) {
						m.put("Ligne " + (i + 1), new ArrayList<String>());
						m.get("Ligne " + (i + 1)).add(tab[i][j]);
					} else {
						m.get("Ligne " + (i + 1)).add(tab[i][j]);
					}
				}
			}
		}
		if (!m.isEmpty()) {
			okay = false;
			err = err
					+ "La liste des segments contient au moins un sommet non défini.\nLes numéros de ligne ne comptent pas les lignes de commentaires.\n";
			Iterator<?> it = m.entrySet().iterator();
			while (it.hasNext()) {
				err = err + it.next().toString() + "\n";
			}
		}

	}

	// Vérification 7 : Vérifie que les données passées sont cohérentes (Numéro
	// de segments existants)
	private void checkCoherenceFaces() {
		Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
		for (int i = nbSommet + nbSegment; i < nbSommet + nbSegment + nbFace; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (Integer.valueOf(tab[i][j]) > nbSegment
						|| Integer.valueOf(tab[i][j]) <= 0) {
					if (!m.containsKey("Ligne " + (i + 1))) {
						m.put("Ligne " + (i + 1), new ArrayList<String>());
						m.get("Ligne " + (i + 1)).add(tab[i][j]);
					} else {
						m.get("Ligne " + (i + 1)).add(tab[i][j]);
					}
				}
			}
		}
		if (!m.isEmpty()) {
			okay = false;
			err = err
					+ "La liste des faces contient au moins un segment non défini.\nLes numéros de ligne ne comptent pas les lignes de commentaires.\n";
			Iterator<?> it = m.entrySet().iterator();
			while (it.hasNext()) {
				err = err + it.next().toString() + "\n";
			}
		}

	}

	// Vérification 8 : Vérifie que chaque sommet est unique
	private void checkUniciteSommets() {
		for (int i = 0; i < nbSommet; ++i) {
			for (int j = i + 1; j < nbSommet; ++j) {
				if (!notEquals(tab[i], tab[j], 3)) {
					okay = false;
					err = err + "Vérifiez l'unicité des sommets.\n";
					break;
				}
			}
		}
	}

	// Vérification 9 : Vérifie que chaque segment est unique
	private void checkUniciteSegments() {
		for (int i = nbSommet; i < nbSommet + nbSegment; ++i) {
			for (int j = i + 1; j < nbSommet + nbSegment; ++j) {
				if (!notEquals(tab[i], tab[j], 2)) {
					okay = false;
					err = err + "Vérifiez l'unicité des segments.\n";
					break;
				}
			}
		}
	}

	// Vérification 10 : Vérifie que chaque face est unique
	private void checkUniciteFaces() {
		for (int i = nbSommet + nbSegment; i < nbSommet + nbSegment + nbFace; ++i) {
			for (int j = i + 1; j < nbSommet + nbSegment + nbFace; ++j) {
				if (!notEquals(tab[i], tab[j], 3)) {
					okay = false;
					err = err + "Vérifiez l'unicité des faces.\n";
					break;
				}
			}
		}
	}

	// Vérification 11 : Vérifie que les triangles sont cohérents (points
	// reliés)
	private void checkTriangles() {
		for (int i = nbSommet + nbSegment; i < nbSommet + nbSegment + nbFace; ++i) {
			int s1 = Integer.parseInt(tab[i][0]);
			int s2 = Integer.parseInt(tab[i][1]);
			int s3 = Integer.parseInt(tab[i][2]);
			if ((checkSegmentsColles(s1, s2) || checkSegmentsColles(s1, s3) || checkSegmentsColles(
					s2, s3)) == false) {
				okay = false;
				err = err
						+ "Les segments qui composent les triangles ne sont pas tous reliés.\n";
			}
		}
	}

	// Vérifie que les deux segments ont bien un point en commun
	private boolean checkSegmentsColles(int s1, int s2) {
		String s1p1 = tab[nbSommet + s1 - 1][0];
		String s1p2 = tab[nbSommet + s1 - 1][1];
		String s2p1 = tab[nbSommet + s2 - 1][0];
		String s2p2 = tab[nbSommet + s2 - 1][1];
		return (s1p1.equals(s2p1) || s1p1.equals(s2p2) || s1p2.equals(s2p1) || s1p2
				.equals(s2p2));
	}

	public static void main(String[] args) throws IOException {
		GtsParser gp = new GtsParser(new FileReader(
				"/home/ange/Projet N3/ProjetModé/res/cube.gts"));
	}
}