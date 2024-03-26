package com.example.PetHostel.modelFromEnum;

import lombok.Getter;

@Getter
public enum UtilityOptions {

    WASH("wash", 1990),
    WALK("walk", 490),
    PLAY("play", 990);

    private String serviceName;
    private Integer priceOfService;
    private Currency currency;

    UtilityOptions(String serviceName, Integer priceOfService) {
        this.serviceName = serviceName;
        this.priceOfService = priceOfService;
    }
}
