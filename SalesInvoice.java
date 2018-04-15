import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesInvoice {
    Date dateSold;
    String customer;
    List<warehouseInventory> InventoryParts;
    String receivedBy;
    double totalCost;

    public SalesInvoice(Date dateSold, String customer) {
        if (dateSold == null)
            this.dateSold = new Date();
        else
            this.dateSold = dateSold;
        this.customer = customer;
        this.InventoryParts = new ArrayList<>();
        this.totalCostOfInvoice = 0;
    }

    public void addInvoice(warehouseInventory wi) {
        InventoryParts.add(wi);
        totalCost += Double.parseDouble(wi.getBikePart().getSalePrice());
    }

    public void addReceivedBy(String name) { receivedBy = name; }

    public Date getDateOfSale() { return dateSold; }

    public String toString() {
        String invoiceOutput = "Invoice: " + customer + " Date: " + dateSold + "\n";
        for (warehouseInventory wi : InventoryParts)
            invoiceOutput += wi.toString() + "\n";
        invoiceOutput += totalCost + "\n";
        return sa;
    }
}

