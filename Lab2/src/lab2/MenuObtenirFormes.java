package lab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;

public class MenuObtenirFormes extends AbstractMenuItem
{
	public MenuObtenirFormes()
	{
		this.actionEvent = ActionEvent.CTRL_MASK;
		this.keystroke = KeyEvent.VK_D;
		this.title = "app.frame.menus.draw.start";
	}

	public void addListener(JMenuItem item, final MenuFenetre mf)
	{
		item.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				mf.comm.start();
				mf.rafraichirMenus();
			}
		});
	}
}