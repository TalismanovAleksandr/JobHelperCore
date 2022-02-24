package ru.talismanandco.jobhelpercore.service;

import ru.talismanandco.jobhelpercore.dto.Vacancy;

import java.util.List;

public interface VacancyService {

    List<Vacancy> findVacanciesByVacancyName(String skill);

}
