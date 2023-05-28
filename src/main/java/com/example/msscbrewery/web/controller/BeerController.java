package com.example.msscbrewery.web.controller;

import com.example.msscbrewery.services.BeerService;
import com.example.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//this is a REST controller
@RequestMapping("/api/v1/beer") //base URL for this entire class
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    // return type can be BeerDto but ResponseEntity gives more options and control
    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId")UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> handlePost(BeerDto beerDto){
        BeerDto savedDto = beerService.saveBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://localhost:8080/api/v1/beer/"+savedDto.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
