package com.rotatingmind.atm.state;

import com.rotatingmind.atm.ATM;
import com.rotatingmind.atm.card.CardDetails;
import com.rotatingmind.atm.db.DBAccessor;

public class ReadyState implements IState {

    private final ATM atm;

    public ReadyState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int init() {
        int transId;
        transId = DBAccessor.createNewTransaction(this.atm.getMachineId());
        if (transId == 0)
            throw new RuntimeException("Unable to start txn");
        this.atm.changeState(new CardReadingState(this.atm));
        return transId;
    }

    @Override
    public boolean readCard(CardDetails cardDetails) {
        throw new IllegalStateException("Currently in ready state, can't read card");
    }

    @Override
    public boolean cancelTransaction(int transId) {
        throw new IllegalStateException("No Transaction in progress");
    }

    @Override
    public boolean readWithdrawalDetails(CardDetails cardDetails, int transId, float amount) {
        throw new IllegalStateException("Currently in ready state, can't read WithdrawalDetails");
    }

    @Override
    public float dispenseCash(int transId) {
        throw new IllegalStateException("Currently in ready state, can't dispense Cash");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Currently in ready state, can't eject Card");
    }

    @Override
    public ATMState getStateName() {
        return ATMState.READY;
    }


}
