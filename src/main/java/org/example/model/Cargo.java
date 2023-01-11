package org.example.model;

import java.math.BigDecimal;

public enum Cargo {
    NORMAL(BigDecimal.ZERO),
    NON_SOLID(BigDecimal.valueOf(150)),
    DANGEROUS(BigDecimal.valueOf(300));
    private final BigDecimal additionalRevenuePerMonth;
    Cargo(BigDecimal additionalRevenuePerMonth) {
        this.additionalRevenuePerMonth = additionalRevenuePerMonth;
    }
    public BigDecimal getAdditionalRevenuePerMonth() {
        return this.additionalRevenuePerMonth;
    }
}
