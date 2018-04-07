package ru.osetsky.jdbc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee
{
    private Integer id;
    private String firstName;
    private String lastName;
    private double income;

    public void setId(int id) {
        this.id = id;
    }

    public int getId (){
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName (){
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName (){
        return lastName;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getIncome (){
        return income;
    }
    //Getters and Setters
}