package Project3Classes;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OfficeManager extends Account{
	
	private DecimalFormat df = new DecimalFormat("0.00");
	private ArrayList<Bikepart> bp = new ArrayList<Bikepart>();
	
	public OfficeManager(String un, String pw, Person p, String pn)
	{
		super(un, pw, p, pn);
		this.setAccounttype(1);
	}
	public String displayPartName(ArrayList<Warehouse> wh, Warehouse w, String displ){
		String output = "";
		int count=0;
		for(Warehouse x : wh)
		{
			if(x.getName().equals(w.getName()))
			{
				count++;
				for(int i=0; i<x.getSize(); i++)
				{
					if(x.getPartName(i).equals(displ))
					{
						count++;
						output = x.display(displ);
					}
				}
			}
		}
		if (count==0)
		{
			output = "Warehouse not found.";
		}
		if(count==1)
		{
			output = "Part not found in warehouse.";
		}

		return output;

	}
	public String displayPartNumber(ArrayList<Warehouse> wh, Warehouse w, int displ){
		String output = "";
		int count=0;
		for(Warehouse x : wh)
		{
			if(x.getName().equals(w.getName()))
			{
				count++;
				for(int i=0; i<x.getSize(); i++)
				{
					if(x.getPartNumber(i)==displ)
					{
						count++;
						output = x.display(x.getPartName(i));
					}
				}
			}
		}
		if (count==0)
		{
			output = "Warehouse not found.";
		}
		if(count==1)
		{
			output = "Part not found in warehouse.";
		}

		return output;

	}
	
	public String paySalesAssociate(String username, ArrayList<Account> acs, Calendar start, Calendar end)
	{
		ArrayList<SalesAssociate2> sa = new ArrayList<SalesAssociate2>();
		ArrayList<SalesInvoice> si = new ArrayList<SalesInvoice>();
		double pay = 0;
		String name = "";
		for(Account x : acs)
		{
			if(x.getAccounttype()==3)
			{
				sa.add((SalesAssociate2)x);
			}
		}
		for(SalesAssociate2 s : sa)
		{
			if(s.getUsername().equals(username))
			{
				name = s.getFirstN()+" "+s.getLastN();
				si.addAll(s.getInvoices());
			}
		}
		for(SalesInvoice i : si)
		{
			if(start.compareTo(i.getDate())<0&&end.compareTo(i.getDate())>0)
			{
				pay+=i.getProfit();
			}
		}
		return name+" was paid $"+df.format(pay*.15);
		
	}
	
	public String getLowParts(Warehouse main)
	{
		String output = "Bike parts at/below minimum: ";
		for(int i=0; i<main.getSize(); i++)
		{
			if(main.getPartQuantity(i)<=10)
			{
				output+=main.getPart(i)+"\n";
				bp.add(main.getPart(i, 0));
				bp.get(bp.size()-1).setquantity(bp.get(bp.size()-1).getquantity()+20);
			}
		}
		 output += "Bike parts close to the minimum: ";
		for(int i=0; i<main.getSize(); i++)
		{
			if(main.getPartQuantity(i)>10&&main.getPartQuantity(i)<=12)
			{
				output+=main.getPart(i)+"\n";
				bp.add(main.getPart(i, 0));
				bp.get(bp.size()-1).setquantity(bp.get(bp.size()-1).getquantity()+20);
			}
		}
		return output;
	}
	
	public void orderParts()
	{
		Warehouse temp = new Warehouse();
		temp.addParts(bp);
		File f = new File("PartsNeeded.txt");
		String s = "";
		try
		{
			PrintWriter print = new PrintWriter(f);
			s+=temp.getSize()+"\n";
			s+=temp.writeToDatabase();
			print.write(s);
			print.close();
		}
		catch(IOException e1)
		{
			System.out.println("Unable to save to databe "+e1.getMessage());
		}
	}

}
