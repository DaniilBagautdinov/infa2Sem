package ru.kpfu.itis.bagautdinov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.itis.bagautdinov.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
