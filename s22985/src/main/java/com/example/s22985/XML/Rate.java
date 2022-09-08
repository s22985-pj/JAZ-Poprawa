package com.example.s22985.XML;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class Rate {
    @JacksonXmlElementWrapper(useWrapping = false)
    private String No;
    @JacksonXmlElementWrapper(useWrapping = false)
    private String EffectiveDate;
    @JacksonXmlElementWrapper(useWrapping = false)
    private String Mid;

    public String getNo() {
        return No;
    }

    public String getEffectiveDate() {
        return EffectiveDate;
    }

    public String getMid() {
        return Mid;
    }

    public void setNo(String no) {
        No = no;
    }

    public void setEffectiveDate(String effectiveDate) {
        EffectiveDate = effectiveDate;
    }

    public void setMid(String mid) {
        Mid = mid;
    }
}
