package com.simona1.PF_exchange.rates.api;

import com.simona1.PF_exchange.rates.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simona1.PF_exchange.rates.service.RateService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/rate")
@RestController
public class RateController {

    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping
    public void addRate(@Valid @NotNull @RequestBody Rate rate){
       rateService.addRate(rate);
    }

    @GetMapping
    public List<Rate> getAllRate(@RequestParam(value = "usedb")boolean usedb){
        if(usedb) {
            return rateService.getAllRate();
        }
        else {
            rateService.refreshRates();
            return rateService.getAllRate();
        }
    }


    @GetMapping(path = "{id}")
    public Rate getRateById(@PathVariable("id") UUID id){
        return rateService.getRateById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteRateById(@PathVariable("id")UUID id){
        rateService.deleteRate(id);
    }

    @PutMapping(path = "{id}")
    public void updateRate(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Rate rateToUpdate){
        rateService.updateRate(id, rateToUpdate);
    }
}
