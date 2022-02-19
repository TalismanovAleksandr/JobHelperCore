package ru.talismanandco.jobhelpercore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.talismanandco.jobhelpercore.dto.HeadHunterVacancy;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

class HeadHunterApiServiceTest {

    private final HeadHunterApiService headHunterApiService = new HeadHunterApiService();

    @Test
    public void testHeadHunterGetVacancies() throws IOException, URISyntaxException {
        Assertions.assertDoesNotThrow(()->{
            List<HeadHunterVacancy> vacancies = headHunterApiService.getVacancies("Java", "0","5");
            Assertions.assertEquals(5,vacancies.size());
            System.out.println(vacancies.size());

            for (HeadHunterVacancy vacancy: vacancies){
                System.out.print(vacancy.getName() + " / " + vacancy.getEmployer().getName()+ " / ");
                if (vacancy.getSalary()!=null){
                    if(vacancy.getSalary().getFrom()!=null) {
                        System.out.print(vacancy.getSalary().getFrom());
                    }
                    else {
                        System.out.print("_");
                    }
                    System.out.print(" - " );
                    if(vacancy.getSalary().getTo()!=null){
                        System.out.println(vacancy.getSalary().getTo());
                    }
                    else {
                        System.out.print("_");
                    }
                }
                else {
                    System.out.println("_");
                }

                if(vacancy.getKeySkills()!=null){
                    vacancy.getKeySkills().forEach(System.out::println);
                }
            }
        });
    }

    @Test
    public void testHeadHunterGetVacancy() throws URISyntaxException, IOException {
        Assertions.assertDoesNotThrow(()-> {
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