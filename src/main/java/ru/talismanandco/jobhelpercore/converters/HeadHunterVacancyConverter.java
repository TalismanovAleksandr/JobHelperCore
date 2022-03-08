package ru.talismanandco.jobhelpercore.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.talismanandco.jobhelpercore.dto.Salary;
import ru.talismanandco.jobhelpercore.dto.Vacancy;
import ru.talismanandco.jobhelpercore.dto.headhunter.HeadHunterVacancy;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HeadHunterVacancyConverter implements GenericConverter<List<HeadHunterVacancy>, List<Vacancy>> {
    private final ObjectMapper mapper;

    @Override
    public List<Vacancy> convert(List<HeadHunterVacancy> hhVacancies) {
        return hhVacancies.stream()
                .map(hhVacancy -> Vacancy.builder()
                                .title(hhVacancy.getName())
                                .skills(hhVacancy.getKeySkills())
                                .salary(mapper.convertValue(hhVacancy.getSalary(), Salary.class))
                                .build())
                .collect(Collectors.toList());
    }
}
