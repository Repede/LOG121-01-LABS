package lab2;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CommBase.java
Date cr��: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *******************************************************/

import java.beans.PropertyChangeListener;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 * Base d'une communication via un fil d'ex�cution parall�le.
 */
public class CommBase
{
	private final int DELAI = 1000;
	private SwingWorker threadComm = null; // Unused ?!
	private PropertyChangeListener listener = null;
	private boolean mIsActif = false;

	private String serveur = null;
	private int port;

	private ServerCommunicator serverCom;

	/**
	 * Constructeur
	 */
	public CommBase()
	{
		
	}

	/**
	 * D�finir le r�cepteur de l'information re�ue dans la communication avec le
	 * serveur
	 * 
	 * @param listener
	 *            sera alert� lors de l'appel de "firePropertyChanger" par le
	 *            SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener)
	{
		this.listener = listener;
	}

	/**
	 * D�marre la communication
	 */
	public void start()
	{
		if (serveur == null || !serverCom.hasActiveConnection())
		{
			String strServer = JOptionPane.showInputDialog(null,
					"Veuillez sp�cifier l'h�te et le port.", "localhost:10000");
			MessageDecoder msgDecoder = new MessageDecoder(strServer);
			serveur = msgDecoder.getServerName();
			port = msgDecoder.getServerPort();
		}

		serverCom = new ServerCommunicator(serveur, port);

		if (serverCom.hasActiveConnection())
		{
			creerCommunication();
		}

	}

	/**
	 * Arrête la communication
	 */
	public void stop()
	{
		mIsActif = false;
		serverCom.closeConnection();

		if (threadComm != null)
		{
			threadComm.cancel(true);
		}
	}

	/**
	 * Cr�er le n�cessaire pour la communication avec le serveur
	 */
	protected void creerCommunication()
	{
		// Cr�e un fil d'ex�cusion parall�le au fil courant,
		threadComm = new SwingWorker()
		{
			@Override
			protected Object doInBackground() throws Exception
			{
				System.out.println("Le fils d'execution parallele est lance.");
				while (true)
				{
					Thread.sleep(DELAI);

					// C'EST DANS CETTE BOUCLE QU'ON COMMUNIQUE AVEC LE SERVEUR
					// La m�thode suivante alerte l'observateur
					if (listener != null)
					{
						// System.out.println("Listening, sending GET serverCom");
						String getmsg = serverCom.queryServer("GET");
						firePropertyChange("GET", null, getmsg);
					}
				}
				// return null;
			}
		};
		if (listener != null)
			threadComm.addPropertyChangeListener(listener); // La m�thode
		threadComm.execute(); // Lance le fil d'ex�cution parall�le.
		mIsActif = true;
	}

	/**
	 * @return si le fil d'ex�cution parall�le est actif
	 */
	public boolean isActif()
	{
		return mIsActif;
	}
}
