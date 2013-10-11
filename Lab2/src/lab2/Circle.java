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
Date créé : 2013-09-25
Date dern. modif. 2013-09-25
 *******************************************************
Historique des modifications
 *******************************************************
2013-09-25 Version initiale
 *******************************************************/

import java.awt.Color;

/**
 * @author Maude
 * 
 */
public class Circle extends Ellipsis
{

	/**
	 * Constructeur de la classe
	 * 
	 * @param sequenceNumber
	 *            Est le numéro de séquence reçu
	 * @param parametres
	 *            Est la chaine de caractères qui contient les paramètres de la
	 *            forme
	 */
	public Circle(int sequenceNumber, String parametres)
	{

		super(sequenceNumber, Color.cyan);

		decoderParametres(parametres);

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

		// Décoder la string de paramètres pour trouver le x, le y, la hauteur
		// et la largeur
		String str[] = parametres.split(" ");

		try
		{
			// Sauvegarde les x et les y + rayon
			setCenterX(Integer.parseInt(str[0]));
			setCenterY(Integer.parseInt(str[1]));
			setRayonH(Integer.parseInt(str[2]));
			setRayonV(Integer.parseInt(str[2]));
		} catch (Exception e)
		{
			// Afficher exception
			e.printStackTrace();
		}
	}

}
