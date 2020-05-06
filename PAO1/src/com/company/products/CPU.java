package com.company.products;

import java.time.LocalDate;

public class CPU extends Product {
    private String name;
    private String socket;
    private double frequency;
    private double turboFrequency;
    private int cores;
    private int threads;
    private int lithography; // 16-14 etc nm;
    boolean cpuCooler;
    private int maximumMemory;
    static String cat = "CPU";

    @Override
    public String getCat() { return cat;}

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public double getTurboFrequency() {
        return turboFrequency;
    }

    public void setTurboFrequency(double turboFrequency) {
        this.turboFrequency = turboFrequency;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public int getLithography() {
        return lithography;
    }

    public void setLithography(int lithography) {
        this.lithography = lithography;
    }

    public boolean isCpuCooler() {
        return cpuCooler;
    }

    public void setCpuCooler(boolean cpuCooler) {
        this.cpuCooler = cpuCooler;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    public void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CPU(float price, int stock, String manufacturer, String name, String socket, double frequency, double turboFrequency, int cores, int threads) {
        super(price, stock, manufacturer);
        this.name = name;
        this.socket = socket;
        this.frequency = frequency;
        this.turboFrequency = turboFrequency;
        this.cores = cores;
        this.threads = threads;
    }

    public CPU(float price, int stock, LocalDate purchaseDate, String manufacturer, String color, String name, String socket, double frequency, double turboFrequency, int cores, int threads) {
        super(price, stock, purchaseDate, manufacturer, color);
        this.name = name;
        this.socket = socket;
        this.frequency = frequency;
        this.turboFrequency = turboFrequency;
        this.cores = cores;
        this.threads = threads;
    }

    public CPU(int price, int stock, LocalDate purchaseDate, String manufacturer,String name, String socket, double frequency,
               double turboFrequency, int cores, int threads, int lithography, boolean cpuCooler, int maximumMemory) {
        super(price, stock, purchaseDate, manufacturer);
        this.name = name;
        this.socket = socket;
        this.frequency = frequency;
        this.turboFrequency = turboFrequency;
        this.cores = cores;
        this.threads = threads;
        this.lithography = lithography;
        this.cpuCooler = cpuCooler;
        this.maximumMemory = maximumMemory;
    }

    public CPU(CPU cpu){
        super(cpu.getPrice(), cpu.getStock(),cpu.getPurchaseDate(), cpu.getManufacturer() );
        this.name = cpu.getName();
        this.socket = cpu.getSocket();
        this.frequency = cpu.getFrequency();
        this.turboFrequency = cpu.getTurboFrequency();
        this.cores = cpu.getCores();
        this.threads = cpu.getThreads();
        this.lithography = cpu.getLithography();
        this.cpuCooler = cpu.isCpuCooler();
        this.maximumMemory = cpu.getMaximumMemory();
    }
    public boolean isOverclockable(){
        String productName =  this.getName();
        if (productName.charAt(this.getName().length() - 1) == 'K' || productName.charAt(this.getName().length() - 1) == 'k'){
            System.out.println("This CPU is overclockable \n");
            return true;
        }
        else{
            System.out.println("Not overclockable \n");
            return false;
        }
    }


    @Override
    public void GeneralInfo() {
        System.out.println(getManufacturer() + " " + getName() + "\n" + getFrequency() + "Ghz" );
        super.GeneralInfo();
    }
}
