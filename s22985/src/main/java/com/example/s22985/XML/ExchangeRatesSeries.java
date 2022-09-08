package com.example.s22985.XML;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRatesSeries {
    @JacksonXmlElementWrapper(useWrapping = false)
    private String Table;
    @JacksonXmlElementWrapper(useWrapping = false)
    private String Currency;
    @JacksonXmlElementWrapper(useWrapping = false)
    private String Code;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Rates> Rates = new ArrayList<>();

    public String getTable() {
        return Table;
    }

    public String getCurrency() {
        return Currency;
    }

    public String getCode() {
        return Code;
    }

    public List<com.example.s22985.XML.Rates> getRates() {
        return Rates;
    }

    public void setTable(String table) {
        Table = table;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setRates(List<com.example.s22985.XML.Rates> rates) {
        Rates = rates;
    }

    public float getCurrencyCurse() {
        List<Rates> ratesList = getRates();
        List<Rate> rateList = ratesList.get(0).getRate();
        return Float.parseFloat(rateList.get(0).getMid());
    }
}