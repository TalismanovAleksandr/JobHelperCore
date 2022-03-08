package ru.talismanandco.jobhelpercore.converters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.talismanandco.jobhelpercore.dto.Vacancy;
import ru.talismanandco.jobhelpercore.dto.headhunter.HeadHunterVacancy;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HeadHunterVacancyConverterTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private HeadHunterVacancyConverter converter;

    @Test
    void convert() throws IOException {
        List<HeadHunterVacancy> list = mapper.readValue(this.getClass().getClassLoader().getResourceAsStream("headhunter-mock-response.json"), new TypeReference<>(){});
        List<Vacancy> vacancies = converter.convert(list);
        assertEquals(5,vacancies.size());
        assertEquals(120000,vacancies.get(0).getSalary().getFrom());
        assertEquals("Стажер-программист Java",vacancies.get(3).getTitle());
    }
}