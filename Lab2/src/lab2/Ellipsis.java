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
 Nom du fichier : Oval.java
 Date créé : 2013-09-25
 Date dern. modif. 2013-09-25
 *******************************************************
 Historique des modifications
 *******************************************************
 2013-09-25 Version initiale
 *******************************************************/

import java.awt.Graphics;
import java.awt.Color;

/**
 * @author Maude
 * 
 */
public class Ellipsis extends AbstractCustomShape
{

	private int centerX;
	private int centerY;
	private int rayonH; // Rayon horizontal
	private int rayonV; // Rayon vertical

	/**
	 * Constructeur de la classe
	 * 
	 * @param sequenceNumber
	 *            Est le numéro de séquence reçu
	 * @param parametres
	 *            Est la chaine de caractères qui contient les paramètres de la
	 *            forme
	 */
	public Ellipsis(int sequenceNumber, String parametres)
	{

		super(sequenceNumber, Color.yellow);

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
	protected Ellipsis(int sequenceNumber, Color color)
	{

		super(sequenceNumber, color);

		// decoderParametres(parametres);

	}

	/**
	 * Trouve les paramètres et les associe
	 * 
	 * @param parametres
	 *            Est la chaine de caractères qui contient les paramètres de la
	 *            forme.
	 */
	@Override
	protected void decoderParametres(String parametres)
	{
		// Décoder la string de paramÃ¨tres pour trouver le x, le y, la hauteur
		// et la largeur

		String str[] = parametres.split(" ");

		try
		{
			// Sauvegarde les x et les y + rayon
			setCenterX(Integer.parseInt(str[0]));
			setCenterY(Integer.parseInt(str[1]));
			setRayonH(Integer.parseInt(str[2]));
			setRayonV(Integer.parseInt(str[3]));

		} catch (Exception e)
		{
			// Afficher exception
			e.printStackTrace();
		}
	}

	/**
	 * @return the centerX
	 */
	public int getCenterX()
	{
		return centerX;
	}

	/**
	 * @param centerX
	 *            the centerX to set
	 */
	public void setCenterX(int centerX)
	{
		this.centerX = centerX;
	}

	/**
	 * @return the centerY
	 */
	public int getCenterY()
	{
		return centerY;
	}

	/**
	 * @param centerY
	 *            the centerY to set
	 */
	public void setCenterY(int centerY)
	{
		this.centerY = centerY;
	}

	/**
	 * @return the rayonH
	 */
	public int getRayonH()
	{
		return rayonH;
	}

	/**
	 * @param rayonH
	 *            the rayonH to set
	 */
	public void setRayonH(int rayonH)
	{
		this.rayonH = rayonH;
	}

	/**
	 * @return the rayonV
	 */
	public int getRayonV()
	{
		return rayonV;
	}

	/**
	 * @param rayonV
	 *            the rayonV to set
	 */
	public void setRayonV(int rayonV)
	{
		this.rayonV = rayonV;
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

		// Pour le centre, il faut déduire le rayon, car la fonction drawOval
		// reÃ§oit le coin supérieur gauche pour dessiner.
		pGraphic.fillOval(getCenterX() - getRayonH(), getCenterY()
				- getRayonV(), getRayonH() * 2, getRayonV() * 2);
	}

}
