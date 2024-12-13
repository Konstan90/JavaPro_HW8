package ru.kononov.limitservice.sheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.kononov.limitservice.service.UserLimitServiceImpl;

@Component
@RequiredArgsConstructor
public class LimitResetScheduler {

    private final UserLimitServiceImpl userLimitService;

    @Scheduled(cron = "0 0 0 * * *") // Запуск каждый день в полночь
    public void resetLimits() {
        userLimitService.resetAllLimits();
    }
}
