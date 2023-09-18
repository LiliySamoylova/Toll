package jd.dao;


import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "NAME")
    String namePerson;

    @Column(name = "PASSWORD")
    String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", namePerson='" + namePerson + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
