package ru.talismanandco.jobhelpercore.service.impl;

import com.google.common.base.Charsets;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.talismanandco.jobhelpercore.dto.Course;
import ru.talismanandco.jobhelpercore.dto.CourseSource;
import ru.talismanandco.jobhelpercore.expections.LearnEpamException;
import ru.talismanandco.jobhelpercore.service.LearnEpamParserService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class LearnEpamParserServiceImpl implements LearnEpamParserService {

    @Value("${talismanov.courses.epam.file-path}")
    private String filePathName;
    @Value("${talismanov.courses.epam.base-url}")
    private String epamBaseUrl;


    @Override
    public List<Course> execute() {

        List<Course> courseList = new ArrayList<>();
        Document doc = getDocument();

        Elements elementsByAttributeValueContaining = doc.getElementsByAttributeValueContaining("class", "SmallCard_container");
        for (Element element : elementsByAttributeValueContaining) {
            Course course = getCourse(element);
            courseList.add(course);
        }
        return courseList;
    }

    private Document getDocument() {
        Document doc;
        try {
            doc = Jsoup.parse(new File(filePathName), String.valueOf(Charsets.UTF_8));
        } catch (IOException e) {
            log.debug(e.getMessage(), e);
            throw new LearnEpamException(e);
        }
        return doc;
    }

    private Course getCourse(Element element) {
        Course course = new Course();
        Element elementA = element.child(0);
        course.setUrl(epamBaseUrl + elementA.attr("href"));
        Element parentOfFive = elementA.child(1);

        Element parentOfLevel = parentOfFive.child(0);
        String difficultyLevel = parentOfLevel.child(0).text();
        course.setDifficultyLevel(difficultyLevel);
        String courseName = parentOfFive.child(1).child(0).text();
        course.setName(courseName);
        String hashTags = parentOfFive.child(2).child(0).text();
        course.setHashTags(hashTags);

        course.setCourseSource(CourseSource.LEARN_EPAM);
        return course;
    }
}
