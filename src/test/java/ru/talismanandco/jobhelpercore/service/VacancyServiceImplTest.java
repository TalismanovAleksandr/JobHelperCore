package ru.talismanandco.jobhelpercore.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.talismanandco.jobhelpercore.dto.Vacancy;
import ru.talismanandco.jobhelpercore.dto.headhunter.HeadHunterVacancy;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class VacancyServiceImplTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private VacancyService vacancyService;

    @MockBean
    private HeadHunterApiService headHunterApiService;

    @Test
    void findVacanciesByVacancyName() throws IOException {

        List<HeadHunterVacancy> list = objectMapper.readValue(this.getClass().getClassLoader().getResourceAsStream("headhunter-mock-response.json"), new TypeReference<>() {
        });

        when(headHunterApiService.getVacancies(anyString())).thenReturn(list);

        List<Vacancy> java = vacancyService.findVacanciesByVacancyName("java");
    }
}