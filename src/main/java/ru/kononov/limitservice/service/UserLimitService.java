package ru.kononov.limitservice.service;

import ru.kononov.limitservice.entity.UserLimit;

import java.math.BigDecimal;

public interface UserLimitService {
    public UserLimit getUserLimit(Long userId);

    public void spendLimit(Long userId, BigDecimal amount);

    public void restoreLimit(Long userId, BigDecimal amount);

    public void resetAllLimits();
}
