package com.jeffrey.academiccollage.advancePrograming.RecyclerExample;

public class Vacation {
    private String nameOfDestination;
    private String moreDetailed;
    private String price;



    public Vacation(String nameOfDestination, String moreDetailed, String price) {
        this.nameOfDestination = nameOfDestination;
        this.moreDetailed = moreDetailed;
        this.price = price;
    }


    public Vacation(){

    }

    public String getNameOfDestination() {
        return nameOfDestination;
    }

    public void setNameOfDestination(String nameOfDestination) {
        this.nameOfDestination = nameOfDestination;
    }

    public String getMoreDetailed() {
        return moreDetailed;
    }

    public void setMoreDetailed(String moreDetailed) {
        this.moreDetailed = moreDetailed;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
