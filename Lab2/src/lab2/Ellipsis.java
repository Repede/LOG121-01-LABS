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
 Nom du fichier : Oval.java
 Date cr�� : 2013-09-25
 Date dern. modif. 2013-09-25
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
public class Ellipsis extends AbstractCustomShape {
	
	protected int rayonH;	// Rayon horizontal
	protected int rayonV; // Rayon vertical

	
	/**
	 * Constructeur de la classe
	 * 
	 * @param sequenceNumber Est le num�ro de s�quence re�u
	 * @param parametres Est la chaine de caract�res qui contient les param�tres de la forme
	 */
	public Ellipsis(int sequenceNumber, String parametres) {
		
		super(sequenceNumber, Color.yellow);
		
		decoderParametres(parametres);
		
	}
	
	/**
	 * Constructeur de la classe
	 * Sert pour l'h�ritage
	 * 
	 * @param sequenceNumber Est le num�ro de s�quence re�u
	 * @param color Est la couleur de la forme
	 */
	protected Ellipsis(int sequenceNumber, Color color) {
		
		super(sequenceNumber, color);
		
		//decoderParametres(parametres);
		
	}
	
	/**
	 * Trouve les param�tres et les associe
	 * 
	 * @param parametres Est la chaine de caract�res qui contient les param�tres de la forme.
	 */
	protected void decoderParametres(String parametres) {
		// D�coder la string de paramètres pour trouver le x, le y, la hauteur et la largeur
		
		String str[] = parametres.split(" ");
		
		try {			
			// Sauvegarde les x et les y + rayon
			setFirstX(Integer.parseInt(str[0]));
			setFirstY(Integer.parseInt(str[1]));
			setRayonH(Integer.parseInt(str[2]));
			setRayonV(Integer.parseInt(str[3]));
		
		}
		catch(Exception e) {
			// Afficher exception
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Fonction qui dessine la forme 
	 * 
	 * @param pGraphic Objet graphique qui est utilis� pour dessiner
	 */
	public void draw(Graphics pGraphic, int drawX, int drawY) {
		drawRectangle(pGraphic);
		
		pGraphic.setColor(this.color);
		
		// Pour le centre, il faut d�duire le rayon, car la fonction drawOval reçoit le coin sup�rieur gauche pour dessiner. 
		pGraphic.fillOval(drawX, drawY, getRayonH() * 2, getRayonV() * 2);
	}
	
	/**
	 * Fonction qui dessine le contour rectangle de la forme 
	 * 
	 * @param pGraphic Objet graphique qui est utilis� pour dessiner
	 */
	protected void drawRectangle(Graphics pGraphic) {
		pGraphic.setColor(Color.gray);
		pGraphic.drawRect(getFirstX() - getRayonH() - 1, getFirstY() - getRayonV() - 1, getWidth() + 1, getHeight() + 1);
	}
	
	
	/**
	 * @return the rayonH
	 */
	public int getRayonH() {
		return rayonH;
	}

	/**
	 * @param rayonH the rayonH to set
	 */
	public void setRayonH(int rayonH) {
		this.rayonH = rayonH;
	}

	/**
	 * @return the rayonV
	 */
	public int getRayonV() {
		return rayonV;
	}

	/**
	 * @param rayonV the rayonV to set
	 */
	public void setRayonV(int rayonV) {
		this.rayonV = rayonV;
	}
	
	
	/**
	 * @param area the area to set
	 */
	protected void setArea() {
		this.area = Math.PI * this.rayonV * this.rayonH;
	}


	/**
	 * @param maxRange the maxRange to set
	 */
	protected void setMaxRange() {
		if (this.rayonH * 2 > this.rayonV * 2) {
			this.maxRange = this.rayonH;
		}
		else {
			this.maxRange = this.rayonV;
		}
	}


	/**
	 * @param width the width to set
	 */
	protected void setWidth(int width) {
		this.width = this.rayonH * 2;
	}


	/**
	 * @param height the height to set
	 */
	protected void setHeight(int height) {
		this.height = this.rayonV * 2;
	}


}
