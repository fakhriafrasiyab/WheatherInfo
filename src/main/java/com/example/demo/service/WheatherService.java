package com.example.demo.service;

import com.example.demo.model.dto.CityDTO;

import java.time.LocalDate;
import java.util.List;

public interface WheatherService {
    CityDTO getCityByDate(LocalDate dateTime);

    List<CityDTO> getAllCities();

    List<CityDTO> getByCity(String location);
}
