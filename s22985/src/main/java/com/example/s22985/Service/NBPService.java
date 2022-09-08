package com.example.s22985.Service;


import com.example.s22985.Entity.NBPEntity;
import com.example.s22985.Repository.NBPRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.s22985.XML.ExchangeRatesSeries;
import com.example.s22985.XML.ArrayOfCenaZlota;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class NBPService {

    private final NBPRepository nbpRepository;


    public NBPService(NBPRepository nbpRepository) {
        this.nbpRepository = nbpRepository;
    }



    public String obliczZloto(String waluta, String startDate, String endDate) throws JsonProcessingException {
        NBPEntity nbpEntity = new NBPEntity();
        XmlMapper xmlMapper = new XmlMapper();
        RestTemplate restTemplate = new RestTemplate();
        float walutaCena = 1;
        float srCenaZlota = 0;

        waluta = waluta.toUpperCase();

        String nbpCenaZlota = "https://api.nbp.pl/api/cenyzlota/"+startDate+"/"+endDate+"?format=xml";
        String nbpWaluta = "https://api.nbp.pl/api/exchangerates/rates/A/"+waluta+"?format=xml";

        ResponseEntity<String> responseZloto = restTemplate.getForEntity(nbpCenaZlota, String.class);
        String zlotoXML = responseZloto.getBody();

        if(!waluta.equals("PLN")) {
            ResponseEntity<String> responseWaluta = restTemplate.getForEntity(nbpWaluta, String.class);
            String walutaXML = responseWaluta.getBody();
            ExchangeRatesSeries exchangeRatesSeries = xmlMapper.readValue(walutaXML, ExchangeRatesSeries.class);
            walutaCena = exchangeRatesSeries.getCurrencyCurse();
        }

        ArrayOfCenaZlota arrayOfCenaZlota = xmlMapper.readValue(zlotoXML, ArrayOfCenaZlota.class);

        srCenaZlota = arrayOfCenaZlota.getCenaZlotaSrednia(walutaCena);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        nbpEntity = new NBPEntity(waluta, startDate, endDate, srCenaZlota, dtf.format(now));


        return nbpRepository.save(nbpEntity).toString();
    }

    public String getID(long id) {
        return nbpRepository.findById(id).get().toString();
    }
}