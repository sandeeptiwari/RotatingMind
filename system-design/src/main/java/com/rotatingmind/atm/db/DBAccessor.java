package com.rotatingmind.atm.db;

import com.rotatingmind.atm.card.CardDetails;
import com.rotatingmind.atm.card.TransactionStatus;
import com.rotatingmind.atm.state.ATMState;

public class DBAccessor {
    private DBAccessor() {}

    public static ATMState getATMState(String machineId) {
        return ATMState.READY;
    }

    public static int createNewTransaction(String machineId) {
        return 1;
    }

    public static void updateATMState(String machineId, ATMState state) {

    }

    public static void persistCardDetails(CardDetails cardDetails, String machineId) {

    }

    public static void disapproveTransaction(String machineId) {

    }

    public static void cancelTransaction(int transId) {

    }

    public static void persistWithDetails(int transId, float amount, TransactionStatus status) {

    }

    public static float markAsExec(int transId) {return 0;}
}
