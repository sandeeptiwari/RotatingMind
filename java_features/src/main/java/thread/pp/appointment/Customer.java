package thread.pp.appointment;

public class Customer implements Runnable {
    private final int appointmentId;

    private final TickingBoard tickingBoard;

    public Customer(int appointmentId, TickingBoard tickingBoard) {
        this.appointmentId = appointmentId;
        this.tickingBoard = tickingBoard;
    }

    @Override
    public void run() {
        while(tickingBoard.isMyTurn(appointmentId)) {
            System.out.println(appointmentId + "denied turn");
        }

        System.out.println(appointmentId + "Get Enter");
    }
}
