package restaurant;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @EmbeddedId
    private ReservationId reservationId;

    @Column
    private int numberOfPersons;

    @Column
    private Long phoneNumber;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="reservationId", referencedColumnName="number"),
    })
    private RestaurantTable restaurantTable;
}
