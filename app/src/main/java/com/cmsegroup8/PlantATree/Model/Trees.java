package com.cmsegroup8.PlantATree.Model;

public class Trees {

    public int id;
    public String name;
    public String price;
    public String desc;
    public String colour;
    public String treeSize;


    public Trees(int id, String name, String price, String desc, String colour, String treeSize) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.colour = colour;
        this.treeSize = treeSize;
    }

    public Trees(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public Trees() {
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getTreeSize() {
        return treeSize;
    }

    public void setTreeSize(String treeSize) {
        this.treeSize = treeSize;
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
