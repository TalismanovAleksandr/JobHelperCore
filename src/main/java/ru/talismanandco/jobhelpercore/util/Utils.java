package ru.talismanandco.jobhelpercore.util;

import java.util.HashSet;
import java.util.Set;

public class Utils {

    private static final Set<String> allSkills = Set.of("JVM", "Collections", "Stream", "Concurrency", "СУБД", "Postgres", "MySql", "Kotlin", "Java", "SQL");

    public static Set<String> requirementsToSkills(String requirements) {
        Set<String> result = new HashSet<>();
        String[] strings = requirements.split("[ ,.]+");
        for (String word : strings) {
            if (allSkills.stream().anyMatch(word::equalsIgnoreCase)) {
                result.add(word);
            }
        }
        return result;
    }
}
