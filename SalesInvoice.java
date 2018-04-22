/**
 * @author dennisjr
 * @param Sales Invoice
 * @return a sales invoice  
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesInvoice {
	Date dateSold; //
    String customer; //customer
    List<Inventory> inventoryCount; //bpa and count
    String receiver; //who recieves the invoice
    double totalCost; //total cost of sales invoice
    
    /**
     * 
     * @param dateSold
     * @param customer
     * @return Sales Invoice characters
     */
    
    public SalesInvoice(Date dateSold, String customer) {
    	if (dateSold == null)
            this.dateSold = new Date();
        else
            this.dateSold = dateSold;
    	this.customer = customer;
        this.inventoryCount = new ArrayList<>();
        this.totalCost = 0;
    }
    /**
     *  @param ic
     *  @return adds a Sales Invoice
     */
    
    public void addSalesInvoice(Inventory ic) { //add sales invoice
    	inventoryCount.add(ic);
        totalCost += Double.parseDouble(ic.getBikePart().getSalesPrice());
    }
    
    /**
     * @param name
     * @return the person who recieved the sale's invoice
     */
    public void addReceivedBy(String name) { receiver = name; } 

    /**
     * @return the date sold
     */
    public Date getDateSold() { return dateSold; }
    
    /**
     * @param prints to string
     */

    public String toString() {
        String sa = "Invoice: " + customer + " Date: " + dateSold + "\n";
        for (Inventory ic : inventoryCount)
            sa += ic.toString() + "\n";
        sa += totalCost + "\n";
        return sa;
    }
}


