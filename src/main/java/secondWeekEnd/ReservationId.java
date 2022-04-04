package secondWeekEnd;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.GregorianCalendar;


@Embeddable
public class ReservationId implements Serializable {

    private String surname;

    private GregorianCalendar date;

    public ReservationId(String surname, GregorianCalendar date) {
        this.surname = surname;
        this.date = date;
    }

    public ReservationId() {

    }
}
