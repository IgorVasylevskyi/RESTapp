package com.example.restapp.service;

import com.example.restapp.model.Currency;

import java.util.List;

public interface CurrencyService {

    Currency addCurrency(Currency currency);
    List<Currency> getAll();
    Currency getLast();
    List<Currency> getLastWeek();

}
