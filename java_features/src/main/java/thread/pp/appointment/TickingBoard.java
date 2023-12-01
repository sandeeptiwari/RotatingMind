package thread.pp.appointment;

import java.util.List;

public class TickingBoard {
    private final List<Integer> appointments;
    private int curr;

    public TickingBoard(List<Integer> appointments) {
        this.appointments = appointments;
        this.curr = 0;
    }

    public boolean isMyTurn(int appointmentId) {
        if (curr == appointments.size()) {
            throw new RuntimeException("No more appointments");
        }
        if (appointments.get(curr) != appointmentId)
            return false;

        curr++;

        return true;
    }
}
