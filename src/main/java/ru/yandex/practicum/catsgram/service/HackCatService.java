package ru.yandex.practicum.catsgram.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class HackCatService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public static final String JDBC_URL = "jdbc:postgresql://127.0.0.1:5432/cats";
    public static final String JDBC_USERNAME = "kitty";
    public static final String JDBC_DRIVER = "org.postgresql.Driver";

    public void tryPassword(String jdbcPassword) {
        DriverManagerDataSource dataSourceConst = new DriverManagerDataSource();
        // проверьте подключение с паролем и параметрами БД
        dataSourceConst.setUrl(JDBC_URL);
        dataSourceConst.setDriverClassName(JDBC_DRIVER);
        dataSourceConst.setUsername(JDBC_USERNAME);
        dataSourceConst.setPassword(jdbcPassword);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceConst);
        jdbcTemplate.execute("SELECT 1;");
    }

    public Optional<String> doHackNow() {
        List<String> catWordList = Arrays.asList("meow", "purr", "purrrrrr", "zzz");
        // проверьте пароли из списка
        for (String catWord : catWordList) {
            try {
                tryPassword(catWord);
                return Optional.of(catWord);
            }
            catch (Exception ex){
                log.info("Такой пароль не подходит --> {}", catWord);
            }
        }
        return Optional.empty();
    }

}
