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
 Nom du fichier : Line.java
 Date créé : 2013-09-25
 Date dern. modif. 2013-10-17
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
public class StraightLine extends AbstractCustomShape {
	
	private int secondX;
	private int secondY;

	
	/**
	 * Constructeur de la classe
	 * 
	 * @param sequenceNumber Est le numéro de séquence reçu
	 * @param parametres Est la chaine de caractères qui contient les paramètres de la forme
	 */
	public StraightLine(int sequenceNumber, String parametres) {
		
		super(sequenceNumber, Color.black);
		
		decoderParametres(parametres);
		
	}
	
	/**
	 * Trouve les paramètres et les associe
	 * 
	 * @param parametres Est la chaine de caractères qui contient les paramètres de la forme.
	 */
	protected void decoderParametres(String parametres) {
		// Décoder la string de paramètres pour trouver le x, le y, la hauteur et la largeur
		
		String str[] = parametres.split(" ");
		
		// Sauvegarde les x et les y
		try {
			setFirstX(Integer.parseInt(str[0]));
			setFirstY(Integer.parseInt(str[1]));
			setSecondX(Integer.parseInt(str[2]));
			setSecondY(Integer.parseInt(str[3]));
		}
		catch(Exception e) {
			// Afficher exception
			e.printStackTrace();
		}
		
	}

	
	/**
	 * Fonction qui dessine la forme 
	 * 
	 * @param pGraphic Objet graphique qui est utilisé pour dessiner
	 */
	public void draw(Graphics pGraphic, int drawX, int drawY) {
		drawRectangle(pGraphic);
		pGraphic.setColor(this.color);
		pGraphic.drawLine(drawX, drawY, getSecondX(), getSecondY());
	}
	
	/**
	 * Fonction qui dessine le contour rectangle de la forme 
	 * 
	 * @param pGraphic Objet graphique qui est utilisé pour dessiner
	 */
	protected void drawRectangle(Graphics pGraphic) {
				
		pGraphic.setColor(Color.black);
		pGraphic.drawRect(getFirstX()-1, getFirstY()-1, getWidth()+1, getHeight()+1);
	}
	
	
	// Getters & Setters
	
	
	/**
	 * @return the secondX
	 */
	public int getSecondX() {
		return secondX;
	}

	/**
	 * @param secondX the secondX to set
	 */
	public void setSecondX(int secondX) {
		this.secondX = secondX;
	}

	/**
	 * @return the secondY
	 */
	public int getSecondY() {
		return secondY;
	}

	/**
	 * @param secondY the secondY to set
	 */
	public void setSecondY(int secondY) {
		this.secondY = secondY;
	}
	
	
	/**
	 * @param area the area to set
	 */
	protected void setArea() {
		this.area = this.width * this.height;
	}


	/**
	 * @param maxRange the maxRange to set
	 */
	protected void setMaxRange() {
		this.maxRange = Math.sqrt( Math.pow(this.secondX - this.firstX, 2) + Math.pow(this.secondY - this.firstY, 2) );
	}


	/**
	 * @param width the width to set
	 */
	protected void setWidth(int width) {
		this.width = width;
	}


	/**
	 * @param height the height to set
	 */
	protected void setHeight(int height) {
		this.height = 1;
	}

}
