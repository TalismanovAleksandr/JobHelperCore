package ru.talismanandco.jobhelpercore.service;

import java.util.List;

public class HeadHunterApiService {


    //TODO поменять сигнатуру метода с List<?> на List<Vacancy>
    public List<?> getVacancies(String queryParam) {
        //1. TODO интеграция с HH API https://github.com/hhru/api/blob/master/docs/vacancies.md#search GET /vacancies

        //TODO использовать apache http client (CloseableHttpClient)

        return null;
    }

}
