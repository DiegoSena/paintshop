package com.hbc.paintshop.model;

import java.util.Comparator;
import java.util.Objects;

public class Preference implements Comparator<Preference> {

    public static final Comparator<Preference> COMPARATOR = Comparator.comparing(a -> a.colorNumber);

    private boolean specialRequest;
    private Integer colorNumber;
    private String colorType;

    public Preference(Integer colorNumber, String colorType, boolean specialRequest) {
        this.colorNumber = colorNumber;
        this.colorType = colorType;
        this.specialRequest = specialRequest;
    }

    public Integer getColorNumber() {
        return colorNumber;
    }

    public String getColorType() {
        return colorType;
    }

    @Override
    public int compare(Preference o1, Preference o2) {
        return o1.colorNumber.compareTo(o2.colorNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preference that = (Preference) o;
        return Objects.equals(colorNumber, that.colorNumber) &&
                Objects.equals(colorType, that.colorType) &&
                Objects.equals(specialRequest, that.specialRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorNumber, colorType, specialRequest);
    }

    @Override
    public String toString() {
        return this.colorNumber + " " + this.getColorType();
    }

    public boolean isSpecialRequest() {
        return specialRequest;
    }
}
