package com.example.restapp.service;

import java.time.LocalDate;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        Date date = java.sql.Date.valueOf(today);
        System.out.println(date);
    }
}
