package ru.talismanandco.jobhelpercore.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import ru.talismanandco.jobhelpercore.dto.HeadHunterVacancies;
import ru.talismanandco.jobhelpercore.dto.HeadHunterVacancy;
import ru.talismanandco.jobhelpercore.dto.Vacancy;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class HeadHunterApiService {

    //Default pagination params
    public List<HeadHunterVacancy> getVacancies(String queryParam) throws IOException, URISyntaxException {
        return this.getVacancies(queryParam,"0","100");
    }

    public List<HeadHunterVacancy> getVacancies(String queryParam,String page, String perPage) throws IOException, URISyntaxException {
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        List<Vacancy> result = new ArrayList<>();

        URIBuilder uriBuilder = new URIBuilder("https://api.hh.ru/vacancies");
        URI params = uriBuilder
                .setParameter("text", queryParam)
                .setParameter("page", page)
                .setParameter("per_page", perPage)
                .build();
        HttpGet httpGet = new HttpGet(params);
        httpGet.addHeader("Accept", "application/json");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        String responseString = EntityUtils.toString(httpResponse.getEntity());
        ObjectMapper mapper = new ObjectMapper().configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false
        );
        HeadHunterVacancies headHunterVacancies = mapper.readValue(responseString, HeadHunterVacancies.class);
        return headHunterVacancies.getItems();
    }

    public HeadHunterVacancy getVacancy(long id) throws URISyntaxException, IOException {
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        List<Vacancy> result = new ArrayList<>();

        URIBuilder uriBuilder = new URIBuilder("https://api.hh.ru/vacancies/"+id);
        URI params = uriBuilder.build();
        HttpGet httpGet = new HttpGet(params);
        httpGet.addHeader("Accept", "application/json");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        String responseString = EntityUtils.toString(httpResponse.getEntity());
        ObjectMapper mapper = new ObjectMapper().configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false
        );
        HeadHunterVacancy headHunterVacancy = mapper.readValue(responseString, HeadHunterVacancy.class);
        return headHunterVacancy;
    }

}
