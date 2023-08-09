package com.ohgiraffers.section01.model.dto;

public class LocationDTO {

    private int code;
    private String name;
    private String menu;
    private int categoryCode;
    private String subway;

    public LocationDTO() {
    }

    public LocationDTO(int code, String name, String menu, int categoryCode, String subway) {
        this.code = code;
        this.name = name;
        this.menu = menu;
        this.categoryCode = categoryCode;
        this.subway = subway;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getSubway() {
        return subway;
    }

    public void setSubway(String subway) {
        this.subway = subway;
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", menu='" + menu + '\'' +
                ", categoryCode=" + categoryCode +
                ", subway='" + subway + '\'' +
                '}';
    }
}
