package com.kodilla.good.patterns.challenges;

public interface Product {

    public default String getProductName(){
        return "";
    }

    public default int getProductPrice(){
        return 0;
    }

}
