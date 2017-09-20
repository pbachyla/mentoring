package com.epam.mentoring.bean;

import com.epam.mentoring.bean.converter.LocalDateFromJsonConverter;
import com.epam.mentoring.bean.converter.LocalDateToJsonConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "userIdGenerator", sequenceName = "userIdGenerator")
public class User implements Serializable {

    private static final long serialVersionUID = -5477331750038230316L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @Column(name = "user_first_name", nullable = false)
    private String firstName;

    @Column(name = "user_last_name")
    private String lastName;

    @Column(name = "user_job")
    private String job;

    @Column(name = "user_birth_day", columnDefinition = "DATE")
    @JsonSerialize(using = LocalDateToJsonConverter.class)
    @JsonDeserialize(using = LocalDateFromJsonConverter.class)
    private LocalDate birthDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(this, user);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

}