package ru.talismanandco.jobhelpercore.dto;

import lombok.Data;

@Data
public class Salary {
    private Integer from;
    private Integer to;
    private String currency;
    private Boolean gross;
}
