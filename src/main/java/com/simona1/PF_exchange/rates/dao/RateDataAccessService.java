package com.simona1.PF_exchange.rates.dao;

import com.simona1.PF_exchange.rates.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class RateDataAccessService implements RateDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RateDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertRate(UUID id, Rate rate) {


        jdbcTemplate.update(
                "INSERT INTO rate VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                id,
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
                rate.getVersion()
        );


        return 1;
    }

    @Override
    public List<Rate> selectAllRate() {
        final String sql = "SELECT id, " +
                "shortName, " +
                "validFrom, " +
                "name, " +
                "country, " +
                "amount, " +
                "valBuy, " +
                "valSell, valMid, currBuy, currSell, currMid, move, cnbMid, version " +
                "from rate ";

        List <Rate> rates= jdbcTemplate.query(sql, (resultSet, i) ->{
            UUID id = UUID.fromString(resultSet.getString("id"));
            return new Rate( id,
                    resultSet.getString("shortName"),
                    resultSet.getDate("validFrom"),
                    resultSet.getString("name"),
                    resultSet.getString("country"),
                    resultSet.getDouble("amount"),
                    resultSet.getDouble("valBuy"),
                    resultSet.getDouble("valSell"),
                    resultSet.getDouble("valMid"),
                    resultSet.getDouble("currBuy"),
                    resultSet.getDouble("currSell"),
                    resultSet.getDouble("currMid"),
                    resultSet.getDouble("move"),
                    resultSet.getDouble("cnbMid"),
                    resultSet.getInt("version")
                    );
        });
        return rates;
    }

    @Override
    public Optional<Rate> selectRateById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteRateById(UUID id) {
        return 0;
    }

    @Override
    public int updateRateById(UUID id, Rate rate) {
        return 0;
    }

    @Override
    public void clearAllRates() {
        jdbcTemplate.update("DELETE FROM RATE");
    }
}
