package ru.talismanandco.jobhelpercore.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.talismanandco.jobhelpercore.converters.EntityVacancyConverter;
import ru.talismanandco.jobhelpercore.converters.HeadHunterVacancyConverter;
import ru.talismanandco.jobhelpercore.dto.Vacancy;
import ru.talismanandco.jobhelpercore.entity.VacancyEntity;
import ru.talismanandco.jobhelpercore.repository.VacancyRepository;
import ru.talismanandco.jobhelpercore.service.HeadHunterApiService;
import ru.talismanandco.jobhelpercore.service.VacancyService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Profile("!mock")
@Slf4j
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;
    private final HeadHunterApiService headHunterApiService;
    private final EntityVacancyConverter vacConverter;
    private final HeadHunterVacancyConverter hhConverter;

    @Override
    public List<Vacancy> findVacanciesByVacancyName(String vacancyName) {
        List<Vacancy> vacancies;
        List<VacancyEntity> vacanciesByTitle = vacancyRepository.findByTitle(vacancyName);
        if (vacanciesByTitle.isEmpty()) {
            vacancies = hhConverter.convert(headHunterApiService.getVacancies(vacancyName));
        } else {
            vacancies = vacConverter.convert(vacanciesByTitle);
        }
        return vacancies;
    }
}
