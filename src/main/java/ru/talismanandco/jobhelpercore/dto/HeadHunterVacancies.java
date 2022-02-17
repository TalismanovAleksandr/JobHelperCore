package ru.talismanandco.jobhelpercore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeadHunterVacancies {
    List<HeadHunterVacancy> items;
    Integer found, pages, page,per_page;
}
