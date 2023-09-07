package jd.dao;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

/**
 * Created by jdev on 28.05.2017.
 */
@Entity
@Table(name="GPS")
public class Gps {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "MODEL")
    String model;

    public String toString() {
        return "GPS{ id=" + id + ", model=" + model+ " }";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
