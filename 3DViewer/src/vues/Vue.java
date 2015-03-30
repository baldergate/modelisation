package vues;
import parser.Modele;

public class Vue {
	private Modele m;
	private double[] points;
	
	public Vue(Modele m){
		this.m=m;
		points= m.getPoints();
	}
	
	public Modele getModele(){
		return m;
	}
	
	public void doHomotetie(double rapport){
		for (int i = 0; i < points.length;++i) {
			points[i] = points[i]*rapport;
		}
	}
	
	public void setModele(Modele m){
		this.m=m;
	}
}
