package com.example.trackyourthings.transfer;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateItemRequest {

    @NotNull
    private String name;
    @NotNull
    private String place;
    private String fromWho;
    private LocalDateTime dateTime;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "CreateItemRequest{" +
                "name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", fromWho='" + fromWho + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}