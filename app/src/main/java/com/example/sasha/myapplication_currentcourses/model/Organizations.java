package com.example.sasha.myapplication_currentcourses.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sasha on 13.09.15.
 */
public class Organizations {
    private String id;
    private String title;
    private String regionId;
    private String cityId;
    private String phone;
    private String address;
    private String link;
    private ArrayList<Currencies> currencieses;


    public Organizations(String id, String title, String regionId, String cityId, String phone, String address, String link, ArrayList<Currencies> currencieses) {
        this.id = id;
        this.title = title;
        this.regionId = regionId;
        this.cityId = cityId;
        this.phone = phone;
        this.address = address;
        this.link = link;
        this.currencieses = currencieses;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Currencies> getCurrencieses() {
        return currencieses;
    }

    public void setCurrencieses(ArrayList<Currencies> currencieses) {
        this.currencieses = currencieses;
    }

    @Override
    public String toString() {
        return "Organizations{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", regionId='" + regionId + '\'' +
                ", cityId='" + cityId + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", link='" + link + '\'' +
                ", currencieses=" + currencieses +
                '}';
    }
}


