package com.codecool.servlet;

public class Item {
    static int idCounter = 1;
    int id;
    String name;
    float price;

    Item(String myName,float myPrice){
        id = idCounter;
        idCounter++;
        name = myName;
        price = myPrice;
    }
}
