/**
 * @author dennisjr
 */

public class Inventory { //Similar to Lab 7 and Project1 
	private BikePart bp;
	private int count;
	
	public Inventory(BikePart bp, int count) {
		this.bp = bp;
		this.count = count;
		}
	
	public BikePart getBikePart() {
		return bp;
	}
		
	public void setBikePart(BikePart bp) {
		this.bp = bp;
		}
		
	public int getCount() {
		return count;
		}
		
	public void setCount(int count) {
		this.count = count;
		
	}
	
	public String toString() {
		return "Inventory{" + "bp=" + bp + ", count=" + count + 
				'}';
	}
}
	
