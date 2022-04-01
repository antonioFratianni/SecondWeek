package jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personId")
    private String id;

    @Column(length = 30)
    private String lastName;

    @Column(length = 30)
    private String name;

    @OneToMany(
            mappedBy = "family"
            , cascade = { CascadeType.ALL}
    )

    private List<Person> persons = new ArrayList<Person>();

}
