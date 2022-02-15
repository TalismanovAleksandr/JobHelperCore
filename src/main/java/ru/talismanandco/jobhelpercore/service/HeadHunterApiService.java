package ru.talismanandco.jobhelpercore.service;

import ru.talismanandco.jobhelpercore.dto.Vacancy;

import java.util.List;

public class HeadHunterApiService {


    //TODO поменять сигнатуру метода с List<?> на List<Vacancy>
    public List<Vacancy> getVacancies(String queryParam) {
        //1. TODO интеграция с HH API https://github.com/hhru/api/blob/master/docs/vacancies.md#search GET /vacancies

        //TODO использовать apache http client (CloseableHttpClient)

        return null;
    }

}
