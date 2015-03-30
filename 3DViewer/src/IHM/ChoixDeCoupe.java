package IHM;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoixDeCoupe {

	public ChoixDeCoupe(){
		JPanel panel = new JPanel();
		JButton coupe = new JButton();
		JButton standard = new JButton();
		panel.setLayout(new BorderLayout());
		panel.add(coupe);
		panel.add(standard);
	
	}
}
