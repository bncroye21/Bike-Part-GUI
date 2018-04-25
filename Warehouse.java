package Project3Classes;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Warehouse implements Serializable {
	private ArrayList<Bikepart> bp = new ArrayList<Bikepart>();
	private String name;

	public Warehouse()
	{
		name = "";
	}
	
	public Warehouse(String n)
	{
		name = n;
	}

	public String reader(String fname) {

		String output = "";
		
		// The name of the file to open.
		String fileName = fname;

		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			ArrayList<Bikepart> temp = new ArrayList<Bikepart>();

			while((line = bufferedReader.readLine()) != null) {
				String[] partinfoarray = line.split(","); 
				Bikepart temppart = new Bikepart();
				temppart.setpartname(partinfoarray[0]);
				temppart.setpartnumber(Integer.valueOf(partinfoarray[1]));
				temppart.setlistprice(Double.valueOf(partinfoarray[2]));
				temppart.setsaleprice(Double.valueOf(partinfoarray[3]));
				temppart.setonsale(Boolean.valueOf(partinfoarray[4]));
				temppart.setquantity(Integer.valueOf(partinfoarray[5]));
				temp.add(temppart);
			}   
			
			if(bp.size()>0)
			{
				for (int i=0; i<temp.size(); i++)
				{
					int count = 0;
					for(int j=0; j<bp.size(); j++)
					{
						if(bp.get(j).getpartnumber()!=temp.get(i).getpartnumber())
						{
							count++;
						}
						else if(bp.get(j).getpartnumber()==temp.get(i).getpartnumber())
						{
							bp.get(j).setquantity(temp.get(i).getquantity());
							bp.get(j).setlistprice(temp.get(i).getlistprice());
							bp.get(j).setonsale(temp.get(i).getonsale());
							bp.get(j).setsaleprice(temp.get(i).getsaleprice());
						}
					}
					if (count!=bp.size()-1)
					{
						bp.add(temp.get(i));
					}
				}
			}
			else
			{
				for(Bikepart x : temp)
				{
					bp.add(x);
				}
			}
			output = ("Inventory complete\n");
			// Always close files.
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			output = "Unable to open file '" + fileName + "'";                
		}
		catch(IOException ex) {
			output = "Error reading file '" + fileName + "'";                  
		}
		return output;
	}
	public static void writer(ArrayList<Bikepart> bikepartlist) {

		// The name of the file to open.
		String fileName = "warehouseDB.txt";

		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Note that write() does not automatically
			// append a newline character.
			for(int i=0; i<bikepartlist.size(); i++){
				bufferedWriter.write(bikepartlist.get(i).getpartname() + "," 
						+ bikepartlist.get(i).getpartnumber() + ","
						+ bikepartlist.get(i).getlistprice() + ","
						+ bikepartlist.get(i).getsaleprice() + ","
						+ bikepartlist.get(i).getonsale() + ","
						+ bikepartlist.get(i).getquantity()+"\n");
			}

			// Always close files.
			bufferedWriter.close();
		}
		catch(IOException ex) {
			System.out.println(
					"Error writing to file '"
							+ fileName + "'");
		}
	}

	//comment here
	public String read(String fname){
		String output = "";
		return reader(fname);
	} 
	
	/**
	 * Takes a string that is a Bikepart and converts it into a Bikepart object then adds it to the ArrayList
	 * @param part Part being entered into database
	 * @return whether the part was added to the database or not
	 */
	public String enter(String part){
		String output = "Part was updated";
		int comma;
		Bikepart bikepart = new Bikepart();
		comma = part.indexOf(',');
		bikepart.setpartname(part.substring(0, comma));
		part = part.substring(comma + 1, part.length());
		comma = part.indexOf(',');
		bikepart.setpartnumber(Integer.parseInt(part.substring(0, comma)));
		part = part.substring(comma + 1, part.length());
		comma = part.indexOf(',');
		bikepart.setlistprice(Double.parseDouble(part.substring(0, comma)));
		part = part.substring(comma + 1, part.length());
		comma = part.indexOf(',');
		bikepart.setsaleprice(Double.parseDouble(part.substring(0, comma)));
		part = part.substring(comma + 1, part.length());
		comma = part.indexOf(',');
		bikepart.setonsale(Boolean.parseBoolean(part.substring(0, comma)));
		part = part.substring(comma + 1, part.length());
		comma = part.indexOf(',');
		bikepart.setquantity(Integer.parseInt(part.substring(0)));
		if(bp.size()>0)
		{
			int count = 0;
			for(Bikepart x : bp)
			{
				if(x.getpartnumber()!=bikepart.getpartnumber())
				{
					count ++;
				}
				else if(x.getpartnumber()==bikepart.getpartnumber())
				{
					x.setquantity(x.getquantity()+bikepart.getquantity());
					x.setlistprice(bikepart.getlistprice());
					x.setonsale(bikepart.getonsale());
					x.setsaleprice(bikepart.getsaleprice());
				}
			}
			if(count!=bp.size()-1)
			{
				bp.add(bikepart);
				output = "\""+bikepart.getpartname()+"\" was added to the database.";
			}
		}
		else
		{
			bp.add(bikepart);
			output = "\""+bikepart.getpartname()+"\" was added to the database.";
		}
		return output;
	}
	
	/**
	 * Takes a Bikepart number, finds that part number, decrements the quantity by 1, displays time shown
	 * @param pnum Part number of Bikepart being sold
	 * @return part and time it was sold or part not found
	 */
	public String sell(int pnum){
		String output = "";
		int count=0;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		for(int i=0; i<bp.size(); i++){
			if(bp.get(i).getpartnumber()==pnum){
				count=count+1;
				if (bp.get(i).getonsale()){
					output = "Part Name: "+bp.get(i).getpartname() + " Part Price: " + bp.get(i).getsaleprice();
					output += "\nItem is on sale.";
				}
				else{
					output = "Part Name: "+bp.get(i).getpartname() + "Part Price: " + bp.get(i).getlistprice();
					output += "\nItem is not on sale.";
				}
			}
			bp.get(i).setquantity(bp.get(i).getquantity()-1);
		}
		output += "Time of sale: "+time.format(cal.getTime());
		if (count==0){
			output = "Part not found.";
		}
		return output;
	}
	
	public String sellByPartName(String pname) {
		String output = "";
		int count=0;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		for(int i=0; i<bp.size(); i++){
			if(bp.get(i).getpartname().equals(pname)){
				count=count+1;
				if (bp.get(i).getonsale()){
					output = "Part Name: "+bp.get(i).getpartname() + " Part Price: " + bp.get(i).getsaleprice();
					output += "\nItem is on sale.";
				}
				else{
					output = "Part Name: "+bp.get(i).getpartname() + "Part Price: " + bp.get(i).getlistprice();
					output += "\nItem is not on sale.";
				}
			}
			bp.get(i).setquantity(bp.get(i).getquantity()-1);
		}
		output += "Time of sale: "+time.format(cal.getTime());
		if (count==0){
			output = "Part not found.";
		}
		return output;
	}
	
	/**
	 * Displays a Bikepart given by the user
	 * @param displ Part that's being displayed
	 * @return part or part not found
	 */
	public String display(String displ){
		String output = "";
		int count=0;
		for(int i=0; i<bp.size(); i++)
		{
			if(bp.get(i).getpartname().equals(displ)){
				count=count+1;
				if (bp.get(i).getonsale()){
					output = "Part Name: "+bp.get(i).getpartname() + " Part Price: " + bp.get(i).getsaleprice();
					output += "\nItem is on sale.";
				}
				else{
					output = "Part Name: "+bp.get(i).getpartname() + "Part Price: " + bp.get(i).getlistprice();
					output += "\nItem is not on sale.";
				}
			}
		}
		if (count==0){
			output = "Part not found.";
		}
		return output;
	}
	
	/**
	 * Sorts list(s) by name
	 */
	public void sortname(){
		for(int i=0; i<bp.size(); i++){
			for(int j=1; j<bp.size()-i; j++){
				if (bp.get(j).getpartname().compareTo(bp.get(j-1).getpartname())<0){
					Bikepart temp = bp.get(j);
					bp.set(j, bp.get(j-1));
					bp.set(j-1, temp);
				}
			}
		}
	}
	
	/**
	 * Sorts list(s) by number
	 */
	public void sortnumber(){
		for(int i=0; i<bp.size(); i++){
			for(int j=1; j<bp.size()-i; j++){
				if (bp.get(j).getpartnumber()<bp.get(j-1).getpartnumber()){
					Bikepart temp = bp.get(j);
					bp.set(j, bp.get(j-1));
					bp.set(j-1, temp);
				}
			}
		}

	}
	
	/**
	 * Collects part information and returns it
	 * @param pnum Part number of Bikepart being grabbed
	 * @return part
	 */
	public String getPart(int pnum)
	{
		String output = "";
		for(Bikepart b : bp)
		{
			if(b.getpartnumber()==pnum)
			{
				output = b.getpartname()+","+b.getpartnumber()+","+b.getlistprice()+","+b.getsaleprice()+","+b.getonsale()+",";
			}
		}
		return output;
	}
	public String getName()
	{
		return name;
	}
	public String getPartName(int x)
	{
		return bp.get(x).getpartname();
	}
	public int getPartNumber(int x)
	{
		return bp.get(x).getpartnumber();
	}
	public double getPartPrice(int x)
	{
		return bp.get(x).getlistprice();
	}
	public double getSalePrice(int x)
	{
		return bp.get(x).getsaleprice();
	}
	public boolean getOnSale(int x)
	{
		return bp.get(x).getonsale();
	}
	public void setPartPrice(int x, double d)
	{
		bp.get(x).setlistprice(d);
	}
	public void setSalePrice(int x, double d)
	{
		bp.get(x).setsaleprice(d);
	}
	public void setOnSale(int x, boolean b)
	{
		bp.get(x).setonsale(b);
	}
	
	/**
	 * Prints out everything in the Bikepart ArrayList
	 * @return everything in Bikepart array
	 */
	public String checkWarehouse()
	{
		String output = "";
		if(bp.size()>0)
		{
			for(Bikepart b : bp)
			{
				output += b.toString()+"\n";
			}
		}
		else
			output = "Warehouse is empty";
		return output;
	}
	public int getSize()
	{
		return bp.size();
	}
	
	/**
	 * Formats a string of Bikeparts to easily write to a file
	 * @return everything formatted for the database file
	 */
	public String writeToDatabase()
	{
		String output = "";
		for(Bikepart x : bp)
		{
			if(x.getpartnumber()==bp.get(bp.size()-1).getpartnumber())
			{
				output += x.getpartname()+","+x.getpartnumber()+","+x.getlistprice()+","+x.getsaleprice()+","
						+x.getonsale()+","+x.getquantity();
			}
			else
				output += x.getpartname()+","+x.getpartnumber()+","+x.getlistprice()+","+x.getsaleprice()+","
						+x.getonsale()+","+x.getquantity()+"\n";
		}
		return output;
	}
	public void setName(String n)
	{
		name = n;
	}
	public void addParts(ArrayList<Bikepart> bp)
	{
		this.bp.addAll(bp);
	}
	public int getPartQuantity(int q)
	{
		return bp.get(q).getquantity();
	}
	public Bikepart getPart(int b, int p)
	{
		return bp.get(b);
	}

}
