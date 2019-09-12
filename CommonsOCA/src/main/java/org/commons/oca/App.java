package org.commons.oca;


import java.util.logging.Logger;

public class App 
{

    private final static Logger _LOG = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        final BankAccount account = new BankAccount();
        account.accountNumber = "0000013";
        account.accountType = 4;
        
        final BankAccount sAccount = new BankAccount();
        sAccount.accountNumber = "1112223344";
        sAccount.accountType = 3;

        System.out.println(account.equals(sAccount));
        System.out.println(account.equals(sAccount));
        System.out.println(account.accountNumber.equals(new String("abc")));
    }



}
