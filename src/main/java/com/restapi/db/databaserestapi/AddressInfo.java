package com.restapi.db.databaserestapi;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="personal_addressinfo")
public class AddressInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="personal_addressinfo_id_seq")
    @SequenceGenerator(name="personal_addressinfo_id_seq", sequenceName="personal_addressinfo_id_seq", allocationSize=1)
    @Column(name = "id")
    private Long id;
    private String address_type;
    private Long door;
    private String street;
    private String city;
    private String state;
    private String country;
    private Long pin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private personal_personalinfo personalinfo;

    public AddressInfo(Long id, String address_type, Long door, String street, String city, String state, String country, Long pin) {
        this.address_type = address_type;
        this.door = door;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pin = pin;
    }

    protected AddressInfo() {
    }

    public String getAddress_type() {
        return address_type;
    }

    public void setAddress_type(String address_type) {
        this.address_type = address_type;
    }

    public Long getDoor() {
        return door;
    }

    public void setDoor(Long door) {
        this.door = door;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPin() {
        return pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
    }

    public personal_personalinfo getPersonalinfo() {
        return personalinfo;
    }

    public void setPersonalinfo(personal_personalinfo personalinfo) {
        this.personalinfo = personalinfo;
    }
}
