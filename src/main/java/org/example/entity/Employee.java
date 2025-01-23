package org.example.entity;

import java.util.Objects;

public class Employee {
    private int id;
    private  String firstname;
    private  String lastname;
//private tanımladık dışarıdan erişilesin diye.
    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }// getter ve setter metotları dışarıdan erişilebilmek için oluşturulur

    public String getLastname() {
        return lastname;
    }

    public Employee(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }// bu constructor üç parametre alır ve EMployee nesnesini oluşturur.

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(firstname, employee.firstname) && Objects.equals(lastname, employee.lastname);
    }// iki Employee nesnesinin id değerlerine göre eşit olup olmadığını kontrol eder

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }// hashCode Nesnelerin benzersiz bir hash değeri oluşturmasını sağlar bu özellikle HashSAet ve Hashmap için gereklidir.


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }// bu metot Employee nesnesini anlamlı bir şekilde string formatında oluşturmamızı sağlar.
}
