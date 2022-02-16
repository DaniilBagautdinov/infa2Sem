package ru.kpfu.itis.bagautdinov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.bagautdinov.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
