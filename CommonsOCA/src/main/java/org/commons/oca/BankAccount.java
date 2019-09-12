package org.commons.oca;

import java.util.logging.Logger;

public class BankAccount {
    String accountNumber;
    int accountType;

    final static Logger _LOG = Logger.getLogger(BankAccount.class.getName());

    @Override
    public boolean equals(Object anObject) {
        _LOG.info("[ENTERING boolean equals(Object anObject)]");
        if (!(anObject instanceof BankAccount)) 
            return false;

        BankAccount account =  (BankAccount) anObject;
        _LOG.info("[ENDING boolean equals(Object anObject)]");
        return (accountNumber.equals(accountNumber) && accountType == account.accountType);
    }
}