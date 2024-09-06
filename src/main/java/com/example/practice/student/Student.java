package com.example.practice.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private long id;

    private String name;
    private String email;
    private LocalDate dob;

    @Transient
    private Integer age;

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // Custom getter for age (derived field)
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    // public Long getId() {
    // return id;
    // }

    // public void setId(long id) {
    // this.id = id;
    // }

    // public String geString() {
    // return name;
    // }

    // public void setName(String name) {
    // this.name = name;
    // }

    // public String getEmail() {
    // return email;
    // }

    // public void setEmail(String email) {
    // this.email = email;
    // }

    // public LocalDate getDob() {
    // return dob;
    // }

    // public void setDob(LocalDate dob) {
    // this.dob = dob;
    // }

    // Override toString() if necessary, or let @Data handle it
    // @Override
    // public String toString() {
    // return "Student{" +
    // "id=" + id +
    // ", name='" + name + '\'' +
    // ", email='" + email + '\'' +
    // ", dob=" + dob +
    // ", age=" + age +
    // '}';
    // }

}