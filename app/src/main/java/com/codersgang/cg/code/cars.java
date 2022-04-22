package com.codersgang.cg.code;

public class cars {
    private long car_id;
    private String Vendor;
    private String Model;
    private String Color;
    private String Body_type;
    private String Fuel_type;
    private String Drive_type;
    private String Type_of_gearbox;
    private String Country_of_origin;
    private int Year;

    public cars() {
        super();
    }

    public cars(long car_id, String vendor, String model, String color, String body_type) {
        super();
        this.car_id = car_id;
        this.Vendor = vendor;
        this.Model = model;
        this.Color = color;
        this.Body_type = body_type;
    }

    public cars(String vendor, String model, String color, String body_type, String fuel_type) {
        super();
        this.Vendor = vendor;
        this.Model = model;
        this.Color = color;
        this.Body_type = body_type;
        this.Fuel_type = fuel_type;
    }
}
