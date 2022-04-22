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
    public long car_id() {
        return car_id;
    }
    public void setCar_id(long id) {
        this.car_id = id;
    }
    public String getVendor() {
        return Vendor;
    }
    public void setVendor(String vendor) {
        this.Vendor = vendor;
    }
    public String getModel() {
        return Model;
    }
    public void setModel(String model) {
        this.Model = model;
    }
    public String getBody() {
        return Body_type;
    }
    public void setBody_type(String body_type) {
        this.Body_type = body_type;
    }
    public String getColor() {
        return Color;
    }
    public void setColor(String color){
        this.Color = color;
    }
    public String Fuel_type(){
        return Fuel_type;
    }
    public void setFuel_type(String fuel_type){
        this.Fuel_type = Fuel_type;
    }
    public String getDrive_type(){
        return Drive_type;
    }
    public void setDrive_type(String drive_type){
        this.Drive_type = drive_type;
    }
    public String getType_of_gearbox() {
        return Type_of_gearbox;
    }
    public void setType_of_gearbox(String type_of_gearbox) {
        this.Type_of_gearbox = type_of_gearbox;
    }
    public String getCountry_of_origin() {
        return Country_of_origin;
    }
    public void setCountry_of_origin(String country_of_origin) {
        this.Country_of_origin = country_of_origin;
    }
    public int getYear() {
        return Year;
    }
    public void setYear(int year){
        this.Year = year;
    }
    @Override
    public String toString() {
        return "#"+car_id+"'%-3s'"+Vendor+"'%-3s'-"+Model+"'%-3s'"+Color;
    }
}
