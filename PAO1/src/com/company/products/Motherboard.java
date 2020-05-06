package com.company.products;

import java.time.LocalDate;

public class Motherboard extends Product {
    private String model;
    private String socket;
    private String chipset;
    private String memoryType;
    private int maxMemory;
    boolean crossfireSupport;
    boolean sliSupport;
    static String cat = "Motherboard";


    @Override
    public String getCat() { return cat;}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public boolean isCrossfireSupport() {
        return crossfireSupport;
    }

    public void setCrossfireSupport(boolean crossfireSupport) {
        this.crossfireSupport = crossfireSupport;
    }

    public boolean isSliSupport() {
        return sliSupport;
    }

    public void setSliSupport(boolean sliSupport) {
        this.sliSupport = sliSupport;
    }

    public Motherboard(float price, int stock, LocalDate purchaseDate, String manufacturer, String color, String model, String socket, String chipset, String memoryType, int maxMemory, boolean crossfireSupport, boolean sliSupport) {
        super(price, stock, purchaseDate, manufacturer, color);
        this.model = model;
        this.socket = socket;
        this.chipset = chipset;
        this.memoryType = memoryType;
        this.maxMemory = maxMemory;
        this.crossfireSupport = crossfireSupport;
        this.sliSupport = sliSupport;
    }

    @Override
    public void GeneralInfo() {
        System.out.println(getManufacturer() + " " + getModel() + " " + getSocket() );
        if (!sliSupport) System.out.println("It supports SLI");
        if (!crossfireSupport) System.out.println("It supports Crossfire");
        super.GeneralInfo();
    }

    public boolean isCompatibleCPU(CPU cpu){
        if (cpu.getSocket() != this.getSocket()){
            System.out.println("Incompatibile \n");
            return false;
        }
        else{
            System.out.println("Compatibile \n");
            return true;
        }
    }
    public boolean canItSLI(GPU gpu1, GPU gpu2){
        if ((gpu1.getModel() != gpu2.getModel()) || !this.isSliSupport()) {
            return false;
        } else
            return true;

    }

}
