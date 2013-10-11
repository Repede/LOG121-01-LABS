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
 Nom du fichier : ShapeCollection.java
 Date cr�� : 2013-09-25
 Date dern. modif. 2013-10-01
 *******************************************************
 Historique des modifications
 *******************************************************
 2013-09-25 Version initiale
 *******************************************************/

//import java.util.ArrayList;

public class ShapeCollection
{

	//private ArrayList<AbstractCustomShape> listShape = new ArrayList<AbstractCustomShape>();
	private ListeChaine listShape = new ListeChaine();

	/**
	 * Ajouter une forme � la liste partir du message r�cup�r� du serveur.
	 * 
	 * @params message Le message re�u du server. Utiliser la classe
	 *         MessageDecoder pour le d�cortiquer
	 * 
	 */
	public void addNewShape(String message)
	{

		// Cr�er la forme par la factory
		AbstractCustomShape newShape = ShapeFactory
				.createShapeByMessage(message);

		listShape.addItem(newShape);

		if (listShape.getSize() > 10)
		{
			listShape.removeItem(0);
		}
	}

	/**
	 * R�cup�rer la liste des formes ajout�s � la collection.
	 * 
	 * @return ArrayList<CustomShape> La liste contenant les CustomShape
	 */
	public ListeChaine getShapes()
	{
		return this.listShape;
	}
}
