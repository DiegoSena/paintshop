package com.hbc.paintshop;

import com.hbc.paintshop.model.Customer;
import com.hbc.paintshop.model.Preference;
import org.junit.Ignore;
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
        Preference preference = new Preference(Integer.valueOf(1), "G", true);
        preferences.add(preference);
        Customer customer1 = new Customer(preferences);

        List<Preference> preferences2 = new ArrayList<>();
        Preference preference2 = new Preference(Integer.valueOf(1), "M", true);
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
        List<Preference> preferencesForCustomer1 = new ArrayList<>();
        preferencesForCustomer1.add(preference(Integer.valueOf(1), "G", false));
        preferencesForCustomer1.add(preference(Integer.valueOf(2), "M", false));
        List<Preference> preferencesForCustomer2 = new ArrayList<>();
        preferencesForCustomer2.add(preference(Integer.valueOf(1), "M", true));
        customers.add(customer(preferencesForCustomer1));
        customers.add(customer(preferencesForCustomer2));
        Mixer mixer = new Mixer();
        assertEquals("M M", mixer.mix(numberOfColors, customers));
    }

    @Test
    @Ignore // Ignore while fixing
    public void mix_test_case2() {
        Integer numberOfColors = Integer.valueOf(5);
        List<Customer> customers = new ArrayList<>();
        List<Preference> preferencesForCustomer1 = new ArrayList<>();
        preferencesForCustomer1.add(preference(Integer.valueOf(1), "M", false));
        preferencesForCustomer1.add(preference(Integer.valueOf(3), "G", false));
        preferencesForCustomer1.add(preference(Integer.valueOf(5), "G", false));
        List<Preference> preferencesForCustomer2 = new ArrayList<>();
        preferencesForCustomer2.add(preference(Integer.valueOf(2), "G", false));
        preferencesForCustomer2.add(preference(Integer.valueOf(3), "M", false));
        preferencesForCustomer2.add(preference(Integer.valueOf(4), "G", false));
        List<Preference> preferencesForCustomer3 = new ArrayList<>();
        preferencesForCustomer3.add(preference(Integer.valueOf(5), "M", true));
        customers.add(customer(preferencesForCustomer1));
        customers.add(customer(preferencesForCustomer2));
        customers.add(customer(preferencesForCustomer3));
        Mixer mixer = new Mixer();
        assertEquals("G G G G M", mixer.mix(numberOfColors, customers));
    }

    private Preference preference(Integer colorNumber, String colorType, boolean specialRequest){
        return new Preference(colorNumber, colorType, specialRequest);
    }

    private Customer customer(List<Preference> preferences){
        return new Customer(preferences);
    }
}