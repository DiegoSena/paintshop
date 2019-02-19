package com.hbc.paintshop;

import com.hbc.paintshop.model.Customer;
import com.hbc.paintshop.model.Preference;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MixerTest {

    @Test
    public void mix_no_solution_exists() {
        Integer numberOfColors = Integer.valueOf(1);
        List<Customer> customers = new ArrayList<>();
        List<Preference> preferences = new ArrayList<>();
        Preference preference = new Preference(Integer.valueOf(1), "G");
        preferences.add(preference);
        Customer customer1 = new Customer(preferences);

        List<Preference> preferences2 = new ArrayList<>();
        Preference preference2 = new Preference(Integer.valueOf(1), "M");
        preferences2.add(preference2);
        Customer customer2 = new Customer(preferences2);
        customers.add(customer1);
        customers.add(customer2);
        Mixer mixer = new Mixer();
        assertEquals("No solution exists", mixer.mix(numberOfColors, customers));
    }

    @Test
    public void mix_test_case1() {
        Integer numberOfColors = Integer.valueOf(2);
        List<Customer> customers = new ArrayList<>();
        List<Preference> preferences = new ArrayList<>();
        Preference preference1 = new Preference(Integer.valueOf(1), "G");
        Preference preference2 = new Preference(Integer.valueOf(2), "M");
        preferences.add(preference1);
        preferences.add(preference2);
        Customer customer1 = new Customer(preferences);

        List<Preference> preferences2 = new ArrayList<>();
        Preference preference3 = new Preference(Integer.valueOf(1), "M");
        preferences2.add(preference3);
        Customer customer2 = new Customer(preferences2);
        customers.add(customer1);
        customers.add(customer2);
        Mixer mixer = new Mixer();
        assertEquals("M M", mixer.mix(numberOfColors, customers));
    }
}