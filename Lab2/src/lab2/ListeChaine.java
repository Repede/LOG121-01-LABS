package lab2;

public class ListeChaine
{
	private Noeud tete;
	private Noeud explorer;
	
	public ListeChaine()
	{
		tete = new Noeud(null,null);
		explorer = tete;
	}
	
	public void addItem(AbstractCustomShape shape)
	{
		if(tete.getObject() == null)
		{
			tete.setObject(shape);
		}
		else
		{
			Noeud looker = tete;
			Noeud newKnot = null;
			while(looker.hasNext())
			{
				looker = looker.getNext();
			}
			newKnot = new Noeud(shape,looker);
			looker.setForward(newKnot);
		}
		
	}
	
	
}