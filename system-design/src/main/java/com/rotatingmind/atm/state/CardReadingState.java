package com.rotatingmind.atm.state;

import com.rotatingmind.atm.ATM;
import com.rotatingmind.atm.card.CardDetails;
import com.rotatingmind.atm.card.CardManagerFactory;
import com.rotatingmind.atm.db.DBAccessor;

public class CardReadingState implements IState {

    private final ATM atm;

    public CardReadingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int init() {
        throw new IllegalStateException();
    }

    @Override
    public boolean readCard(CardDetails cardDetails) {
        boolean result = CardManagerFactory
                .getCardManager(cardDetails.getCardType())
                .validateCard(cardDetails);
        DBAccessor.persistCardDetails(cardDetails,
                this.atm.getMachineId());
        if (result) {
            this.atm.changeState(new WithdrawalDetailsReadingState(this.atm));
        } else {
            DBAccessor.disapproveTransaction(this.atm.getMachineId());
            this.atm.changeState(new ReadyState(this.atm));
        }
        return true;
    }

    @Override
    public boolean cancelTransaction(int transId) {
        DBAccessor.cancelTransaction(transId);
        this.atm.changeState(new ReadyState(this.atm));
        return true;
    }

    @Override
    public boolean readWithdrawalDetails(CardDetails cardDetails, int transId, float amount) {
        throw new IllegalStateException();
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
        return ATMState.CARD_READING;
    }
}
