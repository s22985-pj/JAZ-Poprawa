package com.example.s22985.Repository;

import com.example.s22985.Service.NBPService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NBPRestController {
    final NBPService nbpService;

    public NBPRestController(NBPService nbpService) {
        this.nbpService = nbpService;
    }


    @GetMapping("/zloto/{waluta}/{dataPoczatkowa}/{dataKoncowa}")
    public ResponseEntity<String> zloto(@PathVariable String waluta, @PathVariable String dataPoczatkowa,
                                        @PathVariable String dataKoncowa) throws JsonProcessingException {
        return ResponseEntity.ok(nbpService.obliczZloto(waluta, dataPoczatkowa, dataKoncowa));
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id){
        return ResponseEntity.ok(nbpService.getID(id));
    }


}
