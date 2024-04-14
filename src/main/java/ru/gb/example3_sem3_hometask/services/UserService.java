package ru.gb.example3_sem3_hometask.services;

import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;


/**
 * Сервис создания нового пользователя
 */
@Service
public class UserService {


    /**
     * Метод создания нового пользователя по входным параметрам
     * @param name Имя
     * @param age Возраст
     * @param email Адрес электронной почты
     * @return новый пользователь
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }
}