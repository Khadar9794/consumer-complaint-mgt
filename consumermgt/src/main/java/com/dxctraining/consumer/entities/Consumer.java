package com.dxctraining.consumer.entities;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Consumer {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public Consumer(String name) {
        this.name = name;
    }

    public Consumer()
    {

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
