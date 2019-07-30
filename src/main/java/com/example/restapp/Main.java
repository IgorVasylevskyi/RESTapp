package com.example.restapp;

import com.example.restapp.connection.CurrencyApiConnection;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.ParseException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws JSONException, ParseException, IOException {
        CurrencyApiConnection.connection();
        SpringApplication.run(Main.class, args);
    }

   /* Веб-приложение с базой данных и пользовательским интерфейсом,
    * например на JSF, поскольку он есть среди уроков на канале.
    * Смысл все тот же - разбор данных из открытых источников,
    * но сохраняем результаты обработки в базу данных
    * и предоставляем возможность посмотреть на результаты
    * с помощью пользовательского интерфейса.
    */
}
