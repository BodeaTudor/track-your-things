package com.example.trackyourthings.transfer;

public class UpdateItemTypeFieldRequest {

    private String types;

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "UpdateItemTypeFieldRequest{" +
                "types='" + types + '\'' +
                '}';
    }

}
