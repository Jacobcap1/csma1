package com.coffeeshop.Classes;

public interface Drink {
    String description ="";
    String name = "";
    double price = 0.0;
    char size = 's';

  String getName();
  String getDescription();
  double getPrice();
  char getSize();
}
