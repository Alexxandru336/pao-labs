package com.company.products;

import java.time.LocalDate;

public class HDD extends SSD {
    private int rpm;
    static String cat = "HDD";

    @Override
    public String getCat() { return cat;}

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public HDD(float price, int stock, LocalDate purchaseDate, String manufacturer, String color, int capacity, int cache, int rpm) {
        super(price, stock, purchaseDate, manufacturer, color, capacity, cache);
        this.rpm = rpm;
    }

    public HDD(HDD hdd){
        super(hdd.getPrice(), hdd.getStock(), hdd.getPurchaseDate(), hdd.getManufacturer(), hdd.getColor(), hdd.getCapacity(), hdd.getCache());
        this.rpm = hdd.rpm;
    }
    @Override
    public void GeneralInfo() {
        super.GeneralInfo();
        System.out.println(getRpm() + "RPM");
    }
}
