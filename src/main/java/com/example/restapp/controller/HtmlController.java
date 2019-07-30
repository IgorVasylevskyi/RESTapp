package com.example.restapp.controller;

import com.example.restapp.model.Currency;
import com.example.restapp.repository.CurrencyRepository;
import com.example.restapp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HtmlController {

    @Autowired
    CurrencyService currencyService;


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(){
        return "main";
    }


    @PostMapping (value = "/newrate")
    public String addCurrency(@RequestBody Currency currency, Map<String, Object> model){
        currencyService.addCurrency(currency);

        model.put("lastrate", currencyService.getLast());

        return "newrate";
    }

}
