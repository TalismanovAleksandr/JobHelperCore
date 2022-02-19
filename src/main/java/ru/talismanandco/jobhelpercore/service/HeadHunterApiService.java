package ru.talismanandco.jobhelpercore.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import ru.talismanandco.jobhelpercore.dto.HeadHunterVacancies;
import ru.talismanandco.jobhelpercore.dto.HeadHunterVacancy;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class HeadHunterApiService {

    private static final String VACANCIES_ADDRESS = "https://api.hh.ru/vacancies";
    private final ObjectMapper mapper = new ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
            false
    );

    //Default pagination params
    public List<HeadHunterVacancy> getVacancies(String queryParam) throws IOException, URISyntaxException {
        return this.getVacancies(queryParam,"0","100");
    }

    public List<HeadHunterVacancy> getVacancies(String queryParam,String page, String perPage) throws IOException {
        HeadHunterVacancies headHunterVacancies = new HeadHunterVacancies();
        try {
            URIBuilder uriBuilder = new URIBuilder(VACANCIES_ADDRESS);
            URI params = uriBuilder
                    .setParameter("text", queryParam)
                    .setParameter("page", page)
                    .setParameter("per_page", perPage)
                    .build();
            headHunterVacancies = mapper.readValue(requestFromServer(params), HeadHunterVacancies.class);
        } catch (URISyntaxException e) {
            //TODO сделать log.debug
            e.printStackTrace();
        }
        return headHunterVacancies.getItems();
    }

    public HeadHunterVacancy getVacancy(long id) throws URISyntaxException, IOException {
        URIBuilder uriBuilder = new URIBuilder(VACANCIES_ADDRESS+"/"+id);
        URI params = uriBuilder.build();
        return mapper.readValue(requestFromServer(params), HeadHunterVacancy.class);
    }

    private String requestFromServer(URI params) throws IOException {
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(params);
        httpGet.addHeader("Accept", "application/json");
        return EntityUtils.toString(httpClient.execute(httpGet).getEntity());
    }

}
