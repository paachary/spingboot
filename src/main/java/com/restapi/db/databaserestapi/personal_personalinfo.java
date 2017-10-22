package com.restapi.db.databaserestapi;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.jndi.cosnaming.IiopUrl;
import jdk.nashorn.api.scripting.JSObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class personal_personalinfo {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="personal_personalinfo_id_seq")
        @SequenceGenerator(name="personal_personalinfo_id_seq", sequenceName="personal_personalinfo_id_seq", allocationSize=1)
        @Column(name = "id")
        private Long id;
        private String lastName;
        private String firstName;
        private String middleName;
        private String emailid;

        private String gender;
        private Integer age;

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "personalinfo", cascade = CascadeType.ALL)
        @JsonManagedReference
        private Set<AddressInfo> addresses;

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "personalinfo", cascade = CascadeType.ALL)
        @JsonManagedReference
        private Set<BankMembership> bankMembershipDtls;

        public personal_personalinfo(String firstName, String lastName,
                                     String middleName, String emailid,
                                     String gender, Integer age,
                                     Set<AddressInfo> addresses,
                                     Set<BankMembership> bankMembershipDtls) {
            this.age= age;
            this.emailid = emailid;
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.gender = gender;
            this.addresses = addresses;
            this.bankMembershipDtls = bankMembershipDtls;
        }

        protected personal_personalinfo() {
            }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getEmailid() {
            return emailid;
        }

        public void setEmailid(String emailid) {
            this.emailid = emailid;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getGender() {
        return gender;
    }

        public void setGender(String gender) {
        this.gender = gender;
    }

        public Set<AddressInfo> getAddresses() {
            return addresses;
        }

        public void setAddresses(Set<AddressInfo> addresses) {
            this.addresses = addresses;
        }

        public ArrayList getBankMembershipDtls() {
            HashMap bankdetails = null;
            ArrayList bankmembership = new ArrayList();
            int counter = 0;
            for ( BankMembership bank : bankMembershipDtls  ) {
                bankdetails = new HashMap();
                bankdetails.put("bankid", bank.getBankInfo().getId());
                bankdetails.put("acctType", bank.getAcctType());
                bankdetails.put("bankName", bank.getBankInfo().getName());
                bankdetails.put("branchName", bank.getBankInfo().getBranch());
                bankmembership.add(counter++, bankdetails);
            }
          return bankmembership;
        }

        public void setBankMembershipDtls(Set<BankMembership> bankMembershipDtls) {
            this.bankMembershipDtls = bankMembershipDtls;
        }

/*        @Override
        public String toString() {
            String  result =
                    "PersonalInfo={"+
                            "id=" + getId() +
                            ", firstName='"+ getFirstName()+'\''+
                            ", middleName='" + getMiddleName()+'\''+
                            ", lastName='" + getLastName()+'\''+
                            ", emailid='" + getEmailid()+'\''+
                            ", gender='" + getGender()+'\''+
                            ", age='" + getAge()+
                    '}';

            if (addresses != null) {
                for (AddressInfo addressInfo : addresses) {
                    result += "Address={"+
                            "address_type='"+ addressInfo.getAddress_type()+'\''+
                            ",door='"+ addressInfo.getDoor()+'\''+
                            ",street='"+addressInfo.getStreet()+'\''+
                            ",city='"+addressInfo.getCity()+'\''+
                            ",country='"+addressInfo.getCountry()+'\''+
                            ",state='"+addressInfo.getState()+'\''+
                            ",pin='"+addressInfo.getPin()+
                            '}';
                }
            }
            return result;
        }
        */
}
