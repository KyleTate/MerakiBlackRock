package com.example.blackrockapp;


public class Stock {
    private String purchaseDate;
    private String sellDate;
    private double purchaseValue;
    private String stockName;
    private int quantityOwned;

    public Stock(String stockAbbreviation){
        this.stockName = stockAbbreviation;
        purchaseDate = "5:19am";
        purchaseValue = getCurrentValue(stockAbbreviation);
        this.quantityOwned = 0;
    }

    public double getCurrentValue(String stockAbreviation){
        //THIS METHOD WOULD ACCESS THE API AND RETURN THE CURRENT VALUE
        double returnedValue = 100;
        return returnedValue;
    }

    public String getstockName() {
        return stockName;
    }

    public void setQuantityOwned(int quantityOwned) {
        this.quantityOwned = quantityOwned;
    }

    public int getQuantityOwned(){
        return quantityOwned;
    }

    public double calculatePercentReturn(){
        double percentReturn = 1 - (getCurrentValue(stockName)/purchaseValue);
        return percentReturn;
    }

    public double calculateStockVolatility(String startDate, String endDate, String stockName) {
        double tempHolder = 0.0;

        return tempHolder;
    }

}