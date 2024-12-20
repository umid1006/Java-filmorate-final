package ru.yandex.practicum.filmorate.model;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
public class User {
    int id;
    String email;
    String login;
    String name;

    private LocalDate birthday;
}