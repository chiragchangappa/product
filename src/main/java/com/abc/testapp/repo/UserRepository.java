package com.abc.testapp.repo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.abc.testapp.entity.User;
public interface  UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}

