package com.restapi.db.databaserestapi;

import javax.persistence.*;

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

        public personal_personalinfo(String firstName, String lastName,
                                     String middleName, String emailid,
                                     String gender, Integer age) {
            this.age= age;
            this.emailid = emailid;
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.gender = gender;
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

        @Override
        public String toString() {
            return
                    "{"+
                            "id=" + getId() +
                            ", firstName='"+ getFirstName()+'\''+
                            ", middleName='" + getMiddleName()+'\''+
                            ", lastName='" + getLastName()+'\''+
                            ", emailid='" + getEmailid()+'\''+
                            ", gender='" + getGender()+'\''+
                            ", age='" + getAge()+
                    '}';
        }
}
