package com.company;

public class User {

    private String name;
    private String lastNme;

    public User() {
    }


    public User(String name, String lastNme) {
        this.name = name;
        this.lastNme = lastNme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNme() {
        return lastNme;
    }

    public void setLastNme(String lastNme) {
        this.lastNme = lastNme;
    }
}
