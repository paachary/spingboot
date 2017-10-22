package com.restapi.db.databaserestapi;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="personal_bankmembership")
public class BankMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="personal_bankmembership_id_seq")
    @SequenceGenerator(name="personal_bankmembership_id_seq", sequenceName="personal_bankmembership_id_seq", allocationSize=1)
    @Column(name = "id")
    private Long id;

    private String acctType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private personal_personalinfo personalinfo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id")
    @JsonBackReference
    private BankInfo bankInfo;

    public BankMembership(Long id, String acctType) {
       this.id = id;
       this.acctType = acctType;
    }

    protected BankMembership() {
    }
    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }

    public personal_personalinfo getPersonalinfo() {
        return personalinfo;
    }

    public void setPersonalinfo(personal_personalinfo personalinfo) {
        this.personalinfo = personalinfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
