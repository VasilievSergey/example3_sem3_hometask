package ru.gb.example3_sem3_hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.repository.UserRepository;


import java.util.Comparator;
import java.util.List;

/**
 * Сервис работы с данными.
 * Взаимодействует с репозиторием пользователей и сервисом уведомлений
 */
@Service
public class DataProcessingService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private NotificationService notificationService;

    /**
     * Метод получения списка пользователей из репозитория.
     * Также передает список сервису уведомлений
     * @return список пользователей в базе данных
     */
    public List<User> getUsers() {
        List<User> users = repository.getUsers();
        notificationService.sendNotification("\nList of users from database:");
        users.forEach(user -> notificationService.sendNotification(user.toString()));
        return users;
    }


    /**
     * Метод передачи в репозиторий нового пользователя
     * @param user Новый пользователь для загрузки в репозиторий
     */
    public void addUser(User user) {
        repository.addUser(user);
    }


    /**
     * Метод сортировки списка пользователей по их возрасту в порядке возрастания
     * @param users список пользователей для сортировки
     * @return  отсортированный список пользователей
     * Также передает строку результата сервису уведомлений
     */
    public List<User> sortUsersByAge(List<User> users) {
        List<User> sortedUsers = users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .toList();
        notificationService.sendNotification("\nList of users are sorted by age:");
        sortedUsers.forEach(user -> notificationService.sendNotification(user.toString()));
        return sortedUsers;
    }

    /**
     * Метод фильтрации списка пользователей по возрасту
     * @param users начальный список пользоватей
     * @param age возраст
     * @return отфильтрованный список пользователей
     * Также передает строку результата сервису уведомлений
     */
    public List<User> filterUserByAge(List<User> users, int age) {
        List<User> filteredUsers = users.stream()
                .filter(user -> user.getAge() > age)
                .toList();
        notificationService.sendNotification("\nList of users over " + age + " years old:");
        filteredUsers.forEach(user -> notificationService.sendNotification(user.toString()));
        return filteredUsers;
    }

    /**
     * Метод расчета среднего возраста пользователей
     * @param users Список пользователей
     * @return Средний возраст пользователей
     * Также передает строку результата сервису уведомлений
     */
    public double calculateAverageAge(List<User> users) {
        double averageAge = users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
        notificationService.sendNotification("\nAverage age of users " + averageAge + " years old.");
        return averageAge;
    }
}