package ru.talismanandco.jobhelpercore.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.talismanandco.jobhelpercore.service.SkillsService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class VacancyController {

    private final SkillsService skillsService;

    @GetMapping("/sorted_skills/{vacancy_name}")
    public Map<String, Integer> execute(@PathVariable("vacancy_name") String vacancyName) {
        return skillsService.getSortedSkills(vacancyName);
    }
}
