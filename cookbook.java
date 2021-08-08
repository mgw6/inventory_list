public class cookbook extends book
{

	private String genre;
	private int recipes;

	public cookbook(String ti, String au, String dn, double va, String ge, int re)
	{
		super(ti,au,dn,va);

		this.genre = ge;
		this.recipes = re;
	}

	public String getgenre()
	{
		return this.genre;
	}

	public int getrecipes()
	{
		return this.recipes;
	}


}
