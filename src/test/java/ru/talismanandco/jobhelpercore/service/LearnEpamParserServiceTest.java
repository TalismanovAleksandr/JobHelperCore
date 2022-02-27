package ru.talismanandco.jobhelpercore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.talismanandco.jobhelpercore.dto.Course;
import ru.talismanandco.jobhelpercore.dto.CourseSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LearnEpamParserServiceTest {

    @Autowired
    LearnEpamParserService learnEpamParserService;

    @Test
    void execute() {
        List<Course> courseList = learnEpamParserService.execute();
        assertEquals(56, courseList.size());
        Course firstElement = courseList.get(0);
        assertEquals(CourseSource.LEARN_EPAM, firstElement.getCourseSource());
        assertTrue(firstElement.getUrl().contains("https://learn.epam.com/detailsPage?id="));
    }
}