package com.example.sasha.myapplication_currentcourses.model;

/**
 * Created by sasha on 17.09.15.
 */
public class Currencies {
    private String id;
    private String name;
    private String ask;
    private String bid;

    public Currencies(String id, String name, String ask, String bid) {
        this.id = id;
        this.name = name;
        this.ask = ask;
        this.bid = bid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Currencies{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ask='" + ask + '\'' +
                ", bid='" + bid + '\'' +
                '}';
    }
}
