package restaurant;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "restaurantTable")
public class RestaurantTable {

    @Id
    @Column(name = "number", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column
    private int capacity;

    public int getNumber() {
        return number;
    }

    public void setNumber(int id) {
        this.number = id;
    }

}
