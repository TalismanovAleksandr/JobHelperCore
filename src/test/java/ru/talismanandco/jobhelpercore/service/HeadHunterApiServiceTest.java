package ru.talismanandco.jobhelpercore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.talismanandco.jobhelpercore.dto.headhunter.HeadHunterVacancy;

import java.util.List;

@SpringBootTest
class HeadHunterApiServiceTest {

    @Autowired
    private HeadHunterApiService headHunterApiService;

    @Test
    public void testHeadHunterGetVacancies() {
        Assertions.assertDoesNotThrow(() -> {
            List<HeadHunterVacancy> vacancies = headHunterApiService.getVacancies("Java", "0", "2");
            Assertions.assertEquals(2, vacancies.size());

//            debugInfo(vacancies);
        });
    }

    private void debugInfo(List<HeadHunterVacancy> vacancies) {
        for (HeadHunterVacancy vacancy : vacancies) {
            System.out.print(vacancy.getName() + " / " + vacancy.getEmployer().getName() + " / ");
            if (vacancy.getSalary() != null) {
                if (vacancy.getSalary().getFrom() != null) {
                    System.out.print(vacancy.getSalary().getFrom());
                } else {
                    System.out.print("_");
                }
                System.out.print(" - ");
                if (vacancy.getSalary().getTo() != null) {
                    System.out.println(vacancy.getSalary().getTo());
                } else {
                    System.out.print("_");
                }
            } else {
                System.out.println("_");
            }

            if (vacancy.getKeySkills() != null) {
                vacancy.getKeySkills().forEach(System.out::println);
            }
        }
    }

    @Test
    public void testHeadHunterGetVacancy() {
        Assertions.assertDoesNotThrow(() -> {
            //Ищем одну вакансию и запрашиваем её полностью по id
            HeadHunterVacancy headHunterVacancy = headHunterApiService.getVacancy(
                    headHunterApiService.getVacancies("java", "0", "1").get(0).getId()
            );
            Assertions.assertNotNull(headHunterVacancy.getName());
            System.out.println(headHunterVacancy.getName());
            System.out.println(headHunterVacancy.getKeySkills().toString());
        });
    }
}