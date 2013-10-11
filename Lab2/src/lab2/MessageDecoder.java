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
Nom du fichier : MessageDecoder.java
Date cr�� : 2013-09-25
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
	 *            Le message que l'instance permettra de d�coder
	 */
	public MessageDecoder(String message)
	{
		this.message = message;
	}

	/**
	 * R�cup�rer la partie "num�ro de s�quence" du message instanci�
	 * 
	 * @return String Contient le num�ro de s�quence de la cha�ne initialis�e
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
	 * R�cup�rer la partie "Type de forme" du message instanci�
	 * 
	 * @return String Contient le type de forme de la cha�ne initialis�e
	 */
	public String findShapeType()
	{

		Pattern pattern = Pattern.compile("<(.+?)>");
		Matcher matcher = pattern.matcher(message);
		matcher.find();

		return matcher.group(1).trim();
	}

	/**
	 * R�cup�rer la partie "liste des param�tres" du message instanci�
	 * 
	 * @return String Contient la section des param�tres de la cha�ne
	 *         initialis�e
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
	 * R�cup�rer la partie "DNS du serveur" du message instanci�
	 * 
	 * @return String Contient le nom du serveur de la cha�ne initialis�e
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
	 * R�cup�rer la partie "port" du message instanci�
	 * 
	 * @return String Contient le num�ro de port de la cha�ne initialis�e
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
