/**
 * @author dennisjr
 */

import java.util.ArrayList;
import java.util.List;

public class WareHouse {
	private List<Inventory> whDB;
    public WareHouse() {
        whDB = new ArrayList<Inventory>();
    }
    
    /**
     * finds an Inventory
     * @param bp
     * @return
     */
    
    private Inventory findInventory(BikePart bp) {
        for (Inventory i : whDB) {
            if (i.getBikePart().equals(bp))
                return i;
        }
        return null;
    }
    
    /**
     * updates Inventory
     * @param i
     * @param b
     * @param quantity
     */
    
    private void updateInventory(Inventory i, BikePart b, int quantity) {
        i.getBikePart().setPrice(b.getPrice());
        i.getBikePart().setSalesPrice(b.getSalesPrice());
        i.getBikePart().setOnSale(b.isOnSale());
        i.setCount(i.getCount() + quantity);
    }
    
    /**
     * adds Inventory
     * @param bp
     * @param quantity
     */

    public void addInventory(BikePart bp, int quantity) {
    	Inventory i = findInventory(bp);
    	if (i != null)
    		updateInventory(i, bp, quantity);
    	else
    		whDB.add(new Inventory(bp,quantity));
    	}
}
