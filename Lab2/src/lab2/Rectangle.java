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
Nom du fichier : Rectangle.java
Date créé : 2013-09-20
Date dern. modif. 2013-09-25
 *******************************************************
Historique des modifications
 *******************************************************
2013-09-20 Version initiale
2013-09-25 Ajout de la fonction qui décode les paramètres
 *******************************************************/

import java.awt.Graphics;
import java.awt.Color;

/**
 * @author Maude
 * 
 */
public class Rectangle extends AbstractCustomShape
{

	private int firstX;
	private int firstY;
	private int secondX;
	private int secondY;
	private int width;
	private int height;

	/**
	 * Constructeur de la classe
	 * 
	 * @param sequenceNumber
	 *            Est le numéro de séquence reçu
	 * @param parametres
	 *            Est la chaine de caractères qui contient les paramètres de la
	 *            forme
	 */
	public Rectangle(int sequenceNumber, String parametres)
	{

		super(sequenceNumber, Color.red);

		decoderParametres(parametres);

	}

	/**
	 * Constructeur de la classe Sert pour l'héritage
	 * 
	 * @param sequenceNumber
	 *            Est le numéro de séquence reçu
	 * @param color
	 *            Est la couleur de la forme
	 */
	protected Rectangle(int sequenceNumber, Color color)
	{

		super(sequenceNumber, color);

		// decoderParametres(parametres);

	}

	/**
	 * Trouve les paramètres et les associe
	 */
	@Override
	protected void decoderParametres(String parametres)
	{
		// Décoder la string de paramètres pour trouver le x, le y, la hauteur
		// et la largeur

		String str[] = parametres.split(" ");

		try
		{
			// Sauvegarde les x et les y
			setFirstX(Integer.parseInt(str[0]));
			setFirstY(Integer.parseInt(str[1]));
			setSecondX(Integer.parseInt(str[2]));
			setSecondY(Integer.parseInt(str[3]));

			// Trouver la largeur : x2 - x1
			setWidth(Math.abs(getSecondX() - getFirstX()));

			// Trouver la hauteur : y2 - y1
			setHeight(Math.abs(getSecondY() - getFirstY()));
		} catch (Exception e)
		{
			// Afficher exception
			e.printStackTrace();
		}

	}

	/**
	 * @return the firstX
	 */
	public int getFirstX()
	{
		return firstX;
	}

	/**
	 * @param firstX
	 *            the firstX to set
	 */
	public void setFirstX(int firstX)
	{
		this.firstX = firstX;
	}

	/**
	 * @return the firstY
	 */
	public int getFirstY()
	{
		return firstY;
	}

	/**
	 * @param firstY
	 *            the firstY to set
	 */
	public void setFirstY(int firstY)
	{
		this.firstY = firstY;
	}

	/**
	 * @return the secondX
	 */
	public int getSecondX()
	{
		return secondX;
	}

	/**
	 * @param secondX
	 *            the secondX to set
	 */
	public void setSecondX(int secondX)
	{
		this.secondX = secondX;
	}

	/**
	 * @return the secondY
	 */
	public int getSecondY()
	{
		return secondY;
	}

	/**
	 * @param secondY
	 *            the secondY to set
	 */
	public void setSecondY(int secondY)
	{
		this.secondY = secondY;
	}

	/**
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height)
	{
		this.height = height;
	}

	/**
	 * Fonction qui dessine la forme
	 * 
	 * @param pGraphic
	 *            Objet graphique qui est utilisé pour dessiner
	 */
	@Override
	public void draw(Graphics pGraphic)
	{
		pGraphic.setColor(this.color);
		pGraphic.fillRect(getFirstX(), getFirstY(), getWidth(), getHeight());
	}

}
