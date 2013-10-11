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
Nom du fichier : MessageDecoder.java
Date créé : 2013-09-25
Date dern. modif. 2013-01-10
 *******************************************************
Historique des modifications
 *******************************************************
2013-09-25 Version initiale
 *******************************************************/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecoder
{

	private String message;

	/**
	 * constructeur
	 * 
	 * @param message
	 *            Le message que l'instance permettra de décoder
	 */
	public MessageDecoder(String message)
	{
		this.message = message;
	}

	/**
	 * Récupérer la partie "numéro de séquence" du message instancié
	 * 
	 * @return String Contient le numéro de séquence de la chaîne initialisée
	 */
	public String findSequentialNumber()
	{

		Pattern pattern = Pattern.compile("(.+?)<");
		Matcher matcher = pattern.matcher(message);
		matcher.find();
		String output = matcher.group(1);
		return output.trim();
	}

	/**
	 * Récupérer la partie "Type de forme" du message instancié
	 * 
	 * @return String Contient le type de forme de la chaîne initialisée
	 */
	public String findShapeType()
	{

		Pattern pattern = Pattern.compile("<(.+?)>");
		Matcher matcher = pattern.matcher(message);
		matcher.find();

		return matcher.group(1).trim();
	}

	/**
	 * Récupérer la partie "liste des paramètres" du message instancié
	 * 
	 * @return String Contient la section des paramètres de la chaîne
	 *         initialisée
	 */
	public String findShapeParameters()
	{

		String theTag = this.findShapeType();

		Pattern pattern = Pattern.compile("<" + theTag + ">(.+?)</" + theTag
				+ ">");
		Matcher matcher = pattern.matcher(message);
		matcher.find();

		return matcher.group(1).trim();
	}

	/**
	 * Récupérer la partie "DNS du serveur" du message instancié
	 * 
	 * @return String Contient le nom du serveur de la chaîne initialisée
	 */
	public String getServerName()
	{
		Pattern pattern = Pattern.compile("(.+?):");
		Matcher matcher = pattern.matcher(message);
		matcher.find();

		String output = "";
		try
		{
			output = matcher.group(1).trim();
		} catch (Exception e)
		{
		}

		return output;
	}

	/**
	 * Récupérer la partie "port" du message instancié
	 * 
	 * @return String Contient le numéro de port de la chaîne initialisée
	 */
	public int getServerPort()
	{
		Pattern pattern = Pattern.compile(":([0-9]+)");
		Matcher matcher = pattern.matcher(message);
		matcher.find();

		int output = 0;

		try
		{
			String name = matcher.group(0);
			name = name.substring(1, name.length());
			output = Integer.parseInt(name.trim());
		} catch (Exception e)
		{
		}

		// Validation sur le range du port....
		if (output < 0 || output > 65555)
		{
			output = 0;
		}

		return output;
	}
}
