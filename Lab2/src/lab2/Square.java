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
 Nom du fichier : Square.java
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
public class Square extends Rectangle
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
	public Square(int sequenceNumber, String parametres)
	{

		super(sequenceNumber, Color.green);

		decoderParametres(parametres);

	}

}
