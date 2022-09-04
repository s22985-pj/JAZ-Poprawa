package com.example.s22985.Service;

import com.example.s22985.Repository.NBPRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class NBPService {

    private final NBPRepository nbpRepository;
    private final RestTemplate restTemplate;

    public NBPService(NBPRepository nbpRepository) {
        this.nbpRepository = nbpRepository;
        this.restTemplate = restTemplate;
    }

    public String getCurrencies() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/tables/a/", String.class);
        return response.getBody();
    }

    public String getGoldValue(String code, String startDate, String endDate) {
        ResponseEntity<String> goldValue = restTemplate.getForEntity("http://api.nbp.pl/api/cenyzlota"
                + "/" + startDate + "/" + endDate + "/", String.class);
        ResponseEntity<String> currency = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/rates/a/" + code
                + "/" + startDate + "/" + endDate + "/", String.class);

        return " " + currency;
    }