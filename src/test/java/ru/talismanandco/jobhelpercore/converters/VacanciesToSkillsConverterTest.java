package ru.talismanandco.jobhelpercore.converters;

import org.junit.jupiter.api.Test;
import ru.talismanandco.jobhelpercore.dto.Vacancy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VacanciesToSkillsConverterTest {

    VacanciesToSkillsConverter vacanciesToSkillsConverter = new VacanciesToSkillsConverter();

    @Test
    void convert() {

        List<Vacancy> vacancies = new ArrayList<>();
        Vacancy vacancy1 = new Vacancy();
        vacancy1.setCompany("Google");
        vacancy1.setTitle("Software Developer");
        vacancy1.setSalary("10 000 USD");
        vacancy1.setSkills(List.of("Java", "Spring", "Git", "SQL"));
        vacancies.add(vacancy1);

        Vacancy vacancy2 = new Vacancy();
        vacancy2.setCompany("Yandex");
        vacancy2.setTitle("Senior Java Developer");
        vacancy2.setSalary("500 000");
        vacancy2.setSkills(List.of("Java", "Spring", "SQL"));
        vacancies.add(vacancy2);

        Vacancy vacancy3 = new Vacancy();
        vacancy3.setCompany("ООО \"ПЕЧЬ\"");
        vacancy3.setTitle("Печенег");
        vacancy3.setSalary("100_000_000_000 USD");
        vacancy3.setSkills(List.of("SQL"));
        vacancies.add(vacancy3);



        Map<String, Integer> map = vacanciesToSkillsConverter.convert(vacancies);
        assertEquals(3, map.get("SQL"));
        assertEquals(2, map.get("Java"));
        assertEquals(2, map.get("Spring"));
        assertEquals(1, map.get("Git"));

        System.out.println(map);


    }
}