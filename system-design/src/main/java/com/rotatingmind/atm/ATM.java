package com.rotatingmind.atm;

import com.rotatingmind.atm.card.CardDetails;
import com.rotatingmind.atm.db.DBAccessor;
import com.rotatingmind.atm.state.IState;
import com.rotatingmind.atm.state.StateFactory;

public class ATM {

    private IState state;
    private final String machineId;

    public ATM(String machineId) {
        this.machineId = machineId;
        this.state = StateFactory
                .getState(DBAccessor.getATMState(this.machineId),
                        this);
    }

    public int init() {
        int id = this.state.init();
        return id;
    }

    public boolean cancel(int transId) {
        return this.state.cancelTransaction(transId);
    }

    public boolean readCard(CardDetails cardDetails) {
        return this.state.readCard(cardDetails);
    }

    public boolean readWithdrawalDetails(CardDetails cardDetails, int transId, float amount) {
        return this.state.readWithdrawalDetails(cardDetails, transId, amount);
    }

    public float dispenseCash(int transId) {
        return this.state.dispenseCash(transId);
    }

    public void ejectCard() {
        this.state.ejectCard();
    }

    public IState getState() {
        return state;
    }

    public String getMachineId() {
        return machineId;
    }

    public void changeState(IState newState) {
        this.state = newState;
        DBAccessor.updateATMState(this.getMachineId(), newState.getStateName());
    }
}
