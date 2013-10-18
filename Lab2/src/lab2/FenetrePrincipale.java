package lab2;

/******************************************************
 Cours:  LOG121
 Projet: Squelette du laboratoire #1
 Nom du fichier: FenetrePrincipale.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
 2013-05-03 Version initiale
 *******************************************************/

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;

/**
 * Cette classe représente la fenêtre principale de l'application
 * 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener
{

	private static final long serialVersionUID = -1210804336046370508L;

	private ShapeCollection shapes = null;
	private FenetreFormes fenetreFormes;

	/**
	 * Constructeur
	 */
	public FenetrePrincipale(CommBase comm)
	{
		shapes = new ShapeCollection();
		shapes.setMainWindowListener(this);
		MenuFenetre menu = new MenuFenetre(comm, shapes);
		

		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH);

		fenetreFormes = new FenetreFormes();
		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenêtre de
		this.pack(); // Ajuste la dimension de la fenêtre principale selon celle
						// de ses composants
		this.setVisible(true); // Rend la fenêtre principale visible.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ... Ã  réviser
	}

	// Appelé lorsque le sujet lance "firePropertyChanger"
	@Override
	public void propertyChange(PropertyChangeEvent arg0)
	{

		try
		{
			String myMessage = (String) arg0.getNewValue();
			shapes.addNewShape(myMessage);
		} catch (Exception e)
		{
			// System.out.println("Cette forme n'est pas valide.");
		}

		fenetreFormes.addCollection(shapes);
		
		
		fireRepaintWindow();
	}
	
	public void fireRepaintWindow() 
	{
		this.repaint();
	}
}
