package ru.talismanandco.jobhelpercore.service;

import org.junit.jupiter.api.Test;
import ru.talismanandco.jobhelpercore.dto.HeadHunterVacancy;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

class HeadHunterApiServiceTest {

    private final HeadHunterApiService headHunterApiService = new HeadHunterApiService();

    @Test
    public void testHeadHunterGetVacancies() throws IOException, URISyntaxException {
        List<?> vacancies = headHunterApiService.getVacancies("Java", "0","5");
        System.out.println(vacancies.size());
        for (HeadHunterVacancy vacancy: (List<HeadHunterVacancy>) vacancies){
            System.out.print(
                    vacancy.getName() + " / " +
                    vacancy.getEmployer().getName()+ " / " +
                            (vacancy.getSalary()!=null?(
                            (vacancy.getSalary().getFrom()!=null?vacancy.getSalary().getFrom():"_")+ " - " +
                            (vacancy.getSalary().getTo()!=null?vacancy.getSalary().getTo():"_")
                        ):"_"));

            if(vacancy.getKeySkills()!=null){
                vacancy.getKeySkills().forEach((String skill)->System.out.println(skill));
            }
            System.out.println(vacancy.getDescription());
        }
    }

    @Test
    public void testHeadHunterGetVacancy() throws URISyntaxException, IOException {
        //Ищем одну вакансию и запрашиваем её полностью по id
        HeadHunterVacancy headHunterVacancy = headHunterApiService.getVacancy(
                headHunterApiService.getVacancies("java", "0", "1").get(0).getId()
        );
        System.out.println(headHunterVacancy.getName());
        System.out.println(headHunterVacancy.getKeySkills().toString());
    }
}