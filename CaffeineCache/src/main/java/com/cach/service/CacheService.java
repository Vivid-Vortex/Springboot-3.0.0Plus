package com.cach.service;

import com.cach.dto.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@CacheConfig(cacheNames = "CityCache")
public class CacheService {
    @Autowired
    CacheManager cacheManager;

    public Map<String, City> cityZipCodeRepo;

    CacheService() {
        cityZipCodeRepo = new HashMap<>();
        cityZipCodeRepo.put("Kolkata", City.builder().cityName("Kolkata").zipCode("500091").build());
        cityZipCodeRepo.put("Mumbai", City.builder().cityName("Mumbai").zipCode("500041").build());
        cityZipCodeRepo.put("Delhi", City.builder().cityName("Delhi").zipCode("500001").build());
        cityZipCodeRepo.put("Pune", City.builder().cityName("Pune").zipCode("500098").build());
        cityZipCodeRepo.put("Bangalore", City.builder().cityName("Bangalore").zipCode("500057").build());
    }

    @Cacheable(value = "city-zip-cache")
    public City getCityByCityName(String cityName) {
        log.info("getZipCode Method Called");
        return cityZipCodeRepo.get(cityName);
    }

    public Cache getCacheByName(String cacheName) {
        return cacheManager.getCache(cacheName);
    }

    @CachePut(value ="city-zip-cache",key = "#city.cityName")
    public City addCity(City city) {
        return cityZipCodeRepo.put(city.getCityName(), city);
    }

    @CachePut(value ="city-zip-cache",key = "#city.cityName")
    public City putCity(City city) {
        return cityZipCodeRepo.replace(city.getCityName(), city);
    }

    @CacheEvict(value = "city-zip-cache", allEntries = true)
    public City deleteCity(City city){
        return cityZipCodeRepo.remove(city.getCityName());
    }

}
