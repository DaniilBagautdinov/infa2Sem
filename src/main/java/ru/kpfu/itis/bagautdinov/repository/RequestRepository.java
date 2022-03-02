package ru.kpfu.itis.bagautdinov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.bagautdinov.model.Request;

public interface RequestRepository extends JpaRepository<Request, Integer> {
}
