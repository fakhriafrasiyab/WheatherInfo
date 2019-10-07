package com.example.demo.service.impl;

import com.example.demo.mapper.CityMapper;
import com.example.demo.model.CityEntity;
import com.example.demo.model.dto.CityDTO;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.WheatherService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WheatherServiceImpl implements WheatherService {

    private final CityRepository cityRepository;

    public WheatherServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public CityDTO getCityByDate(LocalDate dateTime) {
        CityEntity cityEntity = cityRepository.findByDateTime(dateTime);
        return CityMapper.INSTANCE.toCityDTO(cityEntity);
    }

    public List<CityDTO> getAllCities() {
        List<CityEntity> cityEntities = cityRepository.findAll();
        return CityMapper.INSTANCE.toCityDtoList(cityEntities);
    }

    @Override
    public List<CityDTO> getByCity(String location) {
        List<CityEntity> cityEntities = cityRepository.findByCityName(location);
        return CityMapper.INSTANCE.toCityDtoList(cityEntities);
    }

}
