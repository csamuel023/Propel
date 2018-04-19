package com.example.christophersamuel.propel;

import java.util.ArrayList;

public class User {

    private int userNum; // user number (tag) i.e. 1 - 10;
    private String name;
    private String username;
    private String password;
    private int age;
    private int weight;
    private double bmi;
    private boolean gender; // 0 male, 1 female
    private boolean active; // 0 passive, 1 active

    private ArrayList<ArrayList<String>> schedule;

    public User (String username, String password) {
        this.username = username;
        this.password = password;

        schedule = new ArrayList<ArrayList<String>>();

    }

    public ArrayList<ArrayList<String>> getSchedule() {
        return schedule;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
