package lab2;
/******************************************************
Cours : LOG121
Session : A2013
Groupe : 01
Projet : Laboratoire #1
�tudiant(e)(s) : Maude Payette
Andr�-Philippe Boulet
Hugo Desjardins-De Libero
Code(s) perm. : PAYM03549202
BOUA29058709
DESH29099109
Professeur : Ghizlane El boussaidi
Charg�s de labo : Alvine Boaye Belle et Mathieu Battah
Nom du fichier : Rectangle.java
Date cr�� : 2013-09-25
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
	 *            Est le num�ro de s�quence re�u
	 * @param parametres
	 *            Est la chaine de caract�res qui contient les param�tres de la
	 *            forme
	 */
	public Circle(int sequenceNumber, String parametres)
	{

		super(sequenceNumber, Color.cyan);

		decoderParametres(parametres);

	}

	/**
	 * Trouve les param�tres et les associe
	 * 
	 * @param parametres
	 *            Est la chaine de caract�res qui contient les param�tres de la
	 *            forme.
	 */
	@Override
	protected void decoderParametres(String parametres)
	{

		// D�coder la string de param�tres pour trouver le x, le y, la hauteur
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
