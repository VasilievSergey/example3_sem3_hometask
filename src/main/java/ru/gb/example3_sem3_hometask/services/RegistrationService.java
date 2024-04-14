package ru.gb.example3_sem3_hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;


/**
 * Сервис регистрации нового пользователя
 * Взаимодействует с сервисами:
 * - работы с данными
 * - уведомлений
 * - создания пользователя
 */
@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;

    /**
     * Метод регистрации пользователя
     * @param user Пользователь
     * передает пользователя:
     * - сервису работы с данными для добавления в базу данных;
     * - сервису уведомлений
     */
    public void processRegistration(User user) {
        dataProcessingService.addUser(user);
        notificationService.notifyUser(user);
    }

    /**
     * Мутод создания нового пользователя по входным параметрам и его регистрации
     * @param name Имя
     * @param age Возраст
     * @param email Эл.почта
     * Передает входные параметры сервису создания нового пользователя.
     * Передает вновь созданного пользователя сервису работы с данными для сохранения в базе данных
     * Передает вновь созданного пользователя сервису уведомлений.
     */
    public void processRegistrationFromParam(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUser(user);
        notificationService.notifyUser(user);
    }

}