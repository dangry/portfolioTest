package models;

import java.util.Date;
import java.util.HashMap;

public class Stock {

    public String name;
    HashMap<Date, Double> stockPrices;

    public Stock() {
        this.stockPrices = new HashMap<>();
    }

    public Stock(String name) throws Exception {
        this();
        this.name = name;
    }

    public void addPrice(Date date, double price) {
        stockPrices.put(date, price);
    }

    public double price(Date date) {
        return stockPrices.get(date);
    }
}
