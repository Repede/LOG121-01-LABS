package lab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;

public class MenuQuitter extends AbstractMenuItem
{
	public MenuQuitter()
	{
		this.actionEvent = ActionEvent.CTRL_MASK;
		this.keystroke = KeyEvent.VK_Q;
		this.title = "app.frame.menus.file.exit";
	}

	public void addListener(JMenuItem item, final MenuFenetre mf)
	{
		item.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				mf.comm.stop();
				try
				{
					Thread.sleep(MenuFenetre.DELAI_QUITTER_MSEC);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
	}

}
