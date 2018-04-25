package Project3Classes;

import java.io.Serializable;

/**This is the class Bikepart.  It creates a bike part for the warehouse/store to sell.
It lists the part name, number, regular price, sale price, if it's on sale, 
and how many are left */
class Bikepart implements Serializable{
   private String partname;
   private int partnumber;
   private double listprice;
   private double saleprice;
   private boolean onsale;
   private int quantity;

   /**Initializes the bike part and it's variables */
   Bikepart(){
      partname="";
      partnumber=0;
      listprice=0.0;
      saleprice=0.0;
      onsale=false;
      quantity=0;
   }
   /**sets the variables from the file to the variables in bike part*/
   Bikepart(String pname, int pnum, double lp, double sp, boolean sale, int numleft){
      partname=pname;
      partnumber=pnum;
      listprice=lp;
      saleprice=sp;
      onsale=sale;
      quantity=numleft;
   }
   /**gets the name from the user/file*/
   public String getpartname(){
      return partname;
   }
   /**sets the name to the bike part*/
   public void setpartname(String pname){
      partname=pname;
   }
   /**gets the part number from user/file*/
   public int getpartnumber(){
      return partnumber;
   }
   /**sets the part number to the bike part*/
   public void setpartnumber(int pnum){
      partnumber=pnum;
   }
   /**gets the list price from the user/file*/
   public double getlistprice(){
      return listprice;
   }
   /**sets the list price to the bike part*/
   public void setlistprice(double lp){
      listprice=lp;
   }
   /**gets the sale price from the user/file*/
   public double getsaleprice(){
      return saleprice;
   }
   /**sets the sale price to the bike part*/
   public void setsaleprice(double sp){
      saleprice=sp;
   }
   /**gets whether or not the part is on sale from the user/file*/
   public boolean getonsale(){
      return onsale;
   }
   /**sets whether or not the part is on sale to the bike part*/
   public void setonsale(boolean sale){
      onsale=sale;
   }
   /**gets the quantity of the bike part from the user/file*/
   public int getquantity(){
      return quantity;
   }
   /**sets the quantity of the bike part to the bike part*/
   public void setquantity(int numleft){
      quantity=numleft;
   }
   public String toString() {
	   return getpartname()+" "+getpartnumber()+" "+getlistprice()+" "+getsaleprice()+" "+getonsale()+" "+getquantity();
   }
}