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
 Nom du fichier : ShapeCollection.java
 Date créé : 2013-09-25
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
	 * Ajouter une forme à la liste partir du message récupéré du serveur.
	 * 
	 * @params message Le message reçu du server. Utiliser la classe
	 *         MessageDecoder pour le décortiquer
	 * 
	 */
	public void addNewShape(String message)
	{

		// Créer la forme par la factory
		AbstractCustomShape newShape = ShapeFactory
				.createShapeByMessage(message);

		listShape.addItem(newShape);

		if (listShape.getSize() > 10)
		{
			listShape.removeItem(0);
		}
	}

	/**
	 * Récupérer la liste des formes ajoutés à la collection.
	 * 
	 * @return ArrayList<CustomShape> La liste contenant les CustomShape
	 */
	public ListeChaine getShapes()
	{
		return this.listShape;
	}
}
