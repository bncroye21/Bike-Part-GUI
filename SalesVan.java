package Project3Classes;

import java.io.Serializable;

public class SalesVan extends Warehouse implements Serializable{

	public SalesVan()
	{
		super();
	}
	
	public SalesVan(String n) 
	{
		super(n);
	}
	
	/**
	 * Moves a given part from a Warehouse to a Sales Van
	 * @param wh 	Warehouse that part is being moved from
	 * @param pname	Name of part being moved
	 * @param quant	Quantity of part being moved
	 * @return name of Sales Van and contents in it's Warehouse
	 */
	public String movePart(Warehouse wh, String pname, int quant)
	{
		int pnum=0;
		for(int j=0; j<wh.getSize(); j++) 
		{
			if(wh.getPartName(j).toLowerCase().equals(pname.toLowerCase()))
			{
				pnum=wh.getPartNumber(j);
				break;
			}
		}
		String part = wh.getPart(pnum);
		for(int i=0; i<quant; i++)
		{
			wh.sell(pnum);
		}
		enter(part+(quant));
		return this.getName()+"\n"+this.checkWarehouse();
	}
	

}
