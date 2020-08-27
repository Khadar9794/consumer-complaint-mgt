package com.dxctraining.complaints.dto;

public class ComplaintDto {
    private int id;
    private String description;
    private int consumerId;
    private String name;

    public ComplaintDto(int id, String description, int consumerId, String name) {
        this.id = id;
        this.description = description;
        this.consumerId = consumerId;
        this.name = name;
    }
    public ComplaintDto()
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

    public String getName() {
        return name;
    }

    public void setConsumerName(String name) {
        this.name = name;
    }
}