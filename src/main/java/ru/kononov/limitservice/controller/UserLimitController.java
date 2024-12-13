package ru.kononov.limitservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kononov.limitservice.service.UserLimitServiceImpl;

import java.math.BigDecimal;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/limits")
@Tag(name = "Сервис лимитов", description = "Управление дневными лимитами пользователей на возможные платежи")
public class UserLimitController {

    private final UserLimitServiceImpl userLimitService;

    @GetMapping("/{userId}")
    @Operation(
            summary = "Получить остаток лимита",
            description = "Позволяет получить остаток лимита по id пользователя")
    public ResponseEntity<BigDecimal> getLimit(@PathVariable Long userId) {
        return ResponseEntity.ok(userLimitService.getUserLimit(userId).getLimit().subtract(userLimitService.getUserLimit(userId).getSpentAmount()));
    }

    @PostMapping("/{userId}/spend")
    @Operation(
            summary = "Уменьшить остаток",
            description = "Позволяет уменьшить остаток")
    public ResponseEntity<String> spendLimit(@PathVariable Long userId, @RequestBody BigDecimal amount) {
        try {
            userLimitService.spendLimit(userId, amount);
            return ResponseEntity.ok("Платеж успешно проведен");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("/{userId}/restore")
    @Operation(
            summary = "Восстановить лимит",
            description = "Позволяет восстановить лимит пользователя")
    public ResponseEntity<String> restoreLimit(@PathVariable Long userId, @RequestBody BigDecimal amount) {
        userLimitService.restoreLimit(userId, amount);
        return ResponseEntity.ok("Лимит восстановлен");
    }
}
