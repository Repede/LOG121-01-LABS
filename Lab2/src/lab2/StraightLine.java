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
 Nom du fichier : Line.java
 Date créé : 2013-09-25
 Date dern. modif. 2013-10-17
 *******************************************************
 Historique des modifications
 *******************************************************
 2013-09-25 Version initiale
 *******************************************************/

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * @author Maude
 * 
 */
public class StraightLine extends AbstractCustomShape
{

	private int secondX;
	private int secondY;

	/**
	 * Constructeur de la classe
	 * 
	 * @param sequenceNumber
	 *            Est le numéro de séquence reçu
	 * @param parametres
	 *            Est la chaine de caractères qui contient les paramètres de la
	 *            forme
	 */
	public StraightLine(int sequenceNumber, String parametres)
	{

		super(sequenceNumber, Color.black);

		decoderParametres(parametres);

	}

	/**
	 * Trouve les paramètres et les associe
	 * 
	 * @param parametres
	 *            Est la chaine de caractères qui contient les paramètres de la
	 *            forme.
	 */
	protected void decoderParametres(String parametres)
	{
		// Décoder la string de paramètres pour trouver le x, le y, la hauteur
		// et la largeur

		String str[] = parametres.split(" ");

		// Sauvegarde les x et les y
		try
		{
			setFirstX(Integer.parseInt(str[0]));
			setFirstY(Integer.parseInt(str[1]));
			setSecondX(Integer.parseInt(str[2]));
			setSecondY(Integer.parseInt(str[3]));
		} catch (Exception e)
		{
			// Afficher exception
			e.printStackTrace();
		}

	}

	/**
	 * Fonction qui dessine la forme
	 * 
	 * @param pGraphic
	 *            Objet graphique qui est utilisé pour dessiner
	 */
	public void draw(Graphics pGraphic, int drawX, int drawY)
	{
		drawRectangle(pGraphic, drawX, drawY);
		pGraphic.setColor(this.color);
		Graphics2D test = (Graphics2D)pGraphic;
		test.setStroke(new BasicStroke(BasicStroke.CAP_BUTT));
		pGraphic.drawLine(drawX, drawY, getSecondX()+(drawX-getFirstX()), getSecondY()+(drawY-getFirstY()));
	}

	/**
	 * Fonction qui dessine le contour rectangle de la forme
	 * 
	 * @param pGraphic
	 *            Objet graphique qui est utilisé pour dessiner
	 */
	protected void drawRectangle(Graphics pGraphic, int drawX, int drawY)
	{
		// A terminer
		pGraphic.setColor(Color.black);
		Graphics2D test = (Graphics2D)pGraphic;
		
		test.setStroke( new BasicStroke(1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[] {3f}, 0f));
		
		pGraphic.drawRect(drawX - 1, drawY - 1, getSecondX()-getFirstX() +1,  getSecondY()-getFirstY() +1);
		/*if(getSecondX()-getFirstX() >= 0 && getSecondY()-getFirstY() >= 0)
		{
			pGraphic.drawRect(drawX - 1, drawY - 1, getSecondX()-getFirstX() +1,  getSecondY()-getFirstY() +1);
		}
		if(getSecondX()-getFirstX() <= 0 && getSecondY()-getFirstY() >= 0)
		{
			pGraphic.drawRect(getSecondX()+(drawX-getFirstX()) - 1, drawY - 1, drawX,  getSecondY()-getFirstY() +1);
		}*/
	}

	// Getters & Setters//

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
	 * @param area
	 *            the area to set
	 */
	protected void setArea()
	{
		this.area = this.width * this.height;
	}

	/**
	 * @param maxRange
	 *            the maxRange to set
	 */
	protected void setMaxRange()
	{
		this.maxRange = Math.sqrt(Math.pow(this.secondX - this.firstX, 2)
				+ Math.pow(this.secondY - this.firstY, 2));
	}

	/**
	 * @param width
	 *            the width to set
	 */
	protected void setWidth(int width)
	{
		this.width = width;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	protected void setHeight(int height)
	{
		this.height = 1;
	}

}
