package jpa;

import javax.persistence.*;

@Entity
public class Family {

    private long id;
    private String name;

    public Family(){}

    public Family(String name){
        this.name=name;
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
}

