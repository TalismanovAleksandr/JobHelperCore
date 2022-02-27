package ru.talismanandco.jobhelpercore.service;

import ru.talismanandco.jobhelpercore.dto.headhunter.HeadHunterVacancy;

import java.util.List;

public interface HeadHunterApiService {

    List<HeadHunterVacancy> getVacancies(String queryParam);
    List<HeadHunterVacancy> getVacancies(String queryParam, String page, String perPage);
    HeadHunterVacancy getVacancy(long id);
}
