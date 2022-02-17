package ru.talismanandco.jobhelpercore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeadHunterVacancy {
    String name;
    HeadHunterSalary salary;
    HeadHunterEmployer employer;
    List<String> keySkills;

//TODO Выбрать оптимальный вариант для keySkills
//    @JsonProperty("key_skills")
//    List<HeadHunterSkill> keySkills;
//    List<Map<String ,String>> keySkills;

    @JsonSetter("key_skills")
    public void addSkill(Map<String ,String> skill){
        this.keySkills.add(skill.get("name"));
    }
}
