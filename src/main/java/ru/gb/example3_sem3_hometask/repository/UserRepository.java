package ru.gb.example3_sem3_hometask.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.example3_sem3_hometask.domain.User;

import java.util.List;

/**
 * Репозиторий пользователей
 */
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Метод получения списка пользователей из базы данных
     * @return список пользоватлей
     */
    public List<User> getUsers() {
        String sql = "SELECT * FROM userTable";
        RowMapper<User> userRowMapper = ((rs, rowNum) -> {
            User user = new User();
            user.setName(rs.getString(("name")));
            user.setAge(rs.getInt("age"));
            user.setEmail(rs.getString("email"));
            return user;
        });
        return jdbcTemplate.query(sql, userRowMapper);
    }

    /**
     * Метод добавления нового пользователя в базу данных
     * @param user Пользователь
     */
    public void addUser(User user) {
        if (user != null) {
            String sql = "INSERT INTO userTable (name, age, email) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail());
        }
    }
}