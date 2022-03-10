package ru.talismanandco.jobhelpercore.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UtilsTest {

    @Autowired
    private Utils utils;

    Set<String> resultSkills = Set.of("JVM", "Collections", "Stream", "Concurrency", "СУБД", "Postgres", "MySql");

    public static final String REQUIREMENTS = "Хорошее знание JVM, Collections, " +
            "Stream API, Concurrency. " +
            "Опыт работы с СУБД Postgres, MySql или подобными. " +
            "Понимание что такое JOIN, GROUP...";

    @Test
    void requirementsToSkills() {
        Set<String> resultingSet = utils.requirementsToSkills(REQUIREMENTS);
        assertTrue(resultSkills.containsAll(resultingSet));
    }

    @Test
    void requirementsToSkills2() {
        Set<String> resultingSet = utils.requirementsToSkills("jvm");
        assertTrue(resultingSet.contains("jvm"));
    }
}