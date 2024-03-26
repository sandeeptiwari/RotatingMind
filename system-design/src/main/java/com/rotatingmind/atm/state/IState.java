package com.rotatingmind.atm.state;

import com.rotatingmind.atm.card.CardDetails;

public interface IState {
    int init();

    boolean readCard(CardDetails cardDetails);

    boolean cancelTransaction(int transId);

    boolean readWithdrawalDetails(CardDetails cardDetails,
                                  int transId, float amount);

    float dispenseCash(int transId);

    void ejectCard();

    ATMState getStateName();


}
