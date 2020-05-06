package com.company.products;

import java.time.LocalDate;

public class Case extends Product {
    private String model;
    private String type;
    private String dimensions;
    private int maximumGPULength;
    static String cat = "Case";

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

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public int getMaximumGPULength() {
        return maximumGPULength;
    }

    public void setMaximumGPULength(int maximumGPULength) {
        this.maximumGPULength = maximumGPULength;
    }

    public Case(float price, int stock, String manufacturer, String model, String type, String dimensions) {
        super(price, stock, manufacturer);
        this.model = model;
        this.type = type;
        this.dimensions = dimensions;
    }

    @Override
    public void GeneralInfo() {
        System.out.println(getManufacturer() + " " + getModel() + "\n" + getDimensions() + "\n");
        super.GeneralInfo();
    }

    public Case(float price, int stock, LocalDate purchaseDate, String manufacturer, String color, String model, String type, String dimensions, int maximumGPULength) {
        super(price, stock, purchaseDate, manufacturer, color);
        this.model = model;
        this.type = type;
        this.dimensions = dimensions;
        this.maximumGPULength = maximumGPULength;
    }
}
