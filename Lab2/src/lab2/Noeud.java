package lab2;

public class Noeud
{
	private Noeud precedent = null;;
	private Object item = null;
	private Noeud suivant = null;

	public Noeud(Object obj, Noeud knot)
	{
		this.item = obj;
		precedent = knot;
	}

	public Noeud getNext()
	{
		return suivant;
	}

	public Noeud getLast()
	{
		return precedent;
	}

	public Object getObject()
	{
		return item;
	}

	public void setForward(Noeud forward)
	{
		suivant = forward;
	}

	public void setBackward(Noeud backward)
	{
		precedent = backward;
	}

	public void setObject(Object obj)
	{
		item = obj;
	}

	public boolean hasNext()
	{
		if (this.suivant == null)
		{
			return false;
		}
		return true;
	}

}
