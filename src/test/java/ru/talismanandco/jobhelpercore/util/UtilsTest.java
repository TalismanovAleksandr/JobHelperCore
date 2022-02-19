package ru.talismanandco.jobhelpercore.util;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    Set<String> resultSkills = Set.of("JVM", "Collections", "Stream", "Concurrency", "СУБД", "Postgres", "MySql");

    public static final String REQUIREMENTS = "Хорошее знание JVM, Collections, " +
            "Stream API, Concurrency. " +
            "Опыт работы с СУБД Postgres, MySql или подобными. " +
            "Понимание что такое JOIN, GROUP...";

    @Test
    void requirementsToSkills() {
        Set<String> resultingSet = Utils.requirementsToSkills(REQUIREMENTS);
        assertTrue(resultSkills.containsAll(resultingSet));
    }

    @Test
    void requirementsToSkills2() {
        Set<String> resultingSet = Utils.requirementsToSkills("jvm");
        assertTrue(resultingSet.contains("jvm"));
    }
}