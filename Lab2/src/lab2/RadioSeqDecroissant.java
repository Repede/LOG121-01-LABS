package lab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class RadioSeqDecroissant extends AbstractMenuItem
{

	public RadioSeqDecroissant()
	{
		this.title = "app.frame.radio.order.seqDec";
	}
	
	public void addListener(JMenuItem item, MenuFenetre mf)
	{
		item.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
	}

}
