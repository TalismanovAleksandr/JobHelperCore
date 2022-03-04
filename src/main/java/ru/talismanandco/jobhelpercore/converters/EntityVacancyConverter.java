package ru.talismanandco.jobhelpercore.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.talismanandco.jobhelpercore.dto.Salary;
import ru.talismanandco.jobhelpercore.dto.Vacancy;
import ru.talismanandco.jobhelpercore.entity.SkillEntity;
import ru.talismanandco.jobhelpercore.entity.VacancyEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EntityVacancyConverter implements GenericConverter<List<VacancyEntity>, List<Vacancy>> {
    private final ObjectMapper mapper;

    @Override
    public List<Vacancy> convert(List<VacancyEntity> entities) {
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        for (VacancyEntity entity : entities) {
           vacancies.add(Vacancy.builder()
                           .company(entity.getCompany())
                           .title(entity.getTitle())
                           .salary(mapper.convertValue(entity.getSalary(), Salary.class))
                           .skills(entity.getSkills().stream()
                                   .map(SkillEntity::getName)
                                   .collect(Collectors.toList()))
                .build());
        }
        return vacancies;
    }
}
