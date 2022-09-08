package com.example.s22985.XML;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class Rates {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Rate> Rate = new ArrayList<>();

    public List<com.example.s22985.XML.Rate> getRate() {
        return Rate;
    }

    public void setRate(List<com.example.s22985.XML.Rate> rate) {
        Rate = rate;
    }
}
