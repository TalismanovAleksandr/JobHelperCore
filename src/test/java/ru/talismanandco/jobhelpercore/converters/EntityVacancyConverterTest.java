package ru.talismanandco.jobhelpercore.converters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.talismanandco.jobhelpercore.dto.Vacancy;
import ru.talismanandco.jobhelpercore.entity.VacancyEntity;
import ru.talismanandco.jobhelpercore.repository.VacancyRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EntityVacancyConverterTest {

    @Autowired
    EntityVacancyConverter converter;

    @Autowired
    VacancyRepository repository;

    @Test
    public void convert(){
        List<VacancyEntity> vacancies = repository.findByTitle("Java developer");
        List<Vacancy> convert = converter.convert(vacancies);
        assertEquals("Java developer",convert.get(0).getTitle());
        assertEquals("java",convert.get(0).getSkills().get(0));
    }
}
