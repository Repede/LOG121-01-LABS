package lab2;
/******************************************************
Cours : LOG121
Session : A2013
Groupe : 01
Projet : Laboratoire #1
Étudiant(e)(s) : Maude Payette
André-Philippe Boulet
Hugo Desjardins-De Libero
Code(s) perm. : PAYM03549202
BOUA29058709
DESH29099109
Professeur : Ghizlane El boussaidi
Chargés de labo : Alvine Boaye Belle et Mathieu Battah
Nom du fichier : CustomShape.java
Date créé : 2013-09-20
Date dern. modif. 2013-09-20
 *******************************************************
Historique des modifications
 *******************************************************
2013-09-20 Version initiale (et1)
 *******************************************************/

import java.awt.Graphics;
import java.awt.Color;

/**
 * @author Maude
 * 
 */
public abstract class AbstractCustomShape
{

	private int sequenceNumber;
	protected Color color;

	/**
	 * Constructeur de la classe
	 * 
	 * @param sequenceNumber
	 *            : numéro de séquence de la forme
	 * @param color
	 *            : couleur de la forme
	 */
	public AbstractCustomShape(int sequenceNumber, Color color)
	{
		setSequenceNumber(sequenceNumber);
		setColor(color);
	}

	/**
	 * @return the sequenceNumber
	 */
	public int getSequenceNumber()
	{
		return sequenceNumber;
	}

	/**
	 * @param sequenceNumber
	 *            the sequenceNumber to set
	 */
	public void setSequenceNumber(int sequenceNumber)
	{
		this.sequenceNumber = sequenceNumber;
	}

	/**
	 * @return the color
	 */
	public Color getColor()
	{
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Color color)
	{
		this.color = color;
	}

	/**
	 * Fonction qui dessine la forme
	 */
	public abstract void draw(Graphics pGraphic);

	protected abstract void decoderParametres(String parametres);

}
