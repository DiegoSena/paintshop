package com.hbc.paintshop.model;

import java.util.Collections;
import java.util.List;

public class Customer {
    List<Preference> preferences;

    public Customer(List<Preference> preferences) {
        this.preferences = preferences;
        Collections.sort(preferences, Preference.COMPARATOR);
    }

    public List<Preference> getPreferences() {
        return preferences;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "preferences=" + preferences +
                '}';
    }
}
