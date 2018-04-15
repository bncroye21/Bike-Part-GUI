import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesAssociate extends LoginAccount {
    private String wareHouseName;
    private WareHouse wh;
    //class that stores warehouse
    private List<SalesInvoice> salesInvoice;
    
    public SalesAssociate(String firstName, String lastName, String emailAddress, 
    String userName, String passWord, String wareHouseName) {
         super(new Person(firstName, lastName, emailAddress), userName, passWord);
          this.wareHouseName = wareHouseName;
          this.salesInvoice = new ArrayList<>();
    }
     
     public SalesVanWareHouse getWareHouse() { return (SalesVanWareHouse) wh; }
     
     public void addBikePart(BikePart bpa) { wh.addBikePart(bpa); }
     
     public void addSalesInvoice(SalesInvoice si) { salesInvoice.add(si); }
     
     public List<SalesInvoice> getSales(Date dateBegin, Date dateEnd) {
         List<SalesInvoice> returnList = new ArrayList<>();
            for (SalesInvoice s : salesInvoice) {
                 if (dateBegin == null) {
                     returnList.add(s);
                 }
            else {
                return returnList;
    }
    
    public void loadSalesVanWareHouse(String fromWh, String fileName) {
        //classthatstoreswarehouse.moveInventory(fromWhName, wareHouseName, fileName);
    }
}
