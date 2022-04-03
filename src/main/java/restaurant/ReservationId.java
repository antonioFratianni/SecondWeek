package restaurant;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ReservationId implements Serializable {

    private String surname;

    private Date date;

    public ReservationId(String surname, Date date) {
        this.surname = surname;
        this.date = date;
    }

    public ReservationId() {

    }
}
