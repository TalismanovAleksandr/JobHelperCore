package ru.talismanandco.jobhelpercore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Data
public class SalaryEntity {
    @Column(name = "bottom")
    private BigDecimal from;
    @Column(name = "top")
    private BigDecimal to;
    private String currency;
    private boolean gross;
}
