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
Nom du fichier : ServerCommunicator.java
Date cr�� : 2013-09-25
Date dern. modif. 2013-01-10
 *******************************************************
Historique des modifications
 *******************************************************
2013-09-25 Version initiale
 *******************************************************/
package lab2;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class ServerCommunicator
{

	private Socket requestSocket;
	private OutputStream output; //
	private OutputStreamWriter outputwriter; // Un stream qui enverra des
												// messages au
	// serveur
	private BufferedWriter bufferedWriter; //

	private InputStream input; //
	private InputStreamReader inputreader; // Un stream qui recoit les r�ponses
											// du
	// serveur
	private BufferedReader bufferedReader; //

	/**
	 * Constructeur
	 * 
	 * @param strServer
	 *            Le DNS du serveur o� on se connectera
	 * @param port
	 *            Le num�ro de port
	 * 
	 */
	public ServerCommunicator(String strServer, int port)
	{
		try
		{
			// 1. creating a socket to connect to the server
			this.requestSocket = new Socket(strServer, port);
			System.out.println("Connected to " + strServer + " in port 10000");
			if (requestSocket.isConnected())
			{
				this.output = this.requestSocket.getOutputStream(); //
				this.outputwriter = new OutputStreamWriter(this.output); // Initialize
																			// les
				// streams
				// d'�criture au
				// serveur
				this.bufferedWriter = new BufferedWriter(outputwriter); //

				this.input = this.requestSocket.getInputStream(); //
				this.inputreader = new InputStreamReader(input); // Initialize
																	// les
																	// streams
				// de lecture au serveur
				this.bufferedReader = new BufferedReader(inputreader); //

				// this.br.readLine();
			}
		} catch (UnknownHostException unknownHost)
		{
			System.err.println("You are trying to connect to an unknown host!");
			JOptionPane.showMessageDialog(null,
					"Le serveur sp�cifi� n'est pas valide.");
		} catch (IOException ioException)
		{
			JOptionPane.showMessageDialog(null,
					"Le serveur sp�cifi� ne r�pond pas.");
			// ioException.printStackTrace();
		}

		// Partir un thread qui enverra un message de d�connexion au serveur si
		// le programme ferme.
		Runtime.getRuntime().addShutdownHook(new Thread()
		{
			@Override
			public void run()
			{
				try
				{
					closeConnection();
				} catch (Exception e)
				{ /* failed */
				}
			}
		});
	}

	/**
	 * Permet d'envoyer un message au serveur et de r�cup�rer sa r�ponse
	 * 
	 * @param queryType
	 *            Le message � envoyer au serveur.
	 * @return String La r�ponse du serveur
	 */
	public String queryServer(String queryType)
	{
		String output = "";
		if (this.requestSocket.isConnected())
		{
			try
			{
				this.bufferedWriter.write(queryType + "\n"); // On envoi le
																// message
				this.bufferedWriter.flush();
				output = this.bufferedReader.readLine(); // On recoit le message
				output = this.bufferedReader.readLine(); // On recoit le message
				// System.out.println("DEBUG:queryServer");
			} catch (Exception e)
			{
				// e.printStackTrace();
			}
		}

		// System.out.println(output);
		return output;
	}

	public Boolean hasActiveConnection()
	{
		if (this.requestSocket == null)
		{
			closeConnection();
			return false;
		}
		return this.requestSocket.isConnected();
	}

	public void closeConnection()
	{
		try
		{
			this.bufferedWriter.write("END");
			this.bufferedWriter.flush();
			this.requestSocket.close();
		} catch (Exception e)
		{
			// e.printStackTrace();
		}
		System.out.println("Connection with the server has terminated safely.");
	}
}
