package ru.yandex.practicum.catsgram.controller;

public class ErrorResponse {
    // название ошибки
    String error;
    // подробное описание
    //String description;

    public ErrorResponse(String error) {
        this.error = error;
      //  this.description = description;
    }

    // геттеры необходимы, чтобы Spring Boot мог получить значения полей
    public String getError() {
        return error;
    }
/*
    public String getDescription() {
        return description;
    }
    */
}
