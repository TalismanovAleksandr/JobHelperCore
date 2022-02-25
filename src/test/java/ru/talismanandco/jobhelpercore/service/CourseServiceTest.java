package ru.talismanandco.jobhelpercore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.talismanandco.jobhelpercore.entity.CourseEntity;
import ru.talismanandco.jobhelpercore.entity.SkillEntity;
import ru.talismanandco.jobhelpercore.repository.SkillRepository;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

class CourseServiceTest {
    @Mock
    private SkillRepository skillRepository;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Метод getCoursesBySkill не должен обрабатывать runtime исключения
     */
    @Test
    void testCourseServiceGetCoursesBySkillThrowsException() {
        Mockito.doThrow(new RuntimeException("success"))
                .when(skillRepository)
                .findByTitle(Mockito.anyString());
        CourseService service = new CourseService(skillRepository);
        String skill = "some skill";

        Assertions.assertThrows(RuntimeException.class,
                () -> service.getCoursesBySkill(skill));
    }

    /**
     * Метод getCoursesBySkill не должен пытаться искать скилл в бд, если параметр null
     * В ответе ожидается пустое множество
     */
    @Test
    void testCourseServiceGetCoursesBySkillCanWorkWithNullArg() {
        Mockito.doThrow(new NullPointerException("Not valid argument null"))
                .when(skillRepository)
                .findByTitle(Mockito.anyString());

        CourseService service = new CourseService(skillRepository);

        Set<CourseEntity> result = service.getCoursesBySkill(null);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    /**
     * Метод getCoursesBySkill не должен пытаться искать скилл в бд, если параметр пустой
     * В ответе ожидается пустое множество
     */
    @Test
    void testCourseServiceGetCoursesBySkillCanWorkWithEmptyArg() {
        Mockito.doThrow(new IllegalArgumentException("Not valid argument: empty"))
                .when(skillRepository)
                .findByTitle(Mockito.anyString());

        CourseService service = new CourseService(skillRepository);

        Set<CourseEntity> result = service.getCoursesBySkill("");
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    /**
     * Метод getCoursesBySkill должен найти курсы независимо от регистра заданного скилла
     * В ответе ожидается коллекция из 1 элемента
     */
    @Test
    void testCourseServiceGetCoursesBySkillCanWorkWithAnyCase() {
        String randomCaseStr = "jhKwhOI21L";
        SkillEntity expected = new SkillEntity();
        expected.setCourseEntities(Collections.singleton(new CourseEntity()));
        Mockito.doReturn(Optional.of(expected))
                .when(skillRepository)
                .findByTitle(randomCaseStr.toLowerCase());

        CourseService service = new CourseService(skillRepository);

        Set<CourseEntity> result = service.getCoursesBySkill(randomCaseStr);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }
}
