package ru.talismanandco.jobhelpercore.entity;


import lombok.*;
import ru.talismanandco.jobhelpercore.converters.ListToStringConverter;

import javax.persistence.*;
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


    //TODO RebuyBoy. @Entity class + flyway migration + CREATE TABLE, INSERTS + незабыть о VacancyService и VacancyRepository
}
