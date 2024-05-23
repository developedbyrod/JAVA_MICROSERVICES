package com.developedbyrod.exchangeservice.dto;


public record ExchangeRecordDTO(Long id, String from, String to, String conversionFactor, String convertedValue, String environments) {
}
