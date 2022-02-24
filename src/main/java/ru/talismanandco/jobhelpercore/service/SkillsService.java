package ru.talismanandco.jobhelpercore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.talismanandco.jobhelpercore.converters.VacanciesToSkillsConverter;
import ru.talismanandco.jobhelpercore.dto.Vacancy;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class SkillsService {

    private final VacancyService vacancyService;
    private final VacanciesToSkillsConverter vacanciesToSkillsConverter;

    public Map<String, Integer> getSortedSkills(String vacancyName) {

        List<Vacancy> vacanciesBySkill = vacancyService.findVacanciesByVacancyName(vacancyName);
        return vacanciesToSkillsConverter.convert(vacanciesBySkill);
    }
}
