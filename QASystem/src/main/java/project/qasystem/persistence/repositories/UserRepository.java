package project.qasystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.qasystem.persistence.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // needed for user authentication
}
