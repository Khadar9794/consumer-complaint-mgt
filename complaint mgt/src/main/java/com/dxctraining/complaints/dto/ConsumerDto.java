package com.dxctraining.complaints.dto;

public class ConsumerDto {
    private int id;
    private String name;

    public ConsumerDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public ConsumerDto()
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
