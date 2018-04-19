
public class Account implements Comparable<Account>{
	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;
	private String username;
	private String password;
	private int accounttype;
	
	public Account(String un, String pw, String em, String fn, String ln, String pn, int at)
	{
		username = un;
		password = pw;
		email = em;
		firstname = fn;
		lastname = ln;
		phonenumber = pn;
		accounttype = at;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return username+"/t"+password+"/t"+email+"/t"+firstname+"/t"+lastname+"/t"+phonenumber+"/t"+accounttype+"/t";
	}
	public int compareTo(Account a) {
		return this.getLastname().toLowerCase().compareTo(a.getLastname().toLowerCase());
	}

}
