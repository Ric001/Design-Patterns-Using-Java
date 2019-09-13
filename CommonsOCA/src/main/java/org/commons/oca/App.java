package org.commons.oca;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        final BankAccount account = new BankAccount();
        account.accountNumber = "00023490";
        account.accountType = 4;
        final List<BankAccount> list = new ArrayList<>();
        list.add(account);
        final BankAccount acct2 = new BankAccount();
        acct2.accountNumber = "00023490";
        acct2.accountType = 4;
        //list.add(acct2);
        System.out.println(list.contains(acct2));
        
    }
}
