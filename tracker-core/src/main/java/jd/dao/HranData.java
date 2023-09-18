package jd.dao;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="HRAN_DATA")
public class HranData {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "SHIROTA")
    Double shirota;

    @Column(name = "DOLGOTA")
    Double dolgota;

    @Column(name = "AZIMYT")
    Double azimyt;

    public String toString() {
        return "HranData{ id=" + id + ", shirota=" + shirota+ ", dolgota=" + dolgota+ ", azimyt=" +azimyt + " }";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setShirota(Double shirota) {
        this.shirota = shirota;
    }

    public void setDolgota(Double dolgota) {
        this.dolgota = dolgota;
    }

    public void setAzimyt(Double azimyt) {
        this.azimyt = azimyt;
    }

    public Double getShirota() {
        return shirota;
    }

    public Double getAzimyt() {
        return azimyt;
    }

    public Double getDolgota() {
        return dolgota;
    }
}
