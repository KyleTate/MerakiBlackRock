package com.example.blackrockapp;

public class ExampleItem {
    private String mText1;
    private String mText2;
    private String stockValue;
    private String percentChange;

    public ExampleItem(String text1, String text2, String stockCurrentValue, String percentChangeNum) {
        mText1 = text1;
        mText2 = text2;
        this.stockValue = stockCurrentValue;
        this.percentChange = percentChangeNum+"";

    }

    public ExampleItem(String text1, String text2, Stock stock) {
        mText1 = text1;
        mText2 = text2 + " STOCKS";
        stockValue = getStockValue();
        this.percentChange = stock.calculatePercentReturn()+"";
    }


    public String getText1() {
        return mText1;
    }

    public String getText2(){
        return mText2;
    }

    public String getStockValue(){
        return stockValue;
    }

    public String getPercentChange(){
        return (percentChange);
    }



}
