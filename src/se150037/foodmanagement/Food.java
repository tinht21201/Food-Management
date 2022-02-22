/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se150037.foodmanagement;

import java.io.Serializable;

/**
 *
 * @author Huynh Trung Tin - SE150037
 */
public abstract class Food implements Serializable {

    private int id;
    private String name;
    private float weight;
    private String type;
    private String place;
    private String expiredDate;

    public Food() {
    }

    public Food(int id, String name, float weight, String type, String place, String expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + this.id + ", name=" + this.name + ", weight="
                + this.weight + ", type=" + this.type + ", place="
                + this.place + ", expiredDate=" + this.expiredDate + '}';
    }

}
