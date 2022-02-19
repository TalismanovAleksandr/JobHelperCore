package ru.talismanandco.jobhelpercore.dto;

import lombok.Data;

@Data
public class HeadHunterSalary {
    private Integer from;
    private Integer to;
    private String currency;
    private Boolean gross;
}
