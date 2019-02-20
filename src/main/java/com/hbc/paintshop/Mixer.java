package com.hbc.paintshop;

import com.hbc.paintshop.model.Customer;
import com.hbc.paintshop.model.Preference;

import java.util.List;

public class Mixer {

    public String mix(Integer numberOfColors, List<Customer> customers){
        Preference[] output = new Preference[numberOfColors];

        try{
            customers.forEach( customer -> {
                this.applyPreferencesToOutput(customer, output);
            });

            return buildOutput(output);
        }catch (IllegalStateException e){
            // log exception
            return "No solution exists";
        }
    }

    private String buildOutput(Preference[] output) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < output.length; i++) {
            sb.append(output[i].getColorType() + (i < output.length - 1 ? " ": ""));
        }
        return sb.toString();
    }

    private void applyPreferencesToOutput(Customer customer, Preference[] output){
        customer.getPreferences().forEach( preference -> {
            Preference prefOutput = output[preference.getColorNumber() - 1];
            if(prefOutput == null){
                output[preference.getColorNumber() -1] = preference;
            }else{
                Preference resolvedPreference = resolvePreference(prefOutput, preference);
                output[preference.getColorNumber() - 1] = resolvedPreference;

            }
        });
    }

    private Preference resolvePreference(Preference prefOutput, Preference preference) {
        if(preference.isSpecialRequest() && prefOutput.isSpecialRequest()) throw new IllegalStateException();
        if((prefOutput.isSpecialRequest() && preference.isSpecialRequest() && preference.equals("G")) ||
            preference.isSpecialRequest() || preference.getColorType().equals("G")){
                return preference;
            }
        return prefOutput;
    }
}
