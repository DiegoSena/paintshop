package com.hbc.paintshop.parser;

import com.hbc.paintshop.model.Customer;
import com.hbc.paintshop.model.PaintShop;
import com.hbc.paintshop.model.Preference;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TextFilePaintShopParser implements PaintShopParser {

    private String file;

    @Override
    public PaintShop parse() {
        try {
            List<String> lines = FileUtils.readLines(FileUtils.getFile(file), "UTF-8");
            if(lines != null && lines.size() >= 2){
                PaintShop paintShop = new PaintShop();
                paintShop.setNumberOfColors(Integer.valueOf(lines.get(0)));
                paintShop.setCustomers(getCustomers(lines.subList(1, lines.size())));
                return paintShop;
            }
            throw new IllegalArgumentException("File has wrong format.");
        } catch (IOException e) {
            //TODO log error
            return null;
        }
    }

    private List<Customer> getCustomers(List<String> customersFromInput) {
        return customersFromInput.stream().map(this::getCustomer).collect(Collectors.toList());
    }

    private Customer getCustomer(String customer){
        List<Preference> preferences = new ArrayList<>();
        String[] preferencesFromInput = customer.split(" ");
        for(int i = 0; i < preferencesFromInput.length; i+=2){
            preferences.add(new Preference(Integer.valueOf(preferencesFromInput[i]),
                                           preferencesFromInput[i+1]));
        }
        return new Customer(preferences);
    }

    @Value("${fileLocation:}")
    public void setFile(String file) {
        this.file = file;
    }

}
