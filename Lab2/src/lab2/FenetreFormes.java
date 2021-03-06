package lab2;

/******************************************************
 Cours:  LOG121
 Projet: Squelette du laboratoire #1
 Nom du fichier: FenetreFormes.java
 Date cr��: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
 2013-05-03 Version initiale
 *******************************************************/

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * Cette fen�tre g�re l'affichage des formes
 * 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent
{

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension DIMENSION = new Dimension(500, 500);

	private ShapeCollection shapes;

	/**
	 * Constructeur
	 */
	public FenetreFormes()
	{
		// ...
	}

	/*
	 * Affiche la liste de formes
	 */
	@Override
	public void paintComponent(Graphics pGraphic)
	{
		try
		{
			ListeChaine listShape = shapes.getShapes();
			// ArrayList<AbstractCustomShape> listShape = shapes.getShapes();

			for (int i = 0; i < listShape.getSize(); i++)
			{
				AbstractCustomShape shape = (AbstractCustomShape) listShape
						.getItem(i);
				shape.draw(pGraphic, 40 * i, 40 * i);
			}
		} catch (Exception e)
		{
			System.err.println("A component could not be paint.");
		}
	}

	public void addCollection(ShapeCollection shapes)
	{
		this.shapes = shapes;
	}

	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver l'espace
	 * nécessaire à son affichage
	 */
	@Override
	public Dimension getPreferredSize()
	{
		return DIMENSION;
	}
}
