package IHM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Menu {

	public JMenuBar menuBar;
	public JMenu menu;
	public JMenuItem menuItem;
	public JCheckBoxMenuItem rbMenuItem;
	public JMenu menuHelp;
	public JMenu menuContact;

	// Create the menu bar.
	public Menu() {
		menuBar = new JMenuBar();
		// Build the first menu.
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		"The principal menu in this program");
		menuBar.add(menu);
		// Build the item in "menu"
		menuItem = new JMenuItem("Nouveau", KeyEvent.VK_T);
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Open a new windows");
		menu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new PanelPrincipal();

			}

		});

		// Build item in "menu"

		
		 menuItem = new JMenuItem("Ouvrir");
		 
		 menuItem.getAccessibleContext().setAccessibleDescription(
		 "Ouvre le fichier");
		 
		 menuItem.setMnemonic(KeyEvent.VK_R);
		 
		 menu.add(menuItem);
		 
		/* menuItem.addActionListener(new ActionListener() {
		 
		 public void actionPerformed(ActionEvent e) {
		 
		 
		 
		 	}
		 
 		});*/
		// Build item in "menu"

		menu.addSeparator();

		menuItem = new JMenuItem("Quitter", KeyEvent.VK_T);

		menuItem.getAccessibleContext().setAccessibleDescription(

		"Ce bouton quitte le programme");

		menu.add(menuItem);

		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}

		});

		menuContact = new JMenu("Contact");

		menuContact.getAccessibleContext().setAccessibleDescription(
				"Ce bouton redirige vers le site des dÃ©veloppeurs");

		JButton fabian = new JButton();

		JButton theo = new JButton();

		JButton clement = new JButton();

		JButton max = new JButton();

		max.setBorderPainted(true);

		max.setText("<HTML>Maximilien BONNARD</HTML>");

		fabian.setText("<HTML>Fabian AVELIN</HTML>");

		clement.setText("<HTML>Clement SORANO</HTML>");

		theo.setText("<HTML>Tico DUCUL</HTML>");

		menuContact.add(fabian);

		menuContact.add(clement);

		menuContact.add(theo);

		menuContact.add(max);

		menuBar.add(menuContact);

		max.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					URI uriMax = new URI(
							"http://www.facebook.com/maximilien.bonnard");

					Desktop.getDesktop().browse(uriMax);

				} catch (IOException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				} catch (URISyntaxException ex) {

					Logger.getLogger(Menu.class.getName()).log(Level.SEVERE,
							null, ex);

				}

			}

		});

		theo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					URI uriMax = new URI("http://www.facebook.com/theo.ange1");

					Desktop.getDesktop().browse(uriMax);

				} catch (IOException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				} catch (URISyntaxException ex) {

					Logger.getLogger(Menu.class.getName()).log(Level.SEVERE,
							null, ex);

				}

			}

		});

		fabian.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					URI uriMax = new URI(
							"http://www.facebook.com/fabian.avelin");

					Desktop.getDesktop().browse(uriMax);

				} catch (IOException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				} catch (URISyntaxException ex) {

					Logger.getLogger(Menu.class.getName()).log(Level.SEVERE,
							null, ex);

				}

			}

		});

		clement.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					URI uriMax = new URI(
							"http://www.facebook.com/clement.sorano");

					Desktop.getDesktop().browse(uriMax);

				} catch (IOException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				} catch (URISyntaxException ex) {

					Logger.getLogger(Menu.class.getName()).log(Level.SEVERE,
							null, ex);

				}

			}

		});

	}
}