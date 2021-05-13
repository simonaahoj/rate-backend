package com.simona1.PF_exchange.rates.dao;

import com.simona1.PF_exchange.rates.model.Rate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("AccessDao")
public class TestRateDataAccessService implements RateDao {

    private static List<Rate> DB = new ArrayList<>();

    @Override
    public int insertRate(UUID id, Rate rate) {
        DB.add(new Rate(id,
                rate.getShortName(),
                rate.getValidFrom(),
                rate.getName(),
                rate.getCountry(),
                rate.getAmount(),
                rate.getValBuy(),
                rate.getValSell(),
                rate.getValMid(),
                rate.getCurrBuy(),
                rate.getCurrSell(),
                rate.getCurrMid(),
                rate.getMove(),
                rate.getCnbMid(),
                rate.getVersion()));
        return 1;
    }

    @Override
    public List<Rate> selectAllRate() {
        return DB;
    }

    @Override
    public Optional<Rate> selectRateById(UUID id) {
        return DB.stream()
                .filter(rate -> rate.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteRateById(UUID id) {
        Optional<Rate> rateMaybe = selectRateById(id);
        if (rateMaybe.isEmpty()){
            return 0;
        }
        DB.remove(rateMaybe.get());
        return 1;
    }


    @Override
    public int updateRateById(UUID id, Rate update) {
        return selectRateById(id)
                .map(rate -> {
                    int indexOfRateToUpdate = DB.indexOf(rate);
                    if (indexOfRateToUpdate >0){
                        DB.set(indexOfRateToUpdate, new Rate(id,
                                update.getShortName(),
                                update.getValidFrom(),
                                update.getName(),
                                update.getCountry(),
                                update.getAmount(),
                                update.getValBuy(),
                                update.getValSell(),
                                update.getValMid(),
                                update.getCurrBuy(),
                                update.getCurrSell(),
                                update.getCurrMid(),
                                update.getMove(),
                                update.getCnbMid(),
                                update.getVersion()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public void clearAllRates() {
        DB.clear();
    }
}
