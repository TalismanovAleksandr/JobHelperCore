package ru.talismanandco.jobhelpercore.dto;

import lombok.Data;

import java.util.List;

@Data
public class Vacancy {

    private String company;
    /** пример от 510 000 до 572 000 руб. до вычета налогов */
    private String salary;
    private String title;
    /** пример "Java" "Spring Framework" */
    private List<String> skills;
}
