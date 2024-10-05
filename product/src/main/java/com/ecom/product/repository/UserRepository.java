package com.ecom.product.repository;

//import com.ecom.product.entity.User;
import com.ecom.product.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@org.springframework.stereotype.Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(User user){
        String sql = "INSERT INTO user (first_name, last_name, email, role, password) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole(), user.getPassword());
    }

    public boolean existsByEmail(String email){
        String sql = "SELECT COUNT(*) FROM user WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{email}, Integer.class);
        return count != null && count > 0;
    }
}
