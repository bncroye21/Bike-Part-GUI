import java.util.ArrayList;

public class WarehouseManager extends Account{

	public WarehouseManager(String un, String pw, String em, String fn, String ln, String pn, int at)
	{
		super(un, pw, em, fn, ln, pn, at);
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
	public String updateInventory(ArrayList<Warehouse> w, Warehouse wh, String file)
	{
		String output="Updated Successfuly";
		int count = 0;
		for(Warehouse x : w)
		{
			if(wh.getName().equals(x.getName()))
			{
				count++;
				x.reader(file);
			}
			for(Warehouse n : w)
			{
				for(int i=0; i<w.get(0).getSize(); i++)
				{
					for(int j=0; j<n.getSize(); j++)
					{
						if(w.get(0).getPartNumber(i)==n.getPartNumber(j))
						{
							n.setPartPrice(j, w.get(0).getPartPrice(i));
							n.setSalePrice(j, w.get(0).getSalePrice(i));
							n.setOnSale(j, w.get(0).getOnSale(i));
						}
					}
				}
			}
		}
		if(count==0)
		{
			output = "Warehouse does not exist";
		}
		return output;
	}
}