package com.company.products;

import java.time.LocalDate;

public class PowerSupply extends Product {
    private String model;
    private String type;
    private int wattage;
    private String modular;
    private String efficiencyCert;
    static String cat = "PowerSupply";

    @Override
    public String getCat() { return cat;}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    public String getModular() {
        return modular;
    }

    public void setModular(String modular) {
        this.modular = modular;
    }

    public String getEfficiencyCert() {
        return efficiencyCert;
    }

    public void setEfficiencyCert(String efficiencyCert) {
        this.efficiencyCert = efficiencyCert;
    }

    public PowerSupply(float price, int stock, String manufacturer, String model, String type, int wattage, String modular, String efficiencyCert) {
        super(price, stock, manufacturer);
        this.model = model;
        this.type = type;
        this.wattage = wattage;
        this.modular = modular;
        this.efficiencyCert = efficiencyCert;
    }

    public PowerSupply(float price, int stock, LocalDate purchaseDate, String manufacturer, String color, String model, String type, int wattage, String modular, String efficiencyCert) {
        super(price, stock, purchaseDate, manufacturer, color);
        this.model = model;
        this.type = type;
        this.wattage = wattage;
        this.modular = modular;
        this.efficiencyCert = efficiencyCert;
    }

    @Override
    public void GeneralInfo() {
        System.out.println(getManufacturer() + " " + getModel());
        super.GeneralInfo();
    }
}
