package secondWeekEnd;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurantTable")
public class RestaurantTable {

    @Id
    @Column(name = "number", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column
    private int capacity;

    @OneToMany(mappedBy = "restaurantTable", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public RestaurantTable(int capacity) {
        this.capacity = capacity;
    }

    public RestaurantTable() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int id) {
        this.number = id;
    }

}
