package com.dxctraining.complaints.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Complaints {
   @GeneratedValue
   @Id
    private int id;
    private String description;
    private int consumerId;
    public Complaints(String descp,int consumerId) {
        this.description = description;
        this.consumerId=consumerId;
    }

    public Complaints()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }
}
