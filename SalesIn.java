package project3;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;

import application.BikePart;

public class SalesIn implements Serializable{

    String cStore;
    String cReceived;
    ArrayList<BikePart> partsSold;
    SalesAsso emplSold;
    Date sellDate;

    static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd 'at' hh:mm:ss a zzz");
    public SalesIn(String cStore, String cReceived, ArrayList<BikePart> partsSold, SalesAsso emplSold) {
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

    public SalesIn() {}
    public String getStore() {
        return cStore;
    }
    public String getCustomer() {
        return cReceived;
    }
    public ArrayList<BikePart> getParts() {
        return partsSold;
    }
    public SalesAsso getEmployee() {
        return emplSold;
    }
    public Date getDate() {
        return sellDate;
    }

    public String toString() {
        String output = "";
        output += ("Sales Invoice for " + this.cStore + ", " + dateFormat.format(sellDate) + "\n");
        output += String.format("%-20s %-16s %-10s %-14s %-16s\n","Part Name","Part Number","Price","Quantity","Total");
        for(BikePart loop : partsSold) {
            output += String.format("%-20s %-16s %-10s %-14s %-16s\n",loop.getName(),loop.getNumber(),loop.getActivePrice(),loop.getStock(),loop.getTotalCost());
        }
        output += String.format("%-20s %-16s %-10s %-14s %-16s\n","Total Cost:","","","",this.getProfit());
        output += ("Sold by: " + this.getEmployee().getfirstN() + " " + this.getEmployee().getlastN() + "\n");
        output += ("Received by: " + this.cReceived);
        return output;
    }
    /**
     * This method returns a condensed version of the toString() method.
     * This will not be as human-readable as toString(), but is best for most efficient data storage.
     * @return An ArrayList with index 0 containing the information about the invoice itself, and the remaining indices containing information about BikeParts.
     */

    public ArrayList<String> toStringCondensed() {

        /**cStore,customerEmployee,SaleDate
         * partName,partNum,partListPrice,partSalesPrice,partOnSale,partQuan
        */

        ArrayList<String> output = new ArrayList<String>();
        output.add(this.cStore + "," + this.cReceived + "," + this.sellDate.getTime());
        for(BikePart part : this.partsSold) {
            output.add(part.getAll());
        }
        return output;
    }

    public double getProfit() {
        double commission = 0;
        for(BikePart tempPart : this.getParts()) {
            commission += tempPart.getTotalCost();
        }
        return commission;
    }
    public void addPart(BikePart newPart) {
        partsSold.add(newPart);

    }

}