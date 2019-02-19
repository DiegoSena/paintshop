package com.hbc.paintshop.model;

import java.util.ArrayList;
import java.util.List;

public class PaintShop {
    private int numberOfColors;
    private List<String> customerOrders = new ArrayList<>();

    public PaintShop() {
    }

    public int getNumberOfColors() {
        return numberOfColors;
    }

    public void setNumberOfColors(int numberOfColors) {
        this.numberOfColors = numberOfColors;
    }

    public List<String> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<String> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
