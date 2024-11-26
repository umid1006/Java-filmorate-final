package ru.yandex.practicum.filmorate.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.ResourceNotFoundException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;
import java.util.HashMap;
import java.util.Map;


@Service
public class FilmService {

    public Film updateFilm(Film film) {

        final Map<Integer, Film> films = new HashMap<>(); // Add this line

        Film existingFilm = films.get(film.getId()); // Replace with your data store logic
        if (existingFilm == null) {
            throw new ResourceNotFoundException("Фильм с ID " + film.getId() + " не найден");
        }

        // 3. Обновление полей фильма (если они не null)
        if (film.getName() != null) {
            existingFilm.setName(film.getName());
        }
        if (film.getDescription() != null) {
            existingFilm.setDescription(film.getDescription());
        }

        return existingFilm;
    }

    // ... (остальной код сервиса)
}
