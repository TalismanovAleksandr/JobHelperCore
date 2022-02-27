package ru.talismanandco.jobhelpercore.service;

import java.util.Map;

public interface SkillsService {
    Map<String, Integer> getSortedSkills(String vacancyName);
}
