package secondWeekEnd;

import javax.persistence.*;

@Entity
@Table(name = "reservation")

public class Reservation {

    @Column(name = "reservationId")
    @EmbeddedId
    private ReservationId reservationId;

    @Column
    private int numberOfPersons;

    @Column
    private Long phoneNumber;

    @ManyToOne
    @JoinColumn(name="reservationId", referencedColumnName="number")
    private RestaurantTable restaurantTable;

    public Reservation() {
    }

    public Reservation(ReservationId reservationId, int numberOfPersons, Long phoneNumber) {
        this.reservationId = reservationId;
        this.numberOfPersons = numberOfPersons;
        this.phoneNumber = phoneNumber;
    }
}
