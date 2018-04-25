package Project3Classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;

public class SalesInvoice implements Serializable{

	String cStore;
	String cReceived;
	ArrayList<Bikepart> partsSold;
	SalesAssociate2 emplSold;
	Calendar sellDate;
	String invoice;
	String name;
	private double totalSales;

	/*public SalesIn(String cStore, String cReceived, ArrayList<BikePart> partsSold, SalesAsso emplSold) {
		this.cStore = cStore;
		this.cReceived = cReceived;
		this.partsSold = partsSold;
		this.emplSold = emplSold;
		this.sellDate = new Date();
	}
	public SalesIn(String cStore, String cReceived, SalesAsso emplSold) {
		this.cStore = cStore;
		this.cReceived = cReceived;
		this.partsSold = new ArrayList<BikePart>();
		this.emplSold = emplSold;
		this.sellDate = new Date();
	}

	public SalesIn(String cStore, String cReceived, ArrayList<BikePart> partsSold, SalesAsso emplSold, long date) {
		this.cStore = cStore;
		this.cReceived = cReceived;
		this.partsSold = partsSold;
		this.emplSold = emplSold;
		this.sellDate = new Date(date);
	}

	public SalesIn() {} */
	public String getStore() {
		return cStore;
	}
	public String getCustomer() {
		return cReceived;
	}
	public ArrayList<Bikepart> getParts() {
		return partsSold;
	}
	public SalesAssociate2 getEmployee() {
		return emplSold;
	}
	public Calendar getDate() {
		return sellDate;
	}

	public String toString(String bikeShop, String cName) {
		String output = "";
		cStore = bikeShop;
		cReceived = cName;
		output += ("Sales Invoice for " + this.cStore + ", " + sellDate.getTime() + "\n");
		output += String.format("%-20s %-16s %-10s %-20s %-14s %-16s\n","Part Name","Part Number","Price","Sales Price","Quantity","Total");
		double[] total = new double[partsSold.size()];
		int count = 0;
		for(Bikepart loop : partsSold) {
			if(loop.getonsale())
			{
				total[count] = loop.getsaleprice()*loop.getquantity();
			}
			else
			{
				total[count] = loop.getlistprice()*loop.getquantity();
			}
			output += String.format("%-20s %-16s %-10s %-20s %-14s %-16s\n",loop.getpartname(),loop.getpartnumber(),loop.getlistprice(),
					loop.getsaleprice(), loop.getquantity(),total[count]);
			count++;
		}
		double overallTotal = 0;
		for(Double x : total)
		{
			overallTotal+=x;
		}
		totalSales = overallTotal;
		output += "Total:\t"+overallTotal+"\n\n";
		output += "Received by:\t" + this.cReceived;
		invoice = output;
		return output;
	}
	/**
	 * This method returns a condensed version of the toString() method.
	 * This will not be as human-readable as toString(), but is best for most efficient data storage.
	 * @return An ArrayList with index 0 containing the information about the invoice itself, and the remaining indices containing information about BikeParts.
	 */

	//public ArrayList<String> toStringCondensed() {

		/**cStore,customerEmployee,SaleDate
		 * partName,partNum,partListPrice,partSalesPrice,partOnSale,partQuan
		 */

		/*ArrayList<String> output = new ArrayList<String>();
		output.add(this.cStore + "," + this.cReceived + "," + this.sellDate.getTime());
		for(Bikepart part : this.partsSold) {
			output.add(part.getAll());
		}
		return output;
	} */

	public double getProfit() {
		return totalSales;
	}
	
	public void addPart(Bikepart newPart) {
		partsSold.add(newPart);

	}
	
	public String getInvoice()
	{
		return invoice;
	}
	
	public void setSeller(String seller)
	{
		name = seller;
	}

}
