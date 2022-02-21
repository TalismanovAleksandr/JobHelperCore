package ru.talismanandco.jobhelpercore.service;

import ru.talismanandco.jobhelpercore.entity.VacancyEntity;

import java.util.List;

public interface VacancyService {
    VacancyEntity save(VacancyEntity vacancy);

    void delete(VacancyEntity vacancy);
    void delete(Long id);

    List<VacancyEntity> getAll();
    List<VacancyEntity> getWithFilters();

}
