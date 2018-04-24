package project3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import person.Person;

public class SalesAssociate extends LoginAccount implements Serializable {


    private String WarehouseName;
    private Warehouse warehouse;
    private AccountType accountType;
    private SalesVanWarehouse salesvanWH;
    private List<SalesInvoice> sales;

    public SalesAssociate(Person p, String userName, String password, String warehouseName) {
        super(p, userName, password);
        this.WarehouseName = warehouseName;
        salesvanWH = new SalesVanWarehouse(warehouseName, WarehouseType.SALES);
        Main.warehouseInventory.add(salesvanWH);
        accountType = AccountType.SALES_ASSOCIATE;
    }

    public String getWarehouseName() {
        return WarehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        WarehouseName = warehouseName;
    }

    public SalesVanWarehouse getWarehouse() {
        return salesvanWH;
    }
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = salesvanWH;
    }
=
    @Override
    public AccountType getType() {
        return accountType;
    }

    public List<SalesInvoice> getSales(Date startDate, Date endDate) {
        List<SalesInvoice> salesList = new ArrayList<>();
        for (SalesInvoice si : sales) {
            if (startDate == null) {
                salesList.add(si);
            }
            else {
                if (startDate.compareTo(si.getSaleDate()) <= 0 && endDate.compareTo(si.getSaleDate()) >= 0)
                    salesList.add(si);
            }
        }
        return salesList;
    }
}