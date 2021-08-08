public class book
{

	private String author;
	private String title;
	private String donor;
	private double value;


	public book (String t, String a, String d, double v)
	{

	this.author = a;
	this.title = t;
	this.donor = d;
	this.value = v;
	}

	public String getauthor()
	{
		return this.author;
	}


	public String gettitle()
	{
		return this.title;
	}


	public String getdonor()
	{
		return this.donor;
	}

	public double getvalue()
	{
		return this.value;
	}

}
