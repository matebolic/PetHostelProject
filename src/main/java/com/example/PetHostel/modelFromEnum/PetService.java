package com.example.PetHostel.modelFromEnum;

public enum PetService {

    WASH("wash", 1990),
    WALK("walk", 490),
    PLAY("play", 990);

    private String serviceName;
    private Integer priceOfService;

    PetService(String serviceName, Integer priceOfService) {
        this.serviceName = serviceName;
        this.priceOfService = priceOfService;
    }
}
