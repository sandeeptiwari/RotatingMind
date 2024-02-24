package com.rotatingmind.atm.state;

import com.rotatingmind.atm.ATM;
import com.rotatingmind.atm.card.CardDetails;
import com.rotatingmind.atm.card.CardManagerFactory;
import com.rotatingmind.atm.card.TransactionStatus;
import com.rotatingmind.atm.db.DBAccessor;

public class WithdrawalDetailsReadingState implements IState {

    private final ATM atm;

    public WithdrawalDetailsReadingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int init() {
        throw new IllegalStateException();
    }

    @Override
    public boolean readCard(CardDetails cardDetails) {
        throw new IllegalStateException();
    }

    @Override
    public boolean cancelTransaction(int transId) {
        DBAccessor.cancelTransaction(transId);
        this.atm.changeState(new CardEjectingState(this.atm));
        return true;
    }

    @Override
    public boolean readWithdrawalDetails(CardDetails cardDetails,
                                         int transId, float amount) {
        boolean res = CardManagerFactory.getCardManager(cardDetails.getCardType())
                .validateWithdrawal(amount, transId);
        if (res) {
            this.atm.changeState(new CashDispensingState(this.atm));
            DBAccessor
                    .persistWithDetails(transId, amount, TransactionStatus.APPROVED);
        } else {
            this.atm.changeState(new CardEjectingState(this.atm));
            DBAccessor
                    .persistWithDetails(transId,
                            amount, TransactionStatus.NOT_APPROVED);
        }
        return res;

    }

    @Override
    public float dispenseCash(int transId) {
        throw new IllegalStateException();
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException();
    }

    @Override
    public ATMState getStateName() {
        return ATMState.WITHDRAWAL_DETAILS_READING;
    }
}
