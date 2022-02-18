package ru.talismanandco.jobhelpercore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeadHunterVacancy {
    Long id;
    String name;
    String description;
    HeadHunterSalary salary;
    HeadHunterEmployer employer;
    List<String> keySkills = new ArrayList<>();

    @JsonSetter("branded_description")
    public void setBrandedDescription(String brandedDescription){
        this.description+= brandedDescription;
    }

    @JsonSetter("key_skills")
    public void addSkill(HeadHunterSkill[] skills)
    {
        for (HeadHunterSkill skill : skills) {
            this.keySkills.add(skill.name);
        }
    }
}
