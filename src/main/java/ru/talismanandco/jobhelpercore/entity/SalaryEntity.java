package ru.talismanandco.jobhelpercore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class SalaryEntity {
    @Column(name = "salary_from")
    private Integer from;
    @Column(name = "salary_to")
    private Integer to;
    private String currency;
    private boolean gross;
}
