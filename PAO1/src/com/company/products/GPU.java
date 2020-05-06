package com.company.products;

import java.time.LocalDate;

public class GPU extends Product {
    private String model;
    private String chipset;
    private int memorySize;
    private double coreClock;
    private double boostClock;
    private boolean fan;
    private int displayPorts;
    static String cat = "GPU";

    @Override
    public String getCat() { return cat;}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public double getCoreClock() {
        return coreClock;
    }

    public void setCoreClock(float coreClock) {
        this.coreClock = coreClock;
    }

    public double getBoostClock() {
        return boostClock;
    }

    public void setBoostClock(float boostClock) {
        this.boostClock = boostClock;
    }

    public boolean isFan() {
        return fan;
    }

    public void setFan(boolean fan) {
        this.fan = fan;
    }

    public int getDisplayPorts() {
        return displayPorts;
    }

    public void setDisplayPorts(int displayPorts) {
        this.displayPorts = displayPorts;
    }

    public GPU(float price, int stock, String manufacturer, String model, String chipset, int memorySize, double coreClock, double boostClock) {
        super(price, stock, manufacturer);
        this.model = model;
        this.chipset = chipset;
        this.memorySize = memorySize;
        this.coreClock = coreClock;
        this.boostClock = boostClock;
    }

    public GPU(float price, int stock, LocalDate purchaseDate, String manufacturer, String color, String model, String chipset, int memorySize,
               double coreClock, double boostClock, boolean fan, int displayPorts) {
        super(price, stock, purchaseDate, manufacturer, color);
        this.model = model;
        this.chipset = chipset;
        this.memorySize = memorySize;
        this.coreClock = coreClock;
        this.boostClock = boostClock;
        this.fan = fan;
        this.displayPorts = displayPorts;
    }



    @Override
    public void GeneralInfo() {
        System.out.println(this.getManufacturer() + "\n" + this.getChipset() + "\n" + this.getModel() + " " + this.getCoreClock() );
        if(getBoostClock() != 0) System.out.println(this.getBoostClock());
        super.GeneralInfo();
    }
}
