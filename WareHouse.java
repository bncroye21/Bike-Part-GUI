/**
 * @author dennisjr
 */

import java.util.ArrayList;

public class WareHouse {
    private ArrayList<String> bp;
    public WareHouse(ArrayList<String> bp) {
        this.bp = bp;
    }
    public ArrayList<String> getInventory(){ return bp;}
}