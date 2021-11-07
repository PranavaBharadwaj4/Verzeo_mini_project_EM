package com.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "employeeTbl")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private String name;
    private Integer age;
    private String email;
    private Long contact;
    private Double salary;
    private String department;

    public Integer getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public Long getContact() {
        return contact;
    }

    public Double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
