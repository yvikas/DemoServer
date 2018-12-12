package com.mangal.demoserver.Model;

public class User {

    private String Name,Password,Phone,IsStaff;

    public int getGetAddress() {
        return getAddress;
    }

    public void setGetAddress(int getAddress) {
        this.getAddress = getAddress;
    }

    public int getAddress;

    public int getGetTotal() {
        return getTotal;
    }

    public void setGetTotal(int getTotal) {
        this.getTotal = getTotal;
    }

    public int getTotal;

    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    public User() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }
}
