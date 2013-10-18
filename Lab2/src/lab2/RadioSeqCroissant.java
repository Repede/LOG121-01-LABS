package lab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class RadioSeqCroissant extends AbstractMenuItem
{

	public RadioSeqCroissant()
	{
		this.title = "app.frame.radio.order.seqInc";
	}
	
	public void addListener(JMenuItem item, final MenuFenetre mf)
	{
		item.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				ShapeComparatorBySequenceNumber comparator = new ShapeComparatorBySequenceNumber();
				// 1 == Croissant
				mf.shapes.sort(comparator, 1);
			}
		});
	}
}