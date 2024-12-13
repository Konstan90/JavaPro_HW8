package ru.kononov.limitservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "userlimit")
public class UserLimit {
    @Id
    private Long userId;
    @Column(name = "limit_amount")
    private BigDecimal limit;
    private BigDecimal spentAmount;

    public UserLimit() {
        this.limit = BigDecimal.valueOf(10000.00); // Начальный лимит
        this.spentAmount = BigDecimal.ZERO; // Начальная потраченная сумма
    }

    public void setSpentAmount(BigDecimal spentAmount) {
        this.spentAmount = spentAmount;
    }

    public void reduceLimit(BigDecimal amount) {
        this.spentAmount = this.spentAmount.add(amount);
    }

    public void restoreLimit(BigDecimal amount) {
        this.spentAmount = this.spentAmount.subtract(amount);
    }
}
