package com.example.demo.controller;

import com.example.demo.model.dto.CityDTO;
import com.example.demo.service.WheatherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/city")
public class WheatherController {

    private final WheatherService wheatherService;

    public WheatherController(WheatherService wheatherService) {
        this.wheatherService = wheatherService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CityDTO>> getAll() {
        return ResponseEntity.ok(wheatherService.getAllCities());
    }

    @GetMapping(value = "/{date}")
    public ResponseEntity<CityDTO> getCityByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateTime) {
        return ResponseEntity.ok(wheatherService.getCityByDate(dateTime));
    }

    @GetMapping(value = "/getByCity")
    public ResponseEntity<List<CityDTO>> getByCity(@RequestParam String location) {
        return ResponseEntity.ok(wheatherService.getByCity(location));
    }
}
