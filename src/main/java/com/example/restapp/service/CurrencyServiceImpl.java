package com.example.restapp.service;

import com.example.restapp.model.Currency;
import com.example.restapp.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public Currency addCurrency(Currency currency) {
        return currencyRepository.saveAndFlush(currency);
    }

    @Override
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency getLast() {
        return currencyRepository.findTopByOrderByIdDesc();
    }


    @Override
    public List<Currency> getLastWeek() {

        LocalDate oneWeekAgo = LocalDate.now().minusDays(7);
        Date weekAgo = java.sql.Date.valueOf(oneWeekAgo);

        return currencyRepository.findByDateIsAfter(weekAgo);
    }
}
