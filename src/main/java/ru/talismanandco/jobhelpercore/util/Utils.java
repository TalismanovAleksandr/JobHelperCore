package ru.talismanandco.jobhelpercore.util;

import org.springframework.stereotype.Component;
import ru.talismanandco.jobhelpercore.entity.SkillEntity;
import ru.talismanandco.jobhelpercore.repository.SkillRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Utils {
    private final SkillRepository skillRepository;
    private final Set<String> allSkills;

    public Utils(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
        allSkills = getAllSkills();
    }

    private Set<String> getAllSkills() {
        return skillRepository.findAll()
                .stream()
                .map(SkillEntity::getName)
                .collect(Collectors.toSet());
    }

    public Set<String> requirementsToSkills(String requirements) {
        System.out.println(requirements);
        Set<String> result = new HashSet<>();
        if (requirements != null && !requirements.isEmpty()) {
            requirements = requirements
                    .replaceAll("</?highlighttext>", "")
                    .replaceAll("[/():-]", " ");
            String[] strings = requirements.split("[ ,.]");
            for (String word : strings) {
                if (allSkills.stream().anyMatch(word::equalsIgnoreCase)) {
                    result.add(word);
                }
            }
        }
        return result;
    }
}
