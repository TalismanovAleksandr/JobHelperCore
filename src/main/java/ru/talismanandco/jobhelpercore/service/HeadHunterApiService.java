package ru.talismanandco.jobhelpercore.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import ru.talismanandco.jobhelpercore.dto.headhunter.HeadHunterVacancies;
import ru.talismanandco.jobhelpercore.dto.headhunter.HeadHunterVacancy;
import ru.talismanandco.jobhelpercore.expections.HeadHunterException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Slf4j
public class HeadHunterApiService {

    private static final String VACANCIES_ADDRESS = "https://api.hh.ru/vacancies";
    private final ObjectMapper mapper = new ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
            false
    );

    //Default pagination params
    public List<HeadHunterVacancy> getVacancies(String queryParam) {
        return this.getVacancies(queryParam,"0","100");
    }

    public List<HeadHunterVacancy> getVacancies(String queryParam,String page, String perPage) {
        HeadHunterVacancies headHunterVacancies = new HeadHunterVacancies();
        try {
            URIBuilder uriBuilder = new URIBuilder(VACANCIES_ADDRESS);
            URI uri = uriBuilder
                    .setParameter("text", queryParam)
                    .setParameter("page", page)
                    .setParameter("per_page", perPage)
                    .build();
            try {
                headHunterVacancies = mapper.readValue(requestServer(uri), HeadHunterVacancies.class);
            } catch (JsonProcessingException e) {
                log.debug(e.getMessage(), e);
                throw new HeadHunterException("JsonProcessingException", e);
            }
        } catch (URISyntaxException e) {
            log.debug(e.getMessage(), e);
        }
        return headHunterVacancies.getItems();
    }

    public HeadHunterVacancy getVacancy(long id) {
        URI params;
        try {
            URIBuilder uriBuilder = new URIBuilder(VACANCIES_ADDRESS + "/" + id);
            params = uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new HeadHunterException("problems with uri", e);
        }
        HeadHunterVacancy headHunterVacancy;
        try {
            headHunterVacancy = mapper.readValue(requestServer(params), HeadHunterVacancy.class);
        } catch (JsonProcessingException e) {
            log.debug(e.getMessage(), e);
            throw new HeadHunterException("json mapping problem", e);
        }
        return headHunterVacancy;
    }

    private String requestServer(URI uri) {
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        log.debug("uri=" + uri);
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader("Accept", "application/json");
        String response;
        try {
            response = EntityUtils.toString(httpClient.execute(httpGet).getEntity());
        } catch (IOException e) {
            log.debug(e.getMessage(), e);
            throw new HeadHunterException("httpClient.execute problem", e);
        }
        log.debug("response=" + response);
        return response;
    }

}
