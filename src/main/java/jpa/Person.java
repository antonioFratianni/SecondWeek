package jpa;

import javax.persistence.*;

@Entity
public class Person {

    private long id;
    private String name;
    private String surname;
    private Family family;

    public Person(){}

    public Person(String name, String surname, Family city){
        this.name=name;
        this.surname=surname;
        this.family =city;
    }

    @Column
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }


    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Family.class)
    @JoinColumn(name="family_id")
    public Family getFamily() {
        return family;
    }
    public void setFamily(Family city) {
        this.family = city;
    }
}

