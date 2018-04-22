/**
 * @author dennisjr
 * @return creates a Sales Associate
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesAssociate extends LoginAccount {
	private String wareHouseName; //similar to Lab 7
	private WareHouse wh;
	private List<SalesInvoice> salesInvoice;
	
	/**
	 * 
	 * @param person
	 * @param userName
	 * @param password
	 * @param wareHouseName
	 * @param wh
	 */
	
	public SalesAssociate(User person, String userName, String password, String wareHouseName, WareHouse wh) {
		super(person, userName, password);
		this.wareHouseName = wareHouseName;
		this.wh = wh;
		}
	
	/**
	 * @param si
	 * @return add a sales invoice
	 */
	
	public void addSalesInvoice(SalesInvoice si) { salesInvoice.add(si); }
	
	/**
	 * @param dateBegin
	 * @param dateEnd
	 * @return
	 */
	
	public List<SalesInvoice> getSales(Date dateBegin, Date dateEnd) {
        List<SalesInvoice> retList = new ArrayList<>();
        for (SalesInvoice si : salesInvoice) {
            if (dateBegin == null) {
                retList.add(si);
            }
          }
        return retList;
    }

	
	public String getWareHouseName() {
		return wareHouseName;
		}
		
	public WareHouse getWareHouse() { return wh; }
	}


