package com.hbc.paintshop.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void test_customer_is_special(){
        List<Preference> preferences = new ArrayList<>();
        Preference preference = new Preference(Integer.valueOf(1), "G");
        preferences.add(preference);
        Customer customer = new Customer(preferences);
        assertTrue(customer.isSpecialCustomer());
    }

    @Test
    public void test_customer_is_not_special(){
        Customer customer = new Customer(Collections.emptyList());
        assertFalse(customer.isSpecialCustomer());
    }

}