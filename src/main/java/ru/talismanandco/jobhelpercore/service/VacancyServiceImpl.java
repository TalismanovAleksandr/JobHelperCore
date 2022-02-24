package ru.talismanandco.jobhelpercore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.talismanandco.jobhelpercore.dto.Vacancy;
import ru.talismanandco.jobhelpercore.dto.headhunter.HeadHunterVacancy;
import ru.talismanandco.jobhelpercore.repository.VacancyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;
    private final HeadHunterApiService headHunterApiService;

    @Override
    public List<Vacancy> findVacanciesByVacancyName(String vacancyName) {
        //TODO RebuyBoy

        List<HeadHunterVacancy> vacancies = headHunterApiService.getVacancies(vacancyName);
        return null;
    }
}
