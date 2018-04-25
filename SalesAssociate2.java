package Project3Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SalesAssociate2 extends Account implements Serializable {


	private String WarehouseName;
	private Warehouse warehouse;
	private SalesVan salesvanWH;
	private ArrayList<SalesInvoice> sales = new ArrayList<SalesInvoice>();
	private ArrayList<Bikepart> bp = new ArrayList<Bikepart>();

	public SalesAssociate2(String userName, String password, Person p, String pn, SalesVan sv) {
		setUsername(userName);
		setPassword(password);
		setPerson(p);
		setPhonenumber(pn);
		salesvanWH = sv;
		setAccounttype(3);
	}

	public String getWarehouseName() {
		return WarehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		WarehouseName = warehouseName;
	}

	public SalesVan getSalesVan() {
		return salesvanWH;
	}
	public void setSalesVan(SalesVan sv) {
		salesvanWH = sv;
	}

//	public List<SalesInvoice> getSales(Date startDate, Date endDate) {
//		List<SalesInvoice> salesList = new ArrayList<>();
//		for (SalesInvoice si : sales) {
//			if (startDate == null) {
//				salesList.add(si);
//			}
//			else {
//				if (startDate.compareTo(si.getDate()) <= 0 && endDate.compareTo(si.getDate()) >= 0)
//					salesList.add(si);
//			}
//		}
//		return salesList;
//	}

	private void moveParts(String file, ArrayList<Warehouse> wh)
	{
		try
		{
			File f = new File(file);
			Scanner scnr = new Scanner(f);
			String warehouseName = scnr.nextLine();
			while(scnr.hasNextLine())
			{
				String line = scnr.nextLine();
				String [] elements = line.split(",");
				String partName = elements[0];
				int quantity = Integer.parseInt(elements[1]);
				for(Warehouse x : wh)
				{
					if(x.getName().equals(warehouseName))
					{
						for(int j=0; j<x.getSize(); j++) 
						{
							if(x.getPartName(j).toLowerCase().equals(partName.toLowerCase()))
							{
								bp.add(new Bikepart(x.getPartName(j), x.getPartNumber(j), x.getPartPrice(j), 
										x.getSalePrice(j), x.getOnSale(j), quantity));
								break;
							}
						}
						for(int i=0; i<quantity; i++)
						{
							x.sellByPartName(partName);
						}
					}
				}
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
	}
	
	public void loadVan(String file, ArrayList<Warehouse> w)
	{
		moveParts(file, w);
		salesvanWH.addParts(bp);
	}
	
	public void sellToBikePart(String filep) throws FileNotFoundException
	{
		Calendar date = Calendar.getInstance();
		ArrayList<Bikepart> b = new ArrayList<Bikepart>();
		File f = new File(filep);
		Scanner scnr = new Scanner(f);
		String shopOwner = scnr.nextLine();
		String bikeShop = shopOwner.substring(0, shopOwner.indexOf(','));
		String signature = shopOwner.substring(shopOwner.indexOf(',')+1);
		int num = scnr.nextInt();
		scnr.nextLine();
		for(int i=0; i<num; i++)
		{
			String line = scnr.nextLine();
			String[] elements = line.split(",");
			b.add(new Bikepart(elements[0], Integer.parseInt(elements[1]), Double.parseDouble(elements[2]), Double.parseDouble(elements[3]),
					Boolean.parseBoolean(elements[4]), Integer.parseInt(elements[5])));
		}
		for(Bikepart x : bp)
		{
			for(Bikepart c : b)
			{
				if(x.getpartnumber()==c.getpartnumber())
				{
					x.setquantity(x.getquantity()-c.getquantity());
				}
			}
		}
		SalesInvoice invoice = new SalesInvoice();
		invoice.setSeller(this.getFirstN()+" "+this.getLastN());
		invoice.toString(bikeShop, signature);
		System.out.println(invoice.getInvoice());
		sales.add(invoice);
	}
	
	public ArrayList<SalesInvoice> getInvoices()
	{
		return sales;
	}
}
