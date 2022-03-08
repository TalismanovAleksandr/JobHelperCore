package ru.talismanandco.jobhelpercore.converters;

import org.springframework.stereotype.Component;
import ru.talismanandco.jobhelpercore.dto.Vacancy;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class VacanciesToSkillsConverter implements GenericConverter<List<Vacancy>, Map<String, Integer>> {

    @Override
    public Map<String, Integer> convert(List<Vacancy> vacancies) {

        Map<String, Integer> map = new HashMap<>();

        for (Vacancy vacancy : vacancies) {
            Collection<String> skills = vacancy.getSkills();
            for (String skill : skills) {
                Integer value = map.get(skill);
                //noinspection Java8MapApi
                if (value == null) {
                    map.put(skill, 1);
                } else {
                    map.put(skill, value + 1);
                }
            }
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap<String, Integer>::new));
    }
}
