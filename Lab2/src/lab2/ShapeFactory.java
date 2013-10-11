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
 Nom du fichier : ShapeFactory.java
 Date créé : 2013-09-25
 Date dern. modif. 2013-10-01
 *******************************************************
 Historique des modifications
 *******************************************************
 2013-09-25 Version initiale
 *******************************************************/

import ca.etsmtl.log.util.IDLogger;

public class ShapeFactory
{

	/**
	 * Fonction "usine statique" pour unifier l'endroit où on initialise les
	 * objets de type "CustomShape"
	 * 
	 * @todo: étudier le factory method pour en améliorer l'implémentation
	 * 
	 * @param message
	 *            Un message contenant le numéro de séquence, le type de forme
	 *            ainsi que les paramères pour la dessiner
	 * @return CustomShape L'instance de la forme créée
	 */
	static public AbstractCustomShape createShapeByMessage(String message)
	{

		IDLogger logger = IDLogger.getInstance(); // MŽthode statique
		AbstractCustomShape newShape = null;

		MessageDecoder decoder = new MessageDecoder(message);

		String type = decoder.findShapeType();
		int noSequence = Integer.parseInt(decoder.findSequentialNumber());
		String args = decoder.findShapeParameters();

		// le id Žtant un int reprŽsentant le numŽro de sŽquence re�u
		logger.logID(noSequence);

		System.out.println(message);

		// @todo: ici on devra améliorer....
		if (type.equals("OVALE"))
		{
			newShape = new Ellipsis(noSequence, args);
		} else if (type.equals("RECTANGLE"))
		{
			newShape = new Rectangle(noSequence, args);
		} else if (type.equals("LIGNE"))
		{
			newShape = new StraightLine(noSequence, args);
		} else if (type.equals("CARRE"))
		{
			newShape = new Square(noSequence, args);
		} else if (type.equals("CERCLE"))
		{
			newShape = new Circle(noSequence, args);
		}

		return newShape;
	}
}
