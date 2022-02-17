package ru.talismanandco.jobhelpercore.dto;

import lombok.Data;

@Data
public class HeadHunterSalary {
    Float from,to;
    String currency;
    Boolean gross;
}
