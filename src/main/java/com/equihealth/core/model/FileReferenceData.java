package com.equihealth.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileReferenceData {

    @JsonProperty("COUNTRY")
    String country;

    @JsonProperty("COMMODITY_NAME")
    String commodity_Name;

    @JsonProperty("FIXED_OVERHEAD")
    Double fixed_overhead;

    @JsonProperty("VAR_OVERHEAD")
    Double var_overhead;

    @Override
    public String toString() {
        return "FileReferenceData{" +
                "country='" + country + '\'' +
                ", commodity_Name='" + commodity_Name + '\'' +
                ", fixed_overhead=" + fixed_overhead +
                ", var_overhead=" + var_overhead +
                '}';
    }


}
