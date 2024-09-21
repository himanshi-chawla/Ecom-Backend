package project.example.sample.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.example.sample.entity.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long> {
    // Custom query to find a user by username
    user findByUsername(String username);
}
