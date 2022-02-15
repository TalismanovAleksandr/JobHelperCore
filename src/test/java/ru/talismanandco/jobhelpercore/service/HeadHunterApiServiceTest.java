package ru.talismanandco.jobhelpercore.service;

import org.junit.jupiter.api.Test;

import java.util.List;

class HeadHunterApiServiceTest {

    private final HeadHunterApiService headHunterApiService = new HeadHunterApiService();

    @Test
    public void testHeadHunterIntegration() {
        List<?> vacancies = headHunterApiService.getVacancies("Java");
        System.out.println(vacancies.size());
    }

}