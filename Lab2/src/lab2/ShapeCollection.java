package lab2;


import java.util.Comparator;

/******************************************************
 * Cours : LOG121 Session : A2013 Groupe : 01 Projet : Laboratoire #1
 * Étudiant(e)(s) : Maude Payette André-Philippe Boulet Hugo Desjardins-De
 * Libero Code(s) perm. : PAYM03549202 BOUA29058709 DESH29099109 Professeur :
 * Ghizlane El boussaidi Chargés de labo : Alvine Boaye Belle et Mathieu Battah
 * Nom du fichier : ShapeCollection.java Date créé : 2013-09-25 Date dern.
 * modif. 2013-10-01
 ******************************************************* 
 * Historique des modifications
 ******************************************************* 
 * 2013-09-25 Version initiale
 *******************************************************/

// import java.util.ArrayList;

public class ShapeCollection
{
	
	private FenetrePrincipale mainWindow = null;

	// private ArrayList<AbstractCustomShape> listShape = new
	// ArrayList<AbstractCustomShape>();
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
	
	
	/**
	 * Définir le récepteur de l'information reçue dans la communication avec le
	 * serveur
	 * 
	 * @param listener
	 *            sera alerté lors de l'appel de "firePropertyChanger" par le
	 *            SwingWorker
	 */
	public void setMainWindowListener(FenetrePrincipale listener)
	{
		this.mainWindow = listener;
	}
	
	
	
	
	// Inspiré de l'exercice 1 sur le patron Méthode template fait en classe
	public void sort( Comparator<AbstractCustomShape> comparator, int order ) {
		if (listShape.getSize() > 1) {
			
			ListeChaine list1 = this.listShape;
			
			ListeChaine list2 = new ListeChaine();

			for (int i = 0; i < list1.getSize(); ++i) {
				
				Object switchElement = null; // L'élément a placer dans la list
				
				for (int j = 0; j < list1.getSize(); ++j) {
					
					if (j != i) {
						// On regarde dans les éléments s'il y a en un qui est plus grand ou petit selon l'ordre	
						// et on trouve celui qui va à la place de i. (Le plus petit ou le plus grand dans ce qui reste)
						
						int compareID = comparator.compare( (AbstractCustomShape)list1.getItem(i), (AbstractCustomShape)list1.getItem(j) );
						System.out.println(compareID);
						
						// Si l'ordre est croissant et que j est plus petit que i (compareID == 1)
						if (order == 1 && compareID == 1) {
							
							if (switchElement == null) {
								switchElement = list1.getItem(j);
							}
							else {
								switchElement = determineSwitchElementCroissant(comparator, switchElement, list1.getItem(j));
							}					
							
							
						}
						// Si l'ordre est décroissant et que j est plus grand que i (compareID == -1)
						else if (order == 0 && compareID == -1) {
							
							if (switchElement == null) {
								switchElement = list1.getItem(j);
							}
							else {
								switchElement = determineSwitchElementDecroissant(comparator, switchElement, list1.getItem(j));
							}
							
						}
					}
										
				}
				
				if (switchElement != null) {
					list2.addItem(switchElement);
				}
				else {
					list2.addItem(list1.getItem(i));
				}
				
			}
			
			System.out.println("YAY");
			this.listShape = list2;
		}
		
		
		
		this.mainWindow.fireRepaintWindow();
	}
		
	private Object determineSwitchElementCroissant(Comparator<AbstractCustomShape> comparator, Object switchElement, Object itemJ) {
		int compareID = comparator.compare( (AbstractCustomShape)switchElement, (AbstractCustomShape)itemJ ); 
		
		// Si j est plus petit que switchElement (compareID == 1)
		if (compareID == 1) {
			
			return itemJ;
		}
		
		return switchElement;
	}
	
	private Object determineSwitchElementDecroissant(Comparator<AbstractCustomShape> comparator,Object switchElement, Object itemJ) {
		int compareID = comparator.compare( (AbstractCustomShape)switchElement, (AbstractCustomShape)itemJ );
		
		
		// Si j est plus grand que switchElement (compareID == -1)
		if (compareID == -1) {
			
			return itemJ;
		}
		
		return switchElement;
	}
}
