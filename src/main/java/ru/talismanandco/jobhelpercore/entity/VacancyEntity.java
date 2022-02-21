package ru.talismanandco.jobhelpercore.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.talismanandco.jobhelpercore.converters.ListToStringConverter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
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
