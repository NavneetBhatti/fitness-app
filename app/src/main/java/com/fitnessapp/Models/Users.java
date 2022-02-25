package com.fitnessapp.Models;

public class Users {

    private String username, email,dob,weight,gender,recType;
    private int age;

    public Users(String username, String email, String dob, int age, String weight, String gender, String recType) {
        this.username = username;
        this.email = email;
        this.dob = dob;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
        this.recType = recType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRecType() {
        return recType;
    }

    public void setRecType(String recType) {
        this.recType = recType;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", age='" + age + '\'' +
                ", weight='" + weight + '\'' +
                ", gender='" + gender + '\'' +
                ", recType='" + recType + '\'' +
                '}';
    }
}
