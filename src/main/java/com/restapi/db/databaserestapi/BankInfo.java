package com.restapi.db.databaserestapi;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "personal_bankinfo")
public class BankInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="personal_bankinfo_id_seq")
    @SequenceGenerator(name="personal_bankinfo_id_seq", sequenceName="personal_bankinfo_id_seq", allocationSize=1)
    @Column(name = "id")
    private Long id;

    private String name;
    private String branch;
    private String address;
    private String phone_nbr;
    private String bnk_abbr_name;
    private String brn_abbr_name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bankInfo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<BankMembership> bankMembershipDtls;

    public BankInfo(String name, String branch, String address, String phone_nbr, String bnk_abbr_name, String brn_abbr_name) {
        this.address = address;
        this.bnk_abbr_name = bnk_abbr_name;
        this.brn_abbr_name = brn_abbr_name;
        this.branch = branch;
        this.name= name;
    }

    protected BankInfo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_nbr() {
        return phone_nbr;
    }

    public void setPhone_nbr(String phone_nbr) {
        this.phone_nbr = phone_nbr;
    }

    public String getBnk_abbr_name() {
        return bnk_abbr_name;
    }

    public void setBnk_abbr_name(String bnk_abbr_name) {
        this.bnk_abbr_name = bnk_abbr_name;
    }

    public String getBrn_abbr_name() {
        return brn_abbr_name;
    }

    public void setBrn_abbr_name(String brn_abbr_name) {
        this.brn_abbr_name = brn_abbr_name;
    }

    public Set<BankMembership> getBankMembershipDtls() {
        return bankMembershipDtls;
    }

    public void setBankMembershipDtls(Set<BankMembership> bankMembershipDtls) {
        this.bankMembershipDtls = bankMembershipDtls;
    }
}
