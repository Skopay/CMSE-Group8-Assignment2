package com.cmsegroup8.searchba.Model;

public class Trees {

    public int id;
    public String name;

    public Trees(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Trees() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
