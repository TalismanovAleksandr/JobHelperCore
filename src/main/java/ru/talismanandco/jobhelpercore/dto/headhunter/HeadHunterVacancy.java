package ru.talismanandco.jobhelpercore.dto.headhunter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeadHunterVacancy {
    private Long id;
    private String name;
    private String description;
    private HeadHunterSalary salary;
    private HeadHunterEmployer employer;
    private Snippet snippet;
    private List<String> keySkills = new ArrayList<>();

    @JsonSetter("branded_description")
    private void setBrandedDescription(String brandedDescription) {
        this.description += brandedDescription;
    }

    @JsonSetter("key_skills")
    private void addSkill(HeadHunterSkill[] skills) {
        for (HeadHunterSkill skill : skills) {
            this.keySkills.add(skill.getName());
        }
    }
}
