package com.example.restapp.controller;

import com.example.restapp.model.Currency;
import com.example.restapp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {

    @Autowired
    public CurrencyService currencyService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Currency addCurrency(@RequestBody Currency currency){
        return currencyService.addCurrency(currency);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Currency> getAll(){
        return currencyService.getAll();
    }

    @RequestMapping(value = "/last", method = RequestMethod.GET)
    public Currency getTodayCurrency(){
        return currencyService.getLast();
    }

    @RequestMapping(value = "/lastweek", method = RequestMethod.GET)
    public List<Currency> getLastWeek(){
        return currencyService.getLastWeek();
    }

}
