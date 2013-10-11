package lab2;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenuObtenirFormes extends AbstractMenuItem
{
	public MenuObtenirFormes()
	{
		this.actionEvent = ActionEvent.CTRL_MASK;
		this.keystroke = KeyEvent.VK_D;
		this.title = "app.frame.menus.draw.start";
	}
}