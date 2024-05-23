package com.developedbyrod.exchangeservice.controller;
import com.developedbyrod.exchangeservice.dto.ExchangeRecordDTO;
import com.developedbyrod.exchangeservice.model.Exchange;
import com.developedbyrod.exchangeservice.repository.ExchangeRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("exchange")
public class ExchangeController {


    private final Environment environment;
    private final ExchangeRepository exchangeRepository;

    private ExchangeRecordDTO exchangeRecordDTO;

    private ExchangeController(Environment environment, ExchangeRepository exchangeRepository){
        this.environment = environment;
        this.exchangeRepository = exchangeRepository;
    }


    @GetMapping(value = "/{amount}/{from}/{to}")
    public Exchange getExchangeValue(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to
    ) throws Exception {
        var exchange = exchangeRepository.findByFromAndTo(from, to);

        if(exchange == null){
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }

        var port =  environment.getProperty("local.server.port");
        BigDecimal conversionFactor = exchange.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);
        exchange.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        exchange.setEnvironment(port);
        return exchange;
    }


}
