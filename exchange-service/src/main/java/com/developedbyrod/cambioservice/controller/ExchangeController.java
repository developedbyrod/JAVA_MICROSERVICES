package com.developedbyrod.cambioservice.controller;
import com.developedbyrod.cambioservice.model.Exchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@RequestMapping("exchange")
public class ExchangeController {

    @GetMapping(value = "/{amount}/{from}/{to}")

    public Exchange getExchangeValue(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to
    ){
        return new Exchange(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, "PORT 8000");
    }
}
