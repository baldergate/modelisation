package affichage;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

import vues.Vue;

@SuppressWarnings("serial")
public class Affichage extends JFrame{
	private Vue v;
	
	public Affichage(Vue vue) {	
		v=vue;
		setLocationRelativeTo(null);
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g){
		double[] points = v.getModele().getPoints();
		int[][] segments = v.getModele().getSegments();
		
		g.setColor(Color.black);
		for (int i = 0; i<v.getModele().getNbSegment();++i) {
			g.drawLine((int)points[(segments[i][0]-1)*3],(int)points[((segments[i][0]-1)*3)+1],(int)points[(segments[i][1]-1)*3],(int)points[((segments[i][1]-1)*3)+1]);
		}
	}
}
