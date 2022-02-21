package ru.talismanandco.jobhelpercore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class SalaryEntity {
    @Column(name = "bottom")
    private int from;
    @Column(name = "top")
    private int to;
    private String currency;
    private boolean gross;
}
