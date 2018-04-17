package Project3;

import person.Person;

public class OfficeManager extends LoginAccount {

    /**
     * Data member
     */
    private AccountType accountType;

    /**
     * @param p = office manager
     * @param userName Username of office manager
     * @param passWord Password of office manager
     */
    public OfficeManager(Person p, String userName, String passWord) {
        super(p, userName, passWord);
        accountType = AccountType.OFFICE_MANAGER;
    }

    /**
     * Get account type
     * @return Account type
     */
    @Override
    public AccountType getType() {
        return accountType;
    }

}