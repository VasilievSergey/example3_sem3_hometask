package ru.gb.example3_sem3_hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.services.DataProcessingService;
import ru.gb.example3_sem3_hometask.services.RegistrationService;

import java.util.List;

/**
 * Контроллер пользователей
 * взаимодействует с сервисом регистрации пользователей
 * и сервисом работы с данными
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private RegistrationService registrationService;

    /**
     * Метод запроса списка пользователей из базы данных
     * @return список пользователей
     */
    @GetMapping
    public List<User> getUsers() {
        return dataProcessingService.getUsers();
    }

    /**
     * Метод добавления нового пользователя из POST запроса
     * @param user пользователь
     * @return строка ответа об удачном добавлении нового пользователя
     * в базу данных
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService.processRegistration(user);
        return "User added from body";
    }

    /**
     * Метод добавления нового пользователя из POST запроса с параметрами
     * @param name имя
     * @param age возраст
     * @param email эл.почта
     * @return строка ответа об удачном добавлении нового пользователя
     * базу данных
     */
    @PostMapping("/param/{name}/{age}/{email}")
    public String userAddFromParam(@PathVariable("name") String name
            , @PathVariable("age") int age
            , @PathVariable("email") String email) {
        registrationService.processRegistrationFromParam(name, age, email);
        return "User added from parameters";
    }

}