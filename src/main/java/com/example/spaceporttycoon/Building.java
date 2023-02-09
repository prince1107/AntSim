package com.example.spaceporttycoon;

public class Building {
    private int row;
    private int column;
    private int creditGeneration = 0;
    private int creditsGenerated = 0;
    private int level = 1;
    private long startTime;
    private int shopPrice;

    private String name;

    public Building(int row, int column, int creditGeneration, long startTime, String name, int shopPrice) {
        this.row = row;
        this.column = column;
        this.creditGeneration = creditGeneration;
        this.startTime = startTime;
        this.name = name;
        this.shopPrice = shopPrice;
    }

    public int getCreditsGenerated() {
        return creditsGenerated;
    }

    public void setCreditsGenerated(int creditsGenerated) {
        this.creditsGenerated = creditsGenerated;
    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getLevel() {
        return level;
    }

    public int getCreditGeneration() {
        return creditGeneration;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setCreditGeneration(int creditGeneration) {
        this.creditGeneration = creditGeneration;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void resetTime() {
        startTime = System.nanoTime();
    }

    public int getShopPrice() {
        return shopPrice;
    }
}
