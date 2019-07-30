package com.example.restapp.repository;

import com.example.restapp.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency findTopByOrderByIdDesc();
    List<Currency> findByDateIsAfter(Date date);
}
