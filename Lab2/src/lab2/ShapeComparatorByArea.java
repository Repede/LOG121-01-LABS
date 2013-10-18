
package lab2;

import java.util.Comparator;

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
Nom du fichier : CustomShape.java
Date cr�� : 2013-10-17
Date dern. modif. 2013-10-17
 *******************************************************
Historique des modifications
 *******************************************************
2013-10-17 Version initiale (et1)
 *******************************************************/

/**
 * @author Maude
 *
 */
public class ShapeComparatorByArea implements Comparator<AbstractCustomShape> {

	/*
	CODE EMPRUNT� :
	Les lignes suivantes ont �t� inspir�es par l'exemple sur Comparator du chapitre 4 du livre de Horstmann.
	L'exemple a �t� trouv� sur le site ci-dessous dans un fichier zip que j'ai t�l�charg�.
	http://www.horstmann.com/design_and_patterns.html
	*/
	@Override
	public int compare(AbstractCustomShape shape1, AbstractCustomShape shape2) {
		
		 return shape1.compareByArea(shape2);
		
	}

}
