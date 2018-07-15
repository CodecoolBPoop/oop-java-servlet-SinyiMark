package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {
    public static List<Item> items = new ArrayList<>();
    public static List<Item> shoppingCart = new ArrayList<>();

    ItemStore(){
        items.add(new Item("A",10));
        items.add(new Item("B",15));
        items.add(new Item("C",20));
    }

    public static void add(String name,float price){
        shoppingCart.add(new Item(name,price));
    }

    public static void remove(String name){
        for (Item item:shoppingCart) {
            if (item.name.equals(name)){
                shoppingCart.remove(item);
                System.out.println(items);
                break;
            }
        }
    }
}
