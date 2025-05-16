package com.hniu.fgg.base;

public abstract class FingerType {
    protected int id;
    protected String name;

    public FingerType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void show() {
        System.out.print(id + ":" + name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}