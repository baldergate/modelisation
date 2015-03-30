package parser;

public class Modele {
	private double [] points;
	private int[][] segments;
	private int[][] faces;
	private int nbSommet;
	private int nbSegment;
	private int nbFace;
	
	public Modele(double [] pts, int[][]segs, int[][]faces, int sommet, int segment, int face){
		points=pts;
		segments = segs;
		this.faces=faces;
		nbSommet= sommet;
		nbSegment = segment;
		nbFace = face;
	}
	
	public int getNbSommet() {
		return nbSommet;
	}
	
	public int getNbSegment() {
		return nbSegment;
	}
	
	public int getNbFace() {
		return nbFace;
	}

	public double [] getPoints() {
		return points;
	}
	
	public void setPoints(double[] points){
		this.points = points;
	}

	public int [][] getSegments() {
		return segments;
	}
	
	public int [][] getFaces() {
		return faces;
	}
}