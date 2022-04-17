package com.dtb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDto {
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("exchangeName")
    private String exchangeName;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("regularMarketPrice")
    private RegularMarketPriceDto regularMarketPriceDto;
}
