package com.simona1.PF_exchange.rates.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class Rate {

    private final UUID id;
    @NotBlank
    private final String shortName;
    private final Date validFrom;
    private final String name;
    private final String country;
    private final Double amount;
    private final Double valBuy;
    private final Double valSell;
    private final Double valMid;
    private final Double currBuy;
    private final Double currSell;
    private final Double currMid;
    private final Double move;
    private final Double cnbMid;
    private final Integer version;


    public Rate(@JsonProperty("id") UUID id,
                @JsonProperty("shortName") String shortName,
                @JsonProperty("validFrom")Date validFrom,
                @JsonProperty("name")String name,
                @JsonProperty("country")String country,
                @JsonProperty("amount")Double amount,
                @JsonProperty("valBuy")Double valBuy,
                @JsonProperty("valSell")Double valSell,
                @JsonProperty("valMid")Double valMid,
                @JsonProperty("currBuy")Double currBuy,
                @JsonProperty("currSell")Double currSell,
                @JsonProperty("currMid")Double currMid,
                @JsonProperty("move")Double move,
                @JsonProperty("cnbMid")Double cnbMid,
                @JsonProperty("version")Integer version) {
        this.id = id;
        this.shortName = shortName;
        this.validFrom = validFrom;
        this.name = name;
        this.country = country;
        this.amount = amount;
        this.valBuy = valBuy;
        this.valSell = valSell;
        this.valMid = valMid;
        this.currBuy = currBuy;
        this.currSell = currSell;
        this.currMid = currMid;
        this.move = move;
        this.cnbMid = cnbMid;
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getValBuy() {
        return valBuy;
    }

    public Double getValSell() {
        return valSell;
    }

    public Double getValMid() {
        return valMid;
    }

    public Double getCurrBuy() {
        return currBuy;
    }

    public Double getCurrSell() {
        return currSell;
    }

    public Double getCurrMid() {
        return currMid;
    }

    public Double getMove() {
        return move;
    }

    public Double getCnbMid() {
        return cnbMid;
    }

    public Integer getVersion() {
        return version;
    }
}
