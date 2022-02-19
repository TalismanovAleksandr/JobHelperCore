package ru.talismanandco.jobhelpercore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeadHunterVacancies {
    private List<HeadHunterVacancy> items;
    private Integer found;
    private Integer pages;
    private Integer page;
    private Integer per_page;
}
