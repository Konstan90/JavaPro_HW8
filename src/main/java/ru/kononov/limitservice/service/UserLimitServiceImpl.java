package ru.kononov.limitservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kononov.limitservice.entity.UserLimit;
import ru.kononov.limitservice.repository.UserLimitRepo;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLimitServiceImpl implements UserLimitService {

    private final UserLimitRepo userLimitRepository;

    public UserLimit getUserLimit(Long userId) {
        Optional<UserLimit> userLimit = Optional.ofNullable(userLimitRepository.findByUserId(userId));

        if (userLimit.isEmpty()) {
            // Если пользователя нет, создаем новую запись с дефолтным лимитом
            UserLimit newUserLimit = new UserLimit();
            newUserLimit.setUserId(userId);
            userLimitRepository.save(newUserLimit);
            return newUserLimit;
        }

        return userLimit.get();
    }

    public void spendLimit(Long userId, BigDecimal amount) {
        UserLimit userLimit = getUserLimit(userId);
        if (userLimit.getLimit().subtract(userLimit.getSpentAmount()).compareTo(amount) >= 0) {
            userLimit.reduceLimit(amount);
            userLimitRepository.save(userLimit);
        } else {
            throw new IllegalArgumentException("Недостаточно средств для проведения операции");
        }
    }

    public void restoreLimit(Long userId, BigDecimal amount) {
        UserLimit userLimit = getUserLimit(userId);
        userLimit.restoreLimit(amount);
        userLimitRepository.save(userLimit);
    }

    public void resetAllLimits() {
        // Сброс всех лимитов в 00:00
        for (UserLimit userLimit : userLimitRepository.findAll()) {
            userLimit.setSpentAmount(BigDecimal.ZERO);
            userLimitRepository.save(userLimit);
        }
    }
}

