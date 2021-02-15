package com.example.trackyourthings.transfer;

public class UpdateItemTypeFieldRequest {

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "UpdateItemTypeFieldRequest{" +
                "types='" + category + '\'' +
                '}';
    }

}
