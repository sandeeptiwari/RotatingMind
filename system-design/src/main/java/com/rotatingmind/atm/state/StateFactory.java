package com.rotatingmind.atm.state;

import com.rotatingmind.atm.ATM;

public class StateFactory {
    private StateFactory() {}

    public static IState getState(ATMState atmState, ATM atm) {
        return switch (atmState) {
            case READY -> new ReadyState(atm);
            case CARD_READING -> new CardReadingState(atm);
            case WITHDRAWAL_DETAILS_READING -> new WithdrawalDetailsReadingState(atm);
            case CASH_DISPENSING -> new CashDispensingState(atm);
            case CARD_EJECTING -> new CardEjectingState(atm);
           /* default -> {
                throw new IllegalArgumentException("Invalid state");
            }*/
        };
    }
}
