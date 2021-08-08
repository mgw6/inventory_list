//MacGregor Winegard
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

// goals for this assignment: be more organized, label all my closing brackets so I don't have a bracket issue like last time
// put my variables up top so I know what I have
public class makebooklist
{
	public static void main(String args[])
	{
		Scanner        menuchoice = new Scanner (System.in); // for the menu
		int            choicenumber = 0; // for the menu
		int            borm = 0 ; // book or magazine
		boolean        checkmenu  = false;
		boolean        gottablast = false;
		double         inventoryvalue = 0;
		ArrayList      inventorylist = new ArrayList();
		int	       inventorylength =0;
		int 	       listcount = 0;

		// these will be the variables for making books and magazines
		String 		bookname;
		String  	inauthor;
		String 		donorname;
		double 		invalue = 0;
		boolean		goodval = false;


		String 		cookgenre;//mag and book specific
		boolean 	checkrecipes = false;
		int 		numrecipes = 0;
		boolean  	goodvalue = false;
		int		magyear = 0;
		int		magmonth = 0;
		boolean 	checkyear = false;
		boolean 	checkmonth = false;

		String 		gottitle; // these are for the getters
		String 		gotauthor;
		String 		gotdonor;
		double 		gotvalue = 0;
		String		gotgenre;
		int 		gotrecipes;
		int		gotmonth=0;
		int		gotyear = 0;

		Scanner 	inname = new Scanner (System.in); // scanners
		Scanner 	inputauthor = new Scanner (System.in);
		Scanner 	indonor = new Scanner (System.in);
		Scanner 	inval = new Scanner (System.in);



		while (!gottablast)
		{


			checkmenu = false;

			while(checkmenu == false)
			{
				try
				{

					printmenu();
					choicenumber = menuchoice.nextInt();

					while (choicenumber>5 || choicenumber<1)
					{
						System.out.printf("Please enter a number 1-5 as an integer:");
						choicenumber = menuchoice.nextInt();
					} // ends choice check while loop
					checkmenu = true;


				} // ends try

				catch (InputMismatchException e)
				{
					System.out.printf("\nThats not even a number... try again.\n");
					menuchoice.nextLine(); // I want to play with my print statements so that the input is on the line with the prompt
				} // end catch
			} // ends check menu while


			switch (choicenumber)
			{
				case 1: // make cookbook

					System.out.printf("\nLets cook up a cookbook!");
					System.out.printf("\nPlease input the name of this cookbook: ");
					bookname = inname.nextLine();

					System.out.printf("\nPlease input the name of the author: ");
					inauthor = inputauthor.nextLine();

					System.out.printf("\nPlease enter the donor name: ");
					donorname = indonor.nextLine();

					goodvalue = false;
					while(goodvalue == false)
					{
						try
						{
							System.out.printf("\nPlease enter the value of the cookbook: $");
							invalue = inval.nextDouble();

							while(invalue <= 0)
							{
								System.out.printf("\nWe're tryna turn a profit here....");
								System.out.printf("\nPlease enter the value of the cookbook: $");
								invalue = inval.nextDouble();
							}
								goodvalue = true;
						} // end try
						catch (InputMismatchException e)
						{
							inval.nextLine();
							System.out.printf("\nLets put in a number please... ");
						}// ends catch

					} // ends goodvalue while

					System.out.printf("\nPLease input the genre of the cookbook: ");
					Scanner ingenre = new Scanner (System.in);
					cookgenre = ingenre.nextLine();

					Scanner inrecipes = new Scanner (System.in);

					checkrecipes = false;
					while (checkrecipes == false)
					{
						try
						{
							System.out.printf("\nPlease input the number of recipes in this cookbook: ");
							numrecipes = inrecipes.nextInt();

							while(numrecipes <1)
							{
								System.out.printf("\nWe want a number of recipes. ");
								numrecipes = inrecipes.nextInt();
							} // end numrecipes while
						checkrecipes = true;

						} // end of try

						catch (InputMismatchException e)
						{
							inrecipes.nextLine();
							System.out.printf("\nWe want a number of recipes. ");
						}
					} // end of checkrecipes while loop


					inventorylist.add(new cookbook(bookname, inauthor, donorname, invalue, cookgenre, numrecipes));
					// for whatever reason this constructor causes the thing to compile but unsafely
					// I used the -Xlint to find this but it compiles and runs and according to Google that is okay.


					inventoryvalue = inventoryvalue + invalue;


				break; // end make cookbook



				case 2: // make magazine
					System.out.printf("\nWe are inputting a magazine.");
					System.out.printf("\nPlease input the name of this magazine: ");
					bookname = inname.nextLine();

					System.out.printf("\nPlease input the name of the author or publisher: ");
					inauthor = inputauthor.nextLine();

					System.out.printf("\nPlease enter the donor name: ");
					donorname = indonor.nextLine();

					goodvalue = false;
					while(goodvalue == false)
					{
						try
						{
							System.out.printf("\nPlease enter the value of the magazine: $");
							invalue = inval.nextDouble();

							while(invalue <= 0)
							{
								System.out.printf("\nWe're tryna turn a profit here....");
								System.out.printf("\nPlease enter the value of the magazine: $");
								invalue = inval.nextDouble();
							}
								goodvalue = true;
						} // end try
						catch (InputMismatchException e)
						{
							inval.nextLine();
							System.out.printf("\nLets put in a number please... ");
						}// ends catch

					} // ends goodvalue while

					checkyear = false ;
					Scanner inyear = new Scanner (System.in);

					while(checkyear == false)
					{
						try
						{
							System.out.printf("\nEnter the year of publication: ");
							magyear = inyear.nextInt();
							while(magyear<1663 || magyear >2020)
							{
								System.out.printf("\nPlease input a valid year: ");
								magyear = inyear.nextInt();
							} //ends year check while loop
							checkyear = true;
						} // ends try
						catch (InputMismatchException e)
						{
							inyear.nextLine();
							System.out.printf("\nPlease input the year as an integer: ");

						}//  ends catch
					} // ends while for the catchyear


					Scanner inmonth = new Scanner (System.in);
					checkmonth = false;

					while(checkmonth == false)
					{
						try
						{
							System.out.printf("\nPlease input the month as a number (i.e. May = 5): ");
							magmonth = inmonth.nextInt();
							while(magmonth > 12 || magmonth <1)
							{
								System.out.printf("\nThere are 12 months in a year: ");
								magmonth = inmonth.nextInt();
							} // end month 1-12 while
							checkmonth = true;
						}
						catch (InputMismatchException e)
						{
							inmonth.nextLine();
							System.out.printf("\nInput the month as an integer: ");
						} //ends catch
					} // end while for checkmonth

					inventorylist.add(new magazine(bookname, inauthor, donorname, invalue, magyear, magmonth));
					// for whatever reason this constructor causes the thing to compile but unsafely
					// I used the -Xlint to find this but it compiles and runs and according to Google that is okay.

					inventoryvalue = inventoryvalue + invalue;
				break; // end make magazine



				case 3: // list inventory
					System.out.printf("\nWe will now list the inventory: \n"); // I knew to do this as a loop
					for (listcount = 0; listcount < inventorylist.size(); listcount ++)
					{
						book b0; cookbook c0; magazine m0; //but Dakota Thompson helped me with how to actually retrieve it
						b0 = (book)(inventorylist.get(listcount));

						gottitle  = b0.gettitle();
						gotauthor = b0.getauthor();
						gotdonor  = b0.getdonor();
						gotvalue  = b0.getvalue();

						System.out.printf("\nTitle: %s\n", gottitle);
						System.out.printf("\tAuthor: %s\n", gotauthor);
						System.out.printf("\tDonor: %s\n", gotdonor);
						System.out.println("\tValue: $" + String.format("%.2f", gotvalue));


						if (inventorylist.get(listcount) instanceof cookbook)
						{
							c0 = (cookbook)(inventorylist.get(listcount));
							gotgenre   = c0.getgenre();
							gotrecipes = c0.getrecipes();

							System.out.printf("\tGenre: %s\n", gotgenre);
							System.out.printf("\tRecipes: %d\n", gotrecipes);

						} // ends if cookbook

						if (inventorylist.get(listcount) instanceof magazine)
						{
						m0 = (magazine)(inventorylist.get(listcount));
						gotyear  = m0.getyear();
						gotmonth = m0.getmonth();

						System.out.printf("\tPublished: ");

						switch (gotmonth)
						{
							case 1:  System.out.printf("January %d\n", gotyear);   break;
							case 2:  System.out.printf("February %d\n", gotyear);  break;
							case 3:  System.out.printf("March %d\n", gotyear);     break;
							case 4:  System.out.printf("April %d\n", gotyear);     break;
							case 5:  System.out.printf("May %d\n", gotyear);       break;
							case 6:  System.out.printf("June %d\n", gotyear);      break;
							case 7:  System.out.printf("July %d\n", gotyear);      break;
							case 8:  System.out.printf("August %d\n", gotyear);    break;
							case 9:  System.out.printf("September %d\n", gotyear); break;
							case 10: System.out.printf("October %d\n", gotyear);   break;
							case 11: System.out.printf("November %d\n", gotyear);  break;
							case 12: System.out.printf("Decmeber %d\n", gotyear);  break;
						} // ends switch

						} // ends if magazine


					} // ends print for loop


				break; // end list inventory



				case 4: //value of inventory
					System.out.println("The inventory value is $" + String.format("%.2f", inventoryvalue));
				break; // end value of inventory

				case 5: // exit
					System.out.printf("\nHave a nice day!\n\n");
					gottablast = true;
				break; // end exit

			} //end menuchoice switch


		} // ends gottablast while loop




	} // end main



	public static void printmenu()
	{
		System.out.printf("\nMenu:\n");
		System.out.printf("\t1) Add cookbook\n");
		System.out.printf("\t2) Add magazine\n");
		System.out.printf("\t3) List Inventory\n");
		System.out.printf("\t4) Calculate Inventory Value\n");
		System.out.printf("\t5) Exit\n");
		System.out.printf("Please enter your selection: ");
	} //end print menu

}
