package com.example.s22985.XML;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class CenaZlota {
    @JacksonXmlElementWrapper(useWrapping = false)
    private String Data;
    @JacksonXmlElementWrapper(useWrapping = false)
    private String Cena;

    public String getData() {
        return Data;
    }

    public String getCena() {
        return Cena;
    }

    public void setData(String data) {
        Data = data;
    }

    public void setCena(String cena) {
        Cena = cena;
    }
}