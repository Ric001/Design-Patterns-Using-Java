package org.commons.oca;

import java.util.Objects;
import java.util.logging.Logger;

public class BankAccount {

    String accountNumber;
    int accountType;
    
    final static Logger _LOG = Logger.getLogger(BankAccount.class.getName());

    
    
    public boolean equals(BankAccount bankAccount) {
        _LOG.info("[ENTERING boolean equals(BankAccount bankAccount)]");

        if (Objects.nonNull(bankAccount))
            return (accountNumber.equals(bankAccount.accountNumber) && accountType == bankAccount.accountType);
        
        _LOG.info("[ENDING boolean equals(BankAccount bankAccount)]");
        return false;
    }
}