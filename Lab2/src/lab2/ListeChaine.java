package lab2;

public class ListeChaine
{
	private Noeud tete;
	private Noeud explorer;

	public ListeChaine()
	{
		tete = new Noeud(null, null);
		explorer = tete;
	}

	public void addItem(AbstractCustomShape shape)
	{
		if (tete.getObject() == null)
		{
			tete.setObject(shape);
		} else
		{
			Noeud looker = tete;
			Noeud newKnot = null;
			while (looker.hasNext())
			{
				looker = looker.getNext();
			}
			newKnot = new Noeud(shape, looker);
			looker.setForward(newKnot);
		}

	}

	public AbstractCustomShape getItem(int num)
	{
		int i = 0;
		Noeud looker = tete;
		boolean finish = false;
		while (looker.hasNext() || finish)
		{
			i++;
			looker = looker.getNext();
			if (i >= num)
			{
				return (AbstractCustomShape) looker.getObject();
			}
		}
		return null;
	}

	public AbstractCustomShape getNext()
	{
		explorer = explorer.getNext();
		return (AbstractCustomShape) explorer.getLast().getObject();
	}

}