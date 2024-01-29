package com.cach.controller;

import com.cach.dto.City;
import com.cach.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/city")
@RequiredArgsConstructor
public class CacheController {
    private final CacheService cacheService;

    @PostMapping("/add")
    public ResponseEntity<City> createProduct(@RequestBody City city) {
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @GetMapping("/search/{cityName}")
    public ResponseEntity<City> getCityByCityName(@PathVariable("cityName") String cityName) {
        return new ResponseEntity<>(cacheService.getCityByCityName(cityName), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        return new ResponseEntity<>(cacheService.putCity(city), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<City> deleteCity(@RequestBody City city) {
        return new ResponseEntity<>(cacheService.deleteCity(city), HttpStatus.OK);
    }
}
