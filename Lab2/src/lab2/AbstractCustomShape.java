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
Nom du fichier : CustomShape.java
Date cr�� : 2013-09-20
Date dern. modif. 2013-10-17
 *******************************************************
Historique des modifications
 *******************************************************
2013-09-20 Version initiale (et1)
 *******************************************************/

import java.awt.Graphics;
import java.awt.Color;

/**
 * @author Maude
 *
 */
public abstract class AbstractCustomShape {
	
	private int sequenceNumber;
	protected Color color;
	protected int firstX;
	protected int firstY;
	protected double area;
	protected double maxRange;
	protected int defaultOrder;
	protected int width;
	protected int height;
	
	/**
	 * Constructeur de la classe
	 * @param sequenceNumber : num�ro de s�quence de la forme
	 * @param color : couleur de la forme
	 */
	public AbstractCustomShape(int sequenceNumber, Color color) {
		setSequenceNumber(sequenceNumber);
		setColor(color);
	}
	
	
	
	// Fonctions
	
	/**/
	
	/**
	 * Fonction qui dessine la forme 
	 * 
	 * @param pGraphic Objet graphique qui est utilis� pour dessiner
	 */
	public abstract void draw(Graphics pGraphic, int drawX, int drawY);
	
	/**
	 * Fonction qui dessine le contour rectangle de la forme 
	 * 
	 * @param pGraphic Objet graphique qui est utilis� pour dessiner
	 */
	protected abstract void drawRectangle(Graphics pGraphic);
	
	protected abstract void decoderParametres(String parametres);
	
	
	
	// Getters & Setters
	
	/**
	 * @return the sequenceNumber
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * @param sequenceNumber the sequenceNumber to set
	 */
	protected void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	protected void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * @return the firstX
	 */	
	public int getFirstX() {
		return firstX;
	}

	/**
	 * @param firstX the firstX to set
	 */
	protected void setFirstX(int firstX) {
		this.firstX = firstX;
	}

	/**
	 * @return the firstY
	 */
	public int getFirstY() {
		return firstY;
	}

	/**
	 * @param firstY the firstY to set
	 */
	protected void setFirstY(int firstY) {
		this.firstY = firstY;
	}



	/**
	 * @return the area
	 */
	public double getArea() {
		return area;
	}



	/**
	 * @param area the area to set
	 */
	protected abstract void setArea();



	/**
	 * @return the maxRange
	 */
	public double getMaxRange() {
		return maxRange;
	}



	/**
	 * @param maxRange the maxRange to set
	 */
	protected abstract void setMaxRange();



	/**
	 * @return the defaultOrder
	 */
	public int getDefaultOrder() {
		return defaultOrder;
	}



	/**
	 * @param defaultOrder the defaultOrder to set
	 */
	protected void setDefaultOrder(int defaultOrder) {
		this.defaultOrder = defaultOrder;
	}



	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}



	/**
	 * @param width the width to set
	 */
	protected abstract void setWidth(int width);



	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}



	/**
	 * @param height the height to set
	 */
	protected abstract void setHeight(int height);

	
	/*
	CODE EMPRUNT� :
	Les fonctions suivantes ont �t� inspir�es par l'exemple sur le Comparator dans le chapitre 4 du livre de Horstmann.
	L'exemple a �t� trouv� sur le site ci-dessous dans un fichier zip que j'ai t�l�charg�.
	http://www.horstmann.com/design_and_patterns.html
	*/
	
	/**
	 * Compare les num�ros de s�quence
	 * 
	 * @param shape La forme a compar�e
	 */
	public int compareBySequenceNumber(AbstractCustomShape shape){
		if (sequenceNumber < shape.sequenceNumber) return -1;
	    if (sequenceNumber > shape.sequenceNumber) return 1;
	    return 0;
	}
	
	/**
	 * Compare l'aire
	 * 
	 * @param shape La forme a compar�e
	 */
	public int compareByArea(AbstractCustomShape shape){
		if (area < shape.area) return -1;
	    if (area > shape.area) return 1;
	    return 0;
	}
	
	/**
	 * Compare la distance entre 2 points
	 * 
	 * @param shape La forme a compar�e
	 */
	public int compareByMaxRange(AbstractCustomShape shape){
		if (maxRange < shape.maxRange) return -1;
	    if (maxRange > shape.maxRange) return 1;
	    return 0;
	}
	
	/**
	 * Compare l'ordre par d�faut
	 * 
	 * @param shape La forme a compar�e
	 */
	public int compareByDefaultOrder(AbstractCustomShape shape){
		if (defaultOrder < shape.defaultOrder) return -1;
	    if (defaultOrder > shape.defaultOrder) return 1;
	    return 0;
	}
	
	/**
	 * Compare la largeur
	 * 
	 * @param shape La forme a compar�e
	 */
	public int compareByWidth(AbstractCustomShape shape){
		if (width < shape.width) return -1;
	    if (width > shape.width) return 1;
	    return 0;
	}
	
	/**
	 * Compare la hauteur
	 * 
	 * @param shape La forme a compar�e
	 */
	public int compareByHeight(AbstractCustomShape shape){
		if (height < shape.height) return -1;
	    if (height > shape.height) return 1;
	    return 0;
	}
	
}
