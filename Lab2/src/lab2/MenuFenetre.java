package lab2;

/******************************************************
 Cours:  LOG121
 Projet: Squelette du laboratoire #1
 Nom du fichier: MenuFenetre.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
 2013-05-03 Version initiale
 *******************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * Crée le menu de la fenÃªtre de l'applicationé
 */
public class MenuFenetre extends JMenuBar
{

	private static final long serialVersionUID = 1536336192561843187L;
	private static final String MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_ORDRE_TITRE = "app.frame.menus.order.title",
			MENU_DESSIN_TITRE = "app.frame.menus.draw.title",
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about";
	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";

	public static final int DELAI_QUITTER_MSEC = 200;
	
	private JMenuItem demarrerMenuItem;
	private JMenuItem quitterMenuItem;

	CommBase comm; // Pour activer/désactiver la communication avec le serveur

	/**
	 * Constructeur
	 */
	public MenuFenetre(CommBase comm)
	{
		this.comm = comm;
		addMenuFichier();
		addMenuOrdre();
		addMenuAide();
	}

	/**
	 * Créer le menu "Draw".
	 */
	protected void addMenuOrdre()
	{
		/******************
		 * MenuObtenirFormes (Démarrage ici)
		 ******************/

		//JMenu menu = creerMenu(MENU_ORDRE_TITRE,
				//new String[] { "" });
		
		// par numéro de séquence croissant 
		
		
		
		// par numéro de séquence décroissant
		// par aire de forme croissante
		// par aire de forme décroissante
		// par type de forme dans l'ordre suivant : carré, rectangle, cercle, ovale, ligne
		// par type de forme dans l'ordre inverse : ligne, ovale, cercle, rectangle, carré
		// par distance (croissante) maximale entre deux points de la forme,
		

		//add(menu);
	}

	/**
	 * Créer le menu "File".
	 */
	protected void addMenuFichier()
	{
		MenuObtenirFormes obtForme = new MenuObtenirFormes();
		MenuQuitter quit = new MenuQuitter();
		
		JMenu menu = creerMenu(MENU_FICHIER_TITRE,
				new String[] { obtForme.title, quit.title,  });
		
		demarrerMenuItem = menu.getItem(0);
		obtForme.addListener(demarrerMenuItem, this);
		demarrerMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				obtForme.keystroke, obtForme.actionEvent));
		
		
		/*
		 * Quitter
		 */
		
		quitterMenuItem = menu.getItem(1);
		quit.addListener(quitterMenuItem, this);

		menu.getItem(1).setAccelerator(KeyStroke.getKeyStroke(quit.keystroke,
						quit.actionEvent));

		add(menu);
	}

	/**
	 * Créer le menu "Help".
	 */
	private void addMenuAide()
	{
		JMenu menu = creerMenu(MENU_AIDE_TITRE,
				new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null,
						LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS),
						LangueConfig.getResource(MENU_AIDE_PROPOS),
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}

	/**
	 * Activer ou désactiver les items du menu selon la sélection.
	 */
	public void rafraichirMenus()
	{
		demarrerMenuItem.setEnabled(!comm.isActif());
	}

	/**
	 * Créer un élément de menu à partir d'un champs principal et ses éléments
	 * 
	 * @param titleKey
	 *            champs principal
	 * @param itemKeys
	 *            éléments
	 * @return le menu
	 */
	private static JMenu creerMenu(String titleKey, String[] itemKeys)
	{
		JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
		for (int i = 0; i < itemKeys.length; ++i)
		{
			menu.add(new JMenuItem(LangueConfig.getResource(itemKeys[i])));
		}
		return menu;
	}
}
