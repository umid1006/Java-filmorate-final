package ru.yandex.practicum.filmorate.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.ResourceNotFoundException;
import ru.yandex.practicum.filmorate.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final Map<Integer, User> users = new HashMap<>();

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User createUser(User user) {
        user.setId(generateId());
        users.put(user.getId(), user);
        return user;
    }

    public User updateUser(User user) {
        if (!users.containsKey(user.getId())) {
            throw new ResourceNotFoundException("Пользователь не найден.");
        }
        users.put(user.getId(), user);
        return user;
    }

    public User getUserById(int id) {
        if (!users.containsKey(id)) {
            throw new ResourceNotFoundException("Пользователь не найден.");
        }
        return users.get(id);
    }

    private int generateId() {
        return users.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
    }
}