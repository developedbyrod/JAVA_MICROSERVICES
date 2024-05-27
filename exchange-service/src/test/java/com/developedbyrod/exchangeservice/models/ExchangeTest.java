package com.developedbyrod.exchangeservice.models;

import com.developedbyrod.exchangeservice.model.Exchange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExchangeTest {
    private Exchange exchange;

    @BeforeEach
    void setUp(){
        exchange = new Exchange();
    }

    @Test
    @DisplayName("Should correctly set the id")
    void idHandling(){
        Long id = 1L;
        exchange.setId(id);
        assertEquals(id, exchange.getId());
    }

    @Test
    @DisplayName("Should correctly set and get to currency")
    void toCurrencyHandling(){
        String to = "USD";
        exchange.setTo(to);
        assertEquals(to, exchange.getTo());
    }

    @Test
    @DisplayName("Should correctly set and get the conversion factor")
    void conversionFactorHandling(){
        BigDecimal conversionFactor = new BigDecimal("1.2");
        exchange.setConversionFactor(conversionFactor);
        assertEquals(conversionFactor, exchange.getConversionFactor());
    }

    @Test
    @DisplayName("Should set and get correctly the converted value")
    void convertedValueHandling(){
        BigDecimal convertedValue = new BigDecimal("1.2");
        exchange.setConvertedValue(convertedValue);
        assertEquals(convertedValue, exchange.getConvertedValue());
    }

    @Test
    @DisplayName("Should correctly set and get the environment")
    void environmentHandling(){
        String environment = "TEST";
        exchange.setEnvironment(environment);
        assertEquals(environment, exchange.getEnvironment());
    }

    @Test
    @DisplayName("Should correctly compare equality and return true")
    void equalsReturnTrue(){
        Exchange exchange1 = new Exchange(1L, "USD", "BRL", new BigDecimal("1.2"), new BigDecimal("120"), "TEST");
        Exchange exchange2 = new Exchange(1L, "USD", "BRL", new BigDecimal("1.2"), new BigDecimal("120"), "TEST");
        assertEquals(exchange1, exchange2);
    }

    @Test
    @DisplayName("Should correctly compare equality and return false")
    void equalsReturnFalse(){
        Exchange exchange1 = new Exchange(1L, "USD", "BRL", new BigDecimal("1.2"), new BigDecimal("120"), "TEST");
        Exchange exchange2 = new Exchange(2L, "USD", "BRL", new BigDecimal("1.2"), new BigDecimal("120"), "TEST");
        assertEquals(exchange1, exchange2);
    }

    @Test
    @DisplayName("Should correctly calculate the hashcode")
    void hashCodeTest(){
        Exchange exchange1 = new Exchange(1L, "USD", "BRL", new BigDecimal("1.2"), new BigDecimal("120"), "TEST");
        Exchange exchange2 = new Exchange(1L, "USD", "BRL", new BigDecimal("1.2"), new BigDecimal("120"), "TEST");
        assertEquals(exchange1.hashCode(), exchange2.hashCode());
    }

}
