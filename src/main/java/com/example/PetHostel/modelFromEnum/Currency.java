package com.example.PetHostel.modelFromEnum;

import lombok.Getter;

@Getter
public enum Currency {

    HUF("Ft", 1.0),
    EUR("Euro", 396.00),
    USD("Dollar", 365.49),
    GBP("Pound", 461.71),
    PLN("Zloty", 91.89);

    Currency(String name, Double exchangeRateToHuf) {
        this.name = name;
        this.exchangeRateToHuf = exchangeRateToHuf;
    }

    //temporary: later MNB Soap API will be used for getting real-time exchange rates
    private String name;
    private Double exchangeRateToHuf;

    public static double convertCurrency(Currency input, Currency output) {
        return input.exchangeRateToHuf/output.exchangeRateToHuf;
    }
}
