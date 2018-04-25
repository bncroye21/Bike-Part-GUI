package Project3Classes;
import java.io.Serializable;

public class Person implements Serializable {

	public String firstN;
	public String lastN;
	public String emailAddress;

	public Person(){
		firstN = "";
		lastN = "";
		emailAddress = "";
	}

	public Person(String firstN, String lastN, String emailAddress) {
		this.firstN = firstN;
		this.lastN = lastN;
		this.emailAddress = emailAddress;
	}

	public String getFirstN() {
		return firstN;
	}

	public void setFirstN(String firstN) {
		this.firstN = firstN;
	}

	public String getLastN() {
		return lastN;
	}

	public void setLastN(String lastN) {
		this.lastN = lastN;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return firstN + " " + lastN + " " + emailAddress;
	}
}
