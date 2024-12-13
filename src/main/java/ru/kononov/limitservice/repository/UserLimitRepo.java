package ru.kononov.limitservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kononov.limitservice.entity.UserLimit;

@Repository
public interface UserLimitRepo extends JpaRepository<UserLimit, Long> {
    UserLimit findByUserId(Long userId);
}
