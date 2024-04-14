package ru.gb.example3_sem3_hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.services.DataProcessingService;


import java.util.ArrayList;
import java.util.List;

/**
 * Контролллер задач
 * взаимодействует с сервисом работы с данными
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    /**
     * Метод получения списка задач
     * @return список задач
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Метод получения отсортированного списка пользователей
     * @return Список пользователей по возрастанию возраста
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        List<User> users = service.getUsers();
        return service.sortUsersByAge(users);
    }

    /**
     * Метод получения списка пользователей с фильтром по возрасту
     * @param age возраст
     * @return список пользователей
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAg(@PathVariable("age") int age) {
        List<User> users = service.getUsers();
        return service.filterUserByAge(users, age);
    }

    /**
     * Метод получения среднего возраста пользователей
     * @return средний возраст
     */
    @GetMapping("/calc")
    public Double calculateAverageAge() {
        List<User> users = service.getUsers();
        return service.calculateAverageAge(users);
    }

}