package project3;

import person.Person;

public class SystemAdmin extends LoginAccount {

    /**
     * Data member
     */
    private AccountType accountType;

    /**
     * System Administrator constructor
     * @param p = system administrator
     * @param userName Username of system administrator
     * @param passWord Password of system administrator
     */
    public SystemAdministrator(Person p, String userName, String passWord) {
        super(p, userName, passWord);
        accountType = AccountType.ADMIN;
    }

    /**
     * Get account type
     * @return System administrator account type
     */
    @Override
    public AccountType getType() {
        return accountType;
    }

}