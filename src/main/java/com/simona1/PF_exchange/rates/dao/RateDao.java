package com.simona1.PF_exchange.rates.dao;

import com.simona1.PF_exchange.rates.model.Rate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RateDao {

    int insertRate(UUID id, Rate rate);

    default int insertRate(Rate rate){
        UUID id = UUID.randomUUID();
        return insertRate(id, rate);
    }

    List<Rate> selectAllRate();

    Optional<Rate> selectRateById(UUID id);

    int deleteRateById(UUID id);

    int updateRateById(UUID id, Rate rate);

    void clearAllRates();
}
