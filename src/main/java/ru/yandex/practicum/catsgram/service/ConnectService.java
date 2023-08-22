package ru.yandex.practicum.catsgram.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class ConnectService {


    public JdbcTemplate getTemplate(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        return jdbcTemplate;
    }

}
