package com.simona1.PF_exchange.rates.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simona1.PF_exchange.rates.dao.RateDao;
import com.simona1.PF_exchange.rates.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RateService {

    private final RateDao rateDao;

    @Autowired
    public RateService(@Qualifier("postgres") RateDao rateDao) {
        this.rateDao = rateDao;
    }

    public int addRate(Rate rate){
        return rateDao.insertRate(rate);
    }

    public List<Rate> getAllRate(){
        return rateDao.selectAllRate();
    }

    public Optional<Rate> getRateById(UUID id) {
        return rateDao.selectRateById(id);
    }

    public int deleteRate(UUID id){
        return rateDao.deleteRateById(id);
    }

    public int updateRate(UUID id, Rate newRate){
        return rateDao.updateRateById(id, newRate);
    }

    public List<Rate> refreshRates() {

        final String uri = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";

        RestTemplate restTemplate = new RestTemplate();
        String ratesFromApiJSON = restTemplate.getForObject(uri, String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<Rate> rates = null;
        try {
            rates = mapper.readValue(ratesFromApiJSON, new TypeReference<List<Rate>>() { });

            rateDao.clearAllRates();
            for(Rate rate: rates){
                addRate(rate);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return rates;
    }
}
