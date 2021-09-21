package com.equihealth.core.model;



public class RequestData {

    public RequestData() {
    }


    String commodityName;

    Double pricePerTon;

    Integer volumeInTons;


    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Double getPricePerTon() {
        return pricePerTon;
    }

    public void setPricePerTon(Double pricePerTon) {
        this.pricePerTon = pricePerTon;
    }

    public Integer getVolumeInTons() {
        return volumeInTons;
    }

    public void setVolumeInTons(Integer volumeInTons) {
        this.volumeInTons = volumeInTons;
    }
}
