package ru.talismanandco.jobhelpercore.service;

import org.junit.jupiter.api.Test;
import ru.talismanandco.jobhelpercore.dto.HeadHunterVacancy;

import java.io.IOException;
import java.util.List;

class HeadHunterApiServiceTest {

    private final HeadHunterApiService headHunterApiService = new HeadHunterApiService();

    @Test
    public void testHeadHunterIntegration() throws IOException {
        List<?> vacancies = headHunterApiService.getVacancies("Java", "0","100");
        System.out.println(vacancies.size());
        for (HeadHunterVacancy vacancy: (List<HeadHunterVacancy>) vacancies){
            System.out.print(
                    vacancy.getName() + " / " +
                    vacancy.getEmployer().getName()+ " / " +
                            (vacancy.getSalary()!=null?(
                            (vacancy.getSalary().getFrom()!=null?vacancy.getSalary().getFrom():"_")+ " - " +
                            (vacancy.getSalary().getTo()!=null?vacancy.getSalary().getTo():"_")
                        ):"_"));
//
//            if(vacancy.getKeySkills()!=null){
//                vacancy.getKeySkills().forEach((skill)->System.out.println(skill.get("name")));
//            }

            if(vacancy.getKeySkills()!=null){
                vacancy.getKeySkills().forEach((String skill)->System.out.println(skill));
            }
            System.out.println();
        }
    }

}