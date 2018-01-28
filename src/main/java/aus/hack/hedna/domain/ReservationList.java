package aus.hack.hedna.domain;

import java.util.Arrays;
import java.util.List;

public class ReservationList
{
    private List<Reservations> reservations;

    public List<Reservations> getReservations ()
    {
        return reservations;
    }

    public void setReservations (List<Reservations> reservations)
    {
        this.reservations = reservations;
    }

	@Override
	public String toString() {
		return "ReservationList [reservations=" + reservations + "]";
	}

}