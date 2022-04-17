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
public class GlobalQuoteDto {
    @JsonProperty("01. symbol")
    private String symbol;
    @JsonProperty("05. price")
    private String price;
    @JsonProperty("10. change percent")
    private String changePercent;
    @JsonProperty("07. latest trading day")
    private String latestTradingDay;
}
