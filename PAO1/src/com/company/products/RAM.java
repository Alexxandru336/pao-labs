package com.company.products;

import java.time.LocalDate;

public class RAM extends Product {

    private String type;
    private String speed;
    private int Size;
    private float voltage;
    static String cat = "RAM";

    @Override
    public String getCat() { return cat;}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public float getVoltage() {
        return voltage;
    }

    public void setVoltage(float voltage) {
        this.voltage = voltage;
    }

    public RAM(float price, int stock, String manufacturer, String type, String speed, int size) {
        super(price, stock, manufacturer);
        this.type = type;
        this.speed = speed;
        Size = size;
    }

    public RAM(float price, int stock, LocalDate purchaseDate, String manufacturer, String color, String type, String speed, int size, float voltage) {
        super(price, stock, purchaseDate, manufacturer, color);
        this.type = type;
        this.speed = speed;
        Size = size;
        this.voltage = voltage;
    }
    public RAM(RAM ram){
        super(ram.getPrice(), ram.getStock(), ram.getPurchaseDate(), ram.getManufacturer());
        this.type = ram.getType();
        this.speed = ram.getSpeed();
        this.Size = ram.getSize();
        this.voltage = ram.getVoltage();
    }
    @Override
    public void GeneralInfo() {
        System.out.println(getManufacturer() + " " + getSize() + "GB " + getSpeed());
        super.GeneralInfo();
    }
}
