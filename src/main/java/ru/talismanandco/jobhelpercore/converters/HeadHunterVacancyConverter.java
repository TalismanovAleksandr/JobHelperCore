package ru.talismanandco.jobhelpercore.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.talismanandco.jobhelpercore.dto.Salary;
import ru.talismanandco.jobhelpercore.dto.Vacancy;
import ru.talismanandco.jobhelpercore.dto.headhunter.HeadHunterVacancy;
import ru.talismanandco.jobhelpercore.util.Utils;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HeadHunterVacancyConverter implements GenericConverter<List<HeadHunterVacancy>, List<Vacancy>> {
    private final ObjectMapper mapper;
    private final Utils utils;

    @Override
    public List<Vacancy> convert(List<HeadHunterVacancy> headHunterVacancies) {
        return headHunterVacancies.stream()
                .map(headHunterVacancy -> Vacancy.builder()
                        .title(headHunterVacancy.getName())
                        .company(headHunterVacancy.getEmployer().getName())
                        .skills(utils.requirementsToSkills(headHunterVacancy.getSnippet() == null ?
                                "" : headHunterVacancy.getSnippet().getRequirement()))
                        .salary(mapper.convertValue(headHunterVacancy.getSalary(), Salary.class))
                        .build())
                .collect(Collectors.toList());
    }
}
