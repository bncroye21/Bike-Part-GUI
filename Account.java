package Project3Classes;

public class Account extends Person implements Comparable<Account>{
	private String phonenumber;
	private String username;
	private String password;
	private int accounttype;
	private Person p;
	
	public Account()
	{
		phonenumber = "";
		username = "";
		password = "";
	}
	
	public Account(String un, String pw, Person ps, String pn)
	{
		username = un;
		password = pw;
		p = ps;
		phonenumber = pn;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(int accounttype) {
		this.accounttype = accounttype;
	}
	public String toString()
	{
		return username+"/t"+password+"/t"+phonenumber+"/t"+accounttype+"/t";
	}
	public int compareTo(Account a) {
		return p.getLastN().toLowerCase().compareTo(a.getLastN().toLowerCase());
	}
	public void setPerson(Person p){
		this.p = p;
	}

}
