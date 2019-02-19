package com.hbc.paintshop.model;

import java.util.ArrayList;
import java.util.List;

public class PaintShop {
    private int numberOfColors;
    private List<Customer> customers = new ArrayList<>();

    public PaintShop() {
    }

    public int getNumberOfColors() {
        return numberOfColors;
    }

    public void setNumberOfColors(int numberOfColors) {
        this.numberOfColors = numberOfColors;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "PaintShop{" +
                "numberOfColors=" + numberOfColors +
                ", customers=" + customers +
                '}';
    }
}
