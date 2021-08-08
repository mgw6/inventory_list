public class magazine extends book
{
	private int year;
	private int month;

	public magazine(String ti, String au, String dn, double va, int yr, int mo)
	{
		super(ti,au,dn,va);

		this.year =yr;
		this.month = mo;
	}



	public int getyear()
	{
		return this.year;
	}

	public int getmonth()
	{
		return this.month;
	}

}
