package ru.gb.example3_sem3_hometask.services;

import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;


/**
 * Сервис уведомлений
 */
@Service
public class NotificationService {

    /**
     * Метод вывода в консоль информации о создании нового пользователя
     * @param user Пользователь
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * Метод вывода в консоль входящих уведомлений
     * @param s Уведомление
     */
    public void sendNotification(String s) {
        System.out.println(s);
    }
}