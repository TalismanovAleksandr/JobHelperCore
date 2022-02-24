package ru.talismanandco.jobhelpercore.entity;


import lombok.*;
import ru.talismanandco.jobhelpercore.converters.ListToStringConverter;

import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity(name = "vacancy")
public class VacancyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String company;
    @Embedded
    private SalaryEntity salary;
    @Convert(converter = ListToStringConverter.class)
    private List<String> skills;
}
