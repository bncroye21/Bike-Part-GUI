package Project3Classes;
import java.util.ArrayList;

public class SystemAdministrator extends Account
{
	    /**
	     * Data member
	     */

	    /**
	     * System Administrator constructor
	     * @param p = system administrator
	     * @param userName Username of system administrator
	     * @param passWord Password of system administrator
	     */
	    public SystemAdministrator(String userName, String passWord, Person p, String pn) 
	    {
	        super(userName, passWord, p, pn);
	        this.setAccounttype(0);
	    }
	    
	    public void createAccount(ArrayList<Account> ac, ArrayList accountsType, String userName, String passWord, Person p, 
	    		String pn, SalesVan sv, int at)
	    {
	    		boolean validUsername = true;
	    		boolean validName = true;
	    		boolean validEmail = true;
	    		if(at==0)
	    		{
	    			if(!userName.equals(null))
	    			{
	    				for(Account a : ac)
	    				{
	    					if(userName.equals(a.getUsername()))
	    					{
	    						validUsername = false;
	    						break;
	    					}
	    				}
	    			}
	    			if(p.getFirstN().equals(null) || p.getLastN().equals(null))
	    			{
	    				validName = false;
	    			}
	    			if(!p.getEmailAddress().equals(null))
	    			{
	    				for(Account a : ac)
	    				{
	    					if(p.getEmailAddress().equals(a.getEmailAddress()))
	    					{
	    						validEmail = false;
	    						break;
	    					}
	    				}
	    			}
	    			if(validUsername&&validName&&validEmail)
	    			{
	    				accountsType.add(new SystemAdministrator(userName, passWord, p, pn));
	    				ac.add((Account) accountsType.get(accountsType.size()-1));
	    			}
	    		}
	    		else if(at==1)
	    		{
	    			if(!userName.equals(null))
	    			{
	    				for(Account a : ac)
	    				{
	    					if(userName.equals(a.getUsername()))
	    					{
	    						validUsername = false;
	    						break;
	    					}
	    				}
	    			}
	    			if(p.getFirstN().equals(null) || p.getLastN().equals(null))
	    			{
	    				validName = false;
	    			}
	    			if(!p.getEmailAddress().equals(null))
	    			{
	    				for(Account a : ac)
	    				{
	    					if(p.getEmailAddress().equals(a.getEmailAddress()))
	    					{
	    						validEmail = false;
	    						break;
	    					}
	    				}
	    			}
	    			if(validUsername&&validName&&validEmail)
	    			{
	    				accountsType.add(new OfficeManager(userName, passWord, p, pn));
	    				ac.add((Account) accountsType.get(accountsType.size()));
	    			}
	    		}
	    		else if(at==2)
	    		{
	    			if(!userName.equals(null))
	    			{
	    				for(Account a : ac)
	    				{
	    					if(userName.equals(a.getUsername()))
	    					{
	    						validUsername = false;
	    						break;
	    					}
	    				}
	    			}
	    			if(p.getFirstN().equals(null) || p.getLastN().equals(null))
	    			{
	    				validName = false;
	    			}
	    			if(!p.getEmailAddress().equals(null))
	    			{
	    				for(Account a : ac)
	    				{
	    					if(p.getEmailAddress().equals(a.getEmailAddress()))
	    					{
	    						validEmail = false;
	    						break;
	    					}
	    				}
	    			}
	    			if(validUsername&&validName&&validEmail)
	    			{
	    				accountsType.add(new WarehouseManager(userName, passWord, p, pn));
	    				ac.add((Account) accountsType.get(accountsType.size()-1));
	    			}
	    		}
	    		else if(at==3)
	    		{
	    			if(!userName.equals(null))
	    			{
	    				for(Account a : ac)
	    				{
	    					if(userName.equals(a.getUsername()))
	    					{
	    						validUsername = false;
	    						break;
	    					}
	    				}
	    			}
	    			if(p.getFirstN().equals(null) || p.getLastN().equals(null))
	    			{
	    				validName = false;
	    			}
	    			if(!p.getEmailAddress().equals(null))
	    			{
	    				for(Account a : ac)
	    				{
	    					if(p.getEmailAddress().equals(a.getEmailAddress()))
	    					{
	    						validEmail = false;
	    						break;
	    					}
	    				}
	    			}
	    			if(validUsername&&validName&&validEmail)
	    			{
	    				accountsType.add(new SalesAssociate2(userName, passWord, p, pn, sv));
	    				ac.add((Account) accountsType.get(accountsType.size()-1));
	    			}
	    		}
	    		else
	    		{
	    			System.out.println("Error");
	    		}
	    }
	    
	    public Boolean changePassword(ArrayList<Account> ac, String usern, String pssw)
	    {
	    		for(Account x : ac)
	    		{
	    			if(x.getUsername().equals(usern))
	    			{
	    				x.setPassword(pssw);
	    				return true;
	    			}
	    		}
	    		return false;
	    }
}