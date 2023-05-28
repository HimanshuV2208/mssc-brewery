package com.example.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

//DTO --> Data Transfer Object
@Data //adds boiler-plate code for getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Builder //implements builder pattern
public class BeerDto {
    private UUID id; // UUID --> Universally Unique IDentifier
    private String beerName;
    private String beerStyle;
    private Long upc; // UPC --> Universal Product Code
}
